package servicio;

import modelo.Ingrediente;
import modelo.Pizza;
import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder extends Pizza {

    private final List<Ingrediente> ingredientesExtrasBuilder = new ArrayList<>();

    // Constructor por defecto para pizza personalizada
    public PizzaBuilder() {
        super("PERS", "Pizza Personalizada", "Pizza creada por el usuario", 8.99, "", "");
    }

    // Corrige el método from: copia todo, incluido el precio
    public PizzaBuilder from(Pizza base) {
        PizzaBuilder builder = new PizzaBuilder();

        builder.setId(base.getId());
        builder.setNombre(base.getNombre());
        builder.setDescripcion(base.getDescripcion());
        builder.setPrecioBase(base.getPrecioBase()); // <<<<< ¡Esto antes no estaba!
        builder.setTamanio(base.getTamanio());
        builder.setTipoMasa(base.getTipoMasa());

        for (Ingrediente ing : base.getIngredientesBase()) {
            builder.agregarIngredienteBase(ing);
        }

        return builder;
    }

    public PizzaBuilder withTamanio(String tamanio) {
        setTamanio(tamanio);
        return this;
    }

    public PizzaBuilder withTipoMasa(String masa) {
        setTipoMasa(masa);
        return this;
    }

    public PizzaBuilder agregarIngredientesExtras(List<Ingrediente> extras) {
        ingredientesExtrasBuilder.addAll(extras);
        return this;
    }

    public Pizza build() {
        Pizza personalizada = new Pizza(getId(), getNombre(), getDescripcion(), getPrecioBase(), getTamanio(), getTipoMasa());

        // Copia ingredientes base
        for (Ingrediente ing : getIngredientesBase()) {
            personalizada.agregarIngredienteBase(ing);
        }

        // Agrega ingredientes extras
        for (Ingrediente ing : ingredientesExtrasBuilder) {
            personalizada.agregarIngredienteExtra(ing);
        }

        return personalizada;
    }

    @Override
    public double getPrecio() {
        return build().getPrecio();
    }
}
