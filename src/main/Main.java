package main;

import controlador.*;
import repositorio.*;
import servicio.*;
import vista.*;

public class Main {
    public static void main(String[] args) {
        // 1) Repositorio y fachada
        var repo   = new PedidoRepositoryMemoria();
        var facade = new PedidoFacade(repo);

        // 2) Factory & Builder
        var pizzaFactory = new PizzaFactory();
        var pizzaBuilder = new PizzaBuilder();

        // 3) Crear todas las vistas
        var bv = new BienvenidaVista();
        var tcp = new TipoConsumoPagoVista();
        var iv = new InicioVista();
        var pp = new ProcesoPagoVista();
        var cv = new CocinaVista();

        // 4) Observer de cocina
        var cocina = new Cocina();
        cv.setCocina(cocina);
        facade.agregarObserver(cv);

        // 5) Controlador único que coordina TODO
        var controlador = new PedidoControlador(
            bv,  // bienvenida
            tcp, // consumo
            iv,  // inicio (menú)
            pp,  // pago
            cv,  // cocina UI
            pizzaFactory,
            pizzaBuilder,
            facade
        );
        
        // Inyectar controlador en vistas
        bv.setControlador(controlador);
        tcp.setControlador(controlador);
        iv.setControlador(controlador);
        pp.setControlador(controlador);
        cv.setControlador(controlador);

        bv.setTipoConsumoPagoVista(tcp);
        tcp.setInicioVista(iv);
        iv.setProcesoPagoVista(pp);
        // Así, cada vista puede mostrar la siguiente usando la instancia correcta.

        // 6) Arrancar
        bv.setVisible(true);
    }
}
