package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import static vista.FrmInicio.initInicio;
import vista.panelUsuarios;

public class ctrlCRUDusuarios implements MouseListener {
    
    panelUsuarios vista;
    Usuarios modelo;
    
    // Constructor de la clase
    public ctrlCRUDusuarios(Usuarios Modelo, panelUsuarios Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        // Configuración de listeners para los componentes de la vista
        vista.jTBusuariosCRUD.addMouseListener(this);
        vista.btnAgregarUsuario.addMouseListener(this);
        vista.btnEditarUsuario1.addMouseListener(this);
        vista.btnEliminarUsuario.addMouseListener(this);
        vista.btnLimpiarUsuarios.addMouseListener(this);
        vista.btnSalirInicio.addMouseListener(this);
        vista.btnVerClave.addMouseListener(this);
        
        // Mostrar los usuarios en la tabla al iniciar
        modelo.mostrarUsuariosTB(Vista.jTBusuariosCRUD);
    }

    // Método para manejar eventos de clic
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnSalirInicio) {
            initInicio();
            vista.dispose();
            return;
        }

        if (e.getSource() == vista.jTBusuariosCRUD) {
            modelo.cargarDatosTabla(vista);
            return;
        }

        if (e.getSource() == vista.btnLimpiarUsuarios) {
            limpiarCampos();
            return;
        }

        // Validaciones comunes para agregar y editar usuario
        if (e.getSource() == vista.btnAgregarUsuario || e.getSource() == vista.btnEditarUsuario1) {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!validarCorreo(vista.txtCorreoCRUD.getText())) {
                JOptionPane.showMessageDialog(vista, "Ingrese un correo válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (vista.txtContrasenaCRUD.getText().length() < 6) {
                JOptionPane.showMessageDialog(vista, "La contraseña debe tener al menos 6 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar si el correo ya está en uso
            if (modelo.verificarCorreo(vista.txtCorreoCRUD.getText())) {
                JOptionPane.showMessageDialog(vista, "Correo en uso", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Acción para agregar usuario
        if (e.getSource() == vista.btnAgregarUsuario) {
            agregarUsuario();
        }

        // Acción para eliminar usuario
        if (e.getSource() == vista.btnEliminarUsuario) {
            eliminarUsuario();
        }

        // Acción para editar usuario
        if (e.getSource() == vista.btnEditarUsuario1) {
            editarUsuario();
        }
    }

    // Método para agregar un nuevo usuario
    private void agregarUsuario() {
        try {
            modelo.setCorreo(vista.txtCorreoCRUD.getText());
            modelo.setClave(vista.txtContrasenaCRUD.getText());
            modelo.setNombre(vista.txtNombreCRUD.getText());

            modelo.insertarUsuario();
            modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
            limpiarCampos();
            JOptionPane.showMessageDialog(vista, "Usuario agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al agregar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un usuario
    private void eliminarUsuario() {
        try {
            int filaSeleccionada = vista.jTBusuariosCRUD.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Seleccione un usuario para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                modelo.eliminarUsuario(vista.jTBusuariosCRUD);
                modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
                limpiarCampos();
                JOptionPane.showMessageDialog(vista, "Usuario eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al eliminar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para editar un usuario existente
    private void editarUsuario() {
        try {
            modelo.setCorreo(vista.txtCorreoCRUD.getText());
            modelo.setClave(vista.txtContrasenaCRUD.getText());
            modelo.setNombre(vista.txtNombreCRUD.getText());

            modelo.actualizarUsuario(vista.jTBusuariosCRUD);
            modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
            limpiarCampos();
            JOptionPane.showMessageDialog(vista, "Usuario actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtNombreCRUD.setText("");
        vista.txtCorreoCRUD.setText("");
        vista.txtContrasenaCRUD.setText("");
    }

    // Método para verificar si hay campos vacíos en el formulario
    private boolean camposVacios() {
        return vista.txtNombreCRUD.getText().isEmpty() ||
               vista.txtCorreoCRUD.getText().isEmpty() ||
               vista.txtContrasenaCRUD.getText().isEmpty();
    }

    // Método para validar el formato del correo electrónico
    private boolean validarCorreo(String correo) {
        return correo.matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
    }

    // Métodos de la interfaz MouseListener que no se utilizan
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}