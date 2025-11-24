package modelo;

//CLASE CONTEXTO

import servicio.MetodoPagoStrategy;

public class MetodoPago {
    private MetodoPagoStrategy strategy;

    public MetodoPago(MetodoPagoStrategy strategy){
        this.strategy = strategy;
    }

    public Comprobante ejecutarPago(Pedido pedido){
        return strategy.pagar(pedido);
    }

    public void setStrategy(MetodoPagoStrategy strategy) {
        this.strategy = strategy;
    }
}

/* Esta interface define los metodos que cualquier forma de pago debe implementar. Asi, diferentes tipos de pago pueden
usarse intercambiablemente en el sistema. */