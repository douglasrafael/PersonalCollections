package br.edu.uepb.personalcollections.telas;

import br.edu.uepb.personalcollections.enums.TipoItem;
import br.edu.uepb.personalcollections.excecoes.PersonalCollectionsException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.edu.uepb.personalcollections.Item;
import br.edu.uepb.personalcollections.enums.FiltroItem;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

/**
 * Interface gráfica. Tela de itens
 *
 * @author Douglas Rafael
 */
public class TelaItens extends javax.swing.JDialog {

    private static final long serialVersionUID = -4816491591252503257L;

    private final String STREDITAR = "Editar Item";
    private final String STRDELETAR = "Deletar Item";
    private final String STRINFORDEL = "Todo histórico relacionado ao item, como por exemplo os empréstimos serão perdidos!";

    private List<Item> listaDeItens;
    private Gerenciador manager;
    private static TelaPrincipal telaPrincipal;

    /**
     * Método construtor TelaItens
     *
     * @param parent O JFrame de origem
     * @param modal Se modal (true), caso contrário (false)
     */
    public TelaItens(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        if (parent != null) {
            TelaItens.telaPrincipal = (TelaPrincipal) parent;
        }
        listaDeItens = new LinkedList<>();
        manager = new Gerenciador();
        initComponents();
        populaComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_itens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        bt_deletar = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        tf_pesquisa = new javax.swing.JTextField();
        bt_pesquisa = new javax.swing.JButton();
        cb_filtro = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personal Collections - Itens");
        setIconImage(new ImageIcon("images/logo.png").getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fechaJanela(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserir Novos Itens"));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new ImageIcon("images/hq.png"));
        jButton1.setText("HQ's");
        jButton1.setPreferredSize(new java.awt.Dimension(73, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCadastroHQ(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setIcon(new ImageIcon("images/media.png"));
        jButton2.setText("Mídias");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCadastroMidia(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setIcon(new ImageIcon("images/game.png"));
        jButton3.setText("Jogos de Videogame");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCadastroGame(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new ImageIcon("images/board.png"));
        jButton4.setText("Jogos de Tabuleiro");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCadastroTabuleiro(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Últimos Itens Cadastrados"));

        table_itens.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Tipo do Item", "Estado", "Emprestado?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_itens.setToolTipText("Selecione o Iitem e clique em editar para atualizar os dados");
        table_itens.getTableHeader().setReorderingAllowed(false);
        table_itens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linhaSelecionada(evt);
            }
        });
        jScrollPane1.setViewportView(table_itens);
        if (table_itens.getColumnModel().getColumnCount() > 0) {
            table_itens.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_itens.getColumnModel().getColumn(0).setMaxWidth(50);
            table_itens.getColumnModel().getColumn(1).setPreferredWidth(260);
            table_itens.getColumnModel().getColumn(2).setPreferredWidth(170);
            table_itens.getColumnModel().getColumn(3).setPreferredWidth(120);
            table_itens.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jLabel1.setText("Total de Itens cadastrados: ");

        lb_total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_total.setText("0");

        bt_deletar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_deletar.setIcon(new ImageIcon("images/delete.png"));
        bt_deletar.setText("Deletar Item");
        bt_deletar.setEnabled(false);
        bt_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acao(evt);
            }
        });

        bt_editar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_editar.setIcon(new ImageIcon("images/edit.png"));
        bt_editar.setText("Editar Item");
        bt_editar.setEnabled(false);
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acao(evt);
            }
        });

