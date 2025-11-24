package modelo;

public class Cliente {
    private String nombre;

    // Constructor recibe nombre y correo (aunque dice direccion, es correo)
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener nombre del cliente
    public String getNombre() { 
        return nombre;
    }
}

/* Esta clase representa al cliente que hace el pedido. Guarda nombre para usar en el comprobante. 
Es basica pero necesaria para identificar quien hace la orden. */