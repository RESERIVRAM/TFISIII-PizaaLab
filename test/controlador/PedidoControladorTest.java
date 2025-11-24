package controlador;

import modelo.Ingrediente;
import org.junit.Before;
import org.junit.Test;

import servicio.PedidoFacade;
import servicio.PizzaBuilder;
import servicio.PizzaFactory;
import vista.BienvenidaVista;
import vista.CocinaVista;
import vista.InicioVista;
import vista.ProcesoPagoVista;
import vista.TipoConsumoPagoVista;

import repositorio.PedidoRepository;
import repositorio.PedidoRepositoryMemoria;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la lógica de cálculo de PedidoControlador.
 * No probamos la interfaz gráfica, solo los métodos de cálculo.
 */
public class PedidoControladorTest {

    private PedidoControlador controlador;

    @Before
    public void setUp() {
        // Vistas (las instancias reales; no usamos su interfaz, solo las necesitamos para el constructor)
        BienvenidaVista bienvenidaVista = new BienvenidaVista();
        TipoConsumoPagoVista consumoVista = new TipoConsumoPagoVista();
        InicioVista inicioVista = new InicioVista();
        ProcesoPagoVista pagoVista = new ProcesoPagoVista();
        CocinaVista cocinaVista = new CocinaVista();

        // Servicios de dominio reales
        PizzaFactory pizzaFactory = new PizzaFactory();
        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        // ✅ PedidoFacade necesita un PedidoRepository en el constructor
        PedidoRepository repoMemoria = new PedidoRepositoryMemoria();
        PedidoFacade pedidoFacade = new PedidoFacade(repoMemoria);

        controlador = new PedidoControlador(
                bienvenidaVista,
                consumoVista,
                inicioVista,
                pagoVista,
                cocinaVista,
                pizzaFactory,
                pizzaBuilder,
                pedidoFacade
        );
    }

    /**
     * Verifica calcularPrecioFinalActual() sin ingredientes extra:
     *  - Pizza Americana
     *  - Tamaño GRANDE (multiplicador 1.8)
     *  - Cantidad 2
     */
    @Test
    public void calcularPrecioFinalActual_sinIngredientesExtras() {
        controlador.seleccionarPizza("Americana");
        controlador.seleccionarTamanio("Grande");
        controlador.seleccionarMasa("Clásica");
        controlador.seleccionarIngredientes(Collections.<Ingrediente>emptyList());
        controlador.seleccionarCantidad(2);

        double precioBase = 14.99;
        double multiplicador = 1.8;
        int cantidad = 2;
        double esperado = (precioBase * multiplicador) * cantidad;

        double total = controlador.calcularPrecioFinalActual();

        assertEquals("El total sin ingredientes extra no es el esperado",
                esperado, total, 0.001);
    }

    /**
     * Verifica calcularPrecioFinalActual() con ingredientes extra:
     *  - Pizza Margarita
     *  - Tamaño MEDIANA (multiplicador 1.4)
     *  - 2 ingredientes adicionales
     */
    @Test
    public void calcularPrecioFinalActual_conIngredientesExtras() {
        Ingrediente quesoExtra = new Ingrediente("Queso Extra", 1.50);
        Ingrediente tocinoExtra = new Ingrediente("Tocino", 2.00);
        List<Ingrediente> extras = Arrays.asList(quesoExtra, tocinoExtra);

        controlador.seleccionarPizza("Margarita");
        controlador.seleccionarTamanio("Mediana");
        controlador.seleccionarMasa("Clásica");
        controlador.seleccionarIngredientes(extras);
        controlador.seleccionarCantidad(1);

        double precioBase = 11.99;
        double multiplicador = 1.4;
        double totalIngredientes = 1.50 + 2.00;
        double esperado = (precioBase * multiplicador + totalIngredientes);

        double total = controlador.calcularPrecioFinalActual();

        assertEquals("El total con ingredientes extra no es correcto",
                esperado, total, 0.001);
    }
}