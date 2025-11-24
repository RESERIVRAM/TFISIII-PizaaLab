package modelo;

import java.util.Arrays;
import java.util.List;

public class Mozzarella extends Pizza {
    private static final List<Ingrediente> INGREDIENTES_BASE = Arrays.asList(
        new Ingrediente("Queso Mozzarella", 1.8),
        new Ingrediente("Tomate", 0.8)
    );

    public Mozzarella(String tamanio, String tipoMasa) {
        super("PZ-MZ", "Mozzarella", "Pizza simple con mucho queso", 8.99, tamanio, tipoMasa);
        for (Ingrediente ing : INGREDIENTES_BASE) {
            agregarIngredienteBase(ing);
        }
    }
}


/* Esta clase representa la pizza Mozzarella con sus ingredientes base ya definidos.
Al crearla se agregan esos ingredientes para calcular el precio total correctamente. */