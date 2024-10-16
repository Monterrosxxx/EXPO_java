package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class clientesDieta {
    // Atributos de la clase clientesDieta
    private int idCliente;
    private String nombre;
    private int edad;
    private double altura;
    private double peso;
    private double imc;
    private String padecimiento;

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    // Método para mostrar los datos de los clientes en una tabla
    public void mostrarClientesDieta(JTable Tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloClienteDieta = new DefaultTableModel();
        modeloClienteDieta.setColumnIdentifiers(new Object[]{"Nombre", "Edad", "Altura", "Peso", "IMC", "Padecimiento"});
        
        try {
            // Consulta SQL que combina datos de las tablas Cliente y Usuarios
            String sql = "SELECT u.nombre, " +
                         "COALESCE(c.edad, 0) AS edad, " +
                         "COALESCE(c.altura, 0) AS altura, " +
                         "COALESCE(c.peso, 0) AS peso, " +
                         "COALESCE(c.imc, 0) AS imc, " +
                         "COALESCE(c.padecimiento, 'ninguno') AS padecimiento " +
                         "FROM Usuarios u " +
                         "LEFT JOIN Cliente c ON u.idUsuario = c.idUsuario " +
                         "WHERE u.idRol = 4"; // Asumiendo que el idRol 4 corresponde a los clientes
            
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                // Agregar cada fila al modelo de la tabla
                modeloClienteDieta.addRow(new Object[]{
                    rs.getString("nombre"),
                    rs.getInt("edad") == 0 ? "ninguno" : rs.getInt("edad"),
                    rs.getDouble("altura") == 0 ? "ninguno" : rs.getDouble("altura"),
                    rs.getDouble("peso") == 0 ? "ninguno" : rs.getDouble("peso"),
                    rs.getDouble("imc") == 0 ? "ninguno" : rs.getDouble("imc"),
                    rs.getString("padecimiento")
                });
            }
            
            // Asignar el modelo a la tabla
            Tabla.setModel(modeloClienteDieta);
            
        } catch (SQLException ex) {
            System.out.println("Error en el método mostrarClientesDieta: " + ex);
        }
    }
}