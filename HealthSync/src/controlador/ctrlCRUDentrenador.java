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
    
    // Constructor de la clase
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
    
    // Método para manejar eventos de clic
    @Override
    public void mouseClicked(MouseEvent e) {
        // Si el evento fue dado en el botón "Agregar Entrenador"
        if (e.getSource() == vista.btnAgregarEntrenador) {
            agregarEntrenador();
        }
        // Si el evento fue dado en el botón "Eliminar Entrenador"
        else if (e.getSource() == vista.btnEliminarEntrenador) {
            eliminarEntrenador();
        }
        // Si el evento fue dado en el botón "Editar Entrenador"
        else if (e.getSource() == vista.btnEditarEntrenador) {
            editarEntrenador();
        }
        // Si el evento fue dado en la tabla de Entrenadores
        else if (e.getSource() == vista.jTBentrenadorCRUD) {
            // Cargar los datos del entrenador seleccionado
            modeloEntrenador.cargarDatos(vista);
        }
        // Si el evento fue dado en el botón "Limpiar"
        else if (e.getSource() == vista.btnLimpiarCRUDentrenador) {
            limpiarCampos();
        }
    }
    
    // Método para agregar un nuevo entrenador
    private void agregarEntrenador() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener los datos de los campos de texto
            String nombre = vista.txtNombreEntrenador1.getText();
            int edad = Integer.parseInt(vista.txtEdadEntrenador.getText());
            String correo = vista.txtCorreoEntrenador.getText();
            String numero = vista.txtNumeroTelEntrenador.getText();
            String clave = vista.txtClave.getText();
            
            // Obtener el idEspecialidad seleccionado
            int idEspecialidad = obtenerIdEspecialidadSeleccionado();
            if (idEspecialidad == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione una especialidad.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Entrenador
            modeloEntrenador.setNombre(nombre);
            modeloEntrenador.setEdad(edad);
            modeloEntrenador.setCorreo(correo);
            modeloEntrenador.setNumero(numero);
            modeloEntrenador.setClave(clave);
            modeloEntrenador.setIdEspecialidad(idEspecialidad);
            
            // Insertar el nuevo entrenador
            modeloEntrenador.insertarEntrenador();
            
            // Actualizar la tabla
            modeloEntrenador.mostrarEntrenador(vista.jTBentrenadorCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Entrenador agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar entrenador: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para eliminar un entrenador
    private void eliminarEntrenador() {
        try {
            // Obtener el ID del entrenador seleccionado
            int filaSeleccionada = vista.jTBentrenadorCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione un entrenador para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idEntrenador = Integer.parseInt(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 0).toString());
            modeloEntrenador.setIdEntrenador(idEntrenador);

            // Confirmar eliminación
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este entrenador?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Eliminar el entrenador
                modeloEntrenador.eliminarEntrenador();
                
                // Actualizar la tabla
                modeloEntrenador.mostrarEntrenador(vista.jTBentrenadorCRUD);
                
                // Limpiar los campos de texto
                limpiarCampos();
                
                JOptionPane.showMessageDialog(vista, "Entrenador eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar entrenador: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para editar un entrenador existente
    private void editarEntrenador() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el ID del entrenador seleccionado
            int filaSeleccionada = vista.jTBentrenadorCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione un entrenador para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idEntrenador = Integer.parseInt(vista.jTBentrenadorCRUD.getValueAt(filaSeleccionada, 0).toString());

            // Obtener los datos de los campos de texto
            String nombre = vista.txtNombreEntrenador1.getText();
            int edad = Integer.parseInt(vista.txtEdadEntrenador.getText());
            String correo = vista.txtCorreoEntrenador.getText();
            String numero = vista.txtNumeroTelEntrenador.getText();
            String clave = vista.txtClave.getText();
            
            // Obtener el idEspecialidad seleccionado
            int idEspecialidad = obtenerIdEspecialidadSeleccionado();
            if (idEspecialidad == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione una especialidad.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Entrenador
            modeloEntrenador.setIdEntrenador(idEntrenador);
            modeloEntrenador.setNombre(nombre);
            modeloEntrenador.setEdad(edad);
            modeloEntrenador.setCorreo(correo);
            modeloEntrenador.setNumero(numero);
            modeloEntrenador.setClave(clave);
            modeloEntrenador.setIdEspecialidad(idEspecialidad);
            
            // Actualizar el entrenador
            modeloEntrenador.actualizarEntrenador();
            
            // Actualizar la tabla
            modeloEntrenador.mostrarEntrenador(vista.jTBentrenadorCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Entrenador actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar entrenador: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para obtener el ID de la especialidad seleccionada
    private int obtenerIdEspecialidadSeleccionado() {
        cbEspecialidad selectedItem = (cbEspecialidad) vista.cbEspecialidad.getSelectedItem();
        if (selectedItem != null) {
            return Integer.parseInt(selectedItem.getIdEspecialidad());
        }
        // Retorna -1 si no se seleccionó ninguna especialidad
        return -1; 
    }
    
    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtNombreEntrenador1.setText("");
        vista.txtEdadEntrenador.setText("");
        vista.txtCorreoEntrenador.setText("");
        vista.txtNumeroTelEntrenador.setText("");
        vista.txtClave.setText("");
        vista.cbEspecialidad.setSelectedIndex(0);
    }
    
    // Método para verificar si hay campos vacíos en el formulario
    private boolean camposVacios() {
        return vista.txtNombreEntrenador1.getText().isEmpty() ||
               vista.txtEdadEntrenador.getText().isEmpty() ||
               vista.txtCorreoEntrenador.getText().isEmpty() ||
               vista.txtNumeroTelEntrenador.getText().isEmpty() ||
               vista.txtClave.getText().isEmpty() ||
               vista.cbEspecialidad.getSelectedIndex() == 0;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}

    private void obtenerIdEspecialidad() {
    }
}