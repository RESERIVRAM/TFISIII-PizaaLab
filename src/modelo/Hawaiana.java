package modelo;

import java.util.Arrays;
import java.util.List;

public class Hawaiana extends Pizza {
    private static final List<Ingrediente> INGREDIENTES_BASE = Arrays.asList(
        new Ingrediente("Queso", 1.5),
        new Ingrediente("Piña", 1.0),
        new Ingrediente("Jamón", 1.2)
    );

    public Hawaiana(String tamanio, String tipoMasa) {
        super("PZ-HW", "Hawaiana", "Pizza tropical con piña y jamón", 14.99, tamanio, tipoMasa);
        for (Ingrediente ing : INGREDIENTES_BASE) {
            agregarIngredienteBase(ing);
        }
    }
}

/* Esta clase es una pizza especifica con su lista fija de ingredientes. En el constructor se llama
a la superclase con los datos basicos y despues se agregan los ingredientes base que definen el sabor. 
Facilita crear pizzas ya listas del menu sin que el usuario tenga que poner ingredientes uno a uno. */