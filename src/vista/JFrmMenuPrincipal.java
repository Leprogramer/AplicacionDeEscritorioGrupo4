/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.IngresosPlanificadosControlador;

/**
 *
 * @author Julius
 */
public class JFrmMenuPrincipal extends javax.swing.JFrame {

    JFrmIngresosPlanificados vistaIngresosPlanificados = new JFrmIngresosPlanificados();
    
    /**
     * Creates new form NewJFrmMenuPrincipal
     */
    public JFrmMenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jBtnGastosDiarios = new javax.swing.JButton();
        jBtnFinDeMes = new javax.swing.JButton();
        jBtnObjetivoFinanciero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Menu Principal ");

        jBtnGastosDiarios.setText("Registrar Ingresos y Egresos");
        jBtnGastosDiarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGastosDiariosActionPerformed(evt);
            }
        });

        jBtnFinDeMes.setText("Fin de Mes");
        jBtnFinDeMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFinDeMesActionPerformed(evt);
            }
        });

        jBtnObjetivoFinanciero.setText("Objetivo Financiero");
        jBtnObjetivoFinanciero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnObjetivoFinancieroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnGastosDiarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnFinDeMes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnObjetivoFinanciero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jBtnGastosDiarios)
                .addGap(18, 18, 18)
                .addComponent(jBtnObjetivoFinanciero)
                .addGap(18, 18, 18)
                .addComponent(jBtnFinDeMes)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGastosDiariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGastosDiariosActionPerformed
        // TODO add your handling code here:
        
        IngresosPlanificadosControlador controladorIngresosEgresos = new IngresosPlanificadosControlador(vistaIngresosPlanificados);
        vistaIngresosPlanificados.setVisible(true);
    }//GEN-LAST:event_jBtnGastosDiariosActionPerformed

    private void jBtnFinDeMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFinDeMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnFinDeMesActionPerformed

    private void jBtnObjetivoFinancieroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnObjetivoFinancieroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnObjetivoFinancieroActionPerformed

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
            java.util.logging.Logger.getLogger(JFrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnFinDeMes;
    public javax.swing.JButton jBtnGastosDiarios;
    public javax.swing.JButton jBtnObjetivoFinanciero;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
