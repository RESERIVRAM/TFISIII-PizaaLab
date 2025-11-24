package servicio;

import modelo.Comprobante;
import modelo.Pedido;

public interface MetodoPagoStrategy {
    Comprobante pagar(Pedido pedido);
}
