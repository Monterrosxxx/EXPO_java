package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import static vista.FrmCorreodeRecuperacion.initCorreodeRecuperacion;
import static vista.Registrarse.initRegistrarse;
import vista.bienvenida;

public class ctrlinicioSesion implements MouseListener{
    
    Usuarios modelo;
    bienvenida vista;
    
    public ctrlinicioSesion (Usuarios Modelo, bienvenida Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        vista.btnRegistrarse.addMouseListener(this);
        vista.btnIniciarSesion.addMouseListener(this);
        vista.btnRecuperarContrasena.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnIniciarSesion){
            
            // Validaciones
        // Que el correo sea válido   
        if (!vista.txtCorreoUsuario.getText().matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(vista, "Ingrese un correo válido");
            return;
        }

        // Que la contraseña tenga más de 6 caracteres
        if (vista.txtContrasena.getText().length() < 6) {
            JOptionPane.showMessageDialog(vista, "Contraseña inválida: debe contener mínimo 6 caracteres");
            return;
        }   
            modelo.setCorreo(vista.txtCorreoUsuario.getText());
            modelo.setClave(vista.txtContrasena.getText());
            
            boolean comprobarCredenciales = modelo.iniciarSesionCredenciales();
        
            if (comprobarCredenciales == true) {
                JOptionPane.showMessageDialog(vista,"Usuario existe, ¡Bienvenido!");
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        }
        if(e.getSource() == vista.btnRegistrarse){
            initRegistrarse();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnRecuperarContrasena){
            initCorreodeRecuperacion();
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