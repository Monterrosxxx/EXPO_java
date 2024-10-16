package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.clientesDieta;
import static vista.FrmInicioNutricioniosta.initNutricionista;
import vista.frmClientesDieta;

public class ctrlClientesDieta implements MouseListener{
    
    frmClientesDieta vista;
    clientesDieta modelo;
    
    public ctrlClientesDieta (frmClientesDieta vista, clientesDieta modelo){
        
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnSalirCD.addMouseListener(this);
        
        modelo.mostrarClientesDieta(vista.jTBclientesDieta);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnSalirCD){
            initNutricionista();
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
