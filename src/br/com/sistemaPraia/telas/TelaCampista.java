/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaPraia.telas;

import br.com.sitemaPraia.Classes.ValidaCPF;
import br.com.sistemaPraia.DAO.Conexao;




import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PC
 */
public class TelaCampista extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCampista
     */
    public TelaCampista() {

        conexao = Conexao.Conector();
        initComponents();

        //LTipo.setVisible(false);
    }

    
    
    

    
    
    private void Adicionar() {
    try {
        String nome = txtNomeCamp.getText();
        String cpf = txtCpfCamp.getText();
        
        if (nome == null || "".equals(nome)
          || cpf == null || "".equals(cpf)) {
            JOptionPane.showMessageDialog(null, "Todos os Campos Marcados com *, são Obrigatórios");
            return;
        }
        
        if (!ValidaCPF.isValid(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido");
            return;
        }

        String sql = "insert into tbcampista(Nomecamp,endcamp,cpfcamp,TelefoneCamp,PlacaCamp,observacoes,Enbarca,Tipo,Perfil)"
               + " values(?,?,?,?,?,?,?,?,?)";
               
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtNomeCamp.getText());
        pst.setString(2, txtEndeCamp.getText());
        pst.setString(3, txtCpfCamp.getText());
        pst.setString(4, txtfonecam.getText());
        pst.setString(5, TxtPlaca.getText());
        pst.setString(6, jObervacoes.getText());
        pst.setString(7, Embarca.getSelectedItem().toString());
        pst.setString(8, LTipo.getSelectedItem().toString());
        pst.setString(9, TipoUsuario.getSelectedItem().toString());
        int adicionado = pst.executeUpdate();

        if (adicionado > 0) {
            JOptionPane.showMessageDialog(null, "Campista  Cadastrado com Sucesso!");
            txtNomeCamp.setText(null);
            txtEndeCamp.setText(null);
            txtCpfCamp.setText(null);
            txtfonecam.setText(null);
            TxtPlaca.setText(null);
            jObervacoes.setText(null);
            Embarca.setSelectedItem(null);
            LTipo.setSelectedItem(null);
            TipoUsuario.setSelectedItem(null);
            //rs.close();
        }
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e);
        
        
    }
}
    private void PesquisarCampistas() {
        String sql = " select * from tbcampista where CpfCamp like ?";
        try {
            pst = conexao.prepareStatement(sql);
            // Passando da caixa de pesquisa
            pst.setString(1, txtPesquisarCamp.getText() + "%");
            // executa a query
            rs = pst.executeQuery();
            // usa a biblioteca para preencher a tabela
            tblCampista.setModel(DbUtils.resultSetToTableModel(rs));
            //BtnCadastroCamp.setEnabled(true);
   rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    //  setar campos do formulario campo da tabela

    public void setar_campos() {

        int setar = tblCampista.getSelectedRow();
        idCamp.setText(tblCampista.getModel().getValueAt(setar, 0).toString());
        txtNomeCamp.setText(tblCampista.getModel().getValueAt(setar, 1).toString());
        txtEndeCamp.setText(tblCampista.getModel().getValueAt(setar, 2).toString());
        txtCpfCamp.setText(tblCampista.getModel().getValueAt(setar, 3).toString());
        txtfonecam.setText(tblCampista.getModel().getValueAt(setar, 4).toString());
        TxtPlaca.setText(tblCampista.getModel().getValueAt(setar, 5).toString().trim());
        jObervacoes.setText(tblCampista.getModel().getValueAt(setar, 6).toString());
        Embarca.setSelectedItem(tblCampista.getModel().getValueAt(setar, 7).toString());
        LTipo.setSelectedItem(tblCampista.getModel().getValueAt(setar, 8).toString());
        TipoUsuario.setSelectedItem(tblCampista.getModel().getValueAt(setar, 9).toString());
          txtCpfCamp.setEnabled(false);
        BtnCadastroCamp.setEnabled(false);
        if (Embarca.getSelectedItem().equals("Sim")) {
            LTipo.setEnabled(true);
        } else {
//Set False    
            if (LTipo.getSelectedItem().equals("Não")) {
                LTipo.setEnabled(false);

            }

        }

    }

    private void alterar() {

        String sql = "update tbcampista set NomeCamp=?,endcamp=?,TelefoneCamp=?,PlacaCamp=?,observacoes=?,"
                + "Enbarca=?,Tipo=?, Perfil=? where IdCamp=?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCamp.getText());
            pst.setString(2, txtEndeCamp.getText());           
            pst.setString(3, txtfonecam.getText());
            pst.setString(4, TxtPlaca.getText());
            pst.setString(5, jObervacoes.getText());
            pst.setString(6, Embarca.getSelectedItem().toString());
            pst.setString(7, LTipo.getSelectedItem().toString());
            pst.setString(8, TipoUsuario.getSelectedItem().toString());
            pst.setString(9, idCamp.getText());

            if ((((txtCpfCamp.getText().isEmpty()) || (txtNomeCamp.getText().isEmpty())))) {

                JOptionPane.showMessageDialog(null, " Todos os Campos Marcados com *, são Obrigatórios");

            } else {

                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, " Dados Do Usuario Alterado com Sucesso!!!");
                    idCamp.setText(null);
                    txtNomeCamp.setText(null);
                    txtEndeCamp.setText(null);
                    txtCpfCamp.setText(null);
                    txtfonecam.setText(null);
                    TxtPlaca.setText(null);
                    jObervacoes.setText(null);

                    Embarca.setSelectedItem(null);
                    LTipo.setSelectedItem(null);

                    TipoUsuario.setSelectedItem(null);
                    BtnCadastroCamp.setEnabled(true);

                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void excluir_campista() {

        // remove
        int confirma = JOptionPane.showConfirmDialog(null, "Ter certeza que Deseja Excluir??");
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbcampista where IdCamp=? ";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, idCamp.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {

                    JOptionPane.showMessageDialog(null, " Campista Removido com Sucesso!!!");

                    txtNomeCamp.setText(null);
                    txtEndeCamp.setText(null);
                    txtfonecam.setText(null);
                    txtCpfCamp.setText(null);
                    TxtPlaca.setText(null);
                    jObervacoes.setText(null);
                    Embarca.setSelectedItem(null);
                    TipoUsuario.setSelectedItem(null);
                    LTipo.setSelectedItem(null);
                    BtnCadastroCamp.setEnabled(true);
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
        
        
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
        jLabel2 = new javax.swing.JLabel();
        txtNomeCamp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfonecam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtPlaca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jObervacoes = new javax.swing.JTextArea();
        BtnCadastroCamp = new javax.swing.JButton();
        txtPesquisarCamp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCampista = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        idCamp = new javax.swing.JLabel();
        bb = new javax.swing.JLabel();
        TipoUsuario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        Embarca = new javax.swing.JComboBox<>();
        LTipo = new javax.swing.JComboBox<>();
        txtCpfCamp = new javax.swing.JFormattedTextField();
        txtEndeCamp = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela Campistas/Visitante");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("* Obrigatório");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("* Nome");

        txtNomeCamp.setForeground(new java.awt.Color(51, 51, 51));
        txtNomeCamp.setDisabledTextColor(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Endereço");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fone");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("* CPF");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Placa ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Observações");

        jObervacoes.setColumns(20);
        jObervacoes.setRows(5);
        jScrollPane1.setViewportView(jObervacoes);

        BtnCadastroCamp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnCadastroCamp.setText("Cadastrar");
        BtnCadastroCamp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCadastroCampMouseClicked(evt);
            }
        });
        BtnCadastroCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastroCampActionPerformed(evt);
            }
        });
        BtnCadastroCamp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCadastroCampKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BtnCadastroCampKeyReleased(evt);
            }
        });

        txtPesquisarCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarCampActionPerformed(evt);
            }
        });
        txtPesquisarCamp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarCampKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Pesquisar");

        tblCampista.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tblCampista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Endereço", "Fone", "Cpf", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCampista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCampistaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCampista);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        idCamp.setText("ID");
        idCamp.setEnabled(false);

        bb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bb.setText("*Cliente");

        TipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Campista", "Visitante" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Embarcação");

        Embarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Embarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        Embarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EmbarcaItemStateChanged(evt);
            }
        });
        Embarca.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                EmbarcaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        Embarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmbarcaMouseClicked(evt);
            }
        });
        Embarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmbarcaActionPerformed(evt);
            }
        });

        LTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Lancha ", "Barco De Madeira", "Jet ski", "Só com reboque", "Outro" }));
        LTipo.setEnabled(false);
        LTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LTipoItemStateChanged(evt);
            }
        });
        LTipo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                LTipoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        LTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LTipoMouseClicked(evt);
            }
        });
        LTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LTipoActionPerformed(evt);
            }
        });

        try {
            txtCpfCamp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisarCamp, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idCamp)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpfCamp)
                                    .addComponent(txtNomeCamp)
                                    .addComponent(txtEndeCamp, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(txtfonecam))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(bb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnCadastroCamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(85, 85, 85)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(9, 9, 9)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(LTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Embarca, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisarCamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idCamp)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeCamp)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtEndeCamp))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                            .addComponent(txtfonecam)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Embarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(3, 3, 3)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCpfCamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(TipoUsuario)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCadastroCamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        setBounds(0, 0, 824, 452);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisarCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarCampActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarCampActionPerformed

    private void BtnCadastroCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastroCampActionPerformed

            
        
        Adicionar();
        

    }//GEN-LAST:event_BtnCadastroCampActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        alterar();
// TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        excluir_campista();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPesquisarCampKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarCampKeyReleased
        // TODO add your handling code here
        PesquisarCampistas();
    }//GEN-LAST:event_txtPesquisarCampKeyReleased

    private void tblCampistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCampistaMouseClicked
        // TODO add your handling code here:
        // setar campos
        setar_campos();
    }//GEN-LAST:event_tblCampistaMouseClicked

    private void EmbarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmbarcaActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_EmbarcaActionPerformed

    @SuppressWarnings("IncompatibleEquals")
    private void LTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LTipoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_LTipoActionPerformed

    private void LTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LTipoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_LTipoMouseClicked

    private void EmbarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmbarcaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_EmbarcaMouseClicked

    private void LTipoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_LTipoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:


    }//GEN-LAST:event_LTipoPopupMenuWillBecomeInvisible

    private void EmbarcaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_EmbarcaPopupMenuWillBecomeInvisible
        // TODO add your handling code here:

        if (Embarca.getSelectedItem().equals("Sim")) {
            LTipo.setEnabled(true);
        } else {
//Set False
            LTipo.setEnabled(false);
        }

    }//GEN-LAST:event_EmbarcaPopupMenuWillBecomeInvisible

    private void LTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LTipoItemStateChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_LTipoItemStateChanged

    private void EmbarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EmbarcaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_EmbarcaItemStateChanged

    private void BtnCadastroCampKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCadastroCampKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_BtnCadastroCampKeyPressed

    private void BtnCadastroCampKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCadastroCampKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_BtnCadastroCampKeyReleased

    private void BtnCadastroCampMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCadastroCampMouseClicked
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_BtnCadastroCampMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastroCamp;
    private javax.swing.JComboBox<String> Embarca;
    private javax.swing.JComboBox<String> LTipo;
    private javax.swing.JComboBox<String> TipoUsuario;
    private javax.swing.JTextField TxtPlaca;
    private javax.swing.JLabel bb;
    private javax.swing.JLabel idCamp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jObervacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCampista;
    private javax.swing.JFormattedTextField txtCpfCamp;
    private javax.swing.JTextField txtEndeCamp;
    private javax.swing.JTextField txtNomeCamp;
    private javax.swing.JTextField txtPesquisarCamp;
    private javax.swing.JTextField txtfonecam;
    // End of variables declaration//GEN-END:variables
}
