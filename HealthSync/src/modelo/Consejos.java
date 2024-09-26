package modelo;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.panelConsejosE;

public class Consejos {
    
    // Atributos de la clase
    private String fraseDia;
    private String consejoEjercicio;
    private int idCliente;

    // Métodos getter y setter para cada atributo
    public String getFraseDia() {
        return fraseDia;
    }

    public void setFraseDia(String fraseDia) {
        this.fraseDia = fraseDia;
    }

    public String getConsejoEjercicio() {
        return consejoEjercicio;
    }

    public void setConsejoEjercicio(String consejoEjercicio) {
        this.consejoEjercicio = consejoEjercicio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Método para insertar un nuevo consejo en la base de datos
    public void insertarConsejo() {
        // Obtener la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        try {
            // Preparar la sentencia SQL para insertar un nuevo consejo
            PreparedStatement addConsejo = conexion.prepareStatement("INSERT INTO Consejo (fraseDia, consejoEjercicio, idCliente) VALUES (?, ?, ?)");
            
            // Establecer los valores de los parámetros
            addConsejo.setString(1, getFraseDia());
            addConsejo.setString(2, getConsejoEjercicio());
            addConsejo.setInt(3, getIdCliente());
            
            // Ejecutar la sentencia SQL
            addConsejo.executeUpdate();
        } catch (SQLException ex) {
            // Imprimir cualquier error que ocurra durante la inserción
            System.out.println("Error en el modelo: Método insertarConsejo " + ex);
        }
    }

    // Método para eliminar un consejo de la base de datos
    public void eliminarConsejo(JTable tabla) {
        // Obtener la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tabla.getSelectedRow();
        
        // Verificar si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtener el ID del consejo seleccionado
            String idConsejoSeleccionado = tabla.getValueAt(filaSeleccionada, 0).toString();
            
            try {
                // Preparar la sentencia SQL para eliminar el consejo
                PreparedStatement deleteConsejo = conexion.prepareStatement("DELETE FROM Consejo WHERE idConsejo = ?");
                
                // Establecer el ID del consejo a eliminar
                deleteConsejo.setString(1, idConsejoSeleccionado);
                
                // Ejecutar la sentencia SQL
                deleteConsejo.executeUpdate();
            } catch (Exception e) {
                // Imprimir cualquier error que ocurra durante la eliminación
                System.out.println("Error al eliminar consejo: " + e);
            }
        }
    }

    // Método para actualizar la información de un consejo en la base de datos
    public void actualizarConsejo(JTable tabla) {
        // Obtener la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = tabla.getSelectedRow();
        
        // Verificar si se ha seleccionada una fila
        if (filaSeleccionada != -1) {
            // Obtener el ID del consejo seleccionado
            String idConsejoSeleccionado = tabla.getValueAt(filaSeleccionada, 0).toString();
            
            try {
                // Preparar la sentencia SQL para actualizar el consejo
                PreparedStatement updateConsejo = conexion.prepareStatement("UPDATE Consejo SET fraseDia = ?, consejoEjercicio = ?, idCliente = ? WHERE idConsejo = ?");
                
                // Establecer los valores de los parámetros
                updateConsejo.setString(1, getFraseDia());
                updateConsejo.setString(2, getConsejoEjercicio());
                updateConsejo.setInt(3, getIdCliente());
                updateConsejo.setString(4, idConsejoSeleccionado);
                
                // Ejecutar la sentencia SQL
                updateConsejo.executeUpdate();
            } catch (Exception e) {
                // Imprimir cualquier error que ocurra durante la actualización
                System.out.println("Error en el método de actualizarConsejo: " + e);
            }
        } else {
            System.out.println("No se pudo actualizar");
        }
    }

    // Método para mostrar todos los consejos en una tabla
    public void mostrarConsejoTB(JTable tabla) {
        // Obtener la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        // Crear un nuevo modelo de tabla
        DefaultTableModel modeloConsejos = new DefaultTableModel();
        modeloConsejos.setColumnIdentifiers(new Object[]{"idConsejo", "Frase del Día", "Consejo de Ejercicio", "ID Cliente"});
        
        try {
            // Crear una declaración SQL
            Statement statement = conexion.createStatement();
            
            // Ejecutar la consulta SQL para obtener todos los consejos
            ResultSet rs = statement.executeQuery("SELECT * FROM Consejo");
            
            // Iterar sobre los resultados y añadirlos al modelo de la tabla
            while (rs.next()) {
                modeloConsejos.addRow(new Object[]{
                    rs.getString("idConsejo"),
                    rs.getString("fraseDia"),
                    rs.getString("consejoEjercicio"),
                    rs.getString("idCliente")
                });
            }
            
            // Establecer el modelo de la tabla
            tabla.setModel(modeloConsejos);
        } catch (Exception e) {
            // Imprimir cualquier error que ocurra durante la carga de datos
            System.out.println("Error en el modelo, método mostrarConsejoTB: " + e);
        }
    }

    // Método para cargar los datos de un consejo seleccionado en la tabla a los campos de texto
    public void cargarDatosTabla(panelConsejosE vista) {
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = vista.jTBconsejoCRUD.getSelectedRow();
        
        // Verificar si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtener los valores de la fila seleccionada
            String fraseDiaTB = vista.jTBconsejoCRUD.getValueAt(filaSeleccionada, 1).toString();
            String consejoEjercicioTB = vista.jTBconsejoCRUD.getValueAt(filaSeleccionada, 2).toString();
            String idClienteTB = vista.jTBconsejoCRUD.getValueAt(filaSeleccionada, 3).toString();
            
            // Establecer los valores en los campos de texto de la vista
            vista.txtConsejoDia.setText(fraseDiaTB);
            vista.txtConsejoEntrenar.setText(consejoEjercicioTB);
            vista.cbClienteIdConsejo.setSelectedItem(idClienteTB);
        }
    }
}