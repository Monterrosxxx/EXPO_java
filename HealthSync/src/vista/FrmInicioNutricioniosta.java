/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ctrlInicioNutricionista;
import modelo.Dieta;
import modelo.cbClientes;

/**
 *
 * @author PC
 */
public class FrmInicioNutricioniosta extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicioNutricioniosta
     */
    public FrmInicioNutricioniosta() {
        initComponents();
    }
    
    public static void initNutricionista(){
        
        cbClientes modeloCliente = new cbClientes();
        Dieta modeloDieta = new Dieta();
        FrmInicioNutricioniosta vista = new FrmInicioNutricioniosta();
        ctrlInicioNutricionista controlador = new ctrlInicioNutricionista(vista, modeloCliente, modeloDieta);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlmuerzo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesayuno = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCena = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRefrigerios = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cbIdCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnVerClientes = new javax.swing.JButton();
        btnAgregarDieta = new javax.swing.JButton();
        btnActualizarDieta = new javax.swing.JButton();
        btnEliminarDieta = new javax.swing.JButton();
        btnLimpiarDieta = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTBdietaCRUD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("IMPORTANTE: primero revisar a que cliente se le asignara la dieta aqui:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 481, -1, -1));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bienvenido a HEALTHSYNC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 17, -1, -1));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Desayuno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 114, -1, -1));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Almuerzo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 114, -1, -1));

        txtAlmuerzo.setColumns(20);
        txtAlmuerzo.setRows(5);
        jScrollPane1.setViewportView(txtAlmuerzo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 151, 397, 210));

        txtDesayuno.setColumns(20);
        txtDesayuno.setRows(5);
        jScrollPane2.setViewportView(txtDesayuno);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 155, 397, 210));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cena");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 114, -1, -1));

        txtCena.setColumns(20);
        txtCena.setRows(5);
        jScrollPane3.setViewportView(txtCena);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 151, 397, 210));

        txtRefrigerios.setColumns(20);
        txtRefrigerios.setRows(5);
        jScrollPane4.setViewportView(txtRefrigerios);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 410, 397, 210));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Refrigerios");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 370, -1, -1));

        cbIdCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 301, 52));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cliente al que se le asignara la dieta");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 379, -1, -1));

        jLabel9.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Agrega una dieta");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        btnVerClientes.setBackground(new java.awt.Color(118, 99, 242));
        btnVerClientes.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnVerClientes.setText("Clientes");
        jPanel1.add(btnVerClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 181, 54));

        btnAgregarDieta.setBackground(new java.awt.Color(118, 99, 242));
        btnAgregarDieta.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnAgregarDieta.setText("Agregar");
        jPanel1.add(btnAgregarDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 120, 181, 54));

        btnActualizarDieta.setBackground(new java.awt.Color(118, 99, 242));
        btnActualizarDieta.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnActualizarDieta.setText("Editar");
        jPanel1.add(btnActualizarDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 190, 182, 54));

        btnEliminarDieta.setBackground(new java.awt.Color(118, 99, 242));
        btnEliminarDieta.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnEliminarDieta.setText("Eliminar");
        jPanel1.add(btnEliminarDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 270, 182, 54));

        btnLimpiarDieta.setBackground(new java.awt.Color(118, 99, 242));
        btnLimpiarDieta.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        btnLimpiarDieta.setText("Limpiar");
        btnLimpiarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDietaActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 340, 182, 54));

        jTBdietaCRUD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTBdietaCRUD);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 1420, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1449, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDietaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarDietaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInicioNutricioniosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicioNutricioniosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicioNutricioniosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicioNutricioniosta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initNutricionista();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarDieta;
    public javax.swing.JButton btnAgregarDieta;
    public javax.swing.JButton btnEliminarDieta;
    public javax.swing.JButton btnLimpiarDieta;
    public javax.swing.JButton btnVerClientes;
    public javax.swing.JComboBox<String> cbIdCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTable jTBdietaCRUD;
    public javax.swing.JTextArea txtAlmuerzo;
    public javax.swing.JTextArea txtCena;
    public javax.swing.JTextArea txtDesayuno;
    public javax.swing.JTextArea txtRefrigerios;
    // End of variables declaration//GEN-END:variables
}
