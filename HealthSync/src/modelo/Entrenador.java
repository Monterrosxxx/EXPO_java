package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.panelEntrenador;

public class Entrenador {
    // Atributos de la clase Entrenador
    private int idEntrenador;
    private String nombre;
    private int edad;
    private String numero;
    private int idEspecialidad;
    private int idUsuario;
    private String correo;
    private String clave;

    // Getters y setters
    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
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

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    // Método para insertar un nuevo entrenador en la base de datos
    public void insertarEntrenador() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Iniciar una transacción
            conexion.setAutoCommit(false);

            // Insertar en la tabla Usuarios
            String sqlUsuario = "INSERT INTO Usuarios (nombre, correo, clave, idRol) VALUES (?, ?, ?, ?)";
            pstmt = conexion.prepareStatement(sqlUsuario, new String[]{"idUsuario"});
            pstmt.setString(1, getNombre());
            pstmt.setString(2, getCorreo());
            // Se hashea la clave
            pstmt.setString(3, convertirSHA256(getClave()));
            // idRol fijo como 2 para entrenadores
            pstmt.setInt(4, 2);
            pstmt.executeUpdate();

            // Obtener el idUsuario generado
            rs = pstmt.getGeneratedKeys();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }

            // Insertar en la tabla Entrenador
            String sqlEntrenador = "INSERT INTO Entrenador (edad, numero, idEspecialidad, idUsuario) VALUES (?, ?, ?, ?)";
            pstmt = conexion.prepareStatement(sqlEntrenador);
            pstmt.setInt(1, getEdad());
            pstmt.setString(2, getNumero());
            pstmt.setInt(3, getIdEspecialidad());
            pstmt.setInt(4, idUsuario);
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
            System.out.println("Error en el método insertarEntrenador: " + e);
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

    // Método para eliminar un entrenador de la base de datos
    public void eliminarEntrenador() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Primero, obtener idUsuario
            String sqlSelect = "SELECT idUsuario FROM Entrenador WHERE idEntrenador = ?";
            pstmt = conexion.prepareStatement(sqlSelect);
            pstmt.setInt(1, getIdEntrenador());
            ResultSet rs = pstmt.executeQuery();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }

            // Eliminar de la tabla Entrenador
            String sqlEntrenador = "DELETE FROM Entrenador WHERE idEntrenador = ?";
            pstmt = conexion.prepareStatement(sqlEntrenador);
            pstmt.setInt(1, getIdEntrenador());
            pstmt.executeUpdate();

            // Eliminar de la tabla Usuarios
            String sqlUsuario = "DELETE FROM Usuarios WHERE idUsuario = ?";
            pstmt = conexion.prepareStatement(sqlUsuario);
            pstmt.setInt(1, idUsuario);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar entrenador: " + e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para actualizar los datos de un entrenador en la base de datos
    public void actualizarEntrenador() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Actualizar la tabla Entrenador
            String sqlEntrenador = "UPDATE Entrenador SET edad = ?, numero = ?, idEspecialidad = ? WHERE idEntrenador = ?";
            pstmt = conexion.prepareStatement(sqlEntrenador);
            pstmt.setInt(1, getEdad());
            pstmt.setString(2, getNumero());
            pstmt.setInt(3, getIdEspecialidad());
            pstmt.setInt(4, getIdEntrenador());
            pstmt.executeUpdate();

            // Obtener idUsuario
            String sqlSelect = "SELECT idUsuario FROM Entrenador WHERE idEntrenador = ?";
            pstmt = conexion.prepareStatement(sqlSelect);
            pstmt.setInt(1, getIdEntrenador());
            ResultSet rs = pstmt.executeQuery();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }

            // Actualizar la tabla Usuarios
            String sqlUsuario = "UPDATE Usuarios SET correo = ?, clave = ?, nombre = ? WHERE idUsuario = ?";
            pstmt = conexion.prepareStatement(sqlUsuario);
            pstmt.setString(1, getCorreo());
            pstmt.setString(2, convertirSHA256(getClave()));
            pstmt.setString(3, getNombre());
            pstmt.setInt(4, idUsuario);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar entrenador: " + e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }

    // Método para mostrar los datos de los entrenadores en una tabla
    public void mostrarEntrenador(JTable Tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloEntrenador = new DefaultTableModel();
        modeloEntrenador.setColumnIdentifiers(new Object[]{"idEntrenador", "Nombre", "Edad", "Número", "idEspecialidad", "idUsuario", "Correo", "Clave"});
        try {
            String sql = "SELECT e.idEntrenador, u.nombre, e.edad, e.numero, e.idEspecialidad, e.idUsuario, u.correo, u.clave " +
                         "FROM Entrenador e " +
                         "INNER JOIN Usuarios u ON e.idUsuario = u.idUsuario";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modeloEntrenador.addRow(new Object[]{
                    rs.getInt("idEntrenador"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("numero"),
                    rs.getInt("idEspecialidad"),
                    rs.getInt("idUsuario"),
                    rs.getString("correo"),
                    rs.getString("clave")
                });
            }
            Tabla.setModel(modeloEntrenador);
        } catch (Exception ex) {
            System.out.println("Error en el modelo, método mostrarEntrenador: " + ex);
        }
    }

    // Método para cargar los datos de un entrenador seleccionado en la tabla
    public void cargarDatos(panelEntrenador vista) {
        int filaSeleccionada = vista.jTBentrenadorCRUD.getSelectedRow();
        if (filaSeleccionada != -1) {
            setIdEntrenador(Integer.parseInt(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 0).toString()));
            setNombre(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 1).toString());
            setEdad(Integer.parseInt(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 2).toString()));
            setNumero(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 3).toString());
            setIdEspecialidad(Integer.parseInt(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 4).toString()));
            setIdUsuario(Integer.parseInt(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 5).toString()));
            setCorreo(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 6).toString());
            setClave(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 7).toString());

            vista.txtNombreEntrenador1.setText(getNombre());
            vista.txtEdadEntrenador.setText(String.valueOf(getEdad()));
            vista.txtNumeroTelEntrenador.setText(getNumero());
            vista.cbEspecialidad.setSelectedItem(getIdEspecialidad());
            vista.txtCorreoEntrenador.setText(getCorreo());
            vista.txtClave.setText(getClave());
        }
    }

    // Método para convertir la contraseña a SHA-256
    public static String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.toString());
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
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