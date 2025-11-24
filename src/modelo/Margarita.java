package modelo;

import java.util.Arrays;
import java.util.List;

public class Margarita extends Pizza {
    private static final List<Ingrediente> INGREDIENTES_BASE = Arrays.asList(
        new Ingrediente("Queso", 1.5),
        new Ingrediente("Albahaca", 0.7),
        new Ingrediente("Tomate", 0.8)
    );

    public Margarita(String tamanio, String tipoMasa) {
        super("PZ-MG", "Margarita", "Pizza clásica italiana con tomate y albahaca", 10.99, tamanio, tipoMasa);
        for (Ingrediente ing : INGREDIENTES_BASE) {
            agregarIngredienteBase(ing);  // solo base, no suma al precio
        }
    }
}


/* Esta clase representa una pizza Margarita con sus ingredientes fijos y precio base. 
Hereda de Pizza y al crearla agrega todos los ingredientes que lleva por defecto. 
Asi el precio final considera el costo base mas el de cada ingrediente extra. */