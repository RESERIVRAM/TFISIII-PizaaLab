package controlador;

import modelo.*;
import servicio.PedidoFacade;
import servicio.PizzaFactory;
import servicio.PizzaBuilder;

import java.util.ArrayList;
import java.util.List;
import servicio.MetodoPagoStrategy;
import vista.BienvenidaVista;
import vista.CocinaVista;
import vista.InicioVista;
import vista.ProcesoPagoVista;
import vista.TipoConsumoPagoVista;

/**
 * Controlador principal del modulo de pedidos.
 * Coordina entre la vista, la logica de negocio y los servicios que gestionan pizzas y pagos.
 * Aplica patrones como Facade, Factory y Builder.
 */
public class PedidoControlador {
    private final BienvenidaVista bienvenidaVista;
    private final TipoConsumoPagoVista consumoVista;
    private final InicioVista inicioVista;
    private final ProcesoPagoVista pagoVista;
    private final CocinaVista cocinaVista;

    private final PizzaFactory pizzaFactory;
    private final PizzaBuilder pizzaBuilder;
    private final PedidoFacade pedidoFacade;
    private final List<Pizza> pizzasDisponibles = new ArrayList<>();

    private Pizza pizzaActual; // Guarda la pizza que se está construyendo actualmente

    // Datos del pedido en construcción
    private String tipoConsumo;
    private String metodoPago;
    private String nombrePizza;
    private String tamanio;
    private String masa;
    private List<Ingrediente> ingredientes = new ArrayList<>();
    private int cantidad = 1;
    private String tipoComprobante;
    private String documento;

    private final List<Pizza> productosSeleccionados = new ArrayList<>();

    // Constructor principal, usado por la aplicación con vistas Swing
    public PedidoControlador(BienvenidaVista bv,
                             TipoConsumoPagoVista cv,
                             InicioVista iv,
                             ProcesoPagoVista pv,
                             CocinaVista cocv,
                             PizzaFactory factory,
                             PizzaBuilder builder,
                             PedidoFacade facade) {
        this.bienvenidaVista = bv;
        this.consumoVista = cv;
        this.inicioVista = iv;
        this.pagoVista = pv;
        this.cocinaVista = cocv;

        this.pizzaFactory = factory;
        this.pizzaBuilder = builder;
        this.pedidoFacade = facade;

        bv.setControlador(this);
        cv.setControlador(this);
        iv.setControlador(this);
        pv.setControlador(this);
        cocv.setControlador(this);
    }

    // Constructor alternativo sin vistas: pensado para pruebas unitarias / entornos headless (CI)
    public PedidoControlador(PizzaFactory factory, PizzaBuilder builder, PedidoFacade facade) {
        this.bienvenidaVista = null;
        this.consumoVista = null;
        this.inicioVista = null;
        this.pagoVista = null;
        this.cocinaVista = null;

        this.pizzaFactory = factory;
        this.pizzaBuilder = builder;
        this.pedidoFacade = facade;
    }

    public void comenzarPedido() {
        if (bienvenidaVista != null) {
            bienvenidaVista.dispose();
        }
        if (consumoVista != null) {
            consumoVista.setVisible(true);
        }
    }

    public void seleccionarTipoConsumo(String tipo) {
        this.tipoConsumo = tipo;
    }

    public void seleccionarMetodoPago(String metodo) {
        this.metodoPago = metodo;
        if (consumoVista != null) {
            consumoVista.setVisible(false);
        }
        if (inicioVista != null) {
            inicioVista.setVisible(true);
        }
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void seleccionarPizza(String nombrePizza) {
        this.nombrePizza = nombrePizza;
        actualizarPizzaDesdeVista();
    }

    public void seleccionarTamanio(String tamanio) {
        this.tamanio = tamanio;
        actualizarPizzaDesdeVista();
    }

    public void seleccionarMasa(String masa) {
        this.masa = masa;
        actualizarPizzaDesdeVista();
    }

    public void seleccionarIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
        actualizarPizzaDesdeVista();
    }

    public void seleccionarCantidad(int cantidad) {
        this.cantidad = cantidad;
        actualizarPizzaDesdeVista();
    }

