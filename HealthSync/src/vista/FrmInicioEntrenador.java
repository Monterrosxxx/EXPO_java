/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ctrlInicioEntrenador;

/**
 *
 * @author PC
 */
public class FrmInicioEntrenador extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicioEntrenador
     */
    public FrmInicioEntrenador() {
        initComponents();
    }
    
    public static void initEntrenador(){
        
        FrmInicioEntrenador vista = new FrmInicioEntrenador();
        ctrlInicioEntrenador controlador = new ctrlInicioEntrenador(vista);
        
        vista.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAggConsejos = new javax.swing.JButton();
        btnAggRutina = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jpContenedorEntrenador = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAggConsejos.setBackground(new java.awt.Color(255, 153, 255));
        btnAggConsejos.setForeground(new java.awt.Color(0, 0, 0));
        btnAggConsejos.setText("Consejos");
        btnAggConsejos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggConsejosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAggConsejos, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 165, 138, 41));

        btnAggRutina.setBackground(new java.awt.Color(255, 153, 255));
        btnAggRutina.setForeground(new java.awt.Color(0, 0, 0));
        btnAggRutina.setText("Rutinas");
        btnAggRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggRutinaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAggRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 281, 138, 41));

        btnCerrarSesion.setBackground(new java.awt.Color(255, 153, 255));
        btnCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 138, 41));

        jpContenedorEntrenador.setBackground(new java.awt.Color(255, 255, 255));
        jpContenedorEntrenador.setPreferredSize(new java.awt.Dimension(894, 0));
        jpContenedorEntrenador.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpContenedorEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpContenedorEntrenador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggConsejosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggConsejosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAggConsejosActionPerformed

    private void btnAggRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggRutinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAggRutinaActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInicioEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicioEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicioEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicioEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initEntrenador();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAggConsejos;
    public javax.swing.JButton btnAggRutina;
    public javax.swing.JButton btnCerrarSesion;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jpContenedorEntrenador;
    // End of variables declaration//GEN-END:variables
}
