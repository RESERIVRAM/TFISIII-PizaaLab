// src/controlador/NotificadorCocina.java
package controlador;

/*
 * Observador (Observer) que conecta la logica de cocina con la vista grafica.
 * Permite notificar automaticamente a la vista cuando hay cambios relevantes en los pedidos.
 */
public interface CocinaObserver {
    void mostrarNuevoPedido(modelo.Pedido pedido);
    void mostrarAlerta(String mensaje);
    void pedidoCompletado(String idPedido);
}

//Esta clase implementa el patrón Observer para mantener sincronizada la vista de cocina con los cambios en los pedidos.
//Su función principal es automatizar la comunicación entre el sistema de gestión de pedidos y el área de cocina, permitiendo 
//que se reflejen en la interfaz sin intervención manual. Esto contribuye directamente a agilizar la preparación y entrega, resolviendo
//la problemática de demoras y errores operativos en PizzaLab.