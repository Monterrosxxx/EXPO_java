package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;

public class cbClientes {
    
    // Atributo para almacenar el idCliente
    private String idCliente;
    // Atributo para almacenar el nombre del usuario
    private String nombreUsuario;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public cbClientes() {
    }
    
    public cbClientes(String ID, String nombre) {
        this.idCliente = ID;
        this.nombreUsuario = nombre;
    }
    
    @Override
    public String toString() {
        return nombreUsuario;
    }
    
    // Método para cargar el comboBox con los nombres de los usuarios (rol 4)
    public void CargarComboClientes(JComboBox comboBox) {    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        
        // Consulta SQL para obtener los nombres de usuarios con rol 4 y sus idCliente correspondientes
        String sql = "SELECT c.idCliente, u.nombre " +
                     "FROM Cliente c " +
                     "INNER JOIN Usuarios u ON c.idUsuario = u.idUsuario " +
                     "WHERE u.idRol = 4";
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                String ID = rs.getString("idCliente");
                String nombre = rs.getString("nombre");
                comboBox.addItem(new cbClientes(ID, nombre));                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  
        }
    }
}