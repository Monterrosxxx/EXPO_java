// Importaciones necesarias para la clase
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.panelNutricionista;

public class Nutricionista {
    // Atributos de la clase Nutricionista
    private int idNutricionista;
    private String nombre;
    private int edad;
    private String numero;
    private String correo;
    private String clave;

    // Getters y setters para cada atributo
    public int getIdNutricionista() {
        return idNutricionista;
    }

    public void setIdNutricionista(int idNutricionista) {
        this.idNutricionista = idNutricionista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

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
    
    // Método para convertir la contraseña a SHA-256
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
    
    // Método para insertar un nuevo nutricionista en la base de datos
    public void insertarNutricionista() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Iniciar una transacción
            conexion.setAutoCommit(false);

            // Insertar en la tabla UsuariosNSERT INTO Usuarios (nombre,
            String sqlUsuario = "INSERT INTO Usuarios (nombre, correo, clave, idRol) VALUES (?, ?, ?, ?)";
            pstmt = conexion.prepareStatement(sqlUsuario, new String[]{"idUsuario"});
            pstmt.setString(1, getNombre());
            pstmt.setString(2, getCorreo());
            // Se hashea la clave
            pstmt.setString(3, convertirSHA256(getClave())); 
            // idRol fijo como 3 para nutricionistas
            pstmt.setInt(4, 3); 
            pstmt.executeUpdate();

            // Obtener el idUsuario generado
            rs = pstmt.getGeneratedKeys();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }

            // Insertar en la tabla Nutricionista
            String sqlNutricionista = "INSERT INTO Nutricionista (edad, numero, idUsuario) VALUES (?, ?, ?)";
            pstmt = conexion.prepareStatement(sqlNutricionista);
            pstmt.setInt(1, getEdad());
            pstmt.setString(2, getNumero());
            pstmt.setInt(3, idUsuario);
            pstmt.executeUpdate();

            // Confirmar la transacción
            conexion.commit();

        } catch (SQLException e) {
            // En caso de error, revertir el statement
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex);
            }
            System.out.println("Error en el metodo insertarNutricionista: " + e);
        } finally {
            try {
                // Restaurar el modo de autocommit
                if (conexion != null) {
                    conexion.setAutoCommit(true);
                }
                // Cerrar recursos
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para eliminar un nutricionista de la base de datos
    public void eliminarNutricionista() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Primero, obtener idUsuario
            String sqlSelect = "SELECT idUsuario FROM Nutricionista WHERE idNutricionista = ?";
            pstmt = conexion.prepareStatement(sqlSelect);
            pstmt.setInt(1, getIdNutricionista());
            ResultSet rs = pstmt.executeQuery();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }

            // Eliminar de la tabla Nutricionista
            String sqlNutricionista = "DELETE FROM Nutricionista WHERE idNutricionista = ?";
            pstmt = conexion.prepareStatement(sqlNutricionista);
            pstmt.setInt(1, getIdNutricionista());
            pstmt.executeUpdate();

            // Eliminar de la tabla Usuarios
            String sqlUsuario = "DELETE FROM Usuarios WHERE idUsuario = ?";
            pstmt = conexion.prepareStatement(sqlUsuario);
            pstmt.setInt(1, idUsuario);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar nutricionista: " + e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para actualizar los datos de un nutricionista en la base de datos
    public void actualizarNutricionista() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Actualizar la tabla Nutricionista
            String sqlNutricionista = "UPDATE Nutricionista SET edad = ?, numero = ? WHERE idNutricionista = ?";
            pstmt = conexion.prepareStatement(sqlNutricionista);
            pstmt.setInt(1, getEdad());
            pstmt.setString(2, getNumero());
            pstmt.setInt(3, getIdNutricionista());
            pstmt.executeUpdate();

            // Obtener idUsuario
            String sqlSelect = "SELECT idUsuario FROM Nutricionista WHERE idNutricionista = ?";
            pstmt = conexion.prepareStatement(sqlSelect);
            pstmt.setInt(1, getIdNutricionista());
            ResultSet rs = pstmt.executeQuery();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }

            // Actualizar la tabla Usuarios
            String sqlUsuario = "UPDATE Usuarios SET correo = ?, clave = ?, nombre = ? WHERE idUsuario = ?";
            pstmt = conexion.prepareStatement(sqlUsuario);
            pstmt.setString(1, getCorreo());
            pstmt.setString(2, getClave());
            pstmt.setString(3, getNombre());
            pstmt.setInt(4, idUsuario);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar nutricionista: " + e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para mostrar los datos de los nutricionistas en una tabla
    public void mostrarDatosNutricionista(JTable tabla) {   
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloNutricionistas = new DefaultTableModel();
        modeloNutricionistas.setColumnIdentifiers(new Object[]{"idNutricionista", "Nombre", "Correo", "Clave", "Edad", "Número", "idUsuario"});
        try {
            // Consulta SQL para obtener datos de nutricionistas y usuarios
            String sql = "SELECT n.idNutricionista, u.nombre, u.correo, u.clave, n.edad, n.numero, n.idUsuario " +
                         "FROM Nutricionista n " +
                         "INNER JOIN Usuarios u ON n.idUsuario = u.idUsuario";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modeloNutricionistas.addRow(new Object[]{
                    rs.getInt("idNutricionista"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("clave"),
                    rs.getInt("edad"),
                    rs.getString("numero"),
                    rs.getInt("idUsuario")
                });
            }
            tabla.setModel(modeloNutricionistas);
        } catch (Exception e) {
            System.out.println("Error en el modelo, método mostrarDatosNutricionista: " + e);
        }
    }

    // Método para cargar los datos de un nutricionista seleccionado en la tabla
    public void cargarDatosNutricionista(panelNutricionista vista) {
        int filaSeleccionada = vista.jTBnutricionistaCRUD.getSelectedRow();
        if (filaSeleccionada != -1) {
            setIdNutricionista(Integer.parseInt(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 0).toString()));
            setNombre(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 1).toString());
            setCorreo(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 2).toString());
            setClave(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 3).toString());
            setEdad(Integer.parseInt(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 4).toString()));
            setNumero(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 5).toString());
            
            vista.txtNombreNutri.setText(getNombre());
            vista.txtCorreoNutri.setText(getCorreo());
            vista.txtClaveNutri.setText(getClave());
            vista.txtEdadNutri.setText(String.valueOf(getEdad()));
            vista.txtNumeroNutri.setText(getNumero());
        }
    }
}