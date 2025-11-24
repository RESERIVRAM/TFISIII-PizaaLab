package servicio;

import java.util.ArrayList;
import java.util.List;

import controlador.CocinaObserver;
import modelo.*;
import repositorio.PedidoRepository;

/*
 * Fachada para el manejo de pedidos que simplifica la interacción
 * entre los distintos componentes del sistema, como repositorios,
 * métodos de pago y generación de comprobantes.
 */
public class PedidoFacade {
    private final PedidoRepository repositorio;
    private final List<Pedido> pedidos = new ArrayList<>();
    private final List<CocinaObserver> observers = new ArrayList<>();

    public PedidoFacade(PedidoRepository repo) {
        this.repositorio = repo;
    }

    /**
     * Orquesta la creación del pedido, la ejecución del pago
     * y el almacenamiento del pedido.
     */
    public Comprobante realizarPedido(List<Pizza> productos, MetodoPagoStrategy estrategiaPago) {
        // 1) Crear Pedido
        Pedido pedido = new Pedido(generarIdPedido());
        productos.forEach(pedido::agregarProducto);

        // 2) Ejecutar pago
        MetodoPago contexto = new MetodoPago(estrategiaPago);
        Comprobante comprobante = contexto.ejecutarPago(pedido);

        // 3) Guardar pedido
        repositorio.guardarPedido(pedido);

        return comprobante;
    }

    // Sobrescribe guardarPedido para mantener la lista interna y notificar observers
    public void guardarPedido(Pedido pedido) {
        pedidos.add(pedido);
        repositorio.guardarPedido(pedido);
        notificarObservers(pedido);
    }

    // Permite registrar observers
    public void agregarObserver(CocinaObserver observer) {
        observers.add(observer);
    }

    // Notifica a los observers de un nuevo pedido
    private void notificarObservers(Pedido pedido) {
        for (CocinaObserver obs : observers) {
            obs.mostrarNuevoPedido(pedido);
            obs.mostrarAlerta("¡Nuevo pedido recibido! ID=" + pedido.getId());
        }
    }

    /**
     * Marca el pedido como completado y notifica a los observers (ejemplo básico).
     */
    public void marcarPedidoComoCompletado(String idPedido) {
        // Busca el pedido y cambia su estado a "completado"
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido != null) {
            pedido.setEstado("completado");
            // Notifica a los observers si aplica (ejemplo)
            notificarObserversPedidoCompletado(pedido);
        }
    }

    // Método auxiliar para buscar pedido por ID (puedes adaptar a tu estructura interna)
    private Pedido buscarPedidoPorId(String idPedido) {
        for (Pedido p : pedidos) { // Asume que tienes una lista 'pedidos'
            if (p.getId().equals(idPedido)) {
                return p;
            }
        }
        return null;
    }

    // Notifica a los observers que un pedido fue completado
    private void notificarObserversPedidoCompletado(Pedido pedido) {
        for (CocinaObserver obs : observers) {
            obs.pedidoCompletado(pedido.getId());
        }
    }

    private String generarIdPedido() {
        return "PED-" + System.currentTimeMillis();
    }
}


/* La clase PedidoFacade funciona como una fachada que simplifica y centraliza el flujo completo de un pedido dentro del sistema. Su responsabilidad principal es orquestar la creación del pedido, agregar los productos, procesar el pago mediante 
la fábrica de métodos de pago, guardar el pedido en el repositorio, y finalmente generar un comprobante (boleta o factura). 
Esto aísla a los consumidores del sistema de detalles internos y facilita el mantenimiento y la extensión futura del proceso de pedidos. */