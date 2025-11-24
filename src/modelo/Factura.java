package modelo;

// Clase hija de Comprobante para Factura
public class Factura extends Comprobante {
    private String rucCliente;

    // Constructor recibe datos de comprobante y datos fiscales del cliente
    public Factura(String id, Pedido pedido, double montoTotal, String rucCliente) {
        super(id, pedido, montoTotal);
        this.rucCliente = rucCliente;
    }

    // Genera el texto especifico para la factura con id, razon social y monto
    @Override
    public String generarTexto() {
        return "FACTURA #" + getId() + "\nRUC: " + rucCliente + "\nTotal: " + getMontoTotal();
    }
}

/* Esta clase representa la factura, que es un tipo de comprobante con datos fiscales extra como ruc y razon social. 
Tiene su forma propia de mostrar la info cuando se imprime o muestra. */