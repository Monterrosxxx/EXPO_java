package modelo;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.panelUsuarios;

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
    
    public void eliminarUsuario(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String idUsuarioSeleccionado = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteEstudiante = conexion.prepareStatement("DELETE FROM Usuarios where idUsuario = ?");
            deleteEstudiante.setString(1, idUsuarioSeleccionado);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    public void mostrarUsuariosTB(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloUsuarios = new DefaultTableModel();
        modeloUsuarios.setColumnIdentifiers(new Object[]{"idUsuario", "Correo", "Contraña", "Nombre"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM Usuarios");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloUsuarios.addRow(new Object[]{rs.getString("idUsuario"), 
                    rs.getString("correo"), 
                    rs.getString("clave"), 
                    rs.getString("nombre")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloUsuarios);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    public void cargarDatosTabla(panelUsuarios vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jTBusuariosCRUD.getSelectedRow();
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String idUsuario = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 0).toString();
            String correoTB = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 1).toString();
            String claveTB = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 2).toString();
            String nombreTB = vista.jTBusuariosCRUD.getValueAt(filaSeleccionada, 3).toString();
            // Establece los valores en los campos de texto
            vista.txtCorreoCRUD.setText(correoTB);
            vista.txtContrasenaCRUD.setText(claveTB);
            vista.txtNombreCRUD.setText(nombreTB);
        }
    }
    
}