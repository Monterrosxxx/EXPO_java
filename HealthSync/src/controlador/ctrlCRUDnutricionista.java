package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vista.panelNutricionista;
import modelo.Nutricionista;

public class ctrlCRUDnutricionista implements MouseListener {
    
    private panelNutricionista vista;
    private Nutricionista modelo;
    
    // Constructor de la clase
    public ctrlCRUDnutricionista(panelNutricionista vista, Nutricionista modelo1) {
        this.vista = vista;
        this.modelo = new Nutricionista();
        
        // Agregar listeners a los botones y la tabla
        vista.btnActualizar.addMouseListener(this);
        vista.btnAgregar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.jTBnutricionistaCRUD.addMouseListener(this);
        vista.btnLimpiar.addMouseListener(this);
        
        // Mostrar los datos de los nutricionistas al iniciar
        modelo.mostrarDatosNutricionista(vista.jTBnutricionistaCRUD);
    }

    // Método principal para manejar eventos de clic
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            agregarNutricionista();
        } else if (e.getSource() == vista.btnEliminar) {
            eliminarNutricionista();
        } else if (e.getSource() == vista.btnActualizar) {
            actualizarNutricionista();
        } else if (e.getSource() == vista.jTBnutricionistaCRUD) {
            // Cargar datos del nutricionista seleccionado
            modelo.cargarDatosNutricionista(vista);
        } else if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
    }

    // Método para agregar un nuevo nutricionista
    private void agregarNutricionista() {
        try {
            // Validar campos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si el correo ya está en uso
            String correo = vista.txtCorreoNutri.getText();
            if (modelo.verificarCorreo(correo)) {
                JOptionPane.showMessageDialog(vista, "Correo en uso", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener datos de la vista
            modelo.setNombre(vista.txtNombreNutri.getText());
            modelo.setEdad(Integer.parseInt(vista.txtEdadNutri.getText()));
            modelo.setNumero(vista.txtNumeroNutri.getText());
            modelo.setCorreo(correo);
            modelo.setClave(vista.txtClaveNutri.getText());

            // Insertar nutricionista en la base de datos
            modelo.insertarNutricionista();

            // Limpiar campos y actualizar tabla
            limpiarCampos();
            modelo.mostrarDatosNutricionista(vista.jTBnutricionistaCRUD);
            JOptionPane.showMessageDialog(vista, "Nutricionista agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar nutricionista: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un nutricionista
    private void eliminarNutricionista() {
        try {
            // Obtener el ID del nutricionista seleccionado
            int filaSeleccionada = vista.jTBnutricionistaCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione un nutricionista para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idNutricionista = Integer.parseInt(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 0).toString());
            modelo.setIdNutricionista(idNutricionista);

            // Confirmar eliminación
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este nutricionista?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Eliminar nutricionista de la base de datos
                modelo.eliminarNutricionista();

                // Limpiar campos y actualizar tabla
                limpiarCampos();
                modelo.mostrarDatosNutricionista(vista.jTBnutricionistaCRUD);
                JOptionPane.showMessageDialog(vista, "Nutricionista eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar nutricionista: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar un nutricionista
    private void actualizarNutricionista() {
        try {
            // Validar campos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el ID del nutricionista seleccionado
            int filaSeleccionada = vista.jTBnutricionistaCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione un nutricionista para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idNutricionista = Integer.parseInt(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 0).toString());
            modelo.setIdNutricionista(idNutricionista);

            // Verificar si el nuevo correo ya está en uso (excluyendo el correo actual del nutricionista)
            String nuevoCorreo = vista.txtCorreoNutri.getText();
            String correoActual = vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 2).toString();
            if (!nuevoCorreo.equals(correoActual) && modelo.verificarCorreo(nuevoCorreo)) {
                JOptionPane.showMessageDialog(vista, "Correo en uso", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener datos de la vista
            modelo.setNombre(vista.txtNombreNutri.getText());
            modelo.setEdad(Integer.parseInt(vista.txtEdadNutri.getText()));
            modelo.setNumero(vista.txtNumeroNutri.getText());
            modelo.setCorreo(nuevoCorreo);
            modelo.setClave(vista.txtClaveNutri.getText());

            // Actualizar nutricionista en la base de datos
            modelo.actualizarNutricionista();

            // Limpiar campos y actualizar tabla
            limpiarCampos();
            modelo.mostrarDatosNutricionista(vista.jTBnutricionistaCRUD);
            JOptionPane.showMessageDialog(vista, "Nutricionista actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar nutricionista: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtNombreNutri.setText("");
        vista.txtEdadNutri.setText("");
        vista.txtNumeroNutri.setText("");
        vista.txtCorreoNutri.setText("");
        vista.txtClaveNutri.setText("");
    }

    // Método para verificar si hay campos vacíos en el formulario
    private boolean camposVacios() {
        return vista.txtNombreNutri.getText().isEmpty() ||
               vista.txtEdadNutri.getText().isEmpty() ||
               vista.txtNumeroNutri.getText().isEmpty() ||
               vista.txtCorreoNutri.getText().isEmpty() ||
               vista.txtClaveNutri.getText().isEmpty();
    }

    // Métodos no utilizados de la interfaz MouseListener
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}