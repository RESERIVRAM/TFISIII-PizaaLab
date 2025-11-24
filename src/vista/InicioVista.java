package vista;

import controlador.PedidoControlador;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import modelo.Ingrediente;
import modelo.Pizza;

public class InicioVista extends javax.swing.JFrame {
    private PedidoControlador controlador;  // importar controlador
    private ProcesoPagoVista procesoPagoVista;
    // Variables para guardar el tamaño y la masa seleccionados
    private String tamanioSeleccionado = "";
    private String masaSeleccionada = "";
    private String nombrePizzaSeleccionada = "";
    private List<Ingrediente> ingredientesSeleccionados = new ArrayList<>();
    private String metodoPagoSeleccionado = null;

    public void setControlador(PedidoControlador ctrl) {
        this.controlador = ctrl;
    }
    
    public void setProcesoPagoVista(ProcesoPagoVista vista) {
        this.procesoPagoVista = vista;
    }
    public void setMetodoPagoSeleccionado(String metodo) {
        this.metodoPagoSeleccionado = metodo;
    }
    public String getMetodoPagoSeleccionado() {
        return metodoPagoSeleccionado;
    }

    public String getCantidadSeleccionada() {
        return jl_cantidad.getText();
    }

    public InicioVista() {
        initComponents();
        
        this.setLocationRelativeTo(null);
           
        // Ocultar titulo de destacados y pizzas
        jp_destacadosCompleto.setVisible(false);
        jp_superior_seleccion.setVisible(false);
        jp_barra_proceso.setVisible(false);
        jp_tamanioPizza.setVisible(false);
        jp_masaPizza.setVisible(false);
        jp_ingredientes.setVisible(false);
        jp_resumen_pedido.setVisible(false);
        
        // Ocultar apartados de la barra de seleccion
        jl_casilla_tamanio1.setVisible(false);
        jl_titulo_masa.setVisible(false);
        jl_casilla_ingrediente.setVisible(false);
        jl_casilla_masa.setVisible(false);
        jl_casilla_masa1.setVisible(false);
        jl_escogiendo_masa.setVisible(false);
        
        jp_barra_proceso2.setVisible(false); // Ocultar apartados de la barra de seleccion 2

        // Quitar las negritas a las interacciones de la izquierda, dejando solo inicio
        jb_crear_pizza.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        jb_pizzas.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        jb_destacados.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        
        jl_precio_margarita.setFont(jl_precio_margarita.getFont().deriveFont(Font.PLAIN));
        jl_precio_hawaiana.setFont(jl_precio_hawaiana.getFont().deriveFont(Font.PLAIN));
        jl_precio_mozzarella.setFont(jl_precio_mozzarella.getFont().deriveFont(Font.PLAIN));
        jl_precio_americana.setFont(jl_precio_americana.getFont().deriveFont(Font.PLAIN));
        
        jl_precio_total2.setFont(jl_precio_total2.getFont().deriveFont(Font.PLAIN));
        jl_precio_individual.setFont(jl_precio_individual.getFont().deriveFont(Font.PLAIN));
        jl_precio_mediana.setFont(jl_precio_mediana.getFont().deriveFont(Font.PLAIN));
        jl_precio_grande.setFont(jl_precio_grande.getFont().deriveFont(Font.PLAIN));
        jl_precio_familiar.setFont(jl_precio_familiar.getFont().deriveFont(Font.PLAIN));
        
        jb_agregar_pedido.setFont(jb_agregar_pedido.getFont().deriveFont(Font.PLAIN));
        jb_agregar_pedido1.setFont(jb_agregar_pedido1.getFont().deriveFont(Font.PLAIN));
        jb_cancelar_pedido.setFont(jb_cancelar_pedido.getFont().deriveFont(Font.PLAIN));
        jb_cancelar_pedido1.setFont(jb_cancelar_pedido1.getFont().deriveFont(Font.PLAIN));
    }
    
    public void cancelarPedido(){
        // Resetear labels de precio
        jl_precio_total1.setText("S/ 0.00");
        jl_precio_total2.setText("S/ 0.00");

        // Resetear selección de tamaño, masa e ingredientes
        tamanioSeleccionado = "";
        masaSeleccionada = "";
        nombrePizzaSeleccionada = "";
        ingredientesSeleccionados.clear();

        // Resetear labels de selección
        if (jl_escogiendo_tamanio1 != null) jl_escogiendo_tamanio1.setText("Escogiendo...");
        if (jl_escogiendo_masa != null) jl_escogiendo_masa.setText("Escogiendo...");
        if (jl_escogiendo_ingrediente != null) jl_escogiendo_ingrediente.setText("Escogiendo...");

        // Deseleccionar todos los checkboxes de ingredientes
        jcb_jamon.setSelected(false);
        jcb_peperoni.setSelected(false);
        jcb_tocino.setSelected(false);
        jcb_carne.setSelected(false);
        jcb_pimiento.setSelected(false);
        jcb_tomate.setSelected(false);
        jcb_champinon.setSelected(false);
        jcb_aceituna.setSelected(false);
        jcb_coca.setSelected(false);
        jcb_inca.setSelected(false);
        jcb_pepsi.setSelected(false);
        jcb_sprite.setSelected(false);
        
        // Ocultar todo
        jp_destacadosCompleto.setVisible(false);
        jp_superior_seleccion.setVisible(false);
        jp_barra_proceso.setVisible(false);
        jp_tamanioPizza.setVisible(false);
        jp_masaPizza.setVisible(false);
        jp_ingredientes.setVisible(false);
        jp_barra_proceso2.setVisible(false);
        jp_barra_proceso.setVisible(false);
        jp_resumen_pedido.setVisible(false);
        
        // Ocultar apartados de la barra de seleccion
        jl_casilla_tamanio1.setVisible(false);
        jl_titulo_masa.setVisible(false);
        jl_casilla_ingrediente.setVisible(false);
        jl_casilla_masa.setVisible(false);
        jl_casilla_masa1.setVisible(false);
        jl_escogiendo_masa.setVisible(false);
        
        // Mostrar inicio
        jp_mi_pizza_lab.setVisible(true);
        jp_menu.setVisible(true);
        jp_inicioCompleto.setVisible(true);
        jp_logo.setVisible(true);
        jl_publicidad.setVisible(true);
        jp_parte_pago.setVisible(true);
    }
    
    public void mostrarPanelSeleccion(){
        // Ocultar todo el set del Inicio con destacados y barras
        jp_destacadosCompleto.setVisible(false);
        jp_menu.setVisible(false);
        jp_mi_pizza_lab.setVisible(false);
        jp_logo.setVisible(false);
        jl_publicidad.setVisible(false);
        
        // Mostrar nuevo apartado de seleccion
        jp_superior_seleccion.setVisible(true);
        jp_barra_proceso.setVisible(true);
        jp_tamanioPizza.setVisible(true);
        jp_masaPizza.setVisible(true);
    }
    
    public void mostrarSeleccionMasa(){
        // Ocultar todo el set seleccion tamaño
        jp_tamanioPizza.setVisible(false);
        jp_destacadosCompleto.setVisible(false);
        jp_inicioCompleto.setVisible(false);              
        jp_menu.setVisible(false);
        jp_mi_pizza_lab.setVisible(false);
        jp_logo.setVisible(false);
        jl_publicidad.setVisible(false);
        
        // Mostrar nuevo apartado seleccion masa
        jp_masaPizza.setVisible(true);
        jl_casilla_tamanio1.setVisible(true);
        jl_titulo_masa.setVisible(true);
        jl_casilla_ingrediente.setVisible(true);
        jl_escogiendo_masa.setVisible(true);
        jl_casilla_masa.setVisible(true);
    }
    
    public void mostrarResumenPedido(){
        jp_ingredientes.setVisible(false);
        jp_resumen_pedido.setVisible(true);
    }


public void actualizarPrecioTotalEnVista(Pizza pizza) {
    if (pizza == null) return;

    int cantidad = 1;
    try {
        cantidad = Integer.parseInt(jl_cantidad.getText().trim());
    } catch (Exception e) {
        cantidad = 1;
    }

    double total = pizza.getPrecio() * cantidad;
    String totalFormateado = String.format("S/ %.2f", total);
    jl_precio_total1.setText(totalFormateado);
    jl_precio_total2.setText(totalFormateado);
}

