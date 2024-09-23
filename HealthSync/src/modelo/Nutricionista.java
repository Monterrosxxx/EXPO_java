package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Nutricionista {
    private int idNutricionista;
    private String nombre;
    private int edad;
    private String numero;
    private String correo;
    private String clave;

    // Getters y setters
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

    public void insertarNutricionista() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Iniciar una transacción
            conexion.setAutoCommit(false);

            // Insertar en la tabla tipoUsuarios
            String sqlTipoUsuario = "INSERT INTO tipoUsuarios (nombreRol) VALUES ('Nutricionista')";
            pstmt = conexion.prepareStatement(sqlTipoUsuario, new String[]{"idRol"});
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            int idRol = 0;
            if (rs.next()) {
                idRol = rs.getInt(1);
            }

            // Insertar en la tabla Usuarios
            String sqlUsuario = "INSERT INTO Usuarios (correo, clave, nombre) VALUES (?, ?, ?)";
            pstmt = conexion.prepareStatement(sqlUsuario, new String[]{"idUsuario"});
            pstmt.setString(1, getCorreo());
            pstmt.setString(2, getClave());
            pstmt.setString(3, getNombre());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }

            // Insertar en la tabla Nutricionista
            String sqlNutricionista = "INSERT INTO Nutricionista (nombre, edad, numero, idRol, idUsuario) VALUES (?, ?, ?, ?, ?)";
            pstmt = conexion.prepareStatement(sqlNutricionista);
            pstmt.setString(1, getNombre());
            pstmt.setInt(2, getEdad());
            pstmt.setString(3, getNumero());
            pstmt.setInt(4, idRol);
            pstmt.setInt(5, idUsuario);
            pstmt.executeUpdate();

            // Confirmar la transacción
            conexion.commit();

        } catch (SQLException e) {
            // En caso de error, revertir la transacción
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("Error al hacer rollback: " + ex);
            }
            System.out.println("Error al insertar nutricionista: " + e);
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

    public void eliminarNutricionista() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Primero, obtener idRol e idUsuario
            String sqlSelect = "SELECT idRol, idUsuario FROM Nutricionista WHERE idNutricionista = ?";
            pstmt = conexion.prepareStatement(sqlSelect);
            pstmt.setInt(1, getIdNutricionista());
            ResultSet rs = pstmt.executeQuery();
            int idRol = 0;
            int idUsuario = 0;
            if (rs.next()) {
                idRol = rs.getInt("idRol");
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

            // Eliminar de la tabla tipoUsuarios
            String sqlTipoUsuario = "DELETE FROM tipoUsuarios WHERE idRol = ?";
            pstmt = conexion.prepareStatement(sqlTipoUsuario);
            pstmt.setInt(1, idRol);
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

    public void actualizarNutricionista() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            // Actualizar la tabla Nutricionista
            String sqlNutricionista = "UPDATE Nutricionista SET nombre = ?, edad = ?, numero = ? WHERE idNutricionista = ?";
            pstmt = conexion.prepareStatement(sqlNutricionista);
            pstmt.setString(1, getNombre());
            pstmt.setInt(2, getEdad());
            pstmt.setString(3, getNumero());
            pstmt.setInt(4, getIdNutricionista());
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
}