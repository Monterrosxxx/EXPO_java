package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Consejos;
import modelo.cbClientes;
import vista.panelConsejosE;

public class ctrlCRUDconsejo implements MouseListener, ActionListener {
    
    panelConsejosE vista;
    cbClientes modeloClientes;
    Consejos modeloConsejo;
    
    // Constructor de la clase
    public ctrlCRUDconsejo(panelConsejosE vista, cbClientes modeloClientes, Consejos modeloConsejo) {
        this.vista = vista;
        this.modeloClientes = modeloClientes;
        this.modeloConsejo = modeloConsejo;
        
        // Agregar los eventos a los botones y componentes
        this.vista.btnAgregarConsejo.addMouseListener(this);
        this.vista.btnEliminarConsejo.addMouseListener(this);
        this.vista.btnActualizarConsejo.addMouseListener(this);
        this.vista.btnLimpiar.addMouseListener(this);
        this.vista.cbClienteIdConsejo.addActionListener(this);
        this.vista.jTBconsejoCRUD.addMouseListener(this);

        // Cargar los nombres de los clientes en el comboBox
        this.modeloClientes.CargarComboClientes(this.vista.cbClienteIdConsejo);
        
        // Mostrar los consejos en la tabla
        this.modeloConsejo.mostrarConsejoTB(this.vista.jTBconsejoCRUD);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Si el evento fue dado en el botón "Agregar Consejo"
        if (e.getSource() == vista.btnAgregarConsejo) {
            agregarConsejo();
        }
        // Si el evento fue dado en el botón "Eliminar Consejo"
        else if (e.getSource() == vista.btnEliminarConsejo) {
            eliminarConsejo();
        }
        // Si el evento fue dado en el botón "Actualizar Consejo"
        else if (e.getSource() == vista.btnActualizarConsejo) {
            actualizarConsejo();
        }
        // Si el evento fue dado en la tabla de Consejos
        else if (e.getSource() == vista.jTBconsejoCRUD) {
            // Cargar los datos del consejo seleccionado
            modeloConsejo.cargarDatosTabla(vista);
        }
        // Si el evento fue dado en el botón "Limpiar"
        else if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
    }

    // Método para agregar un nuevo consejo
    private void agregarConsejo() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Obtener los datos de los campos de texto
            String fraseDia = vista.txtConsejoDia.getText();
            String consejoEjercicio = vista.txtConsejoEntrenar.getText();
            
            // Obtener el idCliente seleccionado
            int idCliente = obtenerIdClienteSeleccionado();
            if (idCliente == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Consejos
            modeloConsejo.setFraseDia(fraseDia);
            modeloConsejo.setConsejoEjercicio(consejoEjercicio);
            modeloConsejo.setIdCliente(idCliente);
            
            // Insertar el nuevo consejo
            modeloConsejo.insertarConsejo();
            
            // Actualizar la tabla
            modeloConsejo.mostrarConsejoTB(vista.jTBconsejoCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Consejo agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar consejo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un consejo
    private void eliminarConsejo() {
        try {
            // Obtener la fila seleccionada
            int filaSeleccionada = vista.jTBconsejoCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione un consejo para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Confirmar eliminación
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este consejo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Eliminar el consejo
                modeloConsejo.eliminarConsejo(vista.jTBconsejoCRUD);
                
                // Actualizar la tabla
                modeloConsejo.mostrarConsejoTB(vista.jTBconsejoCRUD);
                
                // Limpiar los campos de texto
                limpiarCampos();
                
                JOptionPane.showMessageDialog(vista, "Consejo eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar consejo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar un consejo existente
    private void actualizarConsejo() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la fila seleccionada
            int filaSeleccionada = vista.jTBconsejoCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione un consejo para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener los datos de los campos de texto
            String fraseDia = vista.txtConsejoDia.getText();
            String consejoEjercicio = vista.txtConsejoEntrenar.getText();
            
            // Obtener el idCliente seleccionado
            int idCliente = obtenerIdClienteSeleccionado();
            if (idCliente == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Consejos
            modeloConsejo.setFraseDia(fraseDia);
            modeloConsejo.setConsejoEjercicio(consejoEjercicio);
            modeloConsejo.setIdCliente(idCliente);
            
            // Actualizar el consejo
            modeloConsejo.actualizarConsejo(vista.jTBconsejoCRUD);
            
            // Actualizar la tabla
            modeloConsejo.mostrarConsejoTB(vista.jTBconsejoCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Consejo actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar consejo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener el ID del cliente seleccionado
    private int obtenerIdClienteSeleccionado() {
        cbClientes selectedItem = (cbClientes) vista.cbClienteIdConsejo.getSelectedItem();
        if (selectedItem != null) {
            return Integer.parseInt(selectedItem.getIdCliente());
        }
        // Retorna -1 si no se seleccionó ningún cliente
        return -1;
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtConsejoDia.setText("");
        vista.txtConsejoEntrenar.setText("");
        vista.cbClienteIdConsejo.setSelectedIndex(0);
    }

    // Método para verificar si hay campos vacíos en el formulario
    private boolean camposVacios() {
        return vista.txtConsejoDia.getText().isEmpty() ||
               vista.txtConsejoEntrenar.getText().isEmpty();
    }

    // Método para manejar los eventos de acción (selección en el comboBox)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cbClienteIdConsejo) {
            cbClientes selectedItem = (cbClientes) vista.cbClienteIdConsejo.getSelectedItem();
            if (selectedItem != null) {
                // Obtener el ID del cliente seleccionado
                String ID = selectedItem.getIdCliente();
                modeloClientes.setIdCliente(ID);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
}