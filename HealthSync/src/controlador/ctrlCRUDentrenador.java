package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Entrenador;
import modelo.cbEspecialidad;
import vista.panelEntrenador;

public class ctrlCRUDentrenador implements MouseListener {
    
    cbEspecialidad modeloEspecialidad;
    Entrenador modeloEntrenador;
    panelEntrenador vista;
    
    public ctrlCRUDentrenador(panelEntrenador Vista, cbEspecialidad modeloEspecialidad, Entrenador modeloEntrenador) {
        this.modeloEspecialidad = modeloEspecialidad;
        this.vista = Vista;
        this.modeloEntrenador = modeloEntrenador;
        
        // Agregar los eventos a los botones y componentes
        vista.btnAgregarEntrenador.addMouseListener(this);
        vista.btnEditarEntrenador.addMouseListener(this);
        vista.btnEliminarEntrenador.addMouseListener(this);
        vista.btnLimpiarCRUDentrenador.addMouseListener(this);
        vista.btnSalirJPEntrenador.addMouseListener(this);
        vista.jTBentrenadorCRUD.addMouseListener(this);
        vista.cbEspecialidad.addActionListener(e -> obtenerIdEspecialidad());
        
        // Cargar el ComboBox de Especialidades
        modeloEspecialidad.CargarComboEspecialidades(vista.cbEspecialidad);
        
        // Mostrar los entrenadores en la tabla
        modeloEntrenador.mostrarEntrenador(vista.jTBentrenadorCRUD);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // Si se hace clic en el botón "Agregar Entrenador"
        if (e.getSource() == vista.btnAgregarEntrenador) {
            // Obtener los datos de los campos de texto
            String nombre = vista.txtNombreEntrenador1.getText();
            int edad = Integer.parseInt(vista.txtEdadEntrenador.getText());
            String correo = vista.txtCorreoEntrenador.getText();
            String numero = vista.txtNumeroTelEntrenador.getText();
            String clave = vista.txtClave.getText();
            String idEspecialidad = modeloEspecialidad.getIdEspecialidad();
            
            // Validar que los campos no estén vacíos
            if (nombre.isEmpty() || correo.isEmpty() || numero.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.");
                return;
            }
            
            // Establecer los valores en el modelo Entrenador
            modeloEntrenador.setNombre(nombre);
            modeloEntrenador.setEdad(edad);
            modeloEntrenador.setCorreo(correo);
            modeloEntrenador.setNumero(numero);
            modeloEntrenador.setClave(clave);
           modeloEntrenador.setIdEspecialidad(Integer.parseInt(idEspecialidad));            
            // Insertar el nuevo entrenador
            modeloEntrenador.insertarEntrenador();
            
            // Actualizar la tabla
            modeloEntrenador.mostrarEntrenador(vista.jTBentrenadorCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
        }
        // Si se hace clic en el botón "Eliminar Entrenador"
        else if (e.getSource() == vista.btnEliminarEntrenador) {
            // Obtener el entrenador seleccionado en la tabla
            modeloEntrenador.cargarDatos(vista);
            
            // Eliminar el entrenador
            modeloEntrenador.eliminarEntrenador();
            
            // Actualizar la tabla
            modeloEntrenador.mostrarEntrenador(vista.jTBentrenadorCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
        }
        // Si se hace clic en el botón "Editar Entrenador"
        else if (e.getSource() == vista.btnEditarEntrenador) {
            // Obtener los datos de los campos de texto
            int idEntrenador = modeloEntrenador.getIdEntrenador();
            String nombre = vista.txtNombreEntrenador1.getText();
            int edad = Integer.parseInt(vista.txtEdadEntrenador.getText());
            String correo = vista.txtCorreoEntrenador.getText();
            String numero = vista.txtNumeroTelEntrenador.getText();
            String clave = vista.txtClave.getText();
            String idEspecialidad = modeloEspecialidad.getIdEspecialidad();
            
            // Validar que los campos no estén vacíos
            if (nombre.isEmpty() || correo.isEmpty() || numero.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.");
                return;
            }
            
            // Establecer los valores en el modelo Entrenador
            modeloEntrenador.setIdEntrenador(idEntrenador);
            modeloEntrenador.setNombre(nombre);
            modeloEntrenador.setEdad(edad);
            modeloEntrenador.setCorreo(correo);
            modeloEntrenador.setNumero(numero);
            modeloEntrenador.setClave(clave);
            modeloEntrenador.setIdEspecialidad(setText(String.valueOf(getEdad())));
            
            // Actualizar el entrenador
            modeloEntrenador.actualizarEntrenador();
            
            // Actualizar la tabla
            modeloEntrenador.mostrarEntrenador(vista.jTBentrenadorCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
        }
        // Si se hace clic en la tabla de Entrenadores
        else if (e.getSource() == vista.jTBentrenadorCRUD) {
            // Cargar los datos del entrenador seleccionado
            modeloEntrenador.cargarDatos(vista);
        }
        // Si se hace clic en el botón "Limpiar"
        else if (e.getSource() == vista.btnLimpiarCRUDentrenador) {
            limpiarCampos();
        }
    }
    
    private void obtenerIdEspecialidad() {
        cbEspecialidad selectedItem = (cbEspecialidad) vista.cbEspecialidad.getSelectedItem();
        if (selectedItem != null) {
            String ID = selectedItem.getIdEspecialidad();
            modeloEspecialidad.setIdEspecialidad(ID);
        }
    }
    
    private void limpiarCampos() {
        vista.txtNombreEntrenador1.setText("");
        vista.txtEdadEntrenador.setText("");
        vista.txtCorreoEntrenador.setText("");
        vista.txtNumeroTelEntrenador.setText("");
        vista.txtClave.setText("");
        vista.cbEspecialidad.setSelectedIndex(0);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }

    private Object getEdad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int setText(String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}