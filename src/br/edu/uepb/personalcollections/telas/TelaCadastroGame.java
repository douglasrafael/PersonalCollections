package br.edu.uepb.personalcollections.telas;

import br.edu.uepb.personalcollections.enums.Console;
import br.edu.uepb.personalcollections.enums.Estado;
import br.edu.uepb.personalcollections.enums.LocalizacaoDLC;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.excecoes.ValidacaoException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import br.edu.uepb.personalcollections.DLC;
import br.edu.uepb.personalcollections.Game;
import br.edu.uepb.personalcollections.util.Validacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Tela cadastro de Jogos de Videogame
 *
 * @author Douglas Rafael
 */
public class TelaCadastroGame extends javax.swing.JDialog {

    private final String STRCADASTRAR = "Cadastrar";
    private final String STRATUALIZAR = "Atualizar";
    private static int id;
    private DefaultTableModel modelTable;
    private static List<DLC> listaDeDLCs = new ArrayList<>();
    private Game game;

    private Gerenciador manager;

    /**
     * Creates new form TelaCadastroGame
     *
     * @param parent
     * @param modal
     */
    public TelaCadastroGame(java.awt.Frame parent, boolean modal, int idGame) {
        super(parent, modal);
        manager = new Gerenciador();

        initComponents();
        modelTable = (DefaultTableModel) table_dlc.getModel();
        // Se vier do contrutor um id é porque os dados deverão ser atualizados
        if (idGame > 0) {
            montaAlterarDados(idGame);
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

        group_lido = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox();
        rb_nao = new javax.swing.JRadioButton();
        rb_sim = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_obs = new javax.swing.JTextArea();
        bt_inserir = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        sp_nota = new javax.swing.JSpinner();
        tf_preco = new javax.swing.JFormattedTextField();
        cb_console = new javax.swing.JComboBox();
        panel_dlc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_dlc = new javax.swing.JTable();
        tf_titulo_dlc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_localizacao_dlc = new javax.swing.JComboBox();
        bt_inserir_dlc = new javax.swing.JButton();
        bt_deletar = new javax.swing.JButton();
        tf_data_compra = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Jogos de Videogame");
        setIconImage(new ImageIcon("images/logo.png").getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fecharJanela(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Título");

        tf_titulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_titulo.setMargin(new java.awt.Insets(2, 5, 2, 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Console");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Data de Compra");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Já foi Zerado?");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Preço");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Estado");

        cb_estado.setModel(new DefaultComboBoxModel(Estado.values()));

        group_lido.add(rb_nao);
        rb_nao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rb_nao.setSelected(true);
        rb_nao.setText("Não");

        group_lido.add(rb_sim);
        rb_sim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rb_sim.setText("Sim");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Nota do Item");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Observações");

        tf_obs.setColumns(20);
        tf_obs.setRows(5);
        tf_obs.setMargin(new java.awt.Insets(2, 5, 2, 2));
        jScrollPane1.setViewportView(tf_obs);

        bt_inserir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_inserir.setIcon(new ImageIcon("images/save.png"));
        bt_inserir.setText("Cadastrar");
        bt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acao(evt);
            }
        });

