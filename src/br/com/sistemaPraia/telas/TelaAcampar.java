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
        AreaAcamp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        DiasAcampado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        VAcampamento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ValorDia = new javax.swing.JTextField();
        Calcular = new javax.swing.JButton();
        DSemana = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnExtra = new javax.swing.JButton();
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

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela Acampar");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel1.setToolTipText("Informações do Acampamento");
        jPanel1.setName("Informações Acampamento"); // NOI18N

        jLabel1.setText("Nº Acampamento");

        Nuacamp.setEnabled(false);

        jLabel2.setText("Data");

        DataAcamp.setEnabled(false);

        jLabel3.setText("Situação Acamp");

        Situ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uso", "Reservador", "Manutenção" }));
        Situ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SituActionPerformed(evt);
            }
        });

        jLabel6.setText("*Tamanho Área");

        jLabel7.setText("Dias Acampados");

        jLabel8.setText("Valor Acampamentol");

        VAcampamento.setText("0");
        VAcampamento.setEnabled(false);

        jLabel9.setText("Valor Dia");

        ValorDia.setText("0");
        ValorDia.setEnabled(false);
        ValorDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ValorDiaKeyPressed(evt);
            }
        });

        Calcular.setForeground(new java.awt.Color(51, 51, 51));
        Calcular.setText("Calcular");
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        DSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" }));
        DSemana.setToolTipText("tt");
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

        jLabel11.setText("D.Semana");

        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExtra.setText("Extra");
        btnExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(ValorDia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(29, 29, 29)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AreaAcamp, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(DiasAcampado))
                            .addComponent(Situ, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DSemana, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(VAcampamento, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(Nuacamp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addComponent(DataAcamp, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(Calcular)
                .addGap(18, 18, 18)
                .addComponent(btnExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Calcular, btnExtra, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nuacamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataAcamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Situ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(AreaAcamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(DiasAcampado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ValorDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(DSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(VAcampamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calcular)
                    .addComponent(jButton1)
                    .addComponent(btnExtra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Calcular, btnExtra, jButton1});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Campista", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        PesquisaCamp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PesquisaCampKeyReleased(evt);
            }
        });

        jLabel4.setText("Pesquisar ");

        TblAcamp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Fone", "ID", "OB"
            }
        ));
        TblAcamp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblAcampMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblAcamp);

        jLabel5.setText("*ID");

        IdCamp.setEnabled(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Observações");

        OB.setColumns(20);
        OB.setRows(5);
        jScrollPane2.setViewportView(OB);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel10)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PesquisaCamp, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(IdCamp, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisaCamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(IdCamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BotaoSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaoSalvar.setForeground(new java.awt.Color(51, 51, 51));
        BotaoSalvar.setText("Salvar");
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotaPesquisar)
                .addGap(18, 18, 18)
                .addComponent(BotaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotaExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaImprime, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotaEditar, BotaExcluir, BotaImprime, BotaPesquisar, BotaoSalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvar)
                    .addComponent(BotaPesquisar)
                    .addComponent(BotaEditar)
                    .addComponent(BotaExcluir)
                    .addComponent(BotaImprime))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotaEditar, BotaExcluir, BotaImprime, BotaPesquisar, BotaoSalvar});

        jPanel2.getAccessibleContext().setAccessibleName("Pesquisa Campista");

        setBounds(0, 0, 716, 448);
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
        String sql = "insert into tbacampar(Situacao,AreaAcamp,Atendente,valor,DiasAcamp,ObsAcamp,Idcamp) values(?,?,?,?,?,?,?)";

        try {

            pst = conexao.prepareCall(sql);
            pst.setString(1, Situ.getSelectedItem().toString());
            pst.setString(2, AreaAcamp.getText());
            pst.setString(3, TelaPrincipal.atendente.getText());
            pst.setDouble(4, Double.parseDouble(VAcampamento.getText().replace(",", ".")));
            pst.setString(5, DiasAcampado.getText());
            pst.setString(6, OB.getText());

            pst.setString(7, IdCamp.getText());
  
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
                DiasAcampado.setText(rs.getString(7));
                VAcampamento.setText(rs.getString(6));

                OB.setText(rs.getString(8));

                IdCamp.setText(rs.getString(9));
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

        String sql = "update tbacampar set Situacao=?,AreaAcamp=?,valor=?,DiasAcamp=?,ObsAcamp=? where OrA=?";

        try {

            pst = conexao.prepareCall(sql);
            pst.setString(1, Situ.getSelectedItem().toString());
            pst.setString(2, AreaAcamp.getText());
            pst.setDouble(3, Double.parseDouble(VAcampamento.getText().replace(",", ".")));
            pst.setString(4, DiasAcampado.getText());

            pst.setString(5, OB.getText());
            pst.setString(6, Nuacamp.getText());

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
        String src = "Acampamentos.jasper";
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
    private javax.swing.JTextField AreaAcamp;
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
    // End of variables declaration//GEN-END:variables
}
