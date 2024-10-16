package controlador;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vista.FrmCodigoVerificación;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import static vista.FrmContrasenaNueva.initContrasenaNueva;
import static vista.FrmCorreodeRecuperacion.initCorreodeRecuperacion;

public class ctrlCodigoVerificacion implements MouseListener {
    
    FrmCodigoVerificación vista;
    
    public ctrlCodigoVerificacion (FrmCodigoVerificación Vista) {
        this.vista = Vista;
        vista.btnContinuarContraNueva.addMouseListener(this);
        vista.btnRegresarCorreo.addMouseListener(this);
        
        // Configurar el campo de texto para aceptar solo números
        vista.txtCodigoVerificacion.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null)
                    return;
                String oldString = getText(0, getLength());
                String newString = oldString.substring(0, offs) + str + oldString.substring(offs);
                if (newString.matches("\\d*")) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.btnContinuarContraNueva){
            String codigoIngresado = vista.txtCodigoVerificacion.getText();
            if(codigoIngresado.equals(ctrlCorreoRecuperacion.codigoGenerado)){
                JOptionPane.showMessageDialog(vista, "Código válido");
                
                initContrasenaNueva();
                vista.dispose();
                
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR: Código de verificación incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == vista.btnRegresarCorreo){
            
            initCorreodeRecuperacion();
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