    // Para comprobante y BD
public double getPrecioFinalActual() {
    double total = controlador.calcularPrecioFinalActual();
    jl_precio_total1.setText("S/ " + String.format("%.2f", total));
    jl_precio_total2.setText("S/ " + String.format("%.2f", total));
    return total; // <-- esto faltaba
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_fondo = new javax.swing.JPanel();
        jp_superior_seleccion = new javax.swing.JPanel();
        jp_logo1 = new MyContainers.PanelRound();
        jl_img_logo1 = new javax.swing.JLabel();
        jl_precio_total2 = new javax.swing.JLabel();
        jl_producto = new javax.swing.JLabel();
        jl_titulo_pizza = new javax.swing.JLabel();
        jp_barra_proceso2 = new MyContainers.PanelRound();
        jl_casilla_ingrediente1 = new javax.swing.JLabel();
        jl_casilla_ingrediente = new javax.swing.JLabel();
        jl_escogiendo_ingrediente = new javax.swing.JLabel();
        jl_titulo_ingrediente = new javax.swing.JLabel();
        jp_barra_proceso = new MyContainers.PanelRound();
        jl_casilla_masa = new javax.swing.JLabel();
        jl_casilla_masa1 = new javax.swing.JLabel();
        jl_titulo_masa = new javax.swing.JLabel();
        jl_escogiendo_masa = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jl_casilla_tamanio1 = new javax.swing.JLabel();
        jl_casilla_tamanio = new javax.swing.JLabel();
        jl_casilla_producto = new javax.swing.JLabel();
        jl_eleccion_producto = new javax.swing.JLabel();
        jl_escogiendo_tamanio1 = new javax.swing.JLabel();
        jp_ingredientes = new javax.swing.JPanel();
        jl_titulo_ingredientes = new javax.swing.JLabel();
        jl_titulo_bebidas = new javax.swing.JLabel();
        jl_titulo_verduras = new javax.swing.JLabel();
        jl_titulo_carnes = new javax.swing.JLabel();
        jsp_eleccion_bebidas = new javax.swing.JScrollPane();
        jp_bebidas = new javax.swing.JPanel();
        jp_coca = new MyContainers.PanelRound();
        jl_coca_precio = new javax.swing.JLabel();
        jcb_coca = new MyContainers.JCheckBoxCustom();
        jp_inca = new MyContainers.PanelRound();
        jl_inca_precio = new javax.swing.JLabel();
        jcb_inca = new MyContainers.JCheckBoxCustom();
        jp_pepsi = new MyContainers.PanelRound();
        jl_pepsi_precio = new javax.swing.JLabel();
        jcb_pepsi = new MyContainers.JCheckBoxCustom();
        jp_sprite = new MyContainers.PanelRound();
        jl_sprite_precio = new javax.swing.JLabel();
        jcb_sprite = new MyContainers.JCheckBoxCustom();
        jsp_eleccion_carnes = new javax.swing.JScrollPane();
        jp_embutido = new javax.swing.JPanel();
        jp_jamon = new MyContainers.PanelRound();
        jl_jamon_precio = new javax.swing.JLabel();
        jcb_jamon = new MyContainers.JCheckBoxCustom();
        jp_peperoni = new MyContainers.PanelRound();
        jl_peperoni_precio = new javax.swing.JLabel();
        jcb_peperoni = new MyContainers.JCheckBoxCustom();
        jp_tocino = new MyContainers.PanelRound();
        jl_tocino_precio = new javax.swing.JLabel();
        jcb_tocino = new MyContainers.JCheckBoxCustom();
        jp_carne = new MyContainers.PanelRound();
        jl_carne_precio = new javax.swing.JLabel();
        jcb_carne = new MyContainers.JCheckBoxCustom();
        jsp_eleccion_verduras = new javax.swing.JScrollPane();
        jp_verduras = new javax.swing.JPanel();
        jp_pimiento = new MyContainers.PanelRound();
        jl_pimiento_precio = new javax.swing.JLabel();
        jcb_pimiento = new MyContainers.JCheckBoxCustom();
        jp_tomate = new MyContainers.PanelRound();
        jl_tomate_precio = new javax.swing.JLabel();
        jcb_tomate = new MyContainers.JCheckBoxCustom();
        jp_champinon = new MyContainers.PanelRound();
        jl_champinon_precio = new javax.swing.JLabel();
        jcb_champinon = new MyContainers.JCheckBoxCustom();
        jp_aceituna = new MyContainers.PanelRound();
        jl_aceituna_precio = new javax.swing.JLabel();
        jcb_aceituna = new MyContainers.JCheckBoxCustom();
        jp_resumen_pedido = new javax.swing.JPanel();
        jp_cantidad = new MyContainers.PanelRound();
        jl_cantidad = new javax.swing.JLabel();
        jb_mas = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jb_menos = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jl_titulo_ingredientes1 = new javax.swing.JLabel();
        jp_cancelar_pedido1 = new MyContainers.PanelRound();
        jb_cancelar_pedido1 = new javax.swing.JButton();
        jp_agregar_pedido1 = new MyContainers.PanelRound();
        jb_agregar_pedido1 = new javax.swing.JButton();
        jp_tamanioPizza = new javax.swing.JPanel();
        jl_titulo_tamanio = new javax.swing.JLabel();
        jp_pizza_individual = new MyContainers.PanelRound();
        jLabel13 = new javax.swing.JLabel();
        jl_precio_individual = new javax.swing.JLabel();
        jb_individual = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_pizza_mediana = new MyContainers.PanelRound();
        jLabel15 = new javax.swing.JLabel();
        jl_precio_mediana = new javax.swing.JLabel();
        jb_mediana = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_pizza_grande = new MyContainers.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        jl_precio_grande = new javax.swing.JLabel();
        jb_grande = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_pizza_familiar = new MyContainers.PanelRound();
        jLabel19 = new javax.swing.JLabel();
        jb_familiar = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jl_precio_familiar = new javax.swing.JLabel();
        jp_masaPizza = new javax.swing.JPanel();
        jl_titulo_tamanio2 = new javax.swing.JLabel();
        jp_masa_clasica = new MyContainers.PanelRound();
        jLabel22 = new javax.swing.JLabel();
        jb_masa_clasica = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_masa_fina = new MyContainers.PanelRound();
        jLabel23 = new javax.swing.JLabel();
        jb_mediana1 = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_parte_pago = new javax.swing.JPanel();
        jl_precio_total = new javax.swing.JLabel();
        jp_agregar_pedido = new MyContainers.PanelRound();
        jb_agregar_pedido = new javax.swing.JButton();
        jp_cancelar_pedido = new MyContainers.PanelRound();
        jb_cancelar_pedido = new javax.swing.JButton();
        jl_precio_total1 = new javax.swing.JLabel();
        jp_logo = new MyContainers.PanelRound();
        jl_img_logo = new javax.swing.JLabel();
        jl_publicidad = new javax.swing.JLabel();
        jp_mi_pizza_lab = new MyContainers.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jb_crear_pizza = new javax.swing.JButton();
        jb_inicio = new javax.swing.JButton();
        jp_menu = new MyContainers.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jb_pizzas = new javax.swing.JButton();
        jb_destacados = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jp_inicioCompleto = new javax.swing.JPanel();
        jl_pregunta_inicio = new javax.swing.JLabel();
        jb_logo_crear = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_pizzas = new MyContainers.PanelRound();
        jLabel11 = new javax.swing.JLabel();
        jb_pizzas_img = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_destacados = new MyContainers.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        jb_destacados_img = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jp_destacadosCompleto = new javax.swing.JPanel();
        jl_pregunta_destacados = new javax.swing.JLabel();
        jl_img_retroceder = new javax.swing.JLabel();
        jb_retroceder = new javax.swing.JButton();
        jp_pizza_americana = new MyContainers.PanelRound();
        jLabel18 = new javax.swing.JLabel();
        jb_americana = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jl_precio_americana = new javax.swing.JLabel();
        jp_pizza_mozzarella = new MyContainers.PanelRound();
        jLabel16 = new javax.swing.JLabel();
        jb_mozzarella = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jl_precio_mozzarella = new javax.swing.JLabel();
        jp_pizza_hawaiana = new MyContainers.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        jb_hawaiana = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jl_precio_hawaiana = new javax.swing.JLabel();
        jp_pizza_margarita = new MyContainers.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        jb_margarita = new javax.swing.JButton("<html><u>Texto Subrayado</u></html>");
        jl_precio_margarita = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_fondo.setBackground(new java.awt.Color(242, 238, 228));
        jp_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_superior_seleccion.setBackground(new java.awt.Color(242, 238, 228));
        jp_superior_seleccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_logo1.setBackground(new java.awt.Color(242, 229, 209));
        jp_logo1.setRoundBottomLeft(20);
        jp_logo1.setRoundBottomRight(20);
        jp_logo1.setRoundTopLeft(20);
        jp_logo1.setRoundTopRight(20);
        jp_logo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_img_logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoPizza70x65.png"))); // NOI18N
        jp_logo1.add(jl_img_logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 70));

