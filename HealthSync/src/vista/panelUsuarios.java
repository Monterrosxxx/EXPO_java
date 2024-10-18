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
        btnLimpiarUsuarios = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnEditarUsuario1 = new javax.swing.JButton();
        btnAgregarUsuario = new javax.swing.JButton();
        btnVerClave = new javax.swing.JButton();
        btnSalirUsuarios = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1267, 720));
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 910, 250));

        txtContrasenaCRUD.setBackground(new java.awt.Color(210, 203, 236));
        txtContrasenaCRUD.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtContrasenaCRUD.setForeground(new java.awt.Color(69, 69, 69));
        txtContrasenaCRUD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaCRUDActionPerformed(evt);
            }
        });
        add(txtContrasenaCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 373, 44));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(69, 69, 69));
        jLabel4.setText("Contraseña");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        txtCorreoCRUD.setBackground(new java.awt.Color(210, 203, 236));
        txtCorreoCRUD.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtCorreoCRUD.setForeground(new java.awt.Color(69, 69, 69));
        add(txtCorreoCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 373, 48));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(69, 69, 69));
        jLabel5.setText("Correo");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        txtNombreCRUD.setBackground(new java.awt.Color(210, 203, 236));
        txtNombreCRUD.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtNombreCRUD.setForeground(new java.awt.Color(69, 69, 69));
        add(txtNombreCRUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 373, 48));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(69, 69, 69));
        jLabel3.setText("Nombre");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel2.setText("Registra un nuevo usuario");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        btnLimpiarUsuarios.setBackground(new java.awt.Color(46, 52, 64));
        btnLimpiarUsuarios.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnLimpiarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarUsuarios.setText("Limpiar");
        btnLimpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarUsuariosActionPerformed(evt);
            }
        });
        add(btnLimpiarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 630, 130, 40));

        btnEliminarUsuario.setBackground(new java.awt.Color(46, 52, 64));
        btnEliminarUsuario.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setText("Eliminar");
        add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 560, 130, 40));

        btnEditarUsuario1.setBackground(new java.awt.Color(46, 52, 64));
        btnEditarUsuario1.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnEditarUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarUsuario1.setText("Editar");
        add(btnEditarUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 490, 130, 40));

        btnAgregarUsuario.setBackground(new java.awt.Color(46, 52, 64));
        btnAgregarUsuario.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnAgregarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarUsuario.setText("Agregar");
        add(btnAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 420, 130, 40));

        btnVerClave.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnVerClave.setText("Ver");
        btnVerClave.setToolTipText("");
        btnVerClave.setBorder(null);
        btnVerClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerClaveActionPerformed(evt);
            }
        });
        add(btnVerClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        btnSalirUsuarios.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnSalirUsuarios.setText("Salir");
        add(btnSalirUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtContrasenaCRUDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaCRUDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaCRUDActionPerformed

    private void btnLimpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarUsuariosActionPerformed

    private void btnVerClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerClaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarUsuario;
    public javax.swing.JButton btnEditarUsuario1;
    public javax.swing.JButton btnEliminarUsuario;
    public javax.swing.JButton btnLimpiarUsuarios;
    public javax.swing.JLabel btnSalirUsuarios;
    public javax.swing.JButton btnVerClave;
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