    public void actualizarPizzaDesdeVista() {
        if (nombrePizza == null || tamanio == null || masa == null) return;

        pizzaActual = pizzaFactory.crearPizza(nombrePizza, tamanio, masa);
        PizzaBuilder builder = new PizzaBuilder().from(pizzaActual);
        builder.agregarIngredientesExtras(ingredientes);
        pizzaActual = builder.build();

        if (inicioVista != null) {
            inicioVista.actualizarPrecioTotalEnVista(pizzaActual);
        }
    }

    public void personalizarPizza(Pizza base, List<Ingrediente> nuevosIngredientes) {
        pizzaActual = new PizzaBuilder().from(base).agregarIngredientesExtras(nuevosIngredientes).build();
    }

    private boolean esIngredienteBase(String nombrePizza, String nombreIngrediente) {
        switch (nombrePizza) {
            case "Margarita":
                return nombreIngrediente.equals("Queso")
                        || nombreIngrediente.equals("Albahaca")
                        || nombreIngrediente.equals("Tomate");
            case "Hawaiana":
                return nombreIngrediente.equals("Queso")
                        || nombreIngrediente.equals("Jamón")
                        || nombreIngrediente.equals("Piña");
            case "Mozzarella":
                return nombreIngrediente.equals("Queso Mozzarella")
                        || nombreIngrediente.equals("Tomate");
            case "Americana":
                return nombreIngrediente.equals("Queso")
                        || nombreIngrediente.equals("Salchicha")
                        || nombreIngrediente.equals("Tocino");
            default:
                return false;
        }
    }

    public double calcularPrecioFinalActual() {
        String nombre = (this.nombrePizza == null) ? "" : this.nombrePizza;
        double precioBase;
        switch (nombre) {
            case "Americana": precioBase = 14.99; break;
            case "Mozzarella": precioBase = 12.99; break;
            case "Hawaiana": precioBase = 13.99; break;
            case "Margarita": precioBase = 11.99; break;
            default: precioBase = 8.99;
        }

        String tamanioActual = (this.tamanio == null) ? "" : this.tamanio.toUpperCase();
        double multiplicador = switch (tamanioActual) {
            case "MEDIANA" -> 1.4;
            case "GRANDE" -> 1.8;
            case "FAMILIAR" -> 2.3;
            default -> 1.0;
        };

        double totalIngredientes = 0.0;
        if (ingredientes != null) {
            for (Ingrediente ing : ingredientes) {
                totalIngredientes += ing.getPrecioAdicional();
            }
        }

        return (precioBase * multiplicador + totalIngredientes) * cantidad;
    }

    public double calcularTotal(String tipoPizza, String tamanio, List<Ingrediente> seleccionados, int cantidad) {
        Pizza pizza = pizzaFactory.crearPizza(tipoPizza, tamanio, "Clásica");
        for (Ingrediente ing : seleccionados) {
            boolean yaIncluido = pizza.getIngredientesBase().stream()
                    .anyMatch(base -> base.getNombre().equalsIgnoreCase(ing.getNombre()));
            if (!yaIncluido) pizza.agregarIngredienteExtra(ing);
        }
        return pizza.getPrecio() * cantidad;
    }

    public void seleccionarTipoComprobante(String tipo) {
        this.tipoComprobante = tipo;
    }

    public void ingresarDocumento(String documento) {
        this.documento = documento;
    }

