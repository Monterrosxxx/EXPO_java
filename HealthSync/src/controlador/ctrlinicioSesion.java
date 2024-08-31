package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Usuarios;
import static vista.Registrarse.initRegistrarse;
import vista.bienvenida;
import vista.Registrarse;

public class ctrlinicioSesion implements MouseListener{
    
    Usuarios modelo;
    bienvenida vista;
    
    public ctrlinicioSesion (Usuarios Modelo, bienvenida Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        vista.btnRegistrarse.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnRegistrarse){
            initRegistrarse();
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