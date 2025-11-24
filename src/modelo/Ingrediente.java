package modelo;

// Ingredientes para la Pizza
public class Ingrediente {
    private String nombre;
    private double precioAdicional;

    public Ingrediente(String nombre, double precioAdicional) {
        this.nombre = nombre;
        this.precioAdicional = precioAdicional;
    }
    
    // Cada ingrediente tiene un precio adicional que se suma al total de la pizza
    public double getPrecioAdicional() {
        return precioAdicional;
    }
    
    // Getter para el nombre, no incluido pero usualmente necesario
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (S/ " + precioAdicional + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingrediente other = (Ingrediente) obj;
        return nombre.equals(other.nombre);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nombre);
    }
}

/* Esta clase representa un ingrediente que puede agregarse a una pizza. Tiene nombre y un precio extra que se suma al costo base de la pizza.
Sirve para calcular el precio final segun los ingredientes que el cliente agregue o que ya trae una pizza base. */