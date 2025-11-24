package servicio;

import controlador.CocinaObserver;
import modelo.Pedido;
import java.util.*;

/*
 * Sujeto (Subject) en el patrón Observer:
 * mantiene la lista de pedidos y notifica a sus observadores
 * cuando llega un pedido nuevo o uno es marcado como listo.
 */
public class Cocina {
    // Lista de pedidos en estado PENDIENTE
    private final List<Pedido> pedidosPendientes = new ArrayList<>();

    // Lista de pedidos que ya fueron marcados como LISTOS
    private final List<Pedido> pedidosListos = new ArrayList<>();

    // Lista de observadores que serán notificados ante cambios en los pedidos
    private final List<CocinaObserver> observadores = new ArrayList<>();

    /* Se suscribe un observador al sistema de cocina */
    public void agregarObservador(CocinaObserver obs) {
        observadores.add(obs);
    }

    /* Se desuscribe un observador del sistema */
    public void removerObservador(CocinaObserver obs) {
        observadores.remove(obs);
    }

    /* 
     * Llega un nuevo pedido:
     * - Se añade a la lista de pedidos pendientes
     * - Se actualiza su estado a "PENDIENTE"
     * - Se notifica a todos los observadores registrados
     */
    public void recibirPedido(Pedido pedido) {
        pedidosPendientes.add(pedido);
        pedido.actualizarEstado("PENDIENTE");
        for (CocinaObserver obs : observadores) {
            obs.mostrarNuevoPedido(pedido); // Notifica el nuevo pedido
            obs.mostrarAlerta("¡Nuevo pedido recibido! ID=" + pedido.getId());
        }
    }

    /*
     * Marca un pedido como listo:
     * - Se busca el pedido por su ID
     * - Si existe, se remueve de pendientes y se cambia su estado a "LISTO"
     * - Se añade a la lista de pedidos listos
     * - Se notifica a los observadores con una alerta
     */
    
    // Se utiliza programacion funcional
    public void marcarPedidoListo(String idPedido) {
        Optional<Pedido> opt = pedidosPendientes.stream()
            .filter(p -> p.getId().equals(idPedido))
            .findFirst();

        if (opt.isPresent()) {
            Pedido p = opt.get();
            pedidosPendientes.remove(p);
            p.actualizarEstado("LISTO");
            pedidosListos.add(p);
            for (CocinaObserver obs : observadores) {
                obs.pedidoCompletado(p.getId()); // Notifica a la vista que el pedido fue completado
                obs.mostrarAlerta("¡Pedido listo! ID=" + p.getId());
            }
        }
    }

    /*
     * Permite consultar la lista de pedidos pendientes
     * (modo solo lectura, sin posibilidad de modificarla externamente)
     */
    public List<Pedido> mostrarPedidosPendientes() {
        return Collections.unmodifiableList(pedidosPendientes);
    }
}

/* La clase Cocina actúa como el sujeto en el patrón de diseño Observer, gestionando el ciclo de vida de los pedidos dentro del sistema.
Se encarga de recibir pedidos nuevos, cambiar su estado cuando están listos y notificar a todos los observadores registrados (por ejemplo, 
interfaces gráficas o paneles de cocina). Su implementación permite desacoplar la lógica de negocio del manejo visual, facilitando
la escalabilidad y mantenimiento del sistema. */
