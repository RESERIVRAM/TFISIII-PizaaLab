package modelo;

import servicio.MetodoPagoStrategy;

public class PagoBilleteraDigitalStrategy implements MetodoPagoStrategy {
    @Override
    public Comprobante pagar(Pedido pedido) {
        return new Comprobante("BIL-" + pedido.getId(), pedido, pedido.calcularTotal()) {
            @Override public String generarTexto() {
                return "Boleto #" + getId() + " - Pago con QR exitoso. Total: " + getMontoTotal();
            }
        };
    }
}

/* Esta clase implementa el metodo de pago con billeteras digitales, guardando el nombre y correo. 
Simula el proceso de pago y permite obtener detalles para mostrar. */