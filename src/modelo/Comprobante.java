package modelo;

import java.time.LocalDateTime;

public abstract class Comprobante {
    private String id;
    private LocalDateTime fechaEmision;
    private Pedido pedido;
    private double montoTotal;

    // Constructor guarda id, pedido, monto total y fecha actual
    public Comprobante(String id, Pedido pedido, double montoTotal) {
        this.id = id;
        this.pedido = pedido;
        this.montoTotal = montoTotal;
        this.fechaEmision = LocalDateTime.now();
    }
    
    // Metodo abstracto que cada tipo de comprobante debe implementar para generar texto
    public abstract String generarTexto();
    
    // Getters para acceder a los atributos
    public String getId() {
        return id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}

/* Esta clase es la base para los comprobantes que se generan al pagar. Guarda datos comunes como id, fecha, pedido y monto total.
Cada tipo de comprobante (boleta, factura) tiene que implementar su forma de mostrar la info. */