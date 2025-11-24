package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Clase Pedido, representa un pedido hecho por un cliente que incluye varios productos y datos del flujo
public class Pedido {
    private String id;
    private List<Pizza> productos;   // Lista con todos los productos agregados al pedido
    private String estado;              // Estado del pedido: PENDIENTE o LISTO
    private LocalDateTime fechaHora;   // Fecha y hora cuando se creo el pedido
    private String tipoConsumo;        // "Comer aquí" o "Para llevar"
    private String metodoPago;         // "Billetera digital" o "Tarjeta"
    private String nombrePizza;        // Nombre de la pizza elegida
    private String tamanio;            // Tamaño de la pizza
    private String masa;               // Tipo de masa
    private List<Ingrediente> ingredientes; // Ingredientes personalizados
    private int cantidad;              // Cantidad de pizzas
    private String tipoComprobante;    // "Boleta" o "Factura"
    private String documento;          // DNI o RUC
    private double total;

    public Pedido(String id, String tipoConsumo, String metodoPago, String nombrePizza, String tamanio, String masa, List<Ingrediente> ingredientes, int cantidad, String tipoComprobante, String documento) {
        this.id = id;
        this.productos = new ArrayList<>();
        this.estado = "PENDIENTE";
        this.fechaHora = LocalDateTime.now();
        this.tipoConsumo = tipoConsumo;
        this.metodoPago = metodoPago;
        this.nombrePizza = nombrePizza;
        this.tamanio = tamanio;
        this.masa = masa;
        this.ingredientes = ingredientes != null ? ingredientes : new ArrayList<>();
        this.cantidad = cantidad;
        this.tipoComprobante = tipoComprobante;
        this.documento = documento;
    }

    // Constructor anterior para compatibilidad
    public Pedido(String id) {
        this(id, null, null, null, null, null, null, 1, null, null);
    }

    // Agrega un producto a la lista del pedido
    public void agregarProducto(Pizza producto) {
        productos.add(producto);
    }

    // Calcula el total sumando el precio de todos los productos del pedido y multiplicando por la cantidad
    public double calcularTotal() {
        double unitario = productos.stream().mapToDouble(Pizza::getPrecio).sum();
        return unitario * cantidad;
    }

    // Actualiza el estado del pedido, ej: "LISTO" o "PENDIENTE"
    public void actualizarEstado(String estado) {
        this.estado = estado;
    }

    // Cambia el estado del pedido (por compatibilidad con el facade)
    public void setEstado(String estado) {
        this.estado = estado;
    }

public void setTotal(double total) {
    this.total = total;
}

public double getTotal() {
    return total;
}
    // Getters para acceder a los atributos
    public String getId() { return id; }
    public List<Pizza> getProductos() { return productos; }
    public String getEstado() { return estado; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getTipoConsumo() { return tipoConsumo; }
    public String getMetodoPago() { return metodoPago; }
    public String getNombrePizza() { return nombrePizza; }
    public String getTamanio() { return tamanio; }
    public String getMasa() { return masa; }
    public List<Ingrediente> getIngredientes() { return ingredientes; }
    public int getCantidad() { return cantidad; }
    public String getTipoComprobante() { return tipoComprobante; }
    public String getDocumento() { return documento; }
}

/* Clase que representa un pedido hecho por un cliente. Contiene lista de productos, estado, fecha y datos del flujo. 
Permite agregar productos, calcular total y cambiar estado. Es base para manejar la orden en el sistema. */