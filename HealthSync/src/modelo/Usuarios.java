package modelo;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuarios {
    
    private String correo;
    private String clave;
    private String nombre;
    private static String correoRecuperacion;

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
    
    public void insertarUsuario(){
        
        Connection conexion = ClaseConexion.getConexion();
        
        try{
            
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addUsuarios = conexion.prepareStatement("INSERT INTO Usuarios (correo, clave, nombre) VALUES (?, ?, ?)");
            //Establecer valores de la consulta SQL
            addUsuarios.setString(1, getCorreo());
            // Aqui se encripta la clave xdd
            addUsuarios.setString(2, convertirSHA256(getClave())); 
            addUsuarios.setString(3, getNombre());
 
            //Ejecutar la consulta
            addUsuarios.executeUpdate();
            
        }
        catch(SQLException ex){
            System.out.println("este es el error en el modelo: Metodo insertar " + ex);
        }
    }
    
    public boolean iniciarSesionCredenciales(){
        Connection conexion = ClaseConexion.getConexion();
        boolean resultadodelInicioSesion = false;
        
        try {
            //Preparamos la consulta SQL para verificar el usuario
            String sql = "SELECT * FROM Usuarios WHERE correo = ? AND clave = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo());
            // SE encripta la clave para comparar
            statement.setString(2, convertirSHA256(getClave())); 
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultadodelInicioSesion = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }
        return resultadodelInicioSesion;
    }
    
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
}