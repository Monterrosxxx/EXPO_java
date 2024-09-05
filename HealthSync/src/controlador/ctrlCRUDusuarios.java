package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import static vista.FrmInicio.initInicio;
import vista.panelUsuarios;


public class ctrlCRUDusuarios implements MouseListener{
    
    panelUsuarios vista;
    Usuarios modelo;
    
    public ctrlCRUDusuarios (Usuarios Modelo, panelUsuarios Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        //Mostrar datos
        vista.jTBusuariosCRUD.addMouseListener(this);
        modelo.mostrarUsuariosTB(Vista.jTBusuariosCRUD);
        
        
        //Insertar datos
        vista.btnAgregarUsuario.addMouseListener(this);
        
        //Para actualizar datos
        vista.btnEditarUsuario1.addMouseListener(this);
        
        //Para eliminar datos
        vista.btnEliminarUsuario.addMouseListener(this);
        
        //Para limpiar
        vista.btnLimpiarUsuarios.addMouseListener(this);
    }

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
            vista.txtNombreCRUD.setText("");
            vista.txtCorreoCRUD.setText("");
            vista.txtContrasenaCRUD.setText("");
            return;
        }

    // Validaciones solo para btnAgregarUsuario y btnEditarUsuario1
    if (e.getSource() == vista.btnAgregarUsuario || e.getSource() == vista.btnEditarUsuario1) {

        if (vista.txtNombreCRUD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío");
            return;
        }

        if (!vista.txtCorreoCRUD.getText().matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(vista, "Ingrese un correo válido");
            return;
        }

        if (vista.txtContrasenaCRUD.getText().length() < 6) {
            JOptionPane.showMessageDialog(vista, "Contraseña inválida: debe ingresar una contraseña de mínimo 6 caracteres");
            return;
        }
    }

    // Acciones específicas para cada botón
    if (e.getSource() == vista.btnAgregarUsuario) {
        System.err.println("le di clic al boton");

        modelo.setCorreo(vista.txtCorreoCRUD.getText());
        modelo.setClave(vista.txtContrasenaCRUD.getText());
        modelo.setNombre(vista.txtNombreCRUD.getText());

        modelo.insertarUsuario();
        modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
    }

    if (e.getSource() == vista.btnEliminarUsuario) {
        // Validación para verificar si los campos de texto están vacíos
        if (vista.txtNombreCRUD.getText().isEmpty() && vista.txtCorreoCRUD.getText().isEmpty() && vista.txtContrasenaCRUD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Escoja qué registro eliminar por favor");
            return;
        }
        
        modelo.eliminarUsuario(vista.jTBusuariosCRUD);
        modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
    }

    if (e.getSource() == vista.btnEditarUsuario1) {
        modelo.setCorreo(vista.txtCorreoCRUD.getText());
        modelo.setClave(vista.txtContrasenaCRUD.getText());
        modelo.setNombre(vista.txtNombreCRUD.getText());

        modelo.actualizarUsuario(vista.jTBusuariosCRUD);
        modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
    }
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
    
}