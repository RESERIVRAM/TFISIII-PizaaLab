package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String id;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private String tamanio;
    private String tipoMasa;
    private List<Ingrediente> ingredientesBase;
    private List<Ingrediente> ingredientesExtras;

    public Pizza(String id, String nombre, String descripcion, double precioBase, String tamanio, String tipoMasa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tamanio = tamanio;
        this.tipoMasa = tipoMasa;
        this.ingredientesBase = new ArrayList<>();
        this.ingredientesExtras = new ArrayList<>();
    }

    public void agregarIngredienteBase(Ingrediente ingrediente) {
        ingredientesBase.add(ingrediente);
    }

    public void agregarIngredienteExtra(Ingrediente ingrediente) {
        ingredientesExtras.add(ingrediente);
    }

    public List<Ingrediente> getIngredientesBase() {
        return ingredientesBase;
    }

    public List<Ingrediente> getIngredientesExtras() {
        return ingredientesExtras;
    }

    public double getPrecio() {
        double total = precioBase;

        // Solo los ingredientes EXTRAS se suman
        for (Ingrediente ing : ingredientesExtras) {
            total += ing.getPrecioAdicional();
        }

        switch (tamanio.toUpperCase()) {
            case "MEDIANA": total *= 1.4; break;
            case "GRANDE": total *= 1.8; break;
            case "FAMILIAR": total *= 2.3; break;
        }

        return total;
    }
    // En la clase Pizza
    public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public void setPrecioBase(double precioBase) {
    this.precioBase = precioBase;
}

public String getNombre() {
    return nombre;
}

public String getDescripcion() {
    return descripcion;
}

public double getPrecioBase() {
    return precioBase;
}

public String getTamanio() {
    return tamanio;
}

public String getTipoMasa() {
    return tipoMasa;
}
public void setTamanio(String tamanio) {
    this.tamanio = tamanio;
}

public void setTipoMasa(String tipoMasa) {
    this.tipoMasa = tipoMasa;
}


}
