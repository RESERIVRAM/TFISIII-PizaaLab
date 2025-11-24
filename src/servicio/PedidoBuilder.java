package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Ingrediente;
import modelo.Pedido;

public class PedidoBuilder {
    private String id;
    private String tipoConsumo;
    private String metodoPago;
    private String nombrePizza;
    private String tamanio;
    private String masa;
    private List<Ingrediente> ingredientes = new ArrayList<>();
    private int cantidad = 1; // Por defecto 1 pizza
    private String tipoComprobante;
    private String documento;

    public PedidoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PedidoBuilder setTipoConsumo(String tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
        return this;
    }

    public PedidoBuilder setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
        return this;
    }

    public PedidoBuilder setNombrePizza(String nombrePizza) {
        this.nombrePizza = nombrePizza;
        return this;
    }

    public PedidoBuilder setTamanio(String tamanio) {
        this.tamanio = tamanio;
        return this;
    }

    public PedidoBuilder setMasa(String masa) {
        this.masa = masa;
        return this;
    }

    public PedidoBuilder addIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
        return this;
    }

    public PedidoBuilder setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public PedidoBuilder setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
        return this;
    }

    public PedidoBuilder setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public Pedido build() {
        return new Pedido(id, tipoConsumo, metodoPago, nombrePizza, tamanio, masa, ingredientes, cantidad, tipoComprobante, documento);
    }
}
