package repositorio;

import modelo.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.MySQLUtil;

// Clase que implementa la interfaz PedidoRepository utilizando JDBC para interactuar con una base de datos
public class PedidoRepositoryBD implements PedidoRepository {
    private final Connection conn;
    
    public PedidoRepositoryBD() throws SQLException { 
        this.conn = MySQLUtil.getConnection(); 
    }

    @Override
    public void guardarPedido(Pedido pedido) {
        try {
            String sql = "INSERT INTO pedidos (id_pedido, modo_consumo, total, fecha, id_comprobante) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pedido.getId());
            stmt.setString(2, pedido.getTipoConsumo()); // "LOCAL" o "LLEVAR"
            stmt.setDouble(3, pedido.calcularTotal());
            stmt.setTimestamp(4, Timestamp.valueOf(java.time.LocalDateTime.now()));
            stmt.setString(5, pedido.getTipoComprobante()); // Puedes usar el tipo de comprobante como id_comprobante
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido obtenerPorId(String id) {
        // No implementado aún
        return null;
    }

    @Override
    public List<Pedido> obtenerTodos() {
        List<Pedido> lista = new ArrayList<>();
        try {
            String sql = "SELECT id_pedido, modo_consumo, total, fecha, id_comprobante FROM pedidos";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id_pedido");
                String modoConsumo = rs.getString("modo_consumo");
                double total = rs.getDouble("total");
                Timestamp fecha = rs.getTimestamp("fecha");
                String comprobante = rs.getString("id_comprobante");
                // Puedes crear un Pedido con los datos mínimos (ajusta según tu constructor)
                Pedido pedido = new Pedido(id, modoConsumo, null, null, null, null, null, 1, comprobante, null);
                // Si tu constructor requiere más datos, adáptalo aquí
                lista.add(pedido);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

/* La clase PedidoRepositoryBD implementa la interfaz PedidoRepository para gestionar la persistencia de pedidos en una base de 
datos utilizando JDBC. Su propósito principal es permitir guardar, buscar por ID y listar todos los pedidos desde una fuente de 
datos relacional. Aunque actualmente solo está implementado el método guardarPedido, la estructura está preparada para completar
las operaciones CRUD necesarias en un entorno de almacenamiento persistente. Esta clase forma parte del patrón Repository, que
separa la lógica de acceso a datos de la lógica del negocio, facilitando el mantenimiento y la escalabilidad del sistema.*/