/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaPraia.telas;

/**
 *
 * @author PC
 */
import java.sql.*;
import br.com.sistemaPraia.DAO.Conexao;
import java.awt.HeadlessException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class TelaAcampar extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaAcampar
     *
     *
     *
     *
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
 int Total;
    public TelaAcampar() {

        conexao = Conexao.Conector();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Nuacamp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DataAcamp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Situ = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DiasAcampado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        VAcampamento = new javax.swing.JTextField();
        ValorDia = new javax.swing.JTextField();
        Calcular = new javax.swing.JButton();
        DSemana = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnExtra = new javax.swing.JButton();
        se = new javax.swing.JLabel();
        NomeArea = new javax.swing.JComboBox<>();
        AreaAcamp = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        PesquisaCamp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblAcamp = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        IdCamp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OB = new javax.swing.JTextArea();
        BotaoSalvar = new javax.swing.JButton();
        BotaPesquisar = new javax.swing.JButton();
        BotaEditar = new javax.swing.JButton();
        BotaExcluir = new javax.swing.JButton();
        BotaImprime = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela Acampar");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("Informações do Acampamento");
        jPanel1.setName("Informações Acampamento"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Nº Acampamento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Nuacamp.setEnabled(false);
        jPanel1.add(Nuacamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 57, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Data");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 42, -1));

        DataAcamp.setEnabled(false);
        jPanel1.add(DataAcamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 60, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Situação Acamp");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 98, -1, -1));

        Situ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Situ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uso", "Reservador", "Manutenção" }));
        Situ.setToolTipText("Situação do Acampamento");
        Situ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SituActionPerformed(evt);
            }
        });
        jPanel1.add(Situ, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 95, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Tamanho Área");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 129, 111, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Dias Acampados");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 204, -1, -1));

        DiasAcampado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DiasAcampado.setToolTipText("Total de dias acampados");
        DiasAcampado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasAcampadoActionPerformed(evt);
            }
        });
        jPanel1.add(DiasAcampado, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 201, 108, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Valor Dia");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 243, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Valor Total");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 20, 84, -1));

        VAcampamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        VAcampamento.setText("0");
        VAcampamento.setEnabled(false);
        VAcampamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VAcampamentoActionPerformed(evt);
            }
        });
        jPanel1.add(VAcampamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 77, -1));

        ValorDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ValorDia.setText("0");
        ValorDia.setToolTipText("Valor Extra do valor inicial do acampamento");
        ValorDia.setEnabled(false);
        ValorDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValorDiaKeyPressed(evt);
            }
        });
        jPanel1.add(ValorDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 240, 68, -1));

        Calcular.setForeground(new java.awt.Color(51, 51, 51));
        Calcular.setText("Calcular");
        Calcular.setToolTipText("Calcula o Acampamento");
        Calcular.setName("C"); // NOI18N
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });
        jPanel1.add(Calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 361, 90, -1));
        Calcular.getAccessibleContext().setAccessibleName("");

        DSemana.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" }));
        DSemana.setToolTipText("Dia da Semana, a ser calculado extra");
        DSemana.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                DSemanaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        DSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSemanaActionPerformed(evt);
            }
        });
        jPanel1.add(DSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 289, 106, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("D.Semana");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 295, 74, -1));

        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 361, 82, -1));

        btnExtra.setText("Extra");
        btnExtra.setToolTipText("Calcular o Valor Extra. EX 30 reais do acampamento, mais 1 do dia. Total 31 reias");
        btnExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraActionPerformed(evt);
            }
        });
        jPanel1.add(btnExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 361, 78, -1));

        se.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        se.setText("Nome Área");
        jPanel1.add(se, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 163, -1, -1));

        NomeArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomeArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Área 1", "Área 2", "Área 3" }));
        NomeArea.setToolTipText("Nome da àrea dos Acampamentos ");
        NomeArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeAreaActionPerformed(evt);
            }
        });
        jPanel1.add(NomeArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 160, 108, -1));

        AreaAcamp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        AreaAcamp.setToolTipText("Tamanho da Área do Acampamento, pode ser de 20² até 36² metros");
        AreaAcamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaAcampActionPerformed(evt);
            }
        });
        jPanel1.add(AreaAcamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 129, 105, -1));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PesquisaCamp.setToolTipText("Pesquisa Campista");
        PesquisaCamp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PesquisaCampKeyReleased(evt);
            }
        });
        jPanel2.add(PesquisaCamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 34, 220, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Pesquisar ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 37, -1, -1));

        TblAcamp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TblAcamp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Fone", "ID", "OB"
            }
        ));
        TblAcamp.setToolTipText("Informações do campista");
        TblAcamp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblAcampMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblAcamp);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 810, 161));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("*ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        IdCamp.setEnabled(false);
        jPanel2.add(IdCamp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 54, -1));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel10.setText("Observações");

        OB.setColumns(20);
        OB.setRows(5);
        OB.setToolTipText("Observações do acampamento");
        jScrollPane2.setViewportView(OB);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 820, -1));

        BotaoSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaoSalvar.setForeground(new java.awt.Color(51, 51, 51));
        BotaoSalvar.setText("Salvar");
        BotaoSalvar.setToolTipText("Salva a ordem de acampameto");
        BotaoSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoSalvarMouseClicked(evt);
            }
        });
        BotaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvarActionPerformed(evt);
            }
        });

        BotaPesquisar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaPesquisar.setText("Pesquisar");
        BotaPesquisar.setToolTipText("Pesquisa uma ordem de acampamento");
        BotaPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaPesquisarActionPerformed(evt);
            }
        });

        BotaEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaEditar.setText("Editar");
        BotaEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaEditarActionPerformed(evt);
            }
        });

        BotaExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaExcluir.setText("Excluir");
        BotaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaExcluirActionPerformed(evt);
            }
        });

        BotaImprime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaImprime.setText("Recibo");
        BotaImprime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaImprimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(65, 65, 65)
                        .addComponent(BotaPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(BotaEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BotaExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(BotaImprime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotaImprime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        setBounds(0, 0, 1265, 533);
    }// </editor-fold>//GEN-END:initComponents

    private void SituActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SituActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SituActionPerformed

    private void PesquisaCampKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisaCampKeyReleased
        // TODO add your handling code here:
        PesquisarCampistas();
    }//GEN-LAST:event_PesquisaCampKeyReleased

    private void TblAcampMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblAcampMouseClicked
        // TODO add your handling code here:

        setar_campos();
    }//GEN-LAST:event_TblAcampMouseClicked

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed

        // TODO add your handling code here:
        EmitirAcampamento();


    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        // TODO add your handling code here:
        CalcularAC();
        
        //Calcular.setToolTipText("Calcular o Valor do Acampamento");
    }//GEN-LAST:event_CalcularActionPerformed

    private void BotaPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaPesquisarActionPerformed
        // TODO add your handling code here:

        pesquisar_AC();
        btnExtra.setEnabled(false);
        
    }//GEN-LAST:event_BotaPesquisarActionPerformed

    private void BotaEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaEditarActionPerformed
        // TODO add your handling code here:
        AlterarOA();
    }//GEN-LAST:event_BotaEditarActionPerformed

    private void BotaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaExcluirActionPerformed
        // TODO add your handling code here:
        ExcluirOA();
        
          
            
            
            
        

    }//GEN-LAST:event_BotaExcluirActionPerformed

    private void BotaImprimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaImprimeActionPerformed
        // TODO add your handling code here:
        ImprimirORA();
    }//GEN-LAST:event_BotaImprimeActionPerformed

    private void DSemanaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_DSemanaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (DSemana.getSelectedItem().equals("Segunda")) {
            ValorDia.setEnabled(true);
            
        } else if (DSemana.getSelectedItem().equals("Terça")) {
//Set False
            ValorDia.setEnabled(true);

        } else if (DSemana.getSelectedItem().equals("Quarta")) {
            ValorDia.setEnabled(true);

        } else if (DSemana.getSelectedItem().equals("Quinta")) {
           ValorDia.setEnabled(true);

        } else if (DSemana.getSelectedItem().equals("Sexta")) {
            ValorDia.setEnabled(true);

        } else if (DSemana.getSelectedItem().equals("Sábado")) {
           ValorDia.setEnabled(true);

        } else if (DSemana.getSelectedItem().equals("Domingo")) {
           ValorDia.setEnabled(true);

        } else if (DSemana.getSelectedItem().equals("Não")) {
           ValorDia.setEnabled(false);

    }//GEN-LAST:event_DSemanaPopupMenuWillBecomeInvisible
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LImparC();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSemanaActionPerformed
        // TODO add your handling code here:
        if (DSemana.getSelectedItem().equals("Segunda")) {
           Calcular.setEnabled(false);
            btnExtra.setEnabled(true);
        } else if (DSemana.getSelectedItem().equals("Terça")) {
//Set False 
btnExtra.setEnabled(true);
            Calcular.setEnabled(false);
btnExtra.setEnabled(true);
        } else if (DSemana.getSelectedItem().equals("Quarta")) {
            btnExtra.setEnabled(true);
             Calcular.setEnabled(true);
btnExtra.setEnabled(false);
        } else if (DSemana.getSelectedItem().equals("Quinta")) {
            btnExtra.setEnabled(true);
            
            Calcular.setEnabled(false);
btnExtra.setEnabled(true);
        } else if (DSemana.getSelectedItem().equals("Sexta")) {
            btnExtra.setEnabled(true);
             Calcular.setEnabled(false);
btnExtra.setEnabled(true);
        } else if (DSemana.getSelectedItem().equals("Sábado")) {
            Calcular.setEnabled(false);
            btnExtra.setEnabled(true);
        } else if (DSemana.getSelectedItem().equals("Domingo")) {
            btnExtra.setEnabled(true);
           Calcular.setEnabled(false);
btnExtra.setEnabled(true);
        } else if (DSemana.getSelectedItem().equals("Não")) {
           Calcular.setEnabled(true);
btnExtra.setEnabled(false);
        }
        
    
    
        
        
    }//GEN-LAST:event_DSemanaActionPerformed

    private void BotaoSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_BotaoSalvarMouseClicked

    private void btnExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraActionPerformed
        // TODO add your handling code here:
        
        extra();
    }//GEN-LAST:event_btnExtraActionPerformed

    private void ValorDiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorDiaKeyPressed

    }//GEN-LAST:event_ValorDiaKeyPressed

    private void VAcampamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VAcampamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VAcampamentoActionPerformed

    private void DiasAcampadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasAcampadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasAcampadoActionPerformed

    private void NomeAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeAreaActionPerformed

    private void AreaAcampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaAcampActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AreaAcampActionPerformed

    private void PesquisarCampistas() {
        String sql = " select idCamp as ID, NomeCamp as Nome, CpfCamp as CPF, TelefoneCamp as Fone,\n"
                + "observacoes as OB from tbcampista where NomeCamp like ?";
        try {
            pst = conexao.prepareStatement(sql);
            // Passando da caixa de pesquisa
            pst.setString(1, PesquisaCamp.getText() + "%");
            // executa a query
            rs = pst.executeQuery();
            // usa a biblioteca para preencher a tabela
            TblAcamp.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, e);
        }
    }

    public void setar_campos() {

        int setar = TblAcamp.getSelectedRow();
        IdCamp.setText(TblAcamp.getModel().getValueAt(setar, 0).toString());

        //BotaoSalvar.setEnabled(false);
    }

