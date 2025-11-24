package repositorio;

import modelo.Pedido;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Clase que implementa la interfaz PedidoRepository utilizando una estructura de memoria (HashMap)
// Simula el almacenamiento de pedidos sin necesidad de una base de datos real

public class PedidoRepositoryMemoria implements PedidoRepository {
    // Estructura en memoria para almacenar los pedidos, usando el ID como clave
    private final Map<String, Pedido> pedidos = new HashMap<>();

    @Override
    public void guardarPedido(Pedido pedido){
        // Guarda o actualiza el pedido en el mapa según su ID
        pedidos.put(pedido.getId(), pedido);
    }

    @Override
    public Pedido obtenerPorId(String id){
        // Recupera un pedido específico por su ID
        return pedidos.get(id);
    }

    @Override
    public List<Pedido> obtenerTodos(){
        // Devuelve una lista con todos los pedidos almacenados en memoria
        return new ArrayList<>(pedidos.values());
    }
}

/* La clase PedidoRepositoryMemoria es una implementación de la interfaz PedidoRepository que utiliza una estructura en memoria
(HashMap) para simular el almacenamiento de pedidos. Es útil durante el desarrollo y pruebas del sistema, ya que no requiere 
conexión a una base de datos. Esta clase permite guardar, buscar y listar pedidos de manera rápida y sencilla, cumpliendo con
el patrón Repository al abstraer la lógica de acceso a datos.*/