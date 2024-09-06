
package vista;

import controlador.ctrlCRUDentrenador;

/**
 *
 * @author Estudiante
 */
public class panelEntrenador extends javax.swing.JPanel {

    /**
     * Creates new form panelEntrenador
     */
    public panelEntrenador() {
        initComponents();
        
        panelEntrenador panelEcrud = this;
        ctrlCRUDentrenador controlador = new ctrlCRUDentrenador(panelEcrud);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTBusuariosCRUD = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalirJPEntrenador = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombreEntrenador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreoEntrenador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroTelEntrenador = new javax.swing.JTextField();
        btnAgregarEntrenador = new javax.swing.JButton();
        btnEditarEntrenador = new javax.swing.JButton();
        btnLimpiarCRUDentrenador = new javax.swing.JButton();
        cbEdadEntrenador = new javax.swing.JSpinner();
        btnEliminarEntrenador = new javax.swing.JButton();

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

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bienvenido a HealthSync");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¡Hola administrador!");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Estas en el apartado agregar entrenador");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        btnSalirJPEntrenador.setBackground(new java.awt.Color(118, 99, 242));
        btnSalirJPEntrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnSalirJPEntrenador.setText("Salir");
        btnSalirJPEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirJPEntrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalirJPEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 179, 52));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        txtNombreEntrenador.setBackground(new java.awt.Color(221, 221, 221));
        txtNombreEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEntrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 426, 51));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Edad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Correo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        txtCorreoEntrenador.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.add(txtCorreoEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 426, 56));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Número");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, -1, -1));

        txtNumeroTelEntrenador.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.add(txtNumeroTelEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 426, 58));

        btnAgregarEntrenador.setBackground(new java.awt.Color(118, 99, 242));
        btnAgregarEntrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        btnAgregarEntrenador.setText("Agregar");
        btnAgregarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEntrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 179, 52));

        btnEditarEntrenador.setBackground(new java.awt.Color(118, 99, 242));
        btnEditarEntrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        btnEditarEntrenador.setText("Editar");
        jPanel1.add(btnEditarEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 179, 52));

        btnLimpiarCRUDentrenador.setBackground(new java.awt.Color(118, 99, 242));
        btnLimpiarCRUDentrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        btnLimpiarCRUDentrenador.setText("Limpiar");
        btnLimpiarCRUDentrenador.setActionCommand("");
        btnLimpiarCRUDentrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCRUDentrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarCRUDentrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 179, 52));

        cbEdadEntrenador.setModel(new javax.swing.SpinnerNumberModel(0, 0, 150, 1));
        jPanel1.add(cbEdadEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 426, 59));

        btnEliminarEntrenador.setBackground(new java.awt.Color(118, 99, 242));
        btnEliminarEntrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        btnEliminarEntrenador.setText("Eliminar");
        btnEliminarEntrenador.setActionCommand("");
        btnEliminarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEntrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 179, 52));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEntrenadorActionPerformed

    private void btnSalirJPEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirJPEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirJPEntrenadorActionPerformed

    private void btnLimpiarCRUDentrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCRUDentrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarCRUDentrenadorActionPerformed

    private void btnAgregarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEntrenadorActionPerformed

    private void btnEliminarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEntrenadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarEntrenador;
    public javax.swing.JButton btnEditarEntrenador;
    public javax.swing.JButton btnEliminarEntrenador;
    public javax.swing.JButton btnLimpiarCRUDentrenador;
    public javax.swing.JButton btnSalirJPEntrenador;
    public javax.swing.JSpinner cbEdadEntrenador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTBusuariosCRUD;
    public javax.swing.JTextField txtCorreoEntrenador;
    public javax.swing.JTextField txtNombreEntrenador;
    public javax.swing.JTextField txtNumeroTelEntrenador;
    // End of variables declaration//GEN-END:variables
}
