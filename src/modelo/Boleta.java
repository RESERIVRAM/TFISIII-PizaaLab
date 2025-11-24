package modelo;

// Clase hija de Comprobante
public class Boleta extends Comprobante {
    private String dniCliente; // guarda el dni si el cliente lo proporciona

    public Boleta(String id, Pedido pedido, double montoTotal, String dniCliente) {
        super(id, pedido, montoTotal); // llama al constructor del comprobante
        this.dniCliente = dniCliente;
    }

    @Override
    public String generarTexto() {
        // genera el texto que se muestra al cliente
        return "BOLETA #" + getId() + "\nDNI: " + dniCliente +  "\nTotal: $" + getMontoTotal();
    }
}

/*Esta clase representa una boleta simple que se entrega al cliente. Hereda de Comprobante y agrega el campo dni. 
El metodo generarTexto devuelve el texto que se imprime o muestra al cliente. Se usa cuando el cliente elige boleta como tipo de comprobante.*/