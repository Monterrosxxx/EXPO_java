package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import modelo.Usuarios;
import vista.Registrarse;
import static vista.bienvenida.initBienvenida;

public class ctrlRegistro implements MouseListener {
    
    Usuarios modelo;
    Registrarse vista;
    
    // Constructor de la clase
    public ctrlRegistro (Usuarios Modelo, Registrarse Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        // Agregar listeners a los botones
        vista.btnAccederdelRegistro.addMouseListener(this);
        vista.btnSalirRegistro.addMouseListener(this);
        vista.btnVerConfContra.addMouseListener(this);
        vista.btnVerContra.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        // Manejar el botón de salir del registro
        if(e.getSource() == vista.btnSalirRegistro){
            initBienvenida();
            vista.dispose();
        }
        
        // Manejar el botón de acceder del registro
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
            if (new String(vista.txtContrasenaRegistro1.getPassword()).length() < 6) {
                JOptionPane.showMessageDialog(vista, "Contraseña inválida: debe contener mínimo 6 caracteres");
                return;
            }
            
            // Comparar contraseña con la confirmación
            if (!new String(vista.txtContrasenaRegistro1.getPassword()).equals(new String(vista.txtConfirmarContrasena.getPassword()))) {
                JOptionPane.showMessageDialog(vista, "La confirmación de contraseña debe coincidir con la contraseña");
                return;
            }
            
            // Guardar los datos del usuario
            modelo.setNombre(vista.txtNombreRegistro.getText());
            modelo.setCorreo(vista.txtCorreoRegistro.getText());
            modelo.setClave(new String(vista.txtContrasenaRegistro1.getPassword()));
            
            modelo.insertarUsuario();
            
            // Mostrar una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(vista, "Usuario Guardado");
            
            initBienvenida();
            vista.dispose();
        }
        
        // Manejar el botón de ver contraseña
        if(e.getSource() == vista.btnVerContra){
            togglePasswordVisibility(vista.txtContrasenaRegistro1);
        }
        
        // Manejar el botón de ver confirmación de contraseña
        if(e.getSource() == vista.btnVerConfContra){
            togglePasswordVisibility(vista.txtConfirmarContrasena);
        }
    }
    
    // Método para alternar la visibilidad de la contraseña
    private void togglePasswordVisibility(JPasswordField passwordField) {
        if (passwordField.getEchoChar() == 0) {
            // Usar punto medio como caracter de ocultación
            passwordField.setEchoChar('\u2022'); 
        } else {
            // Mostrar el texto de la contraseña
            passwordField.setEchoChar((char) 0); 
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