        bt_cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_cancelar.setIcon(new ImageIcon("images/cancel.png"));
        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        sp_nota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sp_nota.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(1.0f)));

        tf_preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        tf_preco.setMargin(new java.awt.Insets(2, 5, 2, 2));

        cb_console.setModel(new DefaultComboBoxModel(Console.values()));

        panel_dlc.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserir DLC's"));

        table_dlc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Localização"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_dlc.setToolTipText("Dê um duplo clique no DLC para remove-lo da lista...");
        table_dlc.getTableHeader().setReorderingAllowed(false);
        table_dlc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeDLC(evt);
            }
        });
        jScrollPane3.setViewportView(table_dlc);
        if (table_dlc.getColumnModel().getColumnCount() > 0) {
            table_dlc.getColumnModel().getColumn(1).setPreferredWidth(120);
            table_dlc.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        tf_titulo_dlc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_titulo_dlc.setMargin(new java.awt.Insets(2, 5, 2, 2));

        jLabel4.setText("Título do DLC");

        jLabel5.setText("Localização do DLC");

        cb_localizacao_dlc.setModel(new DefaultComboBoxModel(LocalizacaoDLC.values()));

        bt_inserir_dlc.setText("inserir DLC");
        bt_inserir_dlc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarDLC(evt);
            }
        });

        javax.swing.GroupLayout panel_dlcLayout = new javax.swing.GroupLayout(panel_dlc);
        panel_dlc.setLayout(panel_dlcLayout);
        panel_dlcLayout.setHorizontalGroup(
            panel_dlcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dlcLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dlcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panel_dlcLayout.createSequentialGroup()
                        .addGroup(panel_dlcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb_localizacao_dlc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_titulo_dlc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_dlcLayout.createSequentialGroup()
                                .addGroup(panel_dlcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(bt_inserir_dlc)))
                .addContainerGap())
        );
        panel_dlcLayout.setVerticalGroup(
            panel_dlcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dlcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_titulo_dlc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dlcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_localizacao_dlc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_inserir_dlc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
        );

        bt_deletar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_deletar.setIcon(new ImageIcon("images/delete.png"));
        bt_deletar.setText("Deletar");
        bt_deletar.setEnabled(false);
        bt_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGame(evt);
            }
        });

        tf_data_compra.setFormat(2);
        tf_data_compra.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_titulo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(cb_console, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(rb_sim)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb_nao)
                                        .addGap(50, 50, 50))
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sp_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_data_compra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(tf_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cb_estado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 599, Short.MAX_VALUE))
                    .addComponent(panel_dlc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(bt_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tf_data_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cb_console, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_nao)
                            .addComponent(rb_sim)))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_dlc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fecharJanela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharJanela
        this.dispose();
        new TelaItens(null, true).setVisible(true);
    }//GEN-LAST:event_fecharJanela

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        fecharJanela(null);
    }//GEN-LAST:event_cancelar

    /**
     * Verifica se à ação é de inserção ou atualização
     *
     * @param evt
     */
    private void acao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acao
        try {
            if (Validacao.validarCamposVazios(panelPrincipal, getCamposValidar())) {
                throw new ValidacaoException("O prenechimento dos seguintes campos são obrigatórios:"
                        + "\nTítulo"
                        + "\nNúmero"
                        + "\nEditora"
                        + "\nUniverso");
            } else {
                Game game = getGameInterface();
                if (game != null) {
                    if (isInsert()) {
                        inserir(game);
                    } else if (isUpadate()) {
                        atualizar(game);
                    }
                }
            }
        } catch (ValidacaoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Problema na validação", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_acao

    /**
     * Add dlc
     *
     * @param evt
     */
    private void adicionarDLC(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarDLC
        try {
            List<Component> component = new ArrayList<>();
            component.add(tf_titulo_dlc);
            if (Validacao.validarCamposVazios(panel_dlc, component)) {
                tf_titulo_dlc.grabFocus();
                throw new ValidacaoException("O prenechimento dos seguintes campos são obrigatórios:\nTítulo do DLC");
            } else {
                DLC dlc = new DLC(tf_titulo_dlc.getText(), (LocalizacaoDLC) cb_localizacao_dlc.getSelectedItem());
                Object[] o = {dlc.getTitulo(), dlc.getLocalizacao()};
                TelaCadastroGame.listaDeDLCs.add(dlc);
                modelTable.addRow(o);

                tf_titulo_dlc.setText("");
                cb_localizacao_dlc.setSelectedIndex(0);
            }
        } catch (ValidacaoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Problema na validação", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_adicionarDLC

    /**
     * Remove o Jogo de Videogame
     *
     * @param evt
     */
    private void removeGame(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeGame
        try {
            if (getId() > 0) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o item: " + tf_titulo.getText() + "?", "Deletar item", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    if (!manager.removerGame(getId())) {
                        throw new PersonalCollectionsException("Não foi possível remover o item: " + tf_titulo.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "Item removido com sucesso!", "Remorção", JOptionPane.INFORMATION_MESSAGE);
                        fecharJanela(null);
                    }
                }
            }
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problema na exclusão!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removeGame

    /**
     * Remove dlc da lista de DLC's
     *
     * @param evt
     */
    private void removeDLC(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeDLC
        if (evt.getClickCount() == 2) {
            int linha = table_dlc.getSelectedRow();
            String titulo = (String) table_dlc.getValueAt(linha, 0);
            LocalizacaoDLC local = (LocalizacaoDLC) table_dlc.getValueAt(linha, 1);

            DLC dlc = new DLC(titulo, local);
            TelaCadastroGame.listaDeDLCs.remove(dlc);
            montaTabelaDLC();
        }
    }//GEN-LAST:event_removeDLC

    /**
     * Preenche tabela com os DLC's
     *
     * @param dlc
     */
    private void montaTabelaDLC() {
        modelTable.setNumRows(0);
        if (!listaDeDLCs.isEmpty()) {
            for (DLC dlc : listaDeDLCs) {
                Object[] o = {dlc.getTitulo(), dlc.getLocalizacao()};
                modelTable.addRow(o);
            }
        }
    }

    /**
     * Insere jogo de video game
     *
     * @param game
     */
    private void inserir(Game game) {
        try {
            manager.inserirItem(game);
            JOptionPane.showMessageDialog(null, "Jogo de Vídeogame inserido com sucesso!", "Inserção", JOptionPane.INFORMATION_MESSAGE);
            limpaCampos();
            tf_titulo.grabFocus();
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar inserir o Jogo de Videogame", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Atualiza dados do Game
     *
     * @param game
     */
    private void atualizar(Game game) {
        try {
            manager.atualizarItem(game);
            JOptionPane.showMessageDialog(null, "Jogo de Videogame atualizado com sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE);
            fecharJanela(null);
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar atualizar o Jogo de Videogame", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroGame dialog = new TelaCadastroGame(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    /**
     * Monta o objeto Game com os dados oriundos da interface
     *
     * @return Game
     */
    private Game getGameInterface() {
        String titulo = tf_titulo.getText();
        Console console = (Console) cb_console.getSelectedItem();
        String dataCompra = tf_data_compra.getText();
        Double precoDeCompra = (tf_preco.getValue() != null) ? Double.parseDouble(String.valueOf(tf_preco.getValue())) : 0.0;
        Estado estado = (Estado) cb_estado.getSelectedItem();
        boolean zerado = rb_sim.isSelected() ? true : false;
        Double nota = (sp_nota.getValue() != null) ? Double.parseDouble(String.valueOf(sp_nota.getValue())) : 0.0;
        String observacao = tf_obs.getText();

        // Se não possuir DLC's
        if (getDLCs().isEmpty()) {
            // Se não for inserir é atualizar ou deletar
            if (isInsert()) {
                return new Game(titulo, observacao, dataCompra, precoDeCompra, 0, nota, estado, false, console, zerado);
            } else {
                return new Game(id, titulo, observacao, dataCompra, precoDeCompra, getGame().getTotalEmprestado(), nota, estado, getGame().isEmprestado(), console, zerado);
            }
        } else {
            if (isInsert()) {
                return new Game(titulo, observacao, dataCompra, precoDeCompra, 0, nota, estado, false, console, zerado, true, getDLCs());
            } else {
                return new Game(id, titulo, observacao, dataCompra, precoDeCompra, getGame().getTotalEmprestado(), nota, estado, getGame().isEmprestado(), console, zerado, true, getDLCs());
            }
        }
    }

    /**
     * Verifica se o estado do form é de inserção
     *
     * @return
     */
    public boolean isInsert() {
        return bt_inserir.getText().equals(STRCADASTRAR);
    }

    /**
     * Verifica se o estado do form é de atualização
     *
     * @return
     */
    public boolean isUpadate() {
        return bt_inserir.getText().equals(STRATUALIZAR);
    }

    /**
     * Retorna o valor de id, o qual é uma variavel static da classe
     *
     * @return int
     */
    private int getId() {
        return TelaCadastroGame.id;
    }

    /**
     * Retorna lista de DLCs
     *
     * @return
     */
    private List<DLC> getDLCs() {
        return TelaCadastroGame.listaDeDLCs;
    }

    /**
     * Retorna os campos que devem ser validados (obrigatórios)
     *
     * @return Lista com os components
     */
    public List<Component> getCamposValidar() {
        List<Component> components = new ArrayList<>();
        components.add(tf_titulo);
        return components;
    }

    /**
     * Limpa todos os campos
     */
    private void limpaCampos() {
        Component components[] = panelPrincipal.getComponents();
        for (Component component : components) {
            if (component instanceof JTextComponent) {
                ((JTextField) component).setText("");
            }
        }
        tf_data_compra.setSelectedDate(Calendar.getInstance());
        cb_estado.setSelectedIndex(0);
        cb_console.setSelectedIndex(0);
        cb_localizacao_dlc.setSelectedIndex(0);
        sp_nota.setValue(0);
        tf_obs.setText("");
        rb_nao.setSelected(true);
        modelTable.setRowCount(0);
        tf_titulo_dlc.setText("");
        cb_localizacao_dlc.setSelectedIndex(0);
    }

    /**
     * Monta a interface com os dados para atualização
     *
     * @param idGame
     */
    private void montaAlterarDados(int idGame) {
        try {
            Game game = manager.pesquisarGame(idGame);
            if (game != null) {
                setGame(game);
                bt_deletar.setEnabled(true); // habilita o botao deletar
                TelaCadastroGame.id = game.getId(); // seta o valor do id para variavel static 
                bt_inserir.setText("Atualizar");

                tf_titulo.setText(game.getTitulo());
                cb_console.setSelectedItem(game.getConsole());

                String dataCompra = game.getDataDeCompra();
                // prepara a data e seta no campo
                if (!dataCompra.isEmpty()) {
                    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(dataFormat.parse(dataCompra));
                    tf_data_compra.setSelectedDate(c);
                } else {
                    tf_data_compra.setSelectedDate(null);
                }

                tf_preco.setValue(game.getPrecoDeCompra());
                cb_estado.setSelectedItem(game.getEstado());
                sp_nota.setValue(game.getNota());
                tf_obs.setText(game.getObservacao());
                TelaCadastroGame.listaDeDLCs = new ArrayList<>(game.getDLCs());

                if (game.isZerado()) {
                    rb_sim.setSelected(true);
                }

                montaTabelaDLC();
            }
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar montar os dados do item para atualização", "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar montar a data...", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Recupera o Game a ser editado.
     *
     * @return
     */
    public Game getGame() {
        return game;
    }

    /**
     * Seta o Game a ser editado.
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_deletar;
    private javax.swing.JButton bt_inserir;
    private javax.swing.JButton bt_inserir_dlc;
    private javax.swing.JComboBox cb_console;
    private javax.swing.JComboBox cb_estado;
    private javax.swing.JComboBox cb_localizacao_dlc;
    private javax.swing.ButtonGroup group_lido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panel_dlc;
    private javax.swing.JRadioButton rb_nao;
    private javax.swing.JRadioButton rb_sim;
    private javax.swing.JSpinner sp_nota;
    private javax.swing.JTable table_dlc;
    private datechooser.beans.DateChooserCombo tf_data_compra;
    private javax.swing.JTextArea tf_obs;
    private javax.swing.JFormattedTextField tf_preco;
    private javax.swing.JTextField tf_titulo;
    private javax.swing.JTextField tf_titulo_dlc;
    // End of variables declaration//GEN-END:variables
}