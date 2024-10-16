package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.clientesRutina;
import static vista.FrmInicioEntrenador.initEntrenador;
import vista.frmClientesRutina;


public class ctrlClientesRutina implements MouseListener{
    
    frmClientesRutina vista;
    clientesRutina modelo;
    
    public ctrlClientesRutina (frmClientesRutina vista, clientesRutina modelo){
        
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnSalirCR.addMouseListener(this);
        
        modelo.mostrarClientesRutina(vista.jTBclientesRutina);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnSalirCR){
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
