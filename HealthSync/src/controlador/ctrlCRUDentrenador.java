package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.panelEntrenador;


public class ctrlCRUDentrenador implements MouseListener{
    
    panelEntrenador vista;
    
    
    public ctrlCRUDentrenador (panelEntrenador Vista){
        
        this.vista = Vista;
        
        vista.btnAgregarEntrenador.addMouseListener(this);
        vista.btnEditarEntrenador.addMouseListener(this);
        vista.btnEliminarEntrenador.addMouseListener(this);
        vista.btnLimpiarCRUDentrenador.addMouseListener(this);
        vista.btnSalirJPEntrenador.addMouseListener(this);
        vista.jTBentrenadorCRUD.addMouseListener(this);
        
        
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
