package controlador;

import modelo.Ingrediente;
import org.junit.Before;
import org.junit.Test;
import servicio.PizzaBuilder;
import servicio.PizzaFactory;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class PedidoControladorTest {

    private PedidoControlador controlador;

    @Before
    public void setUp() {
        PizzaFactory factory = new PizzaFactory();
        PizzaBuilder builder = new PizzaBuilder();

        // Para estos tests NO necesitamos PedidoFacade ni repositorio,
        // porque nunca llamamos a confirmarPedido().
        // Pasamos null y listo.
        controlador = new PedidoControlador(factory, builder, null);
    }

    @Test
    public void calcularPrecioFinalActual_sinIngredientesExtras() {
        controlador.seleccionarPizza("Americana");
        controlador.seleccionarTamanio("MEDIANA");
        controlador.seleccionarMasa("Clásica");
        controlador.seleccionarIngredientes(Collections.emptyList());
        controlador.seleccionarCantidad(1);

        double total = controlador.calcularPrecioFinalActual();

        double esperado = 14.99 * 1.4; // Americana mediana sin extras
        assertEquals("El total sin ingredientes extra no es el esperado",
                esperado, total, 0.01);
    }

    @Test
    public void calcularPrecioFinalActual_conIngredientesExtras() {
        controlador.seleccionarPizza("Americana");
        controlador.seleccionarTamanio("MEDIANA");
        controlador.seleccionarMasa("Clásica");

        Ingrediente extra1 = new Ingrediente("Pepperoni", 2.50);
        Ingrediente extra2 = new Ingrediente("Aceitunas", 1.00);

        controlador.seleccionarIngredientes(Arrays.asList(extra1, extra2));
        controlador.seleccionarCantidad(1);

        double total = controlador.calcularPrecioFinalActual();

        double esperado = (14.99 * 1.4) + 2.50 + 1.00;
        assertEquals("El total con ingredientes extra no es correcto",
                esperado, total, 0.01);
    }
}