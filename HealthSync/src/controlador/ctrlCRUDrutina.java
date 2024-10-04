package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Rutinas;
import modelo.cbClientes;
import vista.panelRutinas;

public class ctrlCRUDrutina implements MouseListener{
    
    panelRutinas vista;
    Rutinas modeloRutinas;
    cbClientes modeloClientes;
    
    public ctrlCRUDrutina (panelRutinas vista, Rutinas modeloRutinas, cbClientes modeloClientes){
        
        this.vista = vista;
        this.modeloClientes = modeloClientes;
        this.modeloRutinas = modeloRutinas;
        
        vista.btnAgregarRutina.addMouseListener(this);
        vista.btnEliminarRutina.addMouseListener(this);
        vista.btnEditarRutina.addMouseListener(this);
        vista.jTBrutinaCRUD.addMouseListener(this);
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
