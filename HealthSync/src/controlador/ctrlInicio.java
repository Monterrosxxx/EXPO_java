package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.FrmInicio;
import vista.panelUsuarios;


public class ctrlInicio implements MouseListener{
    
    FrmInicio vista;
    
    public ctrlInicio (FrmInicio Vista) {
        this.vista = Vista;
        
        vista.btnUsuarios.addMouseListener(this);
        
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnUsuarios){
            //1-Creo un objeto del panel que quiero mostrar
            panelUsuarios  objUsuarios = new panelUsuarios();
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jpContenedor.removeAll();
            //3- muestro el panel que quiero
            vista.jpContenedor.add(objUsuarios);
            
            //4- Refrescar todo
            vista.jpContenedor.revalidate();
            vista.jpContenedor.repaint();
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
