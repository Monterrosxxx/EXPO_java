package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.panelRutinas;

public class Rutinas {
    
    // Atributos de la clase Rutinas
    private String nombreRutina;
    private String descripcionRutina;
    private int idCliente;

    // Getters y setters para los atributos
    public String getNombreRutina() {
        return nombreRutina;
    }
    
    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }
    
    public String getDescripcionRutina() {
        return descripcionRutina;
    }
    
    public void setDescripcionRutina(String descripcionRutina) {
        this.descripcionRutina = descripcionRutina;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Método para insertar una nueva rutina en la base de datos
    public void insertarRutina() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Preparar la consulta SQL para insertar una nueva rutina
            String sql = "INSERT INTO Rutina (nombreRutina, descripcionRutina, idCliente) VALUES (?, ?, ?)";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, getNombreRutina());
            pstmt.setString(2, getDescripcionRutina());
            pstmt.setInt(3, getIdCliente());
            
            // Ejecutar la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar rutina: " + e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para eliminar una rutina de la base de datos
    public void eliminarRutina(int idRutina) {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Preparar la consulta SQL para eliminar una rutina
            String sql = "DELETE FROM Rutina WHERE idRutina = ?";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idRutina);
            
            // Ejecutar la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar rutina: " + e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para actualizar los datos de una rutina en la base de datos
    public void actualizarRutina(int idRutina) {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Preparar la consulta SQL para actualizar una rutina
            String sql = "UPDATE Rutina SET nombreRutina = ?, descripcionRutina = ?, idCliente = ? WHERE idRutina = ?";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, getNombreRutina());
            pstmt.setString(2, getDescripcionRutina());
            pstmt.setInt(3, getIdCliente());
            pstmt.setInt(4, idRutina);
            
            // Ejecutar la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar rutina: " + e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para mostrar los datos de las rutinas en una tabla
    public void mostrarRutinasTB(JTable Tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloRutina = new DefaultTableModel();
        
        // Definir las columnas de la tabla
        modeloRutina.setColumnIdentifiers(new Object[]{"ID Rutina", "Nombre Rutina", "Descripción", "ID Cliente"});
        
        try {
            // Preparar y ejecutar la consulta SQL para obtener todas las rutinas
            String sql = "SELECT idRutina, nombreRutina, descripcionRutina, idCliente FROM Rutina";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            // Llenar la tabla con los datos obtenidos
            while (rs.next()) {
                modeloRutina.addRow(new Object[]{
                    rs.getInt("idRutina"),
                    rs.getString("nombreRutina"),
                    rs.getString("descripcionRutina"),
                    rs.getInt("idCliente")
                });
            }
            
            // Asignar el modelo a la tabla
            Tabla.setModel(modeloRutina);
        } catch (Exception ex) {
            System.out.println("Error en el modelo, método mostrarRutinasTB: " + ex);
        }
    }

    // Método para cargar los datos de una rutina seleccionada en la tabla a los campos de la vista
    public void cargarDatos(panelRutinas vista) {
        int filaSeleccionada = vista.jTBrutinaCRUD.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada y asignarlos a los atributos de la clase
            String nombre = vista.jTBrutinaCRUD.getValueAt(filaSeleccionada, 1).toString();
            String descripcion = vista.jTBrutinaCRUD.getValueAt(filaSeleccionada, 2).toString();
            int idCliente = Integer.parseInt(vista.jTBrutinaCRUD.getValueAt(filaSeleccionada, 3).toString());
            
            setNombreRutina(nombre);
            setDescripcionRutina(descripcion);
            setIdCliente(idCliente);

            // Cargar los datos en los campos de la vista
            vista.txtNombreRutina.setText(getNombreRutina());
            vista.txtDescripcionRutina.setText(getDescripcionRutina());
        }
    }
}
