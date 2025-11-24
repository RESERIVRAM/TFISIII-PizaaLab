package modelo;

import java.util.Arrays;
import java.util.List;

public class Americana extends Pizza {
    private static final List<Ingrediente> INGREDIENTES_BASE = Arrays.asList(
        new Ingrediente("Queso", 1.5),
        new Ingrediente("Salchicha", 1.5),
        new Ingrediente("Tocino", 2.0)
    );

    public Americana(String tamanio, String tipoMasa) {
        super("PZ-AM", "Americana", "Pizza con ingredientes clásicos americanos", 14.99, tamanio, tipoMasa);
        for (Ingrediente ing : INGREDIENTES_BASE) {
            agregarIngredienteBase(ing);
        }
    }
}


/* Esta clase representa una pizza del tipo Americana, ya viene con ingredientes fijos (pepperoni, champis, etc). 
Se usa como parte del patron Factory para crear pizzas ya listas. Ahorra tiempo y evita que el user arme todo de cero. 
Cuando quieras, seguimos con la siguiente.*/