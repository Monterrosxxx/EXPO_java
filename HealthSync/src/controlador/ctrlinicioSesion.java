package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import modelo.Usuarios;
import static vista.FrmCorreodeRecuperacion.initCorreodeRecuperacion;
import static vista.FrmInicio.initInicio;
import static vista.FrmInicioEntrenador.initEntrenador;
import static vista.FrmInicioNutricioniosta.initNutricionista;
import static vista.Registrarse.initRegistrarse;
import vista.bienvenida;

public class ctrlinicioSesion implements MouseListener {
    
    // Atributos de la clase
    Usuarios modelo;
    bienvenida vista;
    
    // Constructor de la clase
    public ctrlinicioSesion (Usuarios Modelo, bienvenida Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        // Agregar listeners a los botones de la vista
        vista.btnRegistrarse.addMouseListener(this);
        vista.btnIniciarSesion.addMouseListener(this);
        vista.btnRecuperarContrasena.addMouseListener(this);
        vista.btnVerContra.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        // Si se hace clic en el botón de iniciar sesión
        if(e.getSource() == vista.btnIniciarSesion){
            
            // Validación del formato del correo electrónico
            if (!vista.txtCorreoUsuario.getText().matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(vista, "Ingrese un correo válido");
                return;
            }
 
            // Establecer el correo y la clave en el modelo
            modelo.setCorreo(vista.txtCorreoUsuario.getText());
            modelo.setClave(vista.txtContrasena.getText());
            
            // Verificar las credenciales
            boolean comprobarCredenciales = modelo.iniciarSesionCredenciales();
        
            if (comprobarCredenciales) {
                // Si las credenciales son correctas, verificar el rol del usuario
                switch(modelo.getIdRol()) {
                    case 1:
                        JOptionPane.showMessageDialog(vista, "¡Bienvenido administrador!");
                        initInicio();
                        vista.dispose();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(vista, "¡Bienvenido Entrenador!");
                        initEntrenador();
                        vista.dispose();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(vista, "¡Bienvenido Nutricionista!");
                        initNutricionista();
                        vista.dispose();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(vista, "Bienvenido Usuario");
                        break;
                    default:
                        JOptionPane.showMessageDialog(vista, "Rol de usuario no reconocido");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        }

        // Si se hace clic en el botón de registrarse
        if(e.getSource() == vista.btnRegistrarse){
            initRegistrarse();
            vista.dispose();
        }
        
        // Si se hace clic en el botón de recuperar contraseña
        if(e.getSource() == vista.btnRecuperarContrasena){
            initCorreodeRecuperacion();
            vista.dispose();
        }
        
        // Manejar el botón de ver contraseña
        if(e.getSource() == vista.btnVerContra){
            togglePasswordVisibility(vista.txtContrasena);
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

    // Métodos no utilizados de la interfaz MouseListener
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