// cadastrar acampamento, emitir Ordem pra acampar
    private void EmitirAcampamento() {
        String sql = "insert into tbacampar(Situacao,AreaAcamp,NomeArea, Atendente,valor,DiasAcamp,ObsAcamp,Idcamp) values(?,?,?,?,?,?,?,?)";

        try {

            pst = conexao.prepareCall(sql);
            pst.setString(1, Situ.getSelectedItem().toString());
            pst.setString(2, AreaAcamp.getText());
            pst.setString(3, NomeArea.getSelectedItem().toString());
            pst.setString(4, TelaPrincipal.atendente.getText());
            pst.setDouble(5, Double.parseDouble(VAcampamento.getText().replace(",", ".")));
            pst.setString(6, DiasAcampado.getText());
            pst.setString(7, OB.getText());

            pst.setString(8, IdCamp.getText());
  
            if (((IdCamp.getText().isEmpty() || (AreaAcamp.getText().isEmpty())))) {
               
              JOptionPane.showMessageDialog(null, " Todos os Campos Marcados com *, são Obrigatórios");

            } else {
                         
                
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    
                    //Object[] opcoes = {"OK", "Recibo","Cancelar"}; 
//JOptionPane.showOptionDialog( null , "Ordem de Acampamento Adicionado com Sucesso" , "Confirmação", 
//JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.PLAIN_MESSAGE ,null , 
//opcoes , "Recibo");
                     
    try {
       sql = "SELECT max(OrA) as maxOrA FROM tbacampar";
       PreparedStatement stmt = conexao.prepareStatement(sql);
              
        ResultSet rs;
        rs = stmt.executeQuery();
        if (rs.next()) 
        {
                           
           int OrA = rs.getInt("maxOrA");
           stmt.close();
            Nuacamp.setText(String.valueOf(OrA));
             JOptionPane.showMessageDialog(this, " Ordem de Acampamento Número"+
                     "\n" +OrA+ "\n "+ "Adicionado Com Sucesso");
        } 

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro no acesso" + ex);  
    }
 
              
                

                    Nuacamp.setText(null);
                    Situ.setSelectedItem(null);
                    AreaAcamp.setText(null);
                    NomeArea.setSelectedItem(null);
               ValorDia.setText(null);
                    DiasAcampado.setText(null);
                    //TelaPrincipal.atendente.setText(null);
                    VAcampamento.setText(null);
                    OB.setText(null);
                    IdCamp.setText(null);

                }
            }

        } catch ( SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // pesuisa Um acampamento
    private void pesquisar_AC() {

        String NumAc = JOptionPane.showInputDialog("Número Da Ordem do Acampamento");

        String sql = "select * from tbacampar where OrA= " + NumAc;

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                Nuacamp.setText(rs.getString(1));
                DataAcamp.setText(rs.getString(2));
                Situ.setSelectedItem(rs.getString(3));
                AreaAcamp.setText(rs.getString(4));
                NomeArea.setSelectedItem(5);
                
                 VAcampamento.setText(rs.getString(7));
                DiasAcampado.setText(rs.getString(8));
               

                OB.setText(rs.getString(9));

                IdCamp.setText(rs.getString(10));
                /// evitando problemas
                BotaoSalvar.setEnabled(false);
                PesquisaCamp.setEditable(false);
                TblAcamp.setVisible(false);

            } else {

                JOptionPane.showMessageDialog(null, "Acampamento não Cadastrado");
            }

        } catch (java.sql.SQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "Entrada Invalida");
            System.out.println(e);
        } catch (HeadlessException | SQLException e2) {

            JOptionPane.showMessageDialog(null, e2);

        }

    }

    private void AlterarOA() {

        String sql = "update tbacampar set Situacao=?,AreaAcamp=?,NomeArea=?,valor=?,DiasAcamp=?,ObsAcamp=? where OrA=?";

        try {

            pst = conexao.prepareCall(sql);
            pst.setString(1, Situ.getSelectedItem().toString());
            pst.setString(2, AreaAcamp.getText());
            pst.setString(3, NomeArea.getSelectedItem().toString());
            pst.setDouble(4, Double.parseDouble(VAcampamento.getText().replace(",", ".")));
            pst.setString(5, DiasAcampado.getText());

            pst.setString(6, OB.getText());
            pst.setString(7, Nuacamp.getText());

            if (((IdCamp.getText().isEmpty() || (AreaAcamp.getText().isEmpty())))) {
                JOptionPane.showMessageDialog(null, " Todos os Campos Marcados com *, são Obrigatórios");

            } else {

                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(this, " Ordem de Acampamento Alterada com Sucesso!!");
                    Nuacamp.setText("");
                    DataAcamp.setText("");
                    Situ.setSelectedItem("");
                    AreaAcamp.setText("");
                    NomeArea.setSelectedItem("");
                   ValorDia.setText("");
                    DiasAcampado.setText("");
                    //TelaPrincipal.atendente.setText(null);
                    VAcampamento.setText("");
                    OB.setText("");
                    IdCamp.setText("");
                      DSemana.setSelectedItem("");
                    BotaoSalvar.setEnabled(true);
                    PesquisaCamp.setEditable(true);
                    TblAcamp.setVisible(true);
                }
            }

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void ExcluirOA() {

        int confirma = JOptionPane.showConfirmDialog(null, "Quer mesmo Excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_NO_OPTION) {
            String sql = "delete from tbacampar  where OrA=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, Nuacamp.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {

                    JOptionPane.showMessageDialog(null, "Excluido Com Sucesso");
                    Nuacamp.setText(null);
                    DataAcamp.setText(null);
                    Situ.setSelectedItem(null);
                    AreaAcamp.setText(null);
                    NomeArea.setSelectedItem(null);
               ValorDia.setText(null);
                    DiasAcampado.setText(null);
                    //TelaPrincipal.atendente.setText(null);
                    VAcampamento.setText(null);
                    OB.setText(null);
                    IdCamp.setText(null);

                    BotaoSalvar.setEnabled(true);
                    PesquisaCamp.setEditable(true);
                    TblAcamp.setVisible(true);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e);
            }

        }

    }

    // Metodo Calcular Valor a Pagar Automaticamente
    private void CalcularAC() {
        String dias = DiasAcampado.getText().trim();
        String areA = AreaAcamp.getText().trim();
  
        if (dias == null || "".equals(dias) || areA == null || "".equals(areA)) {
            JOptionPane.showMessageDialog(null, "Todos os Campos Marcados com *, São Obrigatórios");

        } else {       

          
    int diasAcampado = Integer.parseInt(DiasAcampado.getText().trim());
    
    
          // int VD= Integer.parseInt(ValorDia.getText().trim());
            int Area = Integer.parseInt(AreaAcamp.getText().trim());
  //int D= Integer.parseInt(DSemana.getSelectedItem().toString());
            try {
                if (Area <= 20) {

                    VAcampamento.setText(String.valueOf(Total = 30 * diasAcampado ));
                    

                    JOptionPane.showMessageDialog(null, "O total é "+ Total);
                            
                } else if (Area >= 20 && Area <= 36) {
                    VAcampamento.setText(String.valueOf(Total = 40 * diasAcampado));

                    JOptionPane.showMessageDialog(null,"O valor Total é R$"+ Total);
                    
              
                            
                            
                            
                } else {

                    JOptionPane.showMessageDialog(null, "Fale Com o Respónsavel ");
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);

            }

        }
    }

    private void LImparC() {
        int confirma = JOptionPane.showConfirmDialog(null, "Quer Limpar os Campos ??");
        if (confirma == JOptionPane.YES_OPTION) {
            DiasAcampado.setText(null);
            VAcampamento.setText(null);
            ValorDia.setText("0");
            Situ.setSelectedItem(null);
            AreaAcamp.setText(null);
            Nuacamp.setText(null);
            DataAcamp.setText(null);
            IdCamp.setText(null);
            DSemana.setSelectedItem("Não");
            btnExtra.setEnabled(false);

        }
    }

    private void ImprimirORA() {
        String src = "src\\Relatorios\\Acampamentos.jasper";
        JasperPrint jasperPrint = null;

        int confirma = JOptionPane.showConfirmDialog(null, "Confirma Emissão Desta Ordem de Acampamento?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {

            // imprimir relatorio com frame
            try {
                // filtro 
                HashMap filtro = new HashMap();

                filtro.put("OrA", Integer.parseInt(Nuacamp.getText()));
                jasperPrint = JasperFillManager.fillReport(src, filtro, conexao);
                // linha exibe relatorio 

                JasperViewer jasp = new JasperViewer(jasperPrint, false);
                jasp.setVisible(true);

            } catch (NumberFormatException | JRException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }
private void extra(){


 
 
   //VTotal.setText(String.valueOf(VD ));
double total = Double.valueOf(VAcampamento.getText().trim());
double VD=  Integer.parseInt(ValorDia.getText().trim());
 
total +=VD;
Total=(int) total;
//VAcampamento.setText(" "+Total);
VAcampamento.setText(String.valueOf(""+Total));
 JOptionPane.showMessageDialog(this,"Valor Total é De R$ "+total);





}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField AreaAcamp;
    private javax.swing.JButton BotaEditar;
    public static javax.swing.JButton BotaExcluir;
    private javax.swing.JButton BotaImprime;
    private javax.swing.JButton BotaPesquisar;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JButton Calcular;
    private javax.swing.JComboBox<String> DSemana;
    private javax.swing.JTextField DataAcamp;
    private javax.swing.JTextField DiasAcampado;
    private javax.swing.JTextField IdCamp;
    private javax.swing.JComboBox<String> NomeArea;
    private javax.swing.JTextField Nuacamp;
    private javax.swing.JTextArea OB;
    private javax.swing.JTextField PesquisaCamp;
    private javax.swing.JComboBox<String> Situ;
    private javax.swing.JTable TblAcamp;
    private javax.swing.JTextField VAcampamento;
    private javax.swing.JTextField ValorDia;
    private javax.swing.JButton btnExtra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel se;
    // End of variables declaration//GEN-END:variables
}
