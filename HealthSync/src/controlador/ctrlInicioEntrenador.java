package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.FrmInicioEntrenador;


public class ctrlInicioEntrenador implements MouseListener{
    
    FrmInicioEntrenador vista;
    
    public ctrlInicioEntrenador (FrmInicioEntrenador vista){
        
        this.vista = vista;
        
        vista.btnAggConsejos.addMouseListener(this);
        vista.btnAggRutina.addMouseListener(this);
        vista.btnCerrarSesion.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
