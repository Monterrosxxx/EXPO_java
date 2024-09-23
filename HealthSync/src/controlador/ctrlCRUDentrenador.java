package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.cbEspecialidad;
import vista.panelEntrenador;


public class ctrlCRUDentrenador implements MouseListener{
    
    cbEspecialidad ModeloEspecialidad;
    panelEntrenador vista;
    
    
    public ctrlCRUDentrenador (panelEntrenador Vista, cbEspecialidad modeloEspecialidad){
        
        this.ModeloEspecialidad = modeloEspecialidad;
        this.vista = Vista;
        
        vista.btnAgregarEntrenador.addMouseListener(this);
        vista.btnEditarEntrenador.addMouseListener(this);
        vista.btnEliminarEntrenador.addMouseListener(this);
        vista.btnLimpiarCRUDentrenador.addMouseListener(this);
        vista.btnSalirJPEntrenador.addMouseListener(this);
        vista.jTBentrenadorCRUD.addMouseListener(this);
        vista.cbEspecialidad.addMouseListener(this);
        
        //Obtener el UUID del doctor seleccionado
        vista.cbEspecialidad.addActionListener(e -> {
            if (e.getSource() == vista.cbEspecialidad) {
                cbEspecialidad selectedItem = (cbEspecialidad) vista.cbEspecialidad.getSelectedItem();
                if (selectedItem != null) {
                    String ID = selectedItem.getIdEspecialidad();
                    ModeloEspecialidad.setIdEspecialidad(ID);
                }
            }
        });        
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
