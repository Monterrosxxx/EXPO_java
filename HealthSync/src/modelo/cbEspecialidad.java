package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;


public class cbEspecialidad {
    
    private String idEspecialidad;
    private String nombreEspecialidad;

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    public cbEspecialidad(){
        
    }
    
    public cbEspecialidad (String ID, String nombre)
    {
        this.idEspecialidad = ID;
        this.nombreEspecialidad = nombre;
    }
    
    public String toString()
    {
        return nombreEspecialidad;
    }
    
    //Metodo para cargar los valores en el ComboBox del CRUD entrenador y insertar la Especialidad
    //del entrenador
    public void CargarComboEspecialidades(JComboBox comboBox){    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Especialidad");
            while (rs.next()) {
                String ID = rs.getString("idEspecialidad");
                String nombreE = rs.getString("nombreEspecialidad");
                comboBox.addItem(new cbEspecialidad(ID, nombreE));                
            }
            
            rs.close();
            statement.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();  
        }
    }
    
}
