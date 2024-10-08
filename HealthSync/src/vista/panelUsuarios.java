package vista;

import controlador.ctrlCRUDusuarios;
import modelo.Usuarios;

public class panelUsuarios extends javax.swing.JPanel {

    public panelUsuarios() {
        initComponents();
        
        panelUsuarios panelCRUD = this;
        Usuarios modelo = new Usuarios();
        ctrlCRUDusuarios controlador = new ctrlCRUDusuarios(modelo, panelCRUD);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTBusuariosCRUD = new javax.swing.JTable();
        txtContrasenaCRUD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreoCRUD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreCRUD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSalirInicio = new javax.swing.JButton();
        btnLimpiarUsuarios = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnEditarUsuario1 = new javax.swing.JButton();
        btnAgregarUsuario = new javax.swing.JButton();
        btnVerClave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1500, 776));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTBusuariosCRUD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTBusuariosCRUD);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 800, 160));

        txtContrasenaCRUD.setBackground(new java.awt.Color(221, 221, 221));
        txtContrasenaCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaCRUDActionPerformed(evt);
            }
        });
        add(txtContrasenaCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 373, 44));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Contraseña");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        txtCorreoCRUD.setBackground(new java.awt.Color(221, 221, 221));
        add(txtCorreoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 373, 48));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Correo");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        txtNombreCRUD.setBackground(new java.awt.Color(221, 221, 221));
        add(txtNombreCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 373, 48));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingrese nuevo usuario");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bienvenido a HEALTHSYNC");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        btnSalirInicio.setBackground(new java.awt.Color(118, 99, 242));
        btnSalirInicio.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnSalirInicio.setText("Salir");
        add(btnSalirInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 148, 53));

        btnLimpiarUsuarios.setBackground(new java.awt.Color(118, 99, 242));
        btnLimpiarUsuarios.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnLimpiarUsuarios.setText("Limpiar");
        btnLimpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarUsuariosActionPerformed(evt);
            }
        });
        add(btnLimpiarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 182, 54));

        btnEliminarUsuario.setBackground(new java.awt.Color(118, 99, 242));
        btnEliminarUsuario.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnEliminarUsuario.setText("Eliminar");
        add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, 182, 54));

        btnEditarUsuario1.setBackground(new java.awt.Color(118, 99, 242));
        btnEditarUsuario1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnEditarUsuario1.setText("Editar");
        add(btnEditarUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 182, 54));

        btnAgregarUsuario.setBackground(new java.awt.Color(118, 99, 242));
        btnAgregarUsuario.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnAgregarUsuario.setText("Agregar");
        add(btnAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 181, 54));

        btnVerClave.setText("Ver");
        btnVerClave.setToolTipText("");
        add(btnVerClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtContrasenaCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaCRUDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaCRUDActionPerformed

    private void btnLimpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarUsuario;
    public javax.swing.JButton btnEditarUsuario1;
    public javax.swing.JButton btnEliminarUsuario;
    public javax.swing.JButton btnLimpiarUsuarios;
    public javax.swing.JButton btnSalirInicio;
    public javax.swing.JButton btnVerClave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTBusuariosCRUD;
    public javax.swing.JTextField txtContrasenaCRUD;
    public javax.swing.JTextField txtCorreoCRUD;
    public javax.swing.JTextField txtNombreCRUD;
    // End of variables declaration//GEN-END:variables

    public void dispose() {
    }

}
