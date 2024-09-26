package modelo;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.FrmInicioNutricioniosta;

public class Dieta {
    
    // Atributos de la clase
    private int idDieta;
    private String tipoDesayunos;
    private String tipoAlmuerzos;
    private String tipoCenas;
    private String tipoRefrigerios;
    private int idCliente;

    // Métodos getter y setter para cada atributo
    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Método para insertar una nueva dieta en la base de datos
    public void insertarDieta() {
        // Establece la conexión con la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        try {
            // Prepara la sentencia SQL para insertar una nueva dieta
            PreparedStatement addDieta = conexion.prepareStatement("INSERT INTO Dieta (idDieta, tipoDesayunos, tipoAlmuerzos, tipoCenas, tipoRefrigerios, idCliente) VALUES (?, ?, ?, ?, ?, ?)");
            
            // Establece los valores para cada campo de la sentencia SQL
            addDieta.setInt(1, getIdDieta());
            addDieta.setString(2, getTipoDesayunos());
            addDieta.setString(3, getTipoAlmuerzos());
            addDieta.setString(4, getTipoCenas());
            addDieta.setString(5, getTipoRefrigerios());
            addDieta.setInt(6, getIdCliente());
            
            // Ejecuta la sentencia SQL
            addDieta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en el modelo: Método insertarDieta " + ex);
        }
    }

    // Método para eliminar una dieta de la base de datos
    public void eliminarDieta(JTable tabla) {
        // Establece la conexión con la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        // Obtiene la fila seleccionada en la tabla
        int filaSeleccionada = tabla.getSelectedRow();
        
        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtiene el ID de la dieta seleccionada
            String idDietaSeleccionada = tabla.getValueAt(filaSeleccionada, 0).toString();
            
            try {
                // Prepara la sentencia SQL para eliminar la dieta
                PreparedStatement deleteDieta = conexion.prepareStatement("DELETE FROM Dieta WHERE idDieta = ?");
                deleteDieta.setString(1, idDietaSeleccionada);
                
                // Ejecuta la sentencia SQL
                deleteDieta.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al eliminar dieta: " + e);
            }
        } else {
            System.out.println("No se ha seleccionado ninguna dieta para eliminar");
        }
    }

    // Método para actualizar la información de una dieta en la base de datos
    public void actualizarDieta(JTable tabla) {
        // Establece la conexión con la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        // Obtiene la fila seleccionada en la tabla
        int filaSeleccionada = tabla.getSelectedRow();
        
        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtiene el ID de la dieta seleccionada
            String idDietaSeleccionada = tabla.getValueAt(filaSeleccionada, 0).toString();
            
            try {
                // Prepara la sentencia SQL para actualizar la dieta
                PreparedStatement updateDieta = conexion.prepareStatement("UPDATE Dieta SET tipoDesayunos = ?, tipoAlmuerzos = ?, tipoCenas = ?, tipoRefrigerios = ?, idCliente = ? WHERE idDieta = ?");
                
                // Establece los valores para cada campo de la sentencia SQL
                updateDieta.setString(1, getTipoDesayunos());
                updateDieta.setString(2, getTipoAlmuerzos());
                updateDieta.setString(3, getTipoCenas());
                updateDieta.setString(4, getTipoRefrigerios());
                updateDieta.setInt(5, getIdCliente());
                updateDieta.setString(6, idDietaSeleccionada);
                
                // Ejecuta la sentencia SQL
                updateDieta.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en el método de actualizarDieta: " + e);
            }
        } else {
            System.out.println("No se pudo actualizar la dieta");
        }
    }

    // Método para mostrar todas las dietas en una tabla
    public void mostrarDietaTB(JTable tabla) {
        // Establece la conexión con la base de datos
        Connection conexion = ClaseConexion.getConexion();
        
        // Crea un nuevo modelo de tabla
        DefaultTableModel modeloDietas = new DefaultTableModel();
        modeloDietas.setColumnIdentifiers(new Object[]{"idDieta", "Desayunos", "Almuerzos", "Cenas", "Refrigerios", "idCliente"});
        
        try {
            // Crea una declaración SQL
            Statement statement = conexion.createStatement();
            
            // Ejecuta la consulta SQL para obtener todas las dietas
            ResultSet rs = statement.executeQuery("SELECT * FROM Dieta");
            
            // Recorre los resultados y los añade al modelo de la tabla
            while (rs.next()) {
                modeloDietas.addRow(new Object[]{
                    rs.getInt("idDieta"),
                    rs.getString("tipoDesayunos"),
                    rs.getString("tipoAlmuerzos"),
                    rs.getString("tipoCenas"),
                    rs.getString("tipoRefrigerios"),
                    rs.getInt("idCliente")
                });
            }
            
            // Asigna el modelo a la tabla
            tabla.setModel(modeloDietas);
        } catch (Exception e) {
            System.out.println("Error en el modelo, método mostrarDietaTB: " + e);
        }
    }

    // Método para cargar los datos de una dieta seleccionada en la tabla a los campos de texto
    public void cargarDatosTabla(FrmInicioNutricioniosta vista) {
        // Obtiene la fila seleccionada en la tabla
        int filaSeleccionada = vista.jTBdietaCRUD.getSelectedRow();
        
        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtiene los valores de la fila seleccionada
            String idDieta = vista.jTBdietaCRUD.getValueAt(filaSeleccionada, 0).toString();
            String desayunos = vista.jTBdietaCRUD.getValueAt(filaSeleccionada, 1).toString();
            String almuerzos = vista.jTBdietaCRUD.getValueAt(filaSeleccionada, 2).toString();
            String cenas = vista.jTBdietaCRUD.getValueAt(filaSeleccionada, 3).toString();
            String refrigerios = vista.jTBdietaCRUD.getValueAt(filaSeleccionada, 4).toString();
            String idCliente = vista.jTBdietaCRUD.getValueAt(filaSeleccionada, 5).toString();
            
            // Asigna los valores a los campos de texto correspondientes
            vista.txtDesayuno.setText(desayunos);
            vista.txtAlmuerzo.setText(almuerzos);
            vista.txtCena.setText(cenas);
            vista.txtRefrigerios.setText(refrigerios);
            vista.cbIdCliente.setSelectedItem(idCliente);
        }
    }
}