/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ctrlCRUDrutina;
import modelo.Rutinas;
import modelo.cbClientes;

/**
 *
 * @author Estudiante
 */
public class panelRutinas extends javax.swing.JPanel {

    /**
     * Creates new form panelRutinas
     */
    public panelRutinas() {
        initComponents();
        
        panelRutinas panel = this;
        cbClientes modeloCliente = new cbClientes();
        Rutinas modeloRutina = new Rutinas();
        ctrlCRUDrutina controlador = new ctrlCRUDrutina(panel, modeloCliente, modeloRutina);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionRutina = new javax.swing.JTextArea();
        cbClienteIdRutina = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtNombreRutina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAgregarRutina = new javax.swing.JButton();
        btnEditarRutina = new javax.swing.JButton();
        btnEliminarRutina = new javax.swing.JButton();
        btnLimpiarRutina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBrutinaCRUD = new javax.swing.JTable();
        btnVerClientesRutina = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Bienvenido a HEALTHSYNC");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingresa una rutina");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Descripción de la rutina");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txtDescripcionRutina.setColumns(20);
        txtDescripcionRutina.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionRutina);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 110));

        cbClienteIdRutina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbClienteIdRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 300, 50));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Selecciona el cliente al que le agregaras los consejos");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        txtNombreRutina.setBackground(new java.awt.Color(221, 221, 221));
        add(txtNombreRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 300, 43));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre de la rutina");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        btnAgregarRutina.setBackground(new java.awt.Color(118, 99, 242));
        btnAgregarRutina.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnAgregarRutina.setText("Agregar");
        add(btnAgregarRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 181, 54));

        btnEditarRutina.setBackground(new java.awt.Color(118, 99, 242));
        btnEditarRutina.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnEditarRutina.setText("Editar");
        add(btnEditarRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 182, 54));

        btnEliminarRutina.setBackground(new java.awt.Color(118, 99, 242));
        btnEliminarRutina.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnEliminarRutina.setText("Eliminar");
        add(btnEliminarRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 182, 54));

        btnLimpiarRutina.setBackground(new java.awt.Color(118, 99, 242));
        btnLimpiarRutina.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnLimpiarRutina.setText("Limpiar");
        btnLimpiarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarRutinaActionPerformed(evt);
            }
        });
        add(btnLimpiarRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 182, 54));

        jTBrutinaCRUD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTBrutinaCRUD);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 830, 160));

        btnVerClientesRutina.setBackground(new java.awt.Color(118, 99, 242));
        btnVerClientesRutina.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnVerClientesRutina.setText("Clientes");
        add(btnVerClientesRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 181, 54));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("se le asignara el consejo aqui:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("IMPORTANTE: primero revisar a que cliente ");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarRutinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarRutinaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarRutina;
    public javax.swing.JButton btnEditarRutina;
    public javax.swing.JButton btnEliminarRutina;
    public javax.swing.JButton btnLimpiarRutina;
    public javax.swing.JButton btnVerClientesRutina;
    public javax.swing.JComboBox<String> cbClienteIdRutina;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTBrutinaCRUD;
    public javax.swing.JTextArea txtDescripcionRutina;
    public javax.swing.JTextField txtNombreRutina;
    // End of variables declaration//GEN-END:variables

}
