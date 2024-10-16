package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class clientesRutina {
    // Atributos de la clase clientesRutina
    private int idCliente;
    private String nombre;
    private String tipoDesayunos;
    private String tipoAlmuerzos;
    private String tipoCenas;
    private String tipoRefrigerios;
    private String experiencia;

    // Getters y setters para cada atributo
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDesayunos() {
        return tipoDesayunos;
    }

    public void setTipoDesayunos(String tipoDesayunos) {
        this.tipoDesayunos = tipoDesayunos;
    }

    public String getTipoAlmuerzos() {
        return tipoAlmuerzos;
    }

    public void setTipoAlmuerzos(String tipoAlmuerzos) {
        this.tipoAlmuerzos = tipoAlmuerzos;
    }

    public String getTipoCenas() {
        return tipoCenas;
    }

    public void setTipoCenas(String tipoCenas) {
        this.tipoCenas = tipoCenas;
    }

    public String getTipoRefrigerios() {
        return tipoRefrigerios;
    }

    public void setTipoRefrigerios(String tipoRefrigerios) {
        this.tipoRefrigerios = tipoRefrigerios;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    // Método para mostrar los datos de los clientes y sus dietas en una tabla
    public void mostrarClientesRutina(JTable Tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloClienteRutina = new DefaultTableModel();
        modeloClienteRutina.setColumnIdentifiers(new Object[]{"Nombre", "Desayunos", "Almuerzos", "Cenas", "Refrigerios", "Experiencia"});
        
        try {
            // Consulta SQL modificada para manejar los campos CLOB
            String sql = "SELECT u.nombre, " +
                         "COALESCE(TO_CHAR(DBMS_LOB.SUBSTR(d.tipoDesayunos, 4000, 1)), 'ninguno') AS tipoDesayunos, " +
                         "COALESCE(TO_CHAR(DBMS_LOB.SUBSTR(d.tipoAlmuerzos, 4000, 1)), 'ninguno') AS tipoAlmuerzos, " +
                         "COALESCE(TO_CHAR(DBMS_LOB.SUBSTR(d.tipoCenas, 4000, 1)), 'ninguno') AS tipoCenas, " +
                         "COALESCE(TO_CHAR(DBMS_LOB.SUBSTR(d.tipoRefrigerios, 4000, 1)), 'ninguno') AS tipoRefrigerios, " +
                         "COALESCE(e.experiencia, 'ninguno') AS experiencia " +
                         "FROM Usuarios u " +
                         "LEFT JOIN Cliente c ON u.idUsuario = c.idUsuario " +
                         "LEFT JOIN Dieta d ON c.idCliente = d.idCliente " +
                         "LEFT JOIN Experiencia e ON c.idExperiencia = e.idExperiencia " +
                         "WHERE u.idRol = 4";
            
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                // Agregar cada fila al modelo de la tabla
                modeloClienteRutina.addRow(new Object[]{
                    rs.getString("nombre"),
                    rs.getString("tipoDesayunos"),
                    rs.getString("tipoAlmuerzos"),
                    rs.getString("tipoCenas"),
                    rs.getString("tipoRefrigerios"),
                    rs.getString("experiencia")
                });
            }
            
            // Asignar el modelo a la tabla
            Tabla.setModel(modeloClienteRutina);
            
        } catch (SQLException ex) {
            System.out.println("Error en el método mostrarClientesRutina: " + ex);
        }
    }
}
