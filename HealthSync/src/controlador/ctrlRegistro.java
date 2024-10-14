package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import vista.Registrarse;
import static vista.bienvenida.initBienvenida;

public class ctrlRegistro implements MouseListener {
    
    Usuarios modelo;
    Registrarse vista;
    
    public ctrlRegistro (Usuarios Modelo, Registrarse Vista) {
        this.modelo = Modelo;
        this.vista = Vista;

        vista.btnAccederdelRegistro.addMouseListener(this);
        vista.btnSalirRegistro.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnSalirRegistro){
            initBienvenida();
            vista.dispose();
        }

        if(e.getSource() == vista.btnAccederdelRegistro){
            // Validaciones
        // Que el nombre no esté vacío
        if (vista.txtNombreRegistro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío");
            return;
        }

        // Que el correo sea válido   
        if (!vista.txtCorreoRegistro.getText().matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(vista, "Ingrese un correo válido");
            return;
        }

        // Que la contraseña tenga más de 6 caracteres
        if (vista.txtContrasenaRegistro.getText().length() < 6) {
            JOptionPane.showMessageDialog(vista, "Contraseña inválida: debe contener mínimo 6 caracteres");
            return;
        }
        
        // Nueva validación: Comparar contraseña con la confirmación
        if (!vista.txtContrasenaRegistro.getText().equals(vista.txtConfirmarContrasena.getText())) {
            JOptionPane.showMessageDialog(vista, "La confirmación de contraseña debe coincidir con la contraseña");
            return;
        }
        
            modelo.setNombre(vista.txtNombreRegistro.getText());
            modelo.setCorreo(vista.txtCorreoRegistro.getText());
            modelo.setClave(vista.txtContrasenaRegistro.getText());
            
            modelo.insertarUsuario();
            
            // Muestro una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(vista, "Usuario Guardado");
            
            initBienvenida();
            vista.dispose();
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