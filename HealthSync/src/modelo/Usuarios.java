package modelo;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.panelUsuarios;

public class Usuarios {
    
    // Atributos de la clase
    private String correo;
    private String clave;
    private String nombre;
    private static String correoRecuperacion;
    private int idRol; 

    // Métodos getter y setter para cada atributo
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void setCorreoRecuperacion(String correo) {
        correoRecuperacion = correo;
    }

    public static String getCorreoRecuperacion() {
        return correoRecuperacion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    // Método para convertir una contraseña a su hash SHA-256
    public static String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println(e.toString());
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
    
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
    
        return sb.toString();
    }
    
    // Método para insertar un nuevo usuario en la base de datos
    public void insertarUsuario(){
        Connection conexion = ClaseConexion.getConexion();
        
        try{
            PreparedStatement addUsuarios = conexion.prepareStatement("INSERT INTO Usuarios (correo, clave, nombre, idRol) VALUES (?, ?, ?, 1)");
            addUsuarios.setString(1, getCorreo());
            addUsuarios.setString(2, convertirSHA256(getClave())); 
            addUsuarios.setString(3, getNombre());
            addUsuarios.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Error en el modelo: Método insertar " + ex);
        }
    }
    
    // Método para iniciar sesión y obtener el idRol del usuario
    public boolean iniciarSesionCredenciales(){
        Connection conexion = ClaseConexion.getConexion();
        boolean resultadodelInicioSesion = false;
        
        try {
            String sql = "SELECT idRol FROM Usuarios WHERE correo = ? AND clave = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo());
            statement.setString(2, convertirSHA256(getClave())); 
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultadodelInicioSesion = true;
                setIdRol(resultSet.getInt("idRol")); 
            }
        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }
        return resultadodelInicioSesion;
    }
    
    // Método para actualizar la contraseña de un usuario
    public static boolean actualizarContrasena(String nuevaContrasena) {
        Connection conexion = ClaseConexion.getConexion();
        boolean actualizacionExitosa = false;
        
        try {
            String sql = "UPDATE Usuarios SET clave = ? WHERE correo = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, convertirSHA256(nuevaContrasena));
            statement.setString(2, correoRecuperacion);
            
            int filasActualizadas = statement.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Contraseña actualizada exitosamente.");
                actualizacionExitosa = true;
            } else {
                System.out.println("No se pudo actualizar la contraseña. Usuario no encontrado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método actualizarContrasena " + ex);
        }
        return actualizacionExitosa;
    }
    
    // Método para actualizar la información de un usuario en la base de datos
    public void actualizarUsuario(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idUsuario = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                PreparedStatement updateProduct = conexion.prepareStatement("UPDATE Usuarios set correo= ?, clave = ?, nombre = ? where idUsuario = ?");
                updateProduct.setString(1, getCorreo());
                updateProduct.setString(2, convertirSHA256(getClave()));
                updateProduct.setString(3, getNombre());
                updateProduct.setString(4, idUsuario);
                updateProduct.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en el método de actualizarUsuario: " + e);
            }
        } else {
            System.out.println("No se pudo actualizar");
        }
    }
    
    // Método para eliminar un usuario de la base de datos
    public void eliminarUsuario(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        int filaSeleccionada = tabla.getSelectedRow();
        String idUsuarioSeleccionado = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        try {
            PreparedStatement deleteCliente = conexion.prepareStatement("DELETE FROM Cliente WHERE idUsuario = ?");
            deleteCliente.setString(1, idUsuarioSeleccionado);
            deleteCliente.executeUpdate();
            
            PreparedStatement deleteUsuario = conexion.prepareStatement("DELETE FROM Usuarios WHERE idUsuario = ?");
            deleteUsuario.setString(1, idUsuarioSeleccionado);
            deleteUsuario.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e);
        }
    }
    
    // Método para mostrar solo los usuarios con idRol = 4
    public void mostrarUsuariosTB(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloUsuarios = new DefaultTableModel();
        modeloUsuarios.setColumnIdentifiers(new Object[]{"idUsuario", "Correo", "Contraseña", "Nombre", "idRol"});
        try {
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Usuarios WHERE idRol = 4");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                modeloUsuarios.addRow(new Object[]{
                    rs.getString("idUsuario"), 
                    rs.getString("correo"), 
                    rs.getString("clave"), 
                    rs.getString("nombre"),
                    rs.getString("idRol")
                });
            }
            tabla.setModel(modeloUsuarios);
        } catch (Exception e) {
            System.out.println("Error en el modelo, método mostrar: " + e);
        }
    }
    
    // Método para cargar los datos de un usuario seleccionado en la tabla a los campos de texto
    public void cargarDatosTabla(panelUsuarios vista) {
        int filaSeleccionada = vista.jTBusuariosCRUD.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idUsuario = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 0).toString();
            String correoTB = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 1).toString();
            String claveTB = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 2).toString();
            String nombreTB = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 3).toString();
            vista.txtCorreoCRUD.setText(correoTB);
            vista.txtContrasenaCRUD.setText(claveTB);
            vista.txtNombreCRUD.setText(nombreTB);
        }
    }
    
    // Método para verificar si el correo ya existe en la base de datos
    public boolean verificarCorreo(String correo) {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean correoExiste = false;

        try {
            String sql = "SELECT COUNT(*) FROM Usuarios WHERE correo = ?";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, correo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                correoExiste = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar correo: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }

        return correoExiste;
    }
}