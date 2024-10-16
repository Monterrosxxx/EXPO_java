package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Dieta;
import modelo.cbClientes;
import vista.FrmInicioNutricioniosta;
import static vista.bienvenida.initBienvenida;
import static vista.frmClientesDieta.initClientesDieta;

public class ctrlInicioNutricionista implements MouseListener, ActionListener {
    
         FrmInicioNutricioniosta vista;
         cbClientes modeloClientes;
         Dieta modeloDieta;
    
    // Constructor de la clase
    public ctrlInicioNutricionista(FrmInicioNutricioniosta vista, cbClientes modeloClientes, Dieta modeloDieta) {
        this.vista = vista;
        this.modeloClientes = modeloClientes;
        this.modeloDieta = modeloDieta;
        
        // Agregar los eventos a los botones y componentes
        this.vista.cbIdCliente.addActionListener(this);
        this.vista.btnAgregarDieta.addMouseListener(this);
        this.vista.btnEliminarDieta.addMouseListener(this);
        this.vista.btnActualizarDieta.addMouseListener(this);
        this.vista.btnLimpiarDieta.addMouseListener(this);
        this.vista.jTBdietaCRUD.addMouseListener(this);
        this.vista.btnCerrarSesion.addMouseListener(this);
        this.vista.btnVerClientesDieta.addMouseListener(this);

        // Cargar los nombres de los clientes en el comboBox
        this.modeloClientes.CargarComboClientes(this.vista.cbIdCliente);
        
        // Mostrar las dietas en la tabla
        this.modeloDieta.mostrarDietaTB(this.vista.jTBdietaCRUD);
    }

    // Método para manejar eventos de clic
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnVerClientesDieta){
            
            initClientesDieta();
            vista.dispose();
            
        }
        
        // Si el evento fue dado en el botón "Agregar Dieta"
        if (e.getSource() == vista.btnAgregarDieta) {
            agregarDieta();
        }
        // Si el evento fue dado en el botón "Eliminar Dieta"
        else if (e.getSource() == vista.btnEliminarDieta) {
            eliminarDieta();
        }
        // Si el evento fue dado en el botón "Actualizar Dieta"
        else if (e.getSource() == vista.btnActualizarDieta) {
            actualizarDieta();
        }
        // Si el evento fue dado en la tabla de Dietas
        else if (e.getSource() == vista.jTBdietaCRUD) {
            // Cargar los datos de la dieta seleccionada
            modeloDieta.cargarDatosTabla(vista);
        }
        // Si el evento fue dado en el botón "Limpiar"
        else if (e.getSource() == vista.btnLimpiarDieta) {
            limpiarCampos();
        }
        
        if(e.getSource() == vista.btnCerrarSesion){
            initBienvenida();
            vista.dispose();
        }
    }

    // Método para agregar una nueva dieta
    private void agregarDieta() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Obtener los datos de los campos de texto
            String tipoDesayunos = vista.txtDesayuno.getText();
            String tipoAlmuerzos = vista.txtAlmuerzo.getText();
            String tipoCenas = vista.txtCena.getText();
            String tipoRefrigerios = vista.txtRefrigerios.getText();
            
            // Obtener el idCliente seleccionado
            int idCliente = obtenerIdClienteSeleccionado();
            if (idCliente == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Dieta
            modeloDieta.setTipoDesayunos(tipoDesayunos);
            modeloDieta.setTipoAlmuerzos(tipoAlmuerzos);
            modeloDieta.setTipoCenas(tipoCenas);
            modeloDieta.setTipoRefrigerios(tipoRefrigerios);
            modeloDieta.setIdCliente(idCliente);
            
            // Insertar la nueva dieta
            modeloDieta.insertarDieta();
            
            // Actualizar la tabla
            modeloDieta.mostrarDietaTB(vista.jTBdietaCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Dieta agregada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar dieta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una dieta
    private void eliminarDieta() {
        try {
            // Obtener la fila seleccionada
            int filaSeleccionada = vista.jTBdietaCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione una dieta para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Confirmar eliminación
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar esta dieta?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Eliminar la dieta
                modeloDieta.eliminarDieta(vista.jTBdietaCRUD);
                
                // Actualizar la tabla
                modeloDieta.mostrarDietaTB(vista.jTBdietaCRUD);
                
                // Limpiar los campos de texto
                limpiarCampos();
                
                JOptionPane.showMessageDialog(vista, "Dieta eliminada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar dieta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar una dieta existente
    private void actualizarDieta() {
        try {
            // Validar que no haya campos vacíos
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la fila seleccionada
            int filaSeleccionada = vista.jTBdietaCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione una dieta para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener los datos de los campos de texto
            String tipoDesayunos = vista.txtDesayuno.getText();
            String tipoAlmuerzos = vista.txtAlmuerzo.getText();
            String tipoCenas = vista.txtCena.getText();
            String tipoRefrigerios = vista.txtRefrigerios.getText();
            
            // Obtener el idCliente seleccionado
            int idCliente = obtenerIdClienteSeleccionado();
            if (idCliente == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor, seleccione un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Establecer los valores en el modelo Dieta
            modeloDieta.setTipoDesayunos(tipoDesayunos);
            modeloDieta.setTipoAlmuerzos(tipoAlmuerzos);
            modeloDieta.setTipoCenas(tipoCenas);
            modeloDieta.setTipoRefrigerios(tipoRefrigerios);
            modeloDieta.setIdCliente(idCliente);
            
            // Actualizar la dieta
            modeloDieta.actualizarDieta(vista.jTBdietaCRUD);
            
            // Actualizar la tabla
            modeloDieta.mostrarDietaTB(vista.jTBdietaCRUD);
            
            // Limpiar los campos de texto
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Dieta actualizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar dieta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener el ID del cliente seleccionado
    private int obtenerIdClienteSeleccionado() {
        cbClientes selectedItem = (cbClientes) vista.cbIdCliente.getSelectedItem();
        if (selectedItem != null) {
            return Integer.parseInt(selectedItem.getIdCliente());
        }
        // Retorna -1 si no se seleccionó ningún cliente
        return -1;
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtDesayuno.setText("");
        vista.txtAlmuerzo.setText("");
        vista.txtCena.setText("");
        vista.txtRefrigerios.setText("");
        vista.cbIdCliente.setSelectedIndex(0);
    }
    

    // Método para verificar si hay campos vacíos en el formulario
    private boolean camposVacios() {
        return vista.txtDesayuno.getText().isEmpty() ||
               vista.txtAlmuerzo.getText().isEmpty() ||
               vista.txtCena.getText().isEmpty() ||
               vista.txtRefrigerios.getText().isEmpty();
    }

    // Método para manejar los eventos de acción (selección en el comboBox)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cbIdCliente) {
            cbClientes selectedItem = (cbClientes) vista.cbIdCliente.getSelectedItem();
            if (selectedItem != null) {
                // Obtener el ID del cliente seleccionado
                String ID = selectedItem.getIdCliente();
                modeloClientes.setIdCliente(ID);
            }
        }
    }

    // Métodos de la interfaz MouseListener que no se utilizan pero deben implementarse
    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
}