        jp_superior_seleccion.add(jp_logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 140, 110));

        jl_precio_total2.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_total2.setText("S/ 0.00");
        jp_superior_seleccion.add(jl_precio_total2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jl_producto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_producto.setForeground(new java.awt.Color(0, 0, 0));
        jl_producto.setText("Producto");
        jp_superior_seleccion.add(jl_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 65, -1, -1));

        jl_titulo_pizza.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jl_titulo_pizza.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_pizza.setText("Pizza Nombre");
        jp_superior_seleccion.add(jl_titulo_pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jp_fondo.add(jp_superior_seleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 150));

        jp_barra_proceso2.setBackground(new java.awt.Color(242, 229, 209));
        jp_barra_proceso2.setRoundBottomLeft(20);
        jp_barra_proceso2.setRoundBottomRight(20);
        jp_barra_proceso2.setRoundTopLeft(20);
        jp_barra_proceso2.setRoundTopRight(20);
        jp_barra_proceso2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_casilla_ingrediente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check15x15.png"))); // NOI18N
        jp_barra_proceso2.add(jl_casilla_ingrediente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, -1, 20));

        jl_casilla_ingrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/casilla15x15.png"))); // NOI18N
        jp_barra_proceso2.add(jl_casilla_ingrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, -1, 20));

        jl_escogiendo_ingrediente.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jl_escogiendo_ingrediente.setForeground(new java.awt.Color(0, 0, 0));
        jl_escogiendo_ingrediente.setText("Escogiendo...");
        jp_barra_proceso2.add(jl_escogiendo_ingrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jl_titulo_ingrediente.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jl_titulo_ingrediente.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_ingrediente.setText("Ingredientes");
        jp_barra_proceso2.add(jl_titulo_ingrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 20));

        jp_fondo.add(jp_barra_proceso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 350, 140, 110));

        jp_barra_proceso.setBackground(new java.awt.Color(242, 229, 209));
        jp_barra_proceso.setRoundBottomLeft(20);
        jp_barra_proceso.setRoundBottomRight(20);
        jp_barra_proceso.setRoundTopLeft(20);
        jp_barra_proceso.setRoundTopRight(20);
        jp_barra_proceso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_casilla_masa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/casilla15x15.png"))); // NOI18N
        jp_barra_proceso.add(jl_casilla_masa, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, -1, 20));

        jl_casilla_masa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check15x15.png"))); // NOI18N
        jp_barra_proceso.add(jl_casilla_masa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, -1, 20));

        jl_titulo_masa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jl_titulo_masa.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_masa.setText("Masa");
        jp_barra_proceso.add(jl_titulo_masa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jl_escogiendo_masa.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jl_escogiendo_masa.setForeground(new java.awt.Color(0, 0, 0));
        jl_escogiendo_masa.setText("Escogiendo...");
        jp_barra_proceso.add(jl_escogiendo_masa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Tamaño");
        jp_barra_proceso.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Producto");
        jp_barra_proceso.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jl_casilla_tamanio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check15x15.png"))); // NOI18N
        jp_barra_proceso.add(jl_casilla_tamanio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, -1, 20));

        jl_casilla_tamanio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/casilla15x15.png"))); // NOI18N
        jp_barra_proceso.add(jl_casilla_tamanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, -1, 20));

        jl_casilla_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check15x15.png"))); // NOI18N
        jp_barra_proceso.add(jl_casilla_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, -1, 20));

        jl_eleccion_producto.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jl_eleccion_producto.setForeground(new java.awt.Color(0, 0, 0));
        jl_eleccion_producto.setText("Pizza Nombre");
        jp_barra_proceso.add(jl_eleccion_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jl_escogiendo_tamanio1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jl_escogiendo_tamanio1.setForeground(new java.awt.Color(0, 0, 0));
        jl_escogiendo_tamanio1.setText("Escogiendo...");
        jp_barra_proceso.add(jl_escogiendo_tamanio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jp_fondo.add(jp_barra_proceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 170, 140, 200));

        jp_ingredientes.setBackground(new java.awt.Color(242, 238, 228));
        jp_ingredientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_titulo_ingredientes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jl_titulo_ingredientes.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_ingredientes.setText("Ingredientes");
        jp_ingredientes.add(jl_titulo_ingredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jl_titulo_bebidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jl_titulo_bebidas.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_bebidas.setText("Bebidas");
        jp_ingredientes.add(jl_titulo_bebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, -1, -1));

        jl_titulo_verduras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jl_titulo_verduras.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_verduras.setText("Verduras");
        jp_ingredientes.add(jl_titulo_verduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        jl_titulo_carnes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jl_titulo_carnes.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_carnes.setText("Carnes");
        jp_ingredientes.add(jl_titulo_carnes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jsp_eleccion_bebidas.setBorder(null);
        jsp_eleccion_bebidas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jp_bebidas.setBackground(new java.awt.Color(242, 238, 228));
        jp_bebidas.setEnabled(false);
        jp_bebidas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_coca.setBackground(new java.awt.Color(242, 221, 171));
        jp_coca.setRoundBottomLeft(20);
        jp_coca.setRoundBottomRight(20);
        jp_coca.setRoundTopLeft(20);
        jp_coca.setRoundTopRight(20);
        jp_coca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_coca_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_coca_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_coca_precio.setText("Coca-Cola  500ml            S/ 3.50");
        jp_coca.add(jl_coca_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_coca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_cocaActionPerformed(evt);
            }
        });
        jp_coca.add(jcb_coca, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_bebidas.add(jp_coca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));

        jp_inca.setBackground(new java.awt.Color(242, 221, 171));
        jp_inca.setRoundBottomLeft(20);
        jp_inca.setRoundBottomRight(20);
        jp_inca.setRoundTopLeft(20);
        jp_inca.setRoundTopRight(20);
        jp_inca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_inca_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_inca_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_inca_precio.setText("Inca Kola  500ml              S/ 3.50");
        jp_inca.add(jl_inca_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_inca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_incaActionPerformed(evt);
            }
        });
        jp_inca.add(jcb_inca, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_bebidas.add(jp_inca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 30));

        jp_pepsi.setBackground(new java.awt.Color(242, 221, 171));
        jp_pepsi.setRoundBottomLeft(20);
        jp_pepsi.setRoundBottomRight(20);
        jp_pepsi.setRoundTopLeft(20);
        jp_pepsi.setRoundTopRight(20);
        jp_pepsi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_pepsi_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_pepsi_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_pepsi_precio.setText("Pepsi  500ml                    S/ 2.50");
        jp_pepsi.add(jl_pepsi_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_pepsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_pepsiActionPerformed(evt);
            }
        });
        jp_pepsi.add(jcb_pepsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_bebidas.add(jp_pepsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 220, 30));

        jp_sprite.setBackground(new java.awt.Color(242, 221, 171));
        jp_sprite.setRoundBottomLeft(20);
        jp_sprite.setRoundBottomRight(20);
        jp_sprite.setRoundTopLeft(20);
        jp_sprite.setRoundTopRight(20);
        jp_sprite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_sprite_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_sprite_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_sprite_precio.setText("Sprite  500ml                   S/ 2.50");
        jp_sprite.add(jl_sprite_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_sprite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_spriteActionPerformed(evt);
            }
        });
        jp_sprite.add(jcb_sprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_bebidas.add(jp_sprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 30));

        jsp_eleccion_bebidas.setViewportView(jp_bebidas);

        jp_ingredientes.add(jsp_eleccion_bebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 240, 70));

        jsp_eleccion_carnes.setBorder(null);
        jsp_eleccion_carnes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jp_embutido.setBackground(new java.awt.Color(242, 238, 228));
        jp_embutido.setEnabled(false);
        jp_embutido.setMinimumSize(new java.awt.Dimension(220, 150));
        jp_embutido.setPreferredSize(new java.awt.Dimension(220, 150));
        jp_embutido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_jamon.setBackground(new java.awt.Color(242, 221, 171));
        jp_jamon.setRoundBottomLeft(20);
        jp_jamon.setRoundBottomRight(20);
        jp_jamon.setRoundTopLeft(20);
        jp_jamon.setRoundTopRight(20);
        jp_jamon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_jamon_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_jamon_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_jamon_precio.setText("Jamón                               S/ 1.99");
        jp_jamon.add(jl_jamon_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_jamon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_jamonActionPerformed(evt);
            }
        });
        jp_jamon.add(jcb_jamon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_embutido.add(jp_jamon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));

        jp_peperoni.setBackground(new java.awt.Color(242, 221, 171));
        jp_peperoni.setRoundBottomLeft(20);
        jp_peperoni.setRoundBottomRight(20);
        jp_peperoni.setRoundTopLeft(20);
        jp_peperoni.setRoundTopRight(20);
        jp_peperoni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_peperoni_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_peperoni_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_peperoni_precio.setText("Peperoni                           S/ 1.99");
        jp_peperoni.add(jl_peperoni_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_peperoni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_peperoniActionPerformed(evt);
            }
        });
        jp_peperoni.add(jcb_peperoni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_embutido.add(jp_peperoni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 30));

        jp_tocino.setBackground(new java.awt.Color(242, 221, 171));
        jp_tocino.setRoundBottomLeft(20);
        jp_tocino.setRoundBottomRight(20);
        jp_tocino.setRoundTopLeft(20);
        jp_tocino.setRoundTopRight(20);
        jp_tocino.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_tocino_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_tocino_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_tocino_precio.setText("Tocino                              S/ 2.99");
        jp_tocino.add(jl_tocino_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_tocino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tocinoActionPerformed(evt);
            }
        });
        jp_tocino.add(jcb_tocino, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_embutido.add(jp_tocino, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 220, 30));

        jp_carne.setBackground(new java.awt.Color(242, 221, 171));
        jp_carne.setRoundBottomLeft(20);
        jp_carne.setRoundBottomRight(20);
        jp_carne.setRoundTopLeft(20);
        jp_carne.setRoundTopRight(20);
        jp_carne.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_carne_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_carne_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_carne_precio.setText("Carne molida                   S/ 2.99");
        jp_carne.add(jl_carne_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_carne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_carneActionPerformed(evt);
            }
        });
        jp_carne.add(jcb_carne, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_embutido.add(jp_carne, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 30));

        jsp_eleccion_carnes.setViewportView(jp_embutido);

        jp_ingredientes.add(jsp_eleccion_carnes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 240, 70));

        jsp_eleccion_verduras.setBorder(null);
        jsp_eleccion_verduras.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jp_verduras.setBackground(new java.awt.Color(242, 238, 228));
        jp_verduras.setEnabled(false);
        jp_verduras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_pimiento.setBackground(new java.awt.Color(242, 221, 171));
        jp_pimiento.setRoundBottomLeft(20);
        jp_pimiento.setRoundBottomRight(20);
        jp_pimiento.setRoundTopLeft(20);
        jp_pimiento.setRoundTopRight(20);
        jp_pimiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_pimiento_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_pimiento_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_pimiento_precio.setText("Pimiento                           S/ 0.80");
        jp_pimiento.add(jl_pimiento_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_pimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_pimientoActionPerformed(evt);
            }
        });
        jp_pimiento.add(jcb_pimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_verduras.add(jp_pimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 30));

        jp_tomate.setBackground(new java.awt.Color(242, 221, 171));
        jp_tomate.setRoundBottomLeft(20);
        jp_tomate.setRoundBottomRight(20);
        jp_tomate.setRoundTopLeft(20);
        jp_tomate.setRoundTopRight(20);
        jp_tomate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_tomate_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_tomate_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_tomate_precio.setText("Tomate                             S/ 0.50");
        jp_tomate.add(jl_tomate_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_tomate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tomateActionPerformed(evt);
            }
        });
        jp_tomate.add(jcb_tomate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_verduras.add(jp_tomate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 30));

        jp_champinon.setBackground(new java.awt.Color(242, 221, 171));
        jp_champinon.setRoundBottomLeft(20);
        jp_champinon.setRoundBottomRight(20);
        jp_champinon.setRoundTopLeft(20);
        jp_champinon.setRoundTopRight(20);
        jp_champinon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_champinon_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_champinon_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_champinon_precio.setText("Champiñon                      S/ 1.30");
        jp_champinon.add(jl_champinon_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_champinon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_champinonActionPerformed(evt);
            }
        });
        jp_champinon.add(jcb_champinon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_verduras.add(jp_champinon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 220, 30));

        jp_aceituna.setBackground(new java.awt.Color(242, 221, 171));
        jp_aceituna.setRoundBottomLeft(20);
        jp_aceituna.setRoundBottomRight(20);
        jp_aceituna.setRoundTopLeft(20);
        jp_aceituna.setRoundTopRight(20);
        jp_aceituna.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_aceituna_precio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jl_aceituna_precio.setForeground(new java.awt.Color(0, 0, 0));
        jl_aceituna_precio.setText("Aceituna                          S/ 1.60");
        jp_aceituna.add(jl_aceituna_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 180, 15));

        jcb_aceituna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_aceitunaActionPerformed(evt);
            }
        });
        jp_aceituna.add(jcb_aceituna, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 6, 20, -1));

        jp_verduras.add(jp_aceituna, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 220, 30));

        jsp_eleccion_verduras.setViewportView(jp_verduras);

        jp_ingredientes.add(jsp_eleccion_verduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 240, 70));

        jp_fondo.add(jp_ingredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        jp_resumen_pedido.setBackground(new java.awt.Color(242, 238, 228));
        jp_resumen_pedido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_cantidad.setBackground(new java.awt.Color(242, 229, 209));
        jp_cantidad.setRoundBottomLeft(20);
        jp_cantidad.setRoundBottomRight(20);
        jp_cantidad.setRoundTopLeft(20);
        jp_cantidad.setRoundTopRight(20);
        jp_cantidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_cantidad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jl_cantidad.setForeground(new java.awt.Color(0, 0, 0));
        jl_cantidad.setText("1");
        jp_cantidad.add(jl_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 20, -1));

        jb_mas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas25x25.png"))); // NOI18N
        jb_mas.setText("");
        jb_mas.setToolTipText("");
        jb_mas.setBorder(null);
        jb_mas.setBorderPainted(false);
        jb_mas.setContentAreaFilled(false);
        jb_mas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_mas.setFocusPainted(false);
        jb_mas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_masActionPerformed(evt);
            }
        });
        jp_cantidad.add(jb_mas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 30, 30));

        jb_menos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menos20x20.png"))); // NOI18N
        jb_menos.setText("");
        jb_menos.setToolTipText("");
        jb_menos.setBorder(null);
        jb_menos.setBorderPainted(false);
        jb_menos.setContentAreaFilled(false);
        jb_menos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_menos.setFocusPainted(false);
        jb_menos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_menosActionPerformed(evt);
            }
        });
        jp_cantidad.add(jb_menos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jp_resumen_pedido.add(jp_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 290, 50));

        jl_titulo_ingredientes1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jl_titulo_ingredientes1.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_ingredientes1.setText("Resumen");
        jp_resumen_pedido.add(jl_titulo_ingredientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jp_cancelar_pedido1.setBackground(new java.awt.Color(204, 204, 204));
        jp_cancelar_pedido1.setRoundBottomLeft(20);
        jp_cancelar_pedido1.setRoundBottomRight(20);
        jp_cancelar_pedido1.setRoundTopLeft(20);
        jp_cancelar_pedido1.setRoundTopRight(20);

        jb_cancelar_pedido1.setBackground(new java.awt.Color(242, 229, 209));
        jb_cancelar_pedido1.setForeground(new java.awt.Color(0, 0, 0));
        jb_cancelar_pedido1.setText("Cancelar Pedido");
        jb_cancelar_pedido1.setBorder(null);
        jb_cancelar_pedido1.setBorderPainted(false);
        jb_cancelar_pedido1.setContentAreaFilled(false);
        jb_cancelar_pedido1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_cancelar_pedido1.setFocusPainted(false);
        jb_cancelar_pedido1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_cancelar_pedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelar_pedido1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_cancelar_pedido1Layout = new javax.swing.GroupLayout(jp_cancelar_pedido1);
        jp_cancelar_pedido1.setLayout(jp_cancelar_pedido1Layout);
        jp_cancelar_pedido1Layout.setHorizontalGroup(
            jp_cancelar_pedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_cancelar_pedido1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_cancelar_pedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jp_cancelar_pedido1Layout.setVerticalGroup(
            jp_cancelar_pedido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_cancelar_pedido1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_cancelar_pedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jp_resumen_pedido.add(jp_cancelar_pedido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, -1, -1));

        jp_agregar_pedido1.setBackground(new java.awt.Color(86, 212, 105));
        jp_agregar_pedido1.setRoundBottomLeft(20);
        jp_agregar_pedido1.setRoundBottomRight(20);
        jp_agregar_pedido1.setRoundTopLeft(20);
        jp_agregar_pedido1.setRoundTopRight(20);
        jp_agregar_pedido1.setLayout(null);

        jb_agregar_pedido1.setBackground(new java.awt.Color(242, 229, 209));
        jb_agregar_pedido1.setForeground(new java.awt.Color(0, 0, 0));
        jb_agregar_pedido1.setText("Confirmar Pedido");
        jb_agregar_pedido1.setBorder(null);
        jb_agregar_pedido1.setBorderPainted(false);
        jb_agregar_pedido1.setContentAreaFilled(false);
        jb_agregar_pedido1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_agregar_pedido1.setFocusPainted(false);
        jb_agregar_pedido1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_agregar_pedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregar_pedido1ActionPerformed(evt);
            }
        });
        jp_agregar_pedido1.add(jb_agregar_pedido1);
        jb_agregar_pedido1.setBounds(0, 0, 140, 40);

        jp_resumen_pedido.add(jp_agregar_pedido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 140, 40));

        jp_fondo.add(jp_resumen_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 730));

        jp_tamanioPizza.setBackground(new java.awt.Color(242, 238, 228));
        jp_tamanioPizza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_titulo_tamanio.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jl_titulo_tamanio.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_tamanio.setText("Tamaño");
        jp_tamanioPizza.add(jl_titulo_tamanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jp_pizza_individual.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_individual.setRoundBottomLeft(20);
        jp_pizza_individual.setRoundBottomRight(20);
        jp_pizza_individual.setRoundTopLeft(20);
        jp_pizza_individual.setRoundTopRight(20);
        jp_pizza_individual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Individual");
        jp_pizza_individual.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 95, -1, -1));

        jl_precio_individual.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_individual.setText("S/ 8.99");
        jl_precio_individual.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_individual.add(jl_precio_individual, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 50, -1));

        jb_individual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_individual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaIndividual60x89.png"))); // NOI18N
        jb_individual.setText("");
        jb_individual.setToolTipText("");
        jb_individual.setBorder(null);
        jb_individual.setBorderPainted(false);
        jb_individual.setContentAreaFilled(false);
        jb_individual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_individual.setFocusPainted(false);
        jb_individual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_individual.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jb_individual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_individualActionPerformed(evt);
            }
        });
        jp_pizza_individual.add(jb_individual, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 7, 120, 130));

        jp_tamanioPizza.add(jp_pizza_individual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 110, 140));

        jp_pizza_mediana.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_mediana.setRoundBottomLeft(20);
        jp_pizza_mediana.setRoundBottomRight(20);
        jp_pizza_mediana.setRoundTopLeft(20);
        jp_pizza_mediana.setRoundTopRight(20);
        jp_pizza_mediana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Mediana");
        jp_pizza_mediana.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 95, -1, -1));

        jl_precio_mediana.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_mediana.setText("S/ 12.99");
        jl_precio_mediana.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_mediana.add(jl_precio_mediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 50, -1));

        jb_mediana.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_mediana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaMediana60x86.png"))); // NOI18N
        jb_mediana.setText("");
        jb_mediana.setToolTipText("");
        jb_mediana.setBorder(null);
        jb_mediana.setBorderPainted(false);
        jb_mediana.setContentAreaFilled(false);
        jb_mediana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_mediana.setFocusPainted(false);
        jb_mediana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_mediana.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jb_mediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_medianaActionPerformed(evt);
            }
        });
        jp_pizza_mediana.add(jb_mediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 130));

        jp_tamanioPizza.add(jp_pizza_mediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 110, 140));

        jp_pizza_grande.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_grande.setRoundBottomLeft(20);
        jp_pizza_grande.setRoundBottomRight(20);
        jp_pizza_grande.setRoundTopLeft(20);
        jp_pizza_grande.setRoundTopRight(20);
        jp_pizza_grande.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Grande");
        jp_pizza_grande.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 95, -1, -1));

        jl_precio_grande.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_grande.setText("S/ 18.99");
        jl_precio_grande.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_grande.add(jl_precio_grande, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 50, -1));

        jb_grande.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_grande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaGrande70x90.png"))); // NOI18N
        jb_grande.setText("");
        jb_grande.setToolTipText("");
        jb_grande.setBorder(null);
        jb_grande.setBorderPainted(false);
        jb_grande.setContentAreaFilled(false);
        jb_grande.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_grande.setFocusPainted(false);
        jb_grande.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_grande.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jb_grande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_grandeActionPerformed(evt);
            }
        });
        jp_pizza_grande.add(jb_grande, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 130));

        jp_tamanioPizza.add(jp_pizza_grande, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 110, 140));

        jp_pizza_familiar.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_familiar.setRoundBottomLeft(20);
        jp_pizza_familiar.setRoundBottomRight(20);
        jp_pizza_familiar.setRoundTopLeft(20);
        jp_pizza_familiar.setRoundTopRight(20);
        jp_pizza_familiar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Familiar");
        jp_pizza_familiar.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 95, -1, -1));

        jb_familiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_familiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaFamiliar75x90.png"))); // NOI18N
        jb_familiar.setText("");
        jb_familiar.setToolTipText("");
        jb_familiar.setBorder(null);
        jb_familiar.setBorderPainted(false);
        jb_familiar.setContentAreaFilled(false);
        jb_familiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_familiar.setFocusPainted(false);
        jb_familiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_familiar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jb_familiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_familiarActionPerformed(evt);
            }
        });
        jp_pizza_familiar.add(jb_familiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 130));

        jl_precio_familiar.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_familiar.setText("S/ 23.99");
        jl_precio_familiar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_familiar.add(jl_precio_familiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 115, 50, -1));

        jp_tamanioPizza.add(jp_pizza_familiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 110, 140));

        jp_fondo.add(jp_tamanioPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        jp_masaPizza.setBackground(new java.awt.Color(242, 238, 228));
        jp_masaPizza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_titulo_tamanio2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jl_titulo_tamanio2.setForeground(new java.awt.Color(0, 0, 0));
        jl_titulo_tamanio2.setText("Tamaño");
        jp_masaPizza.add(jl_titulo_tamanio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jp_masa_clasica.setBackground(new java.awt.Color(242, 229, 209));
        jp_masa_clasica.setRoundBottomLeft(20);
        jp_masa_clasica.setRoundBottomRight(20);
        jp_masa_clasica.setRoundTopLeft(20);
        jp_masa_clasica.setRoundTopRight(20);
        jp_masa_clasica.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Clasica");
        jp_masa_clasica.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 100, -1, -1));

        jb_masa_clasica.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_masa_clasica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/masaClasica80x55.png"))); // NOI18N
        jb_masa_clasica.setText("");
        jb_masa_clasica.setToolTipText("");
        jb_masa_clasica.setBorder(null);
        jb_masa_clasica.setBorderPainted(false);
        jb_masa_clasica.setContentAreaFilled(false);
        jb_masa_clasica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_masa_clasica.setFocusPainted(false);
        jb_masa_clasica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_masa_clasica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_masa_clasicaActionPerformed(evt);
            }
        });
        jp_masa_clasica.add(jb_masa_clasica, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, -3, 100, 120));

        jp_masaPizza.add(jp_masa_clasica, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 110, 140));

        jp_masa_fina.setBackground(new java.awt.Color(242, 229, 209));
        jp_masa_fina.setRoundBottomLeft(20);
        jp_masa_fina.setRoundBottomRight(20);
        jp_masa_fina.setRoundTopLeft(20);
        jp_masa_fina.setRoundTopRight(20);
        jp_masa_fina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Fina");
        jp_masa_fina.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jb_mediana1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_mediana1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/masaFina80x41.png"))); // NOI18N
        jb_mediana1.setText("");
        jb_mediana1.setToolTipText("");
        jb_mediana1.setBorder(null);
        jb_mediana1.setBorderPainted(false);
        jb_mediana1.setContentAreaFilled(false);
        jb_mediana1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_mediana1.setFocusPainted(false);
        jb_mediana1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_mediana1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_mediana1ActionPerformed(evt);
            }
        });
        jp_masa_fina.add(jb_mediana1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 130));

        jp_masaPizza.add(jp_masa_fina, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 110, 140));

        jp_fondo.add(jp_masaPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        jp_parte_pago.setBackground(new java.awt.Color(242, 238, 228));
        jp_parte_pago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jp_parte_pago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_precio_total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jl_precio_total.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_total.setText("Subtotal:");
        jp_parte_pago.add(jl_precio_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jp_agregar_pedido.setBackground(new java.awt.Color(86, 212, 105));
        jp_agregar_pedido.setRoundBottomLeft(20);
        jp_agregar_pedido.setRoundBottomRight(20);
        jp_agregar_pedido.setRoundTopLeft(20);
        jp_agregar_pedido.setRoundTopRight(20);
        jp_agregar_pedido.setLayout(null);

        jb_agregar_pedido.setBackground(new java.awt.Color(242, 229, 209));
        jb_agregar_pedido.setForeground(new java.awt.Color(0, 0, 0));
        jb_agregar_pedido.setText("Añadir al Pedido");
        jb_agregar_pedido.setBorder(null);
        jb_agregar_pedido.setBorderPainted(false);
        jb_agregar_pedido.setContentAreaFilled(false);
        jb_agregar_pedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_agregar_pedido.setFocusPainted(false);
        jb_agregar_pedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_agregar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregar_pedidoActionPerformed(evt);
            }
        });
        jp_agregar_pedido.add(jb_agregar_pedido);
        jb_agregar_pedido.setBounds(0, 1, 140, 40);

        jp_parte_pago.add(jp_agregar_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 140, 40));

        jp_cancelar_pedido.setBackground(new java.awt.Color(204, 204, 204));
        jp_cancelar_pedido.setRoundBottomLeft(20);
        jp_cancelar_pedido.setRoundBottomRight(20);
        jp_cancelar_pedido.setRoundTopLeft(20);
        jp_cancelar_pedido.setRoundTopRight(20);

        jb_cancelar_pedido.setBackground(new java.awt.Color(242, 229, 209));
        jb_cancelar_pedido.setForeground(new java.awt.Color(0, 0, 0));
        jb_cancelar_pedido.setText("Cancelar Pedido");
        jb_cancelar_pedido.setBorder(null);
        jb_cancelar_pedido.setBorderPainted(false);
        jb_cancelar_pedido.setContentAreaFilled(false);
        jb_cancelar_pedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_cancelar_pedido.setFocusPainted(false);
        jb_cancelar_pedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_cancelar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelar_pedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_cancelar_pedidoLayout = new javax.swing.GroupLayout(jp_cancelar_pedido);
        jp_cancelar_pedido.setLayout(jp_cancelar_pedidoLayout);
        jp_cancelar_pedidoLayout.setHorizontalGroup(
            jp_cancelar_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_cancelar_pedidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_cancelar_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jp_cancelar_pedidoLayout.setVerticalGroup(
            jp_cancelar_pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_cancelar_pedidoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_cancelar_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jp_parte_pago.add(jp_cancelar_pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        jl_precio_total1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jl_precio_total1.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_total1.setText("S/ 0.00");
        jp_parte_pago.add(jl_precio_total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 25, -1, -1));

        jp_fondo.add(jp_parte_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 410, 150));

        jp_logo.setBackground(new java.awt.Color(242, 229, 209));
        jp_logo.setRoundBottomLeft(20);
        jp_logo.setRoundBottomRight(20);
        jp_logo.setRoundTopLeft(20);
        jp_logo.setRoundTopRight(20);
        jp_logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoPizza70x65.png"))); // NOI18N
        jp_logo.add(jl_img_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 70));

        jp_fondo.add(jp_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 140, 110));

        jl_publicidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Publicidad240x90.png"))); // NOI18N
        jp_fondo.add(jl_publicidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 70));

        jp_mi_pizza_lab.setBackground(new java.awt.Color(242, 229, 209));
        jp_mi_pizza_lab.setRoundBottomLeft(20);
        jp_mi_pizza_lab.setRoundBottomRight(20);
        jp_mi_pizza_lab.setRoundTopLeft(20);
        jp_mi_pizza_lab.setRoundTopRight(20);
        jp_mi_pizza_lab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoCrearPizza20x20.png"))); // NOI18N
        jp_mi_pizza_lab.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoInicio20x20.png"))); // NOI18N
        jp_mi_pizza_lab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 42, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("MiPizzaLab");
        jp_mi_pizza_lab.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 10, -1, -1));

        jb_crear_pizza.setBackground(new java.awt.Color(242, 229, 209));
        jb_crear_pizza.setForeground(new java.awt.Color(0, 0, 0));
        jb_crear_pizza.setText("Crear pizza");
        jb_crear_pizza.setBorder(null);
        jb_crear_pizza.setBorderPainted(false);
        jb_crear_pizza.setContentAreaFilled(false);
        jb_crear_pizza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_crear_pizza.setFocusPainted(false);
        jb_crear_pizza.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_crear_pizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_crear_pizzaActionPerformed(evt);
            }
        });
        jp_mi_pizza_lab.add(jb_crear_pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, -1));

        jb_inicio.setBackground(new java.awt.Color(242, 229, 209));
        jb_inicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jb_inicio.setForeground(new java.awt.Color(0, 0, 0));
        jb_inicio.setText("Inicio");
        jb_inicio.setBorder(null);
        jb_inicio.setBorderPainted(false);
        jb_inicio.setContentAreaFilled(false);
        jb_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_inicio.setFocusPainted(false);
        jb_inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_inicioActionPerformed(evt);
            }
        });
        jp_mi_pizza_lab.add(jb_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, 95, -1));

        jp_fondo.add(jp_mi_pizza_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 140, 110));

        jp_menu.setBackground(new java.awt.Color(242, 229, 209));
        jp_menu.setRoundBottomLeft(20);
        jp_menu.setRoundBottomRight(20);
        jp_menu.setRoundTopLeft(20);
        jp_menu.setRoundTopRight(20);
        jp_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Menú");
        jp_menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 10, -1, -1));

        jb_pizzas.setBackground(new java.awt.Color(242, 229, 209));
        jb_pizzas.setForeground(new java.awt.Color(0, 0, 0));
        jb_pizzas.setText("Pizzas");
        jb_pizzas.setBorder(null);
        jb_pizzas.setBorderPainted(false);
        jb_pizzas.setContentAreaFilled(false);
        jb_pizzas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_pizzas.setFocusPainted(false);
        jb_pizzas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_pizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pizzasActionPerformed(evt);
            }
        });
        jp_menu.add(jb_pizzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, -1));

        jb_destacados.setBackground(new java.awt.Color(242, 229, 209));
        jb_destacados.setForeground(new java.awt.Color(0, 0, 0));
        jb_destacados.setText("Destacados");
        jb_destacados.setBorder(null);
        jb_destacados.setBorderPainted(false);
        jb_destacados.setContentAreaFilled(false);
        jb_destacados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_destacados.setFocusPainted(false);
        jb_destacados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_destacados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_destacadosActionPerformed(evt);
            }
        });
        jp_menu.add(jb_destacados, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPizzasInicio20x20.png"))); // NOI18N
        jp_menu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 98, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoDestacados20x20.png"))); // NOI18N
        jp_menu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jp_fondo.add(jp_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 300, 140, 140));

        jp_inicioCompleto.setBackground(new java.awt.Color(242, 238, 228));
        jp_inicioCompleto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_pregunta_inicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_pregunta_inicio.setForeground(new java.awt.Color(0, 0, 0));
        jl_pregunta_inicio.setText("¿Que te apece hoy?");
        jp_inicioCompleto.add(jl_pregunta_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jb_logo_crear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_logo_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crearpizza200x133.png"))); // NOI18N
        jb_logo_crear.setText("");
        jb_logo_crear.setToolTipText("");
        jb_logo_crear.setBorder(null);
        jb_logo_crear.setBorderPainted(false);
        jb_logo_crear.setContentAreaFilled(false);
        jb_logo_crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_logo_crear.setFocusPainted(false);
        jb_logo_crear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_logo_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_logo_crearActionPerformed(evt);
            }
        });
        jp_inicioCompleto.add(jb_logo_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 180, 90));

        jp_pizzas.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizzas.setRoundBottomLeft(20);
        jp_pizzas.setRoundBottomRight(20);
        jp_pizzas.setRoundTopLeft(20);
        jp_pizzas.setRoundTopRight(20);
        jp_pizzas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pizzas");
        jp_pizzas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 90, 50, -1));

        jb_pizzas_img.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_pizzas_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzasInicio55x55.png"))); // NOI18N
        jb_pizzas_img.setText("");
        jb_pizzas_img.setToolTipText("");
        jb_pizzas_img.setBorder(null);
        jb_pizzas_img.setBorderPainted(false);
        jb_pizzas_img.setContentAreaFilled(false);
        jb_pizzas_img.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_pizzas_img.setFocusPainted(false);
        jb_pizzas_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_pizzas_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pizzas_imgActionPerformed(evt);
            }
        });
        jp_pizzas.add(jb_pizzas_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        jp_inicioCompleto.add(jp_pizzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 110, 130));

        jp_destacados.setBackground(new java.awt.Color(242, 229, 209));
        jp_destacados.setRoundBottomLeft(20);
        jp_destacados.setRoundBottomRight(20);
        jp_destacados.setRoundTopLeft(20);
        jp_destacados.setRoundTopRight(20);
        jp_destacados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Destacados");
        jp_destacados.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        jb_destacados_img.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_destacados_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaMargarita80x40.png"))); // NOI18N
        jb_destacados_img.setText("");
        jb_destacados_img.setToolTipText("");
        jb_destacados_img.setBorder(null);
        jb_destacados_img.setBorderPainted(false);
        jb_destacados_img.setContentAreaFilled(false);
        jb_destacados_img.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_destacados_img.setFocusPainted(false);
        jb_destacados_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_destacados_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_destacados_imgActionPerformed(evt);
            }
        });
        jp_destacados.add(jb_destacados_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        jp_inicioCompleto.add(jp_destacados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 110, 130));

        jp_fondo.add(jp_inicioCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        jp_destacadosCompleto.setBackground(new java.awt.Color(242, 238, 228));
        jp_destacadosCompleto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_pregunta_destacados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jl_pregunta_destacados.setForeground(new java.awt.Color(0, 0, 0));
        jl_pregunta_destacados.setText("Destacados");
        jp_destacadosCompleto.add(jl_pregunta_destacados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jl_img_retroceder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jl_img_retroceder.setForeground(new java.awt.Color(0, 0, 0));
        jl_img_retroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/retrocederImg15x15.png"))); // NOI18N
        jp_destacadosCompleto.add(jl_img_retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 126, -1, -1));

        jb_retroceder.setBackground(new java.awt.Color(242, 229, 209));
        jb_retroceder.setForeground(new java.awt.Color(208, 29, 20));
        jb_retroceder.setText("Retroceder");
        jb_retroceder.setBorder(null);
        jb_retroceder.setBorderPainted(false);
        jb_retroceder.setContentAreaFilled(false);
        jb_retroceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_retroceder.setFocusPainted(false);
        jb_retroceder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jb_retroceder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_retroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_retrocederActionPerformed(evt);
            }
        });
        jp_destacadosCompleto.add(jb_retroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 125, 100, -1));

        jp_pizza_americana.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_americana.setRoundBottomLeft(20);
        jp_pizza_americana.setRoundBottomRight(20);
        jp_pizza_americana.setRoundTopLeft(20);
        jp_pizza_americana.setRoundTopRight(20);
        jp_pizza_americana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Americana");
        jp_pizza_americana.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        jb_americana.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_americana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaAmericana70x50.png"))); // NOI18N
        jb_americana.setText("");
        jb_americana.setToolTipText("");
        jb_americana.setBorder(null);
        jb_americana.setBorderPainted(false);
        jb_americana.setContentAreaFilled(false);
        jb_americana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_americana.setFocusPainted(false);
        jb_americana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_americana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_americanaActionPerformed(evt);
            }
        });
        jp_pizza_americana.add(jb_americana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        jl_precio_americana.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_americana.setText("S/ 14.99");
        jl_precio_americana.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_americana.add(jl_precio_americana, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 50, -1));

        jp_destacadosCompleto.add(jp_pizza_americana, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 110, 140));

        jp_pizza_mozzarella.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_mozzarella.setRoundBottomLeft(20);
        jp_pizza_mozzarella.setRoundBottomRight(20);
        jp_pizza_mozzarella.setRoundTopLeft(20);
        jp_pizza_mozzarella.setRoundTopRight(20);
        jp_pizza_mozzarella.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Mozzarella");
        jp_pizza_mozzarella.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        jb_mozzarella.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_mozzarella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaMozzarella80x44.png"))); // NOI18N
        jb_mozzarella.setText("");
        jb_mozzarella.setToolTipText("");
        jb_mozzarella.setBorder(null);
        jb_mozzarella.setBorderPainted(false);
        jb_mozzarella.setContentAreaFilled(false);
        jb_mozzarella.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_mozzarella.setFocusPainted(false);
        jb_mozzarella.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_mozzarella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_mozzarellaActionPerformed(evt);
            }
        });
        jp_pizza_mozzarella.add(jb_mozzarella, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        jl_precio_mozzarella.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_mozzarella.setText("S/ 8.99");
        jl_precio_mozzarella.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_mozzarella.add(jl_precio_mozzarella, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 50, -1));

        jp_destacadosCompleto.add(jp_pizza_mozzarella, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 110, 140));

        jp_pizza_hawaiana.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_hawaiana.setRoundBottomLeft(20);
        jp_pizza_hawaiana.setRoundBottomRight(20);
        jp_pizza_hawaiana.setRoundTopLeft(20);
        jp_pizza_hawaiana.setRoundTopRight(20);
        jp_pizza_hawaiana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Hawaiana");
        jp_pizza_hawaiana.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        jb_hawaiana.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_hawaiana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaHawaiana60x60.png"))); // NOI18N
        jb_hawaiana.setText("");
        jb_hawaiana.setToolTipText("");
        jb_hawaiana.setBorder(null);
        jb_hawaiana.setBorderPainted(false);
        jb_hawaiana.setContentAreaFilled(false);
        jb_hawaiana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_hawaiana.setFocusPainted(false);
        jb_hawaiana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_hawaiana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_hawaianaActionPerformed(evt);
            }
        });
        jp_pizza_hawaiana.add(jb_hawaiana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        jl_precio_hawaiana.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_hawaiana.setText("S/ 14.99");
        jl_precio_hawaiana.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_hawaiana.add(jl_precio_hawaiana, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 50, -1));

        jp_destacadosCompleto.add(jp_pizza_hawaiana, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 110, 140));

        jp_pizza_margarita.setBackground(new java.awt.Color(242, 229, 209));
        jp_pizza_margarita.setRoundBottomLeft(20);
        jp_pizza_margarita.setRoundBottomRight(20);
        jp_pizza_margarita.setRoundTopLeft(20);
        jp_pizza_margarita.setRoundTopRight(20);
        jp_pizza_margarita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Margarita");
        jp_pizza_margarita.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, -1));

        jb_margarita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jb_margarita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pizzaMargarita80x40.png"))); // NOI18N
        jb_margarita.setText("");
        jb_margarita.setToolTipText("");
        jb_margarita.setBorder(null);
        jb_margarita.setBorderPainted(false);
        jb_margarita.setContentAreaFilled(false);
        jb_margarita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_margarita.setFocusPainted(false);
        jb_margarita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_margarita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_margaritaActionPerformed(evt);
            }
        });
        jp_pizza_margarita.add(jb_margarita, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        jl_precio_margarita.setForeground(new java.awt.Color(0, 0, 0));
        jl_precio_margarita.setText("S/ 10.99");
        jl_precio_margarita.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jp_pizza_margarita.add(jl_precio_margarita, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 110, 50, -1));

        jp_destacadosCompleto.add(jp_pizza_margarita, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 110, 140));

        jp_fondo.add(jp_destacadosCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_logo_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_logo_crearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_logo_crearActionPerformed

    private void jb_destacados_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_destacados_imgActionPerformed
        jp_inicioCompleto.setVisible(false); // Ocultar bloques de inicio
        jp_destacadosCompleto.setVisible(true);  // Mostrar bloques de destacados
        
        // Poner en negrita este botón (DESTACADOS) 
        jb_destacados.setFont(jb_destacados.getFont().deriveFont(Font.BOLD));

        // Quitar la negrita del botón de inicio (OTROS)
        jb_inicio.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        jb_crear_pizza.setFont(jb_crear_pizza.getFont().deriveFont(Font.PLAIN));
        jb_pizzas.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
    }//GEN-LAST:event_jb_destacados_imgActionPerformed

    private void jb_pizzas_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pizzas_imgActionPerformed
        jp_inicioCompleto.setVisible(false); // Ocultar bloques de inicio
        jp_destacadosCompleto.setVisible(true);  // Mostrar bloques de destacados   

        // Poner en negrita este botón (PIZZAS) 
        jb_pizzas.setFont(jb_pizzas.getFont().deriveFont(Font.BOLD));
        
        // Quitar la negrita del botón de inicio (OTROS)
        jb_inicio.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        jb_crear_pizza.setFont(jb_crear_pizza.getFont().deriveFont(Font.PLAIN));
        jb_destacados.setFont(jb_destacados.getFont().deriveFont(Font.PLAIN));
    }//GEN-LAST:event_jb_pizzas_imgActionPerformed

    private void jb_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_inicioActionPerformed
        jp_destacadosCompleto.setVisible(false); // Ocultar bloques de destacados
        jp_inicioCompleto.setVisible(true);  // Mostrar bloques de inicio
        
        // Poner en negrita este botón (INICIO)
        jb_inicio.setFont(jb_inicio.getFont().deriveFont(Font.BOLD));

        // Quitar la negrita del botón de inicio (OTROS)
        jb_crear_pizza.setFont(jb_crear_pizza.getFont().deriveFont(Font.PLAIN));
        jb_destacados.setFont(jb_destacados.getFont().deriveFont(Font.PLAIN));
        jb_pizzas.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
    }//GEN-LAST:event_jb_inicioActionPerformed

    private void jb_crear_pizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_crear_pizzaActionPerformed
        // Poner en negrita este botón (CREAR PIZZA)
        jb_crear_pizza.setFont(jb_crear_pizza.getFont().deriveFont(Font.BOLD));

        // Quitar la negrita del botón de inicio (OTROS)
        jb_inicio.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        jb_destacados.setFont(jb_destacados.getFont().deriveFont(Font.PLAIN));
        jb_pizzas.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
    }//GEN-LAST:event_jb_crear_pizzaActionPerformed

    private void jb_destacadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_destacadosActionPerformed
        jp_inicioCompleto.setVisible(false); // Ocultar bloques de inicio
        jp_destacadosCompleto.setVisible(true);  // Mostrar bloques de destacados
        
        // Poner en negrita este botón (DESTACADOS) 
        jb_destacados.setFont(jb_destacados.getFont().deriveFont(Font.BOLD));

        // Quitar la negrita del botón de inicio (OTROS)
        jb_inicio.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        jb_crear_pizza.setFont(jb_crear_pizza.getFont().deriveFont(Font.PLAIN));
        jb_pizzas.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
    }//GEN-LAST:event_jb_destacadosActionPerformed

    private void jb_pizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pizzasActionPerformed
        jp_inicioCompleto.setVisible(false); // Ocultar bloques de inicio
        jp_destacadosCompleto.setVisible(true);  // Mostrar bloques de destacados   

        // Poner en negrita este botón (PIZZAS) 
        jb_pizzas.setFont(jb_pizzas.getFont().deriveFont(Font.BOLD));
        
        // Quitar la negrita del botón de inicio (OTROS)
        jb_inicio.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
        jb_crear_pizza.setFont(jb_crear_pizza.getFont().deriveFont(Font.PLAIN));
        jb_destacados.setFont(jb_destacados.getFont().deriveFont(Font.PLAIN));
    }//GEN-LAST:event_jb_pizzasActionPerformed

    private void jb_agregar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregar_pedidoActionPerformed
        jp_ingredientes.setVisible(false);
        jp_parte_pago.setVisible(false);
        jp_resumen_pedido.setVisible(true);
    }//GEN-LAST:event_jb_agregar_pedidoActionPerformed

    private void jb_cancelar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelar_pedidoActionPerformed
        cancelarPedido();
    }//GEN-LAST:event_jb_cancelar_pedidoActionPerformed

    private void jb_margaritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_margaritaActionPerformed
    nombrePizzaSeleccionada = "Margarita";

    controlador.agregarPizzaPredisenada("Margarita", tamanioSeleccionado, masaSeleccionada);

    Pizza pizza = controlador.getPizzaActual();
    actualizarPrecioTotalEnVista(pizza);

    mostrarPanelSeleccion();
    }//GEN-LAST:event_jb_margaritaActionPerformed

    private void jb_hawaianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_hawaianaActionPerformed
    nombrePizzaSeleccionada = "Hawaiana";

    controlador.agregarPizzaPredisenada("Hawaiana", tamanioSeleccionado, masaSeleccionada);

    Pizza pizza = controlador.getPizzaActual();
    actualizarPrecioTotalEnVista(pizza);

    mostrarPanelSeleccion();
    }//GEN-LAST:event_jb_hawaianaActionPerformed

    private void jb_mozzarellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_mozzarellaActionPerformed
        
            nombrePizzaSeleccionada = "Mozzarella";

    controlador.agregarPizzaPredisenada("Mozzarella", tamanioSeleccionado, masaSeleccionada);

    Pizza pizza = controlador.getPizzaActual();
    actualizarPrecioTotalEnVista(pizza);

    mostrarPanelSeleccion();
    }//GEN-LAST:event_jb_mozzarellaActionPerformed

    private void jb_americanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_americanaActionPerformed
        
            nombrePizzaSeleccionada = "Americana";

    controlador.agregarPizzaPredisenada("Americana", tamanioSeleccionado, masaSeleccionada);

    Pizza pizza = controlador.getPizzaActual();
    actualizarPrecioTotalEnVista(pizza);

    mostrarPanelSeleccion();
    }//GEN-LAST:event_jb_americanaActionPerformed

    private void jb_retrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_retrocederActionPerformed
        jp_destacadosCompleto.setVisible(false); // Ocultar bloques de destacados
        jp_inicioCompleto.setVisible(true);  // Mostrar bloques de inicio
        
        // Poner en negrita este botón (INICIO)
        jb_inicio.setFont(jb_inicio.getFont().deriveFont(Font.BOLD));

        // Quitar la negrita del botón de inicio (OTROS)
        jb_crear_pizza.setFont(jb_crear_pizza.getFont().deriveFont(Font.PLAIN));
        jb_destacados.setFont(jb_destacados.getFont().deriveFont(Font.PLAIN));
        jb_pizzas.setFont(jb_inicio.getFont().deriveFont(Font.PLAIN));
    }//GEN-LAST:event_jb_retrocederActionPerformed

    private void jb_familiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_familiarActionPerformed
        tamanioSeleccionado = "Familiar";
        if (jl_escogiendo_tamanio1 != null) jl_escogiendo_tamanio1.setText("Familiar");
        controlador.seleccionarTamanio(tamanioSeleccionado);
        mostrarSeleccionMasa();
    }//GEN-LAST:event_jb_familiarActionPerformed

    private void jb_grandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_grandeActionPerformed
        tamanioSeleccionado = "Grande";
        if (jl_escogiendo_tamanio1 != null) jl_escogiendo_tamanio1.setText("Grande");
        controlador.seleccionarTamanio(tamanioSeleccionado);

        mostrarSeleccionMasa();
    }//GEN-LAST:event_jb_grandeActionPerformed

    private void jb_medianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_medianaActionPerformed
        tamanioSeleccionado = "Mediana";
        if (jl_escogiendo_tamanio1 != null) jl_escogiendo_tamanio1.setText("Mediana");
        controlador.seleccionarTamanio(tamanioSeleccionado);

        mostrarSeleccionMasa();
    }//GEN-LAST:event_jb_medianaActionPerformed

    private void jb_individualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_individualActionPerformed
        tamanioSeleccionado = "Individual";
        if (jl_escogiendo_tamanio1 != null) jl_escogiendo_tamanio1.setText("Individual");
        controlador.seleccionarTamanio(tamanioSeleccionado);

        mostrarSeleccionMasa();
    }//GEN-LAST:event_jb_individualActionPerformed

    private void jb_masa_clasicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_masa_clasicaActionPerformed
        masaSeleccionada = "Clásica";
        if (jl_escogiendo_masa != null) jl_escogiendo_masa.setText("Clásica");
        EmergentesVista ventanaEmergente = new EmergentesVista("jp_pregunta_personalizar", this);
        
        this.setVisible(false);
        // Ocultar todo el set del Inicio con destacados y barras
        jp_masaPizza.setVisible(false);
        jp_tamanioPizza.setVisible(false);
        jp_destacadosCompleto.setVisible(false);
        jp_inicioCompleto.setVisible(false);              
        jp_menu.setVisible(false);
        jp_mi_pizza_lab.setVisible(false);
        jp_logo.setVisible(false);
        jl_publicidad.setVisible(false);
        
        ventanaEmergente.setVisible(true);
        jp_barra_proceso2.setVisible(true);
        jl_casilla_masa1.setVisible(true);
        jp_ingredientes.setVisible(true);
    }//GEN-LAST:event_jb_masa_clasicaActionPerformed

    private void jb_mediana1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_mediana1ActionPerformed
        masaSeleccionada = "Fina";
        if (jl_escogiendo_masa != null) jl_escogiendo_masa.setText("Fina");
        EmergentesVista ventanaEmergente = new EmergentesVista("jp_pregunta_personalizar", this);
        
        this.setVisible(false);
        jp_masaPizza.setVisible(false);
        ventanaEmergente.setVisible(true);
        jp_barra_proceso2.setVisible(true);
        jl_casilla_masa1.setVisible(true);
        jp_ingredientes.setVisible(true);
    }//GEN-LAST:event_jb_mediana1ActionPerformed

    private void jb_cancelar_pedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelar_pedido1ActionPerformed
        cancelarPedido();
    }//GEN-LAST:event_jb_cancelar_pedido1ActionPerformed

    private void jb_agregar_pedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregar_pedido1ActionPerformed
        // Usar la lista global de ingredientes seleccionados
        java.util.List<modelo.Ingrediente> ingredientesPedido = new java.util.ArrayList<>(ingredientesSeleccionados);
        // Obtener la cantidad seleccionada y pasarla al controlador
        int cantidad = 1;
        try {
            cantidad = Integer.parseInt(jl_cantidad.getText().trim());
        } catch (NumberFormatException e) {
            cantidad = 1;
        }
        controlador.seleccionarCantidad(cantidad);
        EmergentesVista ventanaEmergente = new EmergentesVista("jp_producto_agregado", this);
        //Ocultar todo
        this.setVisible(false);
        jp_destacadosCompleto.setVisible(false);
        jp_superior_seleccion.setVisible(false);
        jp_barra_proceso.setVisible(false);
        jp_tamanioPizza.setVisible(false);
        jp_masaPizza.setVisible(false);
        jp_ingredientes.setVisible(false);
        jp_barra_proceso2.setVisible(false);
        jp_barra_proceso.setVisible(false);
        jp_resumen_pedido.setVisible(false);
        // Mostrar la ventana actual
        ventanaEmergente.setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(2000, e -> {
            ventanaEmergente.setVisible(false);
            ventanaEmergente.dispose();
            
            procesoPagoVista.setVisible(true);
            this.setVisible(false);

        });
        timer.setRepeats(false);
        timer.start();
    }//GEN-LAST:event_jb_agregar_pedido1ActionPerformed

    private void jb_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_menosActionPerformed
        try {
            // Obtener el número actual
            int cantidad = Integer.parseInt(jl_cantidad.getText().trim());

            // Solo disminuye si es mayor a 1
            if (cantidad > 1) {
                cantidad--;
                jl_cantidad.setText(String.valueOf(cantidad));
            }
            // Si es 1, no hace nada (puedes poner un mensaje si quieres)

        } catch (NumberFormatException e) {
            // Si el texto no es un número, lo reinicia a 1
            jl_cantidad.setText("1");
        }
    }//GEN-LAST:event_jb_menosActionPerformed

    private void jb_masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_masActionPerformed
        try {
            // Obtener el número actual
            int cantidad = Integer.parseInt(jl_cantidad.getText().trim());

            // Sumar 1
            cantidad++;

            // Mostrar el nuevo valor
            jl_cantidad.setText(String.valueOf(cantidad));

        } catch (NumberFormatException e) {
            // Por si el texto no era un número, lo reinicia a 1
            jl_cantidad.setText("1");
        }
    }//GEN-LAST:event_jb_masActionPerformed

    // Método utilitario para manejar la selección de ingredientes
    private void manejarSeleccionIngrediente(javax.swing.JCheckBox checkBox, String nombre, double precio) {
        Ingrediente ing = new Ingrediente(nombre, precio);
        if (checkBox.isSelected()) {
            if (!ingredientesSeleccionados.contains(ing)) ingredientesSeleccionados.add(ing);
        } else {
            ingredientesSeleccionados.remove(ing);
        }
controlador.seleccionarIngredientes(ingredientesSeleccionados);    }

    private void jcb_jamonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_jamonActionPerformed
        manejarSeleccionIngrediente(jcb_jamon, "Jamón", 1.99);
    }//GEN-LAST:event_jcb_jamonActionPerformed

    private void jcb_peperoniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_peperoniActionPerformed
        manejarSeleccionIngrediente(jcb_peperoni, "Peperoni", 1.99);
    }//GEN-LAST:event_jcb_peperoniActionPerformed

    private void jcb_tocinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tocinoActionPerformed
        manejarSeleccionIngrediente(jcb_tocino, "Tocino", 2.99);
    }//GEN-LAST:event_jcb_tocinoActionPerformed

    private void jcb_carneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_carneActionPerformed
        manejarSeleccionIngrediente(jcb_carne, "Carne molida", 2.99);
    }//GEN-LAST:event_jcb_carneActionPerformed

    private void jcb_pimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_pimientoActionPerformed
        manejarSeleccionIngrediente(jcb_pimiento, "Pimiento", 0.80);
    }//GEN-LAST:event_jcb_pimientoActionPerformed

    private void jcb_tomateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tomateActionPerformed
        manejarSeleccionIngrediente(jcb_tomate, "Tomate", 0.50);
    }//GEN-LAST:event_jcb_tomateActionPerformed

    private void jcb_champinonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_champinonActionPerformed
        manejarSeleccionIngrediente(jcb_champinon, "Champiñón", 1.30);
    }//GEN-LAST:event_jcb_champinonActionPerformed

    private void jcb_aceitunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_aceitunaActionPerformed
        manejarSeleccionIngrediente(jcb_aceituna, "Aceituna", 1.60);
    }//GEN-LAST:event_jcb_aceitunaActionPerformed

    private void jcb_cocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_cocaActionPerformed
        manejarSeleccionIngrediente(jcb_coca, "Coca-Cola", 3.50);
    }//GEN-LAST:event_jcb_cocaActionPerformed

    private void jcb_incaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_incaActionPerformed
        manejarSeleccionIngrediente(jcb_inca, "Inca Kola", 3.50);
    }//GEN-LAST:event_jcb_incaActionPerformed

    private void jcb_pepsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_pepsiActionPerformed
        manejarSeleccionIngrediente(jcb_pepsi, "Pepsi", 2.50);
    }//GEN-LAST:event_jcb_pepsiActionPerformed

    private void jcb_spriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_spriteActionPerformed
        manejarSeleccionIngrediente(jcb_sprite, "Sprite", 2.50);
    }//GEN-LAST:event_jcb_spriteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jb_agregar_pedido;
    private javax.swing.JButton jb_agregar_pedido1;
    private javax.swing.JButton jb_americana;
    private javax.swing.JButton jb_cancelar_pedido;
    private javax.swing.JButton jb_cancelar_pedido1;
    private javax.swing.JButton jb_crear_pizza;
    private javax.swing.JButton jb_destacados;
    private javax.swing.JButton jb_destacados_img;
    private javax.swing.JButton jb_familiar;
    private javax.swing.JButton jb_grande;
    private javax.swing.JButton jb_hawaiana;
    private javax.swing.JButton jb_individual;
    private javax.swing.JButton jb_inicio;
    private javax.swing.JButton jb_logo_crear;
    private javax.swing.JButton jb_margarita;
    private javax.swing.JButton jb_mas;
    private javax.swing.JButton jb_masa_clasica;
    private javax.swing.JButton jb_mediana;
    private javax.swing.JButton jb_mediana1;
    private javax.swing.JButton jb_menos;
    private javax.swing.JButton jb_mozzarella;
    private javax.swing.JButton jb_pizzas;
    private javax.swing.JButton jb_pizzas_img;
    private javax.swing.JButton jb_retroceder;
    private MyContainers.JCheckBoxCustom jcb_aceituna;
    private MyContainers.JCheckBoxCustom jcb_carne;
    private MyContainers.JCheckBoxCustom jcb_champinon;
    private MyContainers.JCheckBoxCustom jcb_coca;
    private MyContainers.JCheckBoxCustom jcb_inca;
    private MyContainers.JCheckBoxCustom jcb_jamon;
    private MyContainers.JCheckBoxCustom jcb_peperoni;
    private MyContainers.JCheckBoxCustom jcb_pepsi;
    private MyContainers.JCheckBoxCustom jcb_pimiento;
    private MyContainers.JCheckBoxCustom jcb_sprite;
    private MyContainers.JCheckBoxCustom jcb_tocino;
    private MyContainers.JCheckBoxCustom jcb_tomate;
    private javax.swing.JLabel jl_aceituna_precio;
    private javax.swing.JLabel jl_cantidad;
    private javax.swing.JLabel jl_carne_precio;
    private javax.swing.JLabel jl_casilla_ingrediente;
    private javax.swing.JLabel jl_casilla_ingrediente1;
    private javax.swing.JLabel jl_casilla_masa;
    private javax.swing.JLabel jl_casilla_masa1;
    private javax.swing.JLabel jl_casilla_producto;
    private javax.swing.JLabel jl_casilla_tamanio;
    private javax.swing.JLabel jl_casilla_tamanio1;
    private javax.swing.JLabel jl_champinon_precio;
    private javax.swing.JLabel jl_coca_precio;
    private javax.swing.JLabel jl_eleccion_producto;
    private javax.swing.JLabel jl_escogiendo_ingrediente;
    private javax.swing.JLabel jl_escogiendo_masa;
    private javax.swing.JLabel jl_escogiendo_tamanio1;
    private javax.swing.JLabel jl_img_logo;
    private javax.swing.JLabel jl_img_logo1;
    private javax.swing.JLabel jl_img_retroceder;
    private javax.swing.JLabel jl_inca_precio;
    private javax.swing.JLabel jl_jamon_precio;
    private javax.swing.JLabel jl_peperoni_precio;
    private javax.swing.JLabel jl_pepsi_precio;
    private javax.swing.JLabel jl_pimiento_precio;
    private javax.swing.JLabel jl_precio_americana;
    private javax.swing.JLabel jl_precio_familiar;
    private javax.swing.JLabel jl_precio_grande;
    private javax.swing.JLabel jl_precio_hawaiana;
    private javax.swing.JLabel jl_precio_individual;
    private javax.swing.JLabel jl_precio_margarita;
    private javax.swing.JLabel jl_precio_mediana;
    private javax.swing.JLabel jl_precio_mozzarella;
    private javax.swing.JLabel jl_precio_total;
    private javax.swing.JLabel jl_precio_total1;
    private javax.swing.JLabel jl_precio_total2;
    private javax.swing.JLabel jl_pregunta_destacados;
    private javax.swing.JLabel jl_pregunta_inicio;
    private javax.swing.JLabel jl_producto;
    private javax.swing.JLabel jl_publicidad;
    private javax.swing.JLabel jl_sprite_precio;
    private javax.swing.JLabel jl_titulo_bebidas;
    private javax.swing.JLabel jl_titulo_carnes;
    private javax.swing.JLabel jl_titulo_ingrediente;
    private javax.swing.JLabel jl_titulo_ingredientes;
    private javax.swing.JLabel jl_titulo_ingredientes1;
    private javax.swing.JLabel jl_titulo_masa;
    private javax.swing.JLabel jl_titulo_pizza;
    private javax.swing.JLabel jl_titulo_tamanio;
    private javax.swing.JLabel jl_titulo_tamanio2;
    private javax.swing.JLabel jl_titulo_verduras;
    private javax.swing.JLabel jl_tocino_precio;
    private javax.swing.JLabel jl_tomate_precio;
    private MyContainers.PanelRound jp_aceituna;
    private MyContainers.PanelRound jp_agregar_pedido;
    private MyContainers.PanelRound jp_agregar_pedido1;
    private MyContainers.PanelRound jp_barra_proceso;
    private MyContainers.PanelRound jp_barra_proceso2;
    private javax.swing.JPanel jp_bebidas;
    private MyContainers.PanelRound jp_cancelar_pedido;
    private MyContainers.PanelRound jp_cancelar_pedido1;
    private MyContainers.PanelRound jp_cantidad;
    private MyContainers.PanelRound jp_carne;
    private MyContainers.PanelRound jp_champinon;
    private MyContainers.PanelRound jp_coca;
    private MyContainers.PanelRound jp_destacados;
    private javax.swing.JPanel jp_destacadosCompleto;
    private javax.swing.JPanel jp_embutido;
    private javax.swing.JPanel jp_fondo;
    private MyContainers.PanelRound jp_inca;
    private javax.swing.JPanel jp_ingredientes;
    private javax.swing.JPanel jp_inicioCompleto;
    private MyContainers.PanelRound jp_jamon;
    private MyContainers.PanelRound jp_logo;
    private MyContainers.PanelRound jp_logo1;
    private javax.swing.JPanel jp_masaPizza;
    private MyContainers.PanelRound jp_masa_clasica;
    private MyContainers.PanelRound jp_masa_fina;
    private MyContainers.PanelRound jp_menu;
    private MyContainers.PanelRound jp_mi_pizza_lab;
    private javax.swing.JPanel jp_parte_pago;
    private MyContainers.PanelRound jp_peperoni;
    private MyContainers.PanelRound jp_pepsi;
    private MyContainers.PanelRound jp_pimiento;
    private MyContainers.PanelRound jp_pizza_americana;
    private MyContainers.PanelRound jp_pizza_familiar;
    private MyContainers.PanelRound jp_pizza_grande;
    private MyContainers.PanelRound jp_pizza_hawaiana;
    private MyContainers.PanelRound jp_pizza_individual;
    private MyContainers.PanelRound jp_pizza_margarita;
    private MyContainers.PanelRound jp_pizza_mediana;
    private MyContainers.PanelRound jp_pizza_mozzarella;
    private MyContainers.PanelRound jp_pizzas;
    private javax.swing.JPanel jp_resumen_pedido;
    private MyContainers.PanelRound jp_sprite;
    private javax.swing.JPanel jp_superior_seleccion;
    private javax.swing.JPanel jp_tamanioPizza;
    private MyContainers.PanelRound jp_tocino;
    private MyContainers.PanelRound jp_tomate;
    private javax.swing.JPanel jp_verduras;
    private javax.swing.JScrollPane jsp_eleccion_bebidas;
    private javax.swing.JScrollPane jsp_eleccion_carnes;
    private javax.swing.JScrollPane jsp_eleccion_verduras;
    // End of variables declaration//GEN-END:variables
}
