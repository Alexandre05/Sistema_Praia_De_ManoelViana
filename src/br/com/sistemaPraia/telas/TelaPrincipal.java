/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaPraia.telas;

import br.com.sistemaPraia.DAO.Conexao;
import br.com.sitemaPraia.Classes.Threads;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    
    Connection conexao = null;
   
    public TelaPrincipal() {
        initComponents();
        conexao = Conexao.Conector();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaP = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        usuario = new javax.swing.JLabel();
        atendente = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        BtVisitante = new javax.swing.JMenu();
        txtCamp = new javax.swing.JMenuItem();
        txtOrdemCamp = new javax.swing.JMenuItem();
        menuCad = new javax.swing.JMenuItem();
        RelaA = new javax.swing.JMenu();
        RelatorioAcamp = new javax.swing.JMenuItem();
        RelaCampista = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        regrasPDF = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        email = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Para Controlar os  Acampamentos Da  Praia de Manoel Viana");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModalExclusionType(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        telaP.setBackground(java.awt.SystemColor.controlLtHighlight);
        telaP.setForeground(new java.awt.Color(204, 204, 255));
        telaP.setToolTipText("");
        telaP.setEnabled(false);
        telaP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telaP.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));

        javax.swing.GroupLayout telaPLayout = new javax.swing.GroupLayout(telaP);
        telaP.setLayout(telaPLayout);
        telaPLayout.setHorizontalGroup(
            telaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        telaPLayout.setVerticalGroup(
            telaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(819, 450));

        usuario.setBackground(new java.awt.Color(0, 0, 0));
        usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuario.setText("Usuário");

        atendente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        atendente.setForeground(new java.awt.Color(204, 0, 51));
        atendente.setText("Atendente");

        lblData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblData.setText("Data ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(atendente)
                    .addComponent(usuario))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        Menu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Menu.setToolTipText("Tela Principal");
        Menu.setMaximumSize(new java.awt.Dimension(500, 32769));

        BtVisitante.setText("Cadastro");
        BtVisitante.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtCamp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        txtCamp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCamp.setText("Campista");
        txtCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampActionPerformed(evt);
            }
        });
        BtVisitante.add(txtCamp);
        txtCamp.getAccessibleContext().setAccessibleParent(Menu);

        txtOrdemCamp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        txtOrdemCamp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrdemCamp.setText("Solicitar Acampamento");
        txtOrdemCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrdemCampActionPerformed(evt);
            }
        });
        BtVisitante.add(txtOrdemCamp);

        menuCad.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuCad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuCad.setText("Usuários Sistema");
        menuCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadActionPerformed(evt);
            }
        });
        BtVisitante.add(menuCad);

        Menu.add(BtVisitante);

        RelaA.setText("Relatório");
        RelaA.setEnabled(false);
        RelaA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RelaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelaAActionPerformed(evt);
            }
        });

        RelatorioAcamp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        RelatorioAcamp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RelatorioAcamp.setText("Acampamentos");
        RelatorioAcamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAcampActionPerformed(evt);
            }
        });
        RelaA.add(RelatorioAcamp);

        RelaCampista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        RelaCampista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RelaCampista.setText("Campistas");
        RelaCampista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelaCampistaActionPerformed(evt);
            }
        });
        RelaA.add(RelaCampista);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Relatórios de Acampamentos Por Data");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        RelaA.add(jMenuItem1);

        jMenuItem2.setText("Relatório Por Perfil De Clientes Praia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        RelaA.add(jMenuItem2);

        Menu.add(RelaA);

        jMenu3.setText("Ajuda");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenuItem4.setText("Sobre");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        Menu.add(jMenu3);

        jMenu6.setText("Opções");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        regrasPDF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regrasPDF.setText("Regras");
        regrasPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regrasPDFActionPerformed(evt);
            }
        });
        jMenu6.add(regrasPDF);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem5.setText("Calculadora");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem6.setText("Sair");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        email.setText("Email");
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jMenu6.add(email);

        jMenuItem3.setText("Camera Controle");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        Menu.add(jMenu6);
        jMenu6.getAccessibleContext().setAccessibleParent(this);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaP, javax.swing.GroupLayout.PREFERRED_SIZE, 874, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(telaP, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtOrdemCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrdemCampActionPerformed
        // TODO add your handling code here:
        TelaAcampar  ac = new TelaAcampar();
        ac.setVisible(true);
        telaP.add(ac);
    }//GEN-LAST:event_txtOrdemCampActionPerformed

    private void txtCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampActionPerformed
        // TODO add your handling code here:
        TelaCampista campista = new TelaCampista();
        campista.setVisible(true);
        telaP.add(campista);
    }//GEN-LAST:event_txtCampActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // 
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
        
    }//GEN-LAST:event_formWindowActivated

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int sair = JOptionPane.showConfirmDialog(null,"Deseja mesmo Sair?","Atenção",JOptionPane.YES_OPTION);
        
        if(sair ==JOptionPane.YES_OPTION){
            System.exit(0);
        
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Sobre sobre = new Sobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadActionPerformed
        // TODO add your handling code here:
        TelaCadastroAtentendes usuario = new TelaCadastroAtentendes ();
        usuario.setVisible(true);
                telaP.add(usuario);
    }//GEN-LAST:event_menuCadActionPerformed

    private void RelaCampistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelaCampistaActionPerformed
        // TODO add your handling code here:
         int confirma = JOptionPane.showConfirmDialog(null, "Confirma Emissão Deste Realatório?","Atenção",JOptionPane.YES_NO_OPTION);
        if(confirma ==JOptionPane.YES_OPTION){
        
        // imprimir relatorio com frame
        
            try {
                
                JasperPrint imprimir= JasperFillManager.fillReport("Campistas.jasper",null,conexao);
                // linha exibe relatorio 
                
                JasperViewer.viewReport(imprimir,false);
                
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_RelaCampistaActionPerformed

    private void RelaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelaAActionPerformed
        // TODO add your handling code here:
        
        // relatorio de Campistas
       
            
        
        
        
    }//GEN-LAST:event_RelaAActionPerformed

    private void RelatorioAcampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAcampActionPerformed
       
        // painel mensagem de confirmação
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma Emissão Deste Realatório?","Atenção",JOptionPane.YES_NO_OPTION);
        if(confirma ==JOptionPane.YES_OPTION){
           
        // imprimir relatorio com frame
        
            
                String src = "Acampamentos.jasper";
        JasperPrint jasperPrint = null;

                
                JasperPrint imprimir;
                try {
                    imprimir = JasperFillManager.fillReport("Ordem.jasper",null,conexao);
                    JasperViewer.viewReport(imprimir,false);
                } catch (JRException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                
             //   // linha exibe relatorio 
              
                 
        }
    }
    }//GEN-LAST:event_RelatorioAcampActionPerformed

    private void regrasPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regrasPDFActionPerformed
        try {
            // TODO add your handling code here:

            gerarPDF();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_regrasPDFActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            // TODO add your handling code here:
            Runtime.getRuntime().exec("calc");
        } catch (IOException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        OpcaoRelatorios op = new OpcaoRelatorios();
        op.setVisible(true);
        telaP.add(op);
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         RelatorioPorPerfilCampista re = new RelatorioPorPerfilCampista();
        re.setVisible(true);
        telaP.add(re);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
       EmailMAndar em = new EmailMAndar();
        em.setVisible(true);
        telaP.add(em);        // TODO add your handling code here:
        
    }//GEN-LAST:event_emailActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        
        Reconhecimento em = new Reconhecimento();
        em.setVisible(true);
        telaP.add(em);   
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed
public void gerarPDF() throws FileNotFoundException, IOException{

Document document = new Document();
          try {
              
              PdfWriter.getInstance(document, new FileOutputStream("regras.pdf"));
              document.open();
              document.setPageSize(PageSize.A4);
              // adicionando um parágrafo no documento
              document.add(new Paragraph("Tudo Que Prescisa Saber Sobre o Camping"));
    }
          catch(DocumentException | IOException de) {
              System.err.println(de.getMessage());
          }
          document.close();
          Desktop.getDesktop().open( new File("regras.pdf"));
      }   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
     // fim principal
    
// classe final MinFrame

        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu BtVisitante;
    private javax.swing.JMenuBar Menu;
    public static javax.swing.JMenu RelaA;
    private javax.swing.JMenuItem RelaCampista;
    public static javax.swing.JMenuItem RelatorioAcamp;
    public static javax.swing.JLabel atendente;
    private javax.swing.JMenuItem email;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblData;
    public static javax.swing.JMenuItem menuCad;
    public javax.swing.JMenuItem regrasPDF;
    public static javax.swing.JDesktopPane telaP;
    public static javax.swing.JMenuItem txtCamp;
    public static javax.swing.JMenuItem txtOrdemCamp;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
