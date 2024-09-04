package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Usuarios;
import vista.panelUsuarios;


public class ctrlCRUDusuarios implements MouseListener{
    
    panelUsuarios vista;
    Usuarios modelo;
    
    public ctrlCRUDusuarios (Usuarios Modelo, panelUsuarios Vista) {
        this.modelo = Modelo;
        this.vista = Vista;
        
        //Mostrar datos
        vista.jTBusuariosCRUD.addMouseListener(this);
        modelo.mostrarUsuariosTB(Vista.jTBusuariosCRUD);
        
        
        //Insertar datos
        vista.btnAgregarUsuario.addMouseListener(this);
        
        //Para actualizar datos
        vista.btnEditarUsuario1.addMouseListener(this);
        
        //Para eliminar datos
        vista.btnEliminarUsuario.addMouseListener(this);
        
        //Para limpiar
        vista.btnLimpiarUsuarios.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnAgregarUsuario){
            System.err.println("le di clic al boton");
                    
            modelo.setCorreo(vista.txtCorreoCRUD.getText());
            modelo.setClave(vista.txtContrasenaCRUD.getText());
            modelo.setNombre(vista.txtNombreCRUD.getText());
            
            modelo.insertarUsuario();
            modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
        }
        
        if (e.getSource() == vista.btnEliminarUsuario) {
            modelo.eliminarUsuario(vista.jTBusuariosCRUD);
            modelo.mostrarUsuariosTB(vista.jTBusuariosCRUD);
        }
        
        if(e.getSource() == vista.jTBusuariosCRUD){
            modelo.cargarDatosTabla(vista);
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
