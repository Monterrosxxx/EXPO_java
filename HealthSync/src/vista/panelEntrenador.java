
package vista;

import controlador.ctrlCRUDentrenador;
import modelo.Entrenador;
import modelo.cbEspecialidad;

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
        Entrenador modeloDos = new Entrenador();
        cbEspecialidad modeloUno = new cbEspecialidad();
        ctrlCRUDentrenador controlador = new ctrlCRUDentrenador(panelEcrud, modeloUno, modeloDos);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEdadEntrenador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCorreoEntrenador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumeroTelEntrenador = new javax.swing.JTextField();
        btnAgregarEntrenador = new javax.swing.JButton();
        btnEditarEntrenador = new javax.swing.JButton();
        btnLimpiarCRUDentrenador = new javax.swing.JButton();
        btnEliminarEntrenador = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbEspecialidad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtNombreEntrenador1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTBentrenadorCRUD = new javax.swing.JTable();

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
        jPanel1.setPreferredSize(new java.awt.Dimension(1267, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel3.setText("Agrega un nuevo entrenador");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(69, 69, 69));
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtEdadEntrenador.setBackground(new java.awt.Color(210, 203, 236));
        txtEdadEntrenador.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtEdadEntrenador.setForeground(new java.awt.Color(69, 69, 69));
        txtEdadEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadEntrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdadEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 330, 45));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(69, 69, 69));
        jLabel5.setText("Edad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(69, 69, 69));
        jLabel6.setText("Correo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txtCorreoEntrenador.setBackground(new java.awt.Color(210, 203, 236));
        txtCorreoEntrenador.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtCorreoEntrenador.setForeground(new java.awt.Color(69, 69, 69));
        jPanel1.add(txtCorreoEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 330, 45));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(69, 69, 69));
        jLabel7.setText("Número");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        txtNumeroTelEntrenador.setBackground(new java.awt.Color(210, 203, 236));
        txtNumeroTelEntrenador.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtNumeroTelEntrenador.setForeground(new java.awt.Color(69, 69, 69));
        jPanel1.add(txtNumeroTelEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 330, 45));

        btnAgregarEntrenador.setBackground(new java.awt.Color(46, 52, 64));
        btnAgregarEntrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnAgregarEntrenador.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEntrenador.setText("Agregar");
        btnAgregarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEntrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 130, 50));

        btnEditarEntrenador.setBackground(new java.awt.Color(46, 52, 64));
        btnEditarEntrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnEditarEntrenador.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarEntrenador.setText("Editar");
        jPanel1.add(btnEditarEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 130, 50));

        btnLimpiarCRUDentrenador.setBackground(new java.awt.Color(46, 52, 64));
        btnLimpiarCRUDentrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnLimpiarCRUDentrenador.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarCRUDentrenador.setText("Limpiar");
        btnLimpiarCRUDentrenador.setActionCommand("");
        btnLimpiarCRUDentrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCRUDentrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarCRUDentrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 620, 130, 50));

        btnEliminarEntrenador.setBackground(new java.awt.Color(46, 52, 64));
        btnEliminarEntrenador.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        btnEliminarEntrenador.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEntrenador.setText("Eliminar");
        btnEliminarEntrenador.setActionCommand("");
        btnEliminarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEntrenadorActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 130, 50));

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(69, 69, 69));
        jLabel8.setText("Especialidad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, 20));

        cbEspecialidad.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        cbEspecialidad.setForeground(new java.awt.Color(69, 69, 69));
        cbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecialidadActionPerformed(evt);
            }
        });
        jPanel1.add(cbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 330, 45));

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(69, 69, 69));
        jLabel9.setText("Contraseña");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        txtClave.setBackground(new java.awt.Color(210, 203, 236));
        txtClave.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtClave.setForeground(new java.awt.Color(69, 69, 69));
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 330, 45));

        txtNombreEntrenador1.setBackground(new java.awt.Color(210, 203, 236));
        txtNombreEntrenador1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        txtNombreEntrenador1.setForeground(new java.awt.Color(69, 69, 69));
        txtNombreEntrenador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEntrenador1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreEntrenador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 330, 45));

        jTBentrenadorCRUD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTBentrenadorCRUD);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 740, 260));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEdadEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadEntrenadorActionPerformed

    private void btnLimpiarCRUDentrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCRUDentrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarCRUDentrenadorActionPerformed

    private void btnAgregarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEntrenadorActionPerformed

    private void btnEliminarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarEntrenadorActionPerformed

    private void cbEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEspecialidadActionPerformed

    private void txtNombreEntrenador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEntrenador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEntrenador1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarEntrenador;
    public javax.swing.JButton btnEditarEntrenador;
    public javax.swing.JButton btnEliminarEntrenador;
    public javax.swing.JButton btnLimpiarCRUDentrenador;
    public javax.swing.JComboBox<String> cbEspecialidad;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTBentrenadorCRUD;
    public javax.swing.JTable jTBusuariosCRUD;
    public javax.swing.JTextField txtClave;
    public javax.swing.JTextField txtCorreoEntrenador;
    public javax.swing.JTextField txtEdadEntrenador;
    public javax.swing.JTextField txtNombreEntrenador1;
    public javax.swing.JTextField txtNumeroTelEntrenador;
    // End of variables declaration//GEN-END:variables
}