        tf_pesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_pesquisa.setMargin(new java.awt.Insets(2, 5, 2, 2));
        tf_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chamaPesquisar(evt);
            }
        });

        bt_pesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_pesquisa.setIcon(new ImageIcon("images/search.png"));
        bt_pesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisar(evt);
            }
        });

        cb_filtro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_filtro.setModel(new DefaultComboBoxModel(FiltroItem.values()));
        cb_filtro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemSelecionado(evt);
            }
        });

        jLabel2.setText("Filtro:");

        jLabel3.setText("Pesquisar:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lb_total)
                    .addComponent(bt_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre cadastro de HQ.
     *
     * @param evt O evento
     */
    private void abrirCadastroHQ(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCadastroHQ
        this.dispose();
        new TelaCadastroHQ(null, true, 0).setVisible(true);
    }//GEN-LAST:event_abrirCadastroHQ
    /**
     * Abre cadastro de Tabuleiro.
     *
     * @param evt O evento
     */
    private void abrirCadastroTabuleiro(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCadastroTabuleiro
        this.dispose();
        new TelaCadastroTabuleiro(null, true, 0).setVisible(true);
    }//GEN-LAST:event_abrirCadastroTabuleiro

    /**
     * Abre cadastro de Midia.
     *
     * @param evt O evento
     */
    private void abrirCadastroMidia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCadastroMidia
        this.dispose();
        new TelaCadastroMidia(null, true, 0).setVisible(true);
    }//GEN-LAST:event_abrirCadastroMidia

    /**
     * Abre cadastro de Game.
     *
     * @param evt O evento
     */
    private void abrirCadastroGame(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCadastroGame
        this.dispose();
        new TelaCadastroGame(null, true, 0).setVisible(true);
    }//GEN-LAST:event_abrirCadastroGame

    /**
     * Chama a ação respectiva
     *
     * @param evt O evento
     */
    private void linhaSelecionada(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linhaSelecionada
        if (evt.getClickCount() == 1) {
            bt_deletar.setEnabled(true);
            bt_editar.setEnabled(true);
        }
    }//GEN-LAST:event_linhaSelecionada

    /**
     * Recupera o index da linha selecionada da tabela de itens
     *
     * @return O index da linha selecionada
     */
    private int getLinhaSelecionada() {
        return table_itens.getSelectedRow();
    }

    /**
     * mapeia qual ação será executada (atualização ou exclusão)
     *
     * @param evt O evento
     */
    private void acao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acao
        int linha = getLinhaSelecionada();
        int id = Integer.parseInt((String) table_itens.getValueAt(linha, 0));
        String tipo = (String) table_itens.getValueAt(linha, 2); // Pega o tipo do item
        String titulo = (String) table_itens.getValueAt(linha, 1);

        // Verifica se foi o botão editar que chamou o método
        // Se não foi, então foi o botão remover
        if (evt.getActionCommand().equals(STREDITAR)) {
            if (tipo.equals(TipoItem.HQ.getTitulo())) {
                abreTelaEditarHQ(id);
            } else if (tipo.equals(TipoItem.MIDIA.getTitulo())) {
                abreTelaEditarMidia(id);
            } else if (tipo.equals(TipoItem.JOGOVIDEOGAME.getTitulo())) {
                abreTelaEditarGame(id);
            } else if (tipo.equals(TipoItem.JOGOTABULEIRO.getTitulo())) {
                abreTelaEditarTabuleiro(id);
            }
        } else if (evt.getActionCommand().equals(STRDELETAR)) {
            if (tipo.equals(TipoItem.HQ.getTitulo())) {
                removeHQ(id, titulo);
            } else if (tipo.equals(TipoItem.MIDIA.getTitulo())) {
                removeMidia(id, titulo);
            } else if (tipo.equals(TipoItem.JOGOVIDEOGAME.getTitulo())) {
                removeGame(id, titulo);
            } else if (tipo.equals(TipoItem.JOGOTABULEIRO.getTitulo())) {
                removeTabuleiro(id, titulo);
            }
        }
    }//GEN-LAST:event_acao

    /**
     * Relza pesquisa de item utilizando campo de busca e filtro.
     *
     * @param evt O evento
     */
    private void pesquisar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisar
        if (!tf_pesquisa.getText().isEmpty()) {
            listaDeItens = manager.pesquisarItem((FiltroItem) cb_filtro.getSelectedItem(), tf_pesquisa.getText());
            if (listaDeItens.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum item foi encontrado para essa pesquisa: \"" + tf_pesquisa.getText() + "\"\nTente outra pesquisa...", "Pesquisar Item", JOptionPane.INFORMATION_MESSAGE);
            }
            refresh();
        } else {
            tf_pesquisa.grabFocus();
            pesquisaVazia();
        }
    }//GEN-LAST:event_pesquisar

    /**
     * Chama método pesquisar.
     *
     * @param evt O evento
     */
    private void chamaPesquisar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chamaPesquisar
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisar(null);
        }
    }//GEN-LAST:event_chamaPesquisar

    /**
     * Realiza pesquisa com o item selecionado no combo de filtro.
     *
     * @param evt O evento
     */
    private void itemSelecionado(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemSelecionado
        tf_pesquisa.setText("");
        tf_pesquisa.grabFocus();
        pesquisaVazia();
    }//GEN-LAST:event_itemSelecionado

    /**
     * Fecha Janela.
     *
     * @param evt O evento
     */
    private void fechaJanela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fechaJanela
        // Atualiza a tela principal
        if (TelaItens.telaPrincipal != null) {
            telaPrincipal.refresh();
        }
        this.dispose();
    }//GEN-LAST:event_fechaJanela

    /**
     * Realiza busca por item com base apenas no filtro, ou lista tudo se o
     * campo de busca estiver vazio
     */
    private void pesquisaVazia() {
        FiltroItem filtro = (FiltroItem) cb_filtro.getSelectedItem();
        listaDeItens = manager.pesquisarItem(filtro, "");
        refresh();
    }

    /**
     * Remove Tabuleiro
     *
     * @param id O id do tabuleiro a ser removido
     * @param titulo O título do tabuleiro
     */
    private void removeTabuleiro(int id, String titulo) {
        try {
            if (id > 0) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o Jogo de Tabuleiro: \"" + titulo + "\"?\n" + STRINFORDEL, "Deletar item", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    if (!manager.removerTabuleiro(id)) {
                        throw new PersonalCollectionsException("Não foi possível remover Jogo de Tabuleiro: " + titulo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Item removido com sucesso!", "Remorção", JOptionPane.INFORMATION_MESSAGE);
                        listaDeItens = manager.listarItens();
                        refresh();
                    }
                }
            }
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problema na exclusão!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Remove HQ
     *
     * @param id O id da HQ a ser removida
     * @param titulo O título da HQ
     */
    private void removeHQ(int id, String titulo) {
        try {
            if (id > 0) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover a HQ: \"" + titulo + "\"?\n" + STRINFORDEL, "Deletar item", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    if (!manager.removerHQ(id)) {
                        throw new PersonalCollectionsException("Não foi possível remover a HQ: " + titulo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Item removido com sucesso!", "Remorção", JOptionPane.INFORMATION_MESSAGE);
                        listaDeItens = manager.listarItens();
                        refresh();
                    }
                }
            }
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problema na exclusão!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Remove Midia
     *
     * @param id O id da mídia a ser removida
     * @param titulo O título da mídia
     */
    private void removeMidia(int id, String titulo) {
        try {
            if (id > 0) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover a Mídia: \"" + titulo + "\"?\n" + STRINFORDEL, "Deletar item", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    if (!manager.removerMidia(id)) {
                        throw new PersonalCollectionsException("Não foi possível remover a Mídia: " + titulo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Item removido com sucesso!", "Remorção", JOptionPane.INFORMATION_MESSAGE);
                        listaDeItens = manager.listarItens();
                        refresh();
                    }
                }
            }
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problema na exclusão!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Remove Game
     *
     * @param id O id do game a ser removido
     * @param titulo O título do game
     */
    private void removeGame(int id, String titulo) {
        try {
            if (id > 0) {
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente remover a Mídia: \"" + titulo + "\"?\n" + STRINFORDEL, "Deletar item", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    if (!manager.removerGame(id)) {
                        throw new PersonalCollectionsException("Não foi possível remover a Mídia: " + titulo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Item removido com sucesso!", "Remorção", JOptionPane.INFORMATION_MESSAGE);
                        listaDeItens = manager.listarItens();
                        refresh();
                    }
                }
            }
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problema na exclusão!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Abre tela editar HQ
     *
     * @param id O id da HQ
     */
    private void abreTelaEditarHQ(int id) {
        this.dispose();
        // instancia um objeto apenas com o id
//        HQ hq = new HQ(id, "", "", "", 0, 0, 0, Estado.NOVO, false, TipoItem.HQ, 0, "", "", "", false);
        new TelaCadastroHQ(null, true, id).setVisible(true);
    }

    /**
     * Abre tela editar Midia
     *
     * @param id O id da midia
     */
    private void abreTelaEditarMidia(int id) {
        this.dispose();
        new TelaCadastroMidia(null, true, id).setVisible(true);
    }

    /**
     * Abre tela editar Game
     *
     * @param id O id do game
     */
    private void abreTelaEditarGame(int id) {
        this.dispose();
        new TelaCadastroGame(null, true, id).setVisible(true);
    }

    /**
     * Abre tela editar tabuleiro
     *
     * @param id O id do tabuleiro
     */
    private void abreTelaEditarTabuleiro(int id) {
        this.dispose();
        new TelaCadastroTabuleiro(null, true, id).setVisible(true);
    }

    /**
     * Método main.
     *
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
            java.util.logging.Logger.getLogger(TelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaItens dialog = new TelaItens(new javax.swing.JFrame(), true);
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
     * Monta a tabela de itens
     *
     */
    private void montaTabela() {
        DefaultTableModel modelTable = (DefaultTableModel) table_itens.getModel();
        modelTable.setNumRows(0); // Zera a tabela
        if (!listaDeItens.isEmpty()) {
            int total_itens = listaDeItens.size();

            // Ordena em ordem decrescente pelo id
            Collections.sort(listaDeItens);

            for (Item itemVez : listaDeItens) {
                Object[] o = {String.format("%04d", itemVez.getId()), itemVez.getTitulo(), itemVez.getTipo().getTitulo(), itemVez.getEstado(), itemVez.getStringEmprestado()};
                modelTable.addRow(o);
            }
            lb_total.setText(String.valueOf(total_itens));
        } else {
            bt_deletar.setEnabled(false);
            bt_editar.setEnabled(false);
        }
    }

    /**
     * Popula os components da tela
     */
    private void populaComponents() {
        try {
            listaDeItens = manager.listarItens();
            // Ordena em ordem decrescente pelo id
            Collections.sort(listaDeItens);

            refresh();
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ocorreu um erro ao tentar obter os dados!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Atualiza a tela
     */
    private void refresh() {
        montaTabela();
    }

    /**
     * Retorna o filtro selecionado.
     *
     * @return O filtro selecionado
     */
    private String getFiltro() {
        return (String) cb_filtro.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_deletar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_pesquisa;
    private javax.swing.JComboBox cb_filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTable table_itens;
    private javax.swing.JTextField tf_pesquisa;
    // End of variables declaration//GEN-END:variables
}
