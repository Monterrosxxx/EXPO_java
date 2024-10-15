package controlador;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;
import vista.FrmCorreodeRecuperacion;
import modelo.envioCorreos;
import modelo.Usuarios;
import static vista.FrmCodigoVerificación.initCodigoVerificacion;
import static vista.bienvenida.initBienvenida;

public class ctrlCorreoRecuperacion implements MouseListener {
    
    FrmCorreodeRecuperacion vista;
    public static String codigoGenerado; // Variable para almacenar el código
    
    public ctrlCorreoRecuperacion (FrmCorreodeRecuperacion Vista) {
        this.vista = Vista;
        vista.btnContinuarCodVeri.addMouseListener(this);
        vista.btnRegresar.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.btnContinuarCodVeri){
            
            if (!vista.txtCorreoRecuperacion.getText().matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(vista, "Ingrese un correo válido");
                return;
            }
            
            String correoRecuperacion = vista.txtCorreoRecuperacion.getText();
            Usuarios.setCorreoRecuperacion(correoRecuperacion); // Guardamos el correo para la recuperación
            
            Random random = new Random();
            
            // Genera un número aleatorio de 4 dígitos (1000 a 9999)
            int numeroAleatorio = 1000 + random.nextInt(9000);
            codigoGenerado = String.valueOf(numeroAleatorio); // Almacena el código generado
            
            String recipient = correoRecuperacion;
            String subject = "Recuperación de contraseña";
            envioCorreos.enviarCorreo(recipient, subject, codigoGenerado);
            
            initCodigoVerificacion();
            vista.dispose();
        }
        
        if(e.getSource() == vista.btnRegresar){
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
