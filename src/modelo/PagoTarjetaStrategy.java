package modelo;

import servicio.MetodoPagoStrategy;

public class PagoTarjetaStrategy implements MetodoPagoStrategy {
    @Override
    public Comprobante pagar(Pedido pedido) {
        return new Comprobante("INV-" + pedido.getId(), pedido, pedido.calcularTotal()) {
            @Override public String generarTexto() {
                return "Boleta #" + getId() + " - Pago con POS exitoso. Total: " + getMontoTotal();
            }
        };
    }
}

/* Clase que implementa el metodo de pago usando tarjeta de credito o debito. Guarda datos basicos y simula el procesamiento. 
El metodo obtenerDetalles oculta los primeros digitos para proteger la informacion. */