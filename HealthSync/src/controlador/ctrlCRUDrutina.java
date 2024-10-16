package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Rutinas;
import modelo.cbClientes;
import static vista.frmClientesRutina.initClientesRutina;
import vista.panelRutinas;

// Controlador para el CRUD de rutinas
public class ctrlCRUDrutina implements MouseListener, ActionListener {
    
    panelRutinas vista;
    Rutinas modeloRutinas;
    cbClientes modeloClientes;
    
    // Constructor de la clase
    public ctrlCRUDrutina(panelRutinas vista, cbClientes modeloClientes, Rutinas modeloRutinas) {
        this.vista = vista;
        this.modeloClientes = modeloClientes;
        this.modeloRutinas = modeloRutinas;
        
        // Agregar listeners a los componentes de la vista
        this.vista.btnAgregarRutina.addMouseListener(this);
        this.vista.btnEliminarRutina.addMouseListener(this);
        this.vista.btnEditarRutina.addMouseListener(this);
        this.vista.cbClienteIdRutina.addActionListener(this);
        this.vista.jTBrutinaCRUD.addMouseListener(this);
        this.vista.btnVerClientesRutina.addMouseListener(this);
        
        // Cargar los clientes en el comboBox
        this.modeloClientes.CargarComboClientes(this.vista.cbClienteIdRutina);
        
        // Mostrar las rutinas en la tabla
        this.modeloRutinas.mostrarRutinasTB(this.vista.jTBrutinaCRUD);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnVerClientesRutina){
            initClientesRutina();
        }
        
        // Manejar eventos de clic en los botones y la tabla
        if (e.getSource() == vista.btnAgregarRutina) {
            agregarRutina();
        } else if (e.getSource() == vista.btnEliminarRutina) {
            eliminarRutina();
        } else if (e.getSource() == vista.btnEditarRutina) {
            editarRutina();
        } else if (e.getSource() == vista.jTBrutinaCRUD) {
            // Cargar los datos de la rutina seleccionada
            modeloRutinas.cargarDatos(vista);
        }
    }

    // Método para agregar una nueva rutina
    private void agregarRutina() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Obtener los datos de los campos de texto
            String nombreRutina = vista.txtNombreRutina.getText();
            String descripcionRutina = vista.txtDescripcionRutina.getText();
            
            // Obtener el idCliente seleccionado
            int idCliente = obtenerIdClienteSeleccionado();
            if (idCliente == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Rutinas
            modeloRutinas.setNombreRutina(nombreRutina);
            modeloRutinas.setDescripcionRutina(descripcionRutina);
            modeloRutinas.setIdCliente(idCliente);
            
            // Insertar la nueva rutina
            modeloRutinas.insertarRutina();
            
            // Actualizar la tabla
            modeloRutinas.mostrarRutinasTB(vista.jTBrutinaCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Rutina agregada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar rutina: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una rutina
    private void eliminarRutina() {
        try {
            // Obtener la fila seleccionada
            int filaSeleccionada = vista.jTBrutinaCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione una rutina para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Confirmar eliminación
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar esta rutina?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Obtener el ID de la rutina seleccionada
                int idRutina = Integer.parseInt(vista.jTBrutinaCRUD.getValueAt(filaSeleccionada, 0).toString());
                
                // Eliminar la rutina
                modeloRutinas.eliminarRutina(idRutina);
                
                // Actualizar la tabla
                modeloRutinas.mostrarRutinasTB(vista.jTBrutinaCRUD);
                
                // Limpiar los campos de texto
                limpiarCampos();
                
                JOptionPane.showMessageDialog(vista, "Rutina eliminada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar rutina: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para editar una rutina existente
    private void editarRutina() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la fila seleccionada
            int filaSeleccionada = vista.jTBrutinaCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione una rutina para editar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener los datos de los campos de texto
            String nombreRutina = vista.txtNombreRutina.getText();
            String descripcionRutina = vista.txtDescripcionRutina.getText();
            
            // Obtener el idCliente seleccionado
            int idCliente = obtenerIdClienteSeleccionado();
            if (idCliente == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Rutinas
            modeloRutinas.setNombreRutina(nombreRutina);
            modeloRutinas.setDescripcionRutina(descripcionRutina);
            modeloRutinas.setIdCliente(idCliente);
            
            // Obtener el ID de la rutina seleccionada
            int idRutina = Integer.parseInt(vista.jTBrutinaCRUD.getValueAt(filaSeleccionada, 0).toString());
            
            // Actualizar la rutina
            modeloRutinas.actualizarRutina(idRutina);
            
            // Actualizar la tabla
            modeloRutinas.mostrarRutinasTB(vista.jTBrutinaCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Rutina actualizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar rutina: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener el ID del cliente seleccionado
    private int obtenerIdClienteSeleccionado() {
        cbClientes selectedItem = (cbClientes) vista.cbClienteIdRutina.getSelectedItem();
        if (selectedItem != null) {
            return Integer.parseInt(selectedItem.getIdCliente());
        }
        // Retorna -1 si no se seleccionó ningún cliente
        return -1;
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtNombreRutina.setText("");
        vista.txtDescripcionRutina.setText("");
        vista.cbClienteIdRutina.setSelectedIndex(0);
    }

    // Método para verificar si hay campos vacíos en el formulario
    private boolean camposVacios() {
        return vista.txtNombreRutina.getText().isEmpty() ||
               vista.txtDescripcionRutina.getText().isEmpty();
    }

    // Método para manejar los eventos de acción (selección en el comboBox)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cbClienteIdRutina) {
            cbClientes selectedItem = (cbClientes) vista.cbClienteIdRutina.getSelectedItem();
            if (selectedItem != null) {
                // Obtener el ID del cliente seleccionado
                String ID = selectedItem.getIdCliente();
                modeloClientes.setIdCliente(ID);
            }
        }
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
