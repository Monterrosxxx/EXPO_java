package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vista.panelNutricionista;
import modelo.Nutricionista;

public class ctrlCRUDnutricionista implements MouseListener {
    
    private panelNutricionista vista;
    private Nutricionista modelo;
    
    public ctrlCRUDnutricionista(panelNutricionista vista, Nutricionista modelo1) {
        this.vista = vista;
        this.modelo = new Nutricionista();
        
        // Agregar listeners a los botones y la tabla
        vista.btnActualizar.addMouseListener(this);
        vista.btnAgregar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.jTBnutricionistaCRUD.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            agregarNutricionista();
        } else if (e.getSource() == vista.btnEliminar) {
            eliminarNutricionista();
        } else if (e.getSource() == vista.btnActualizar) {
            actualizarNutricionista();
        } else if (e.getSource() == vista.jTBnutricionistaCRUD) {
            cargarDatosNutricionista();
        }
    }

    private void agregarNutricionista() {
        try {
            // Validar campos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener datos de la vista
            modelo.setNombre(vista.txtNombreNutri.getText());
            modelo.setEdad(Integer.parseInt(vista.txtEdadNutri.getText()));
            modelo.setNumero(vista.txtNumeroNutri.getText());
            modelo.setCorreo(vista.txtCorreoNutri.getText());
            modelo.setClave(vista.txtClaveNutri.getText());

            // Insertar nutricionista
            modelo.insertarNutricionista();

            // Limpiar campos y actualizar tabla
            limpiarCampos();
            actualizarTabla();
            JOptionPane.showMessageDialog(vista, "Nutricionista agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar nutricionista: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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
                // Eliminar nutricionista
                modelo.eliminarNutricionista();

                // Limpiar campos y actualizar tabla
                limpiarCampos();
                actualizarTabla();
                JOptionPane.showMessageDialog(vista, "Nutricionista eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar nutricionista: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarNutricionista() {
        try {
            // Validar campos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener datos de la vista
            modelo.setNombre(vista.txtNombreNutri.getText());
            modelo.setEdad(Integer.parseInt(vista.txtEdadNutri.getText()));
            modelo.setNumero(vista.txtNumeroNutri.getText());
            modelo.setCorreo(vista.txtCorreoNutri.getText());
            modelo.setClave(vista.txtClaveNutri.getText());

            // Actualizar nutricionista
            modelo.actualizarNutricionista();

            // Limpiar campos y actualizar tabla
            limpiarCampos();
            actualizarTabla();
            JOptionPane.showMessageDialog(vista, "Nutricionista actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar nutricionista: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosNutricionista() {
        int filaSeleccionada = vista.jTBnutricionistaCRUD.getSelectedRow();
        if (filaSeleccionada != -1) {
            vista.txtNombreNutri.setText(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 1).toString());
            vista.txtEdadNutri.setText(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 2).toString());
            vista.txtNumeroNutri.setText(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 3).toString());
            vista.txtCorreoNutri.setText(vista.jTBnutricionistaCRUD.getValueAt(filaSeleccionada, 4).toString());
            // No mostramos la clave por seguridad
            vista.txtClaveNutri.setText("");
        }
    }

    private void limpiarCampos() {
        vista.txtNombreNutri.setText("");
        vista.txtEdadNutri.setText("");
        vista.txtNumeroNutri.setText("");
        vista.txtCorreoNutri.setText("");
        vista.txtClaveNutri.setText("");
    }

    private void actualizarTabla() {
        // Aquí deberías implementar la lógica para actualizar la tabla
        // Por ejemplo, podrías tener un método en el modelo que devuelva todos los nutricionistas
        // y luego actualizar el modelo de la tabla con esos datos
    }

    private boolean camposVacios() {
        return vista.txtNombreNutri.getText().isEmpty() ||
               vista.txtEdadNutri.getText().isEmpty() ||
               vista.txtNumeroNutri.getText().isEmpty() ||
               vista.txtCorreoNutri.getText().isEmpty() ||
               vista.txtClaveNutri.getText().isEmpty();
    }

    // Estos métodos quedan vacíos ya que no necesitamos implementarlos
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}