    public void confirmarPedido() {
        String id = "PED" + System.currentTimeMillis();

        // Calcular el total final con todos los factores
        double totalCalculado = calcularPrecioFinalActual();

        // Crear el objeto Pedido con los datos actuales
        Pedido pedido = new Pedido(
                id, tipoConsumo, metodoPago, nombrePizza, tamanio, masa,
                ingredientes, cantidad, tipoComprobante, documento
        );

        pedido.setTotal(totalCalculado); // Guardar el total calculado en el pedido

        for (Pizza p : productosSeleccionados) {
            pedido.agregarProducto(p);
        }

        // Guardar en base de datos
        try {
            repositorio.PedidoRepositoryBD repoBD = new repositorio.PedidoRepositoryBD();
            repoBD.guardarPedido(pedido);
        } catch (Exception e) {
            System.err.println("Error al guardar pedido en BD: " + e.getMessage());
        }

        // Guardar comprobante en archivo
        guardarComprobanteTxt(pedido);

        // Mostrar información por consola
        System.out.println("\n--- Comprobante de Pedido ---");
        System.out.println("ID: " + pedido.getId());
        System.out.println("Pizza: " + pedido.getNombrePizza());
        System.out.println("Tamaño: " + pedido.getTamanio());
        System.out.println("Masa: " + pedido.getMasa());
        System.out.println("Adicionales: " + pedido.getIngredientes());
        System.out.println("Cantidad: " + pedido.getCantidad());
        System.out.println("Tipo de consumo: " + pedido.getTipoConsumo());
        System.out.println("Método de pago: " + pedido.getMetodoPago());
        System.out.println("Tipo comprobante: " + pedido.getTipoComprobante());
        System.out.println("Documento: " + pedido.getDocumento());
        System.out.printf("Total: S/ %.2f\n", pedido.getTotal());
        System.out.println("----------------------------\n");

        if (cocinaVista != null) {
            cocinaVista.setVisible(true);
        }
        pedidoFacade.guardarPedido(pedido);

        limpiarDatos();
    }

    public void marcarPedidoListo(String idPedido) {
        pedidoFacade.marcarPedidoComoCompletado(idPedido);
        if (cocinaVista != null) {
            cocinaVista.pedidoCompletado(idPedido);
        }
    }

    public void mostrarCocinaVista() {
        if (pagoVista != null) pagoVista.setVisible(false);
        if (cocinaVista != null) cocinaVista.setVisible(true);
    }

    private void limpiarDatos() {
        tipoConsumo = null;
        metodoPago = null;
        nombrePizza = null;
        tamanio = null;
        masa = null;
        ingredientes = new ArrayList<>();
        cantidad = 1;
        tipoComprobante = null;
        documento = null;
        productosSeleccionados.clear();
        pizzaActual = null;
    }

    public void agregarPizzaPredisenada(String tipo, String tamanio, String masa) {
        this.nombrePizza = tipo;
        this.tamanio = tamanio;
        this.masa = masa;
        actualizarPizzaDesdeVista();
    }

    public Pizza getPizzaActual() {
        return this.pizzaActual;
    }

    private void guardarComprobanteTxt(Pedido pedido) {
        try (java.io.PrintWriter out = new java.io.PrintWriter("comprobante_" + pedido.getId() + ".txt")) {
            out.println("--- Comprobante de Pedido PizzaLab ---");
            out.println("ID: " + pedido.getId());
            out.println("Pizza: " + pedido.getNombrePizza());
            out.println("Tamaño: " + pedido.getTamanio());
            out.println("Masa: " + pedido.getMasa());
            out.println("Ingredientes: " + pedido.getIngredientes());
            out.println("Cantidad: " + pedido.getCantidad());
            out.println("Tipo de consumo: " + pedido.getTipoConsumo());
            out.println("Método de pago: " + pedido.getMetodoPago());
            out.println("Tipo comprobante: " + pedido.getTipoComprobante());
            out.println("Documento: " + pedido.getDocumento());
            out.println("Total: S/ " + String.format("%.2f", pedido.calcularTotal()));
            out.println("--------------------------------------");
        } catch (Exception e) {
            System.err.println("Error al guardar comprobante: " + e.getMessage());
        }
    }
}

/*PedidoControlador es el corazon del modulo de pedidos, enlazando la vista con la logica de creacion de pizzas y procesamiento de ordenes.
    • Aplica Factory para generar pizzas base prediseñadas.
    • Utiliza Builder para permitir la personalización flexible de pizzas.
    • Se apoya en una Facade (PedidoFacade) para simplificar la operación completa del pedido, incluyendo 
validaciones, calculo de total, seleccion de metodo de pago y generacion de comprobante. Su implementacion mejora la experiencia 
del cliente al hacer el proceso de pedido fluido, claro y autonomo, respondiendo directamente a los problemas planteados en la definicion del proyecto.*/