package controlador;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import vista.FrmContrasenaNueva;
import static vista.bienvenida.initBienvenida;

public class ctrlContrasenaNueva implements MouseListener {
    
    FrmContrasenaNueva vista;
    Usuarios modelo;
    
    public ctrlContrasenaNueva (Usuarios Modelo, FrmContrasenaNueva Vista) {
        this.vista = Vista;
        this.modelo = Modelo;
        vista.btnConfirmarContrairLogin.addMouseListener(this);
        vista.btnRegresarBienvenida.addMouseListener(this);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnConfirmarContrairLogin) {
            // Obtener la nueva contraseña de la vista
            String nuevaContrasena = vista.txtContrasenaNueva.getText();
            
            // Llamar al método estático actualizarContrasena
            boolean actualizacionExitosa = Usuarios.actualizarContrasena(nuevaContrasena);
            
            if (actualizacionExitosa) {
                JOptionPane.showMessageDialog(vista, "¡Contraseña cambiada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                initBienvenida();
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo actualizar la contraseña. Por favor, intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == vista.btnRegresarBienvenida){
            
            initBienvenida();
            vista.dispose();
            
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