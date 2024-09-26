package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.FrmInicioEntrenador;
import static vista.bienvenida.initBienvenida;
import vista.panelConsejosE;


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
        
        if(e.getSource() == vista.btnAggConsejos){
            //1-Creo un objeto del panel que quiero mostrar
            panelConsejosE  objConsejos = new panelConsejosE();
            
            //2- Limpio el panel contendor (por si acaso)
            vista.jpContenedorEntrenador.removeAll();
            //3- muestro el panel que quiero
            vista.jpContenedorEntrenador.add(objConsejos);
            
            //4- Refrescar todo
            vista.jpContenedorEntrenador.revalidate();
            vista.jpContenedorEntrenador.repaint();
        }
        
        if(e.getSource() == vista.btnCerrarSesion){
            initBienvenida();
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
