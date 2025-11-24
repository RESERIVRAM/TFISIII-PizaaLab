package repositorio;

import modelo.Pedido; // Importa la clase Pedido desde el paquete modelo
import java.util.List;

// Interfaz PedidoRepository que define los métodos para gestionar el almacenamiento de pedidos
public interface PedidoRepository {
    
    // Guarda un nuevo pedido en el repositorio (memoria, base de datos, etc.)
    void guardarPedido(Pedido pedido);
    
    // Retorna un pedido específico según su ID único
    Pedido obtenerPorId(String id);
    
    // Retorna la lista completa de todos los pedidos almacenados
    List<Pedido> obtenerTodos();
}

/*Esta interfaz define un contrato para las clases que implementen la lógica de almacenamiento de pedidos. 
Permite desacoplar el manejo de persistencia del resto del sistema, facilitando el uso de distintas fuentes de datos 
(como listas en memoria, archivos o bases de datos). */