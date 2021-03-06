/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaPraia.telas;

import br.com.sitemaPraia.Classes.EnviarJava;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author PC
 */
public class EmailMAndar extends javax.swing.JInternalFrame {
String caminho= null;
    /**
     * Creates new form EmailMAndar
     */
    public EmailMAndar() {
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

        EnviEmail = new javax.swing.JButton();
        TxtVisuali = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Enviar Relátórios Por Email");

        EnviEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EnviEmail.setText("Email");
        EnviEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviEmailActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(TxtVisuali, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(EnviEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {EnviEmail, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(TxtVisuali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnviEmail)
                    .addComponent(jButton1))
                .addGap(74, 74, 74))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {EnviEmail, jButton1});

        setBounds(0, 0, 410, 312);
    }// </editor-fold>//GEN-END:initComponents

    private void EnviEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviEmailActionPerformed
        // TODO add your handling code here:
        
         JFileChooser ch = new JFileChooser();
        ch.setDialogTitle("Anexe Seu Arquivo");
        ch.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");

        ch.setFileFilter(filter);
        int retorno = ch.showOpenDialog(this);
 
        if (retorno == JFileChooser.APPROVE_OPTION) {

            int confirma = JOptionPane.showConfirmDialog(null, "Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {

                EnviarJava e = new EnviarJava();
              
                File f = ch.getSelectedFile();
                caminho= f.getAbsolutePath();
                TxtVisuali.setText(f.getPath());

             try {
                    e.envioAnexo("Alexandre Menna","Relatório", "Praia","alexandremenna@hotmail.com",caminho);
                    
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(OpcaoRelatorios.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            }

    }//GEN-LAST:event_EnviEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EnviEmail;
    private javax.swing.JLabel TxtVisuali;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
