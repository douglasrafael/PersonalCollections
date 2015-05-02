package telas;

import enums.TipoItem;
import excecoes.PersonalCollectionsException;
import excecoes.ValidacaoException;
import gerenciador.Gerenciador;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tipos.Amigo;
import tipos.Emprestimo;
import tipos.Item;

/**
 * tela de emprestimos
 *
 * @author Douglas Rafael
 */
public class TelaRanking extends javax.swing.JDialog {

    private DefaultTableModel modelTableRanking;
    private DefaultTableModel modelTableNotas;
    private Gerenciador manager;

    /**
     * Costrutor TelaEmprestimos
     *
     * @param parent
     * @param modal
     */
    public TelaRanking(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        manager = new Gerenciador();
        initComponents();

        modelTableRanking = (DefaultTableModel) table_ranking.getModel();
        modelTableNotas = (DefaultTableModel) table_notas.getModel();
        montaTabelas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ranking = new javax.swing.JPanel();
        panel_tabela = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_ranking = new javax.swing.JTable();
        panel_nota = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_notas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empréstimos");

        panel_tabela.setBorder(javax.swing.BorderFactory.createTitledBorder("Ranking dos itens mais empréstados"));

        table_ranking.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_ranking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Tipo do Item", "Total de Empréstimos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_ranking.setToolTipText("Selecione o Iitem e clique em editar para atualizar os dados");
        table_ranking.getTableHeader().setReorderingAllowed(false);
        table_ranking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_rankinglinhaSelecionada(evt);
            }
        });
        jScrollPane4.setViewportView(table_ranking);
        if (table_ranking.getColumnModel().getColumnCount() > 0) {
            table_ranking.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_ranking.getColumnModel().getColumn(0).setMaxWidth(50);
            table_ranking.getColumnModel().getColumn(2).setPreferredWidth(170);
            table_ranking.getColumnModel().getColumn(2).setMaxWidth(170);
            table_ranking.getColumnModel().getColumn(3).setPreferredWidth(130);
            table_ranking.getColumnModel().getColumn(3).setMaxWidth(130);
        }

        javax.swing.GroupLayout panel_tabelaLayout = new javax.swing.GroupLayout(panel_tabela);
        panel_tabela.setLayout(panel_tabelaLayout);
        panel_tabelaLayout.setHorizontalGroup(
            panel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_tabelaLayout.setVerticalGroup(
            panel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_nota.setBorder(javax.swing.BorderFactory.createTitledBorder("Ranking dos itens com melhores notas"));

        table_notas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Tipo do Item", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_notas.setToolTipText("Selecione o Iitem e clique em editar para atualizar os dados");
        table_notas.getTableHeader().setReorderingAllowed(false);
        table_notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_notaslinhaSelecionada(evt);
            }
        });
        jScrollPane5.setViewportView(table_notas);
        if (table_notas.getColumnModel().getColumnCount() > 0) {
            table_notas.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_notas.getColumnModel().getColumn(0).setMaxWidth(50);
            table_notas.getColumnModel().getColumn(2).setPreferredWidth(170);
            table_notas.getColumnModel().getColumn(2).setMaxWidth(170);
            table_notas.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_notas.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        javax.swing.GroupLayout panel_notaLayout = new javax.swing.GroupLayout(panel_nota);
        panel_nota.setLayout(panel_notaLayout);
        panel_notaLayout.setHorizontalGroup(
            panel_notaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_notaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        panel_notaLayout.setVerticalGroup(
            panel_notaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_notaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_rankingLayout = new javax.swing.GroupLayout(panel_ranking);
        panel_ranking.setLayout(panel_rankingLayout);
        panel_rankingLayout.setHorizontalGroup(
            panel_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_rankingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_nota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_rankingLayout.setVerticalGroup(
            panel_rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_rankingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(panel_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_ranking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(panel_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_rankinglinhaSelecionada(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rankinglinhaSelecionada
        // TODO add your handling code here:
    }//GEN-LAST:event_table_rankinglinhaSelecionada

    private void table_notaslinhaSelecionada(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_notaslinhaSelecionada
        // TODO add your handling code here:
    }//GEN-LAST:event_table_notaslinhaSelecionada

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
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaRanking dialog = new TelaRanking(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panel_nota;
    private javax.swing.JPanel panel_ranking;
    private javax.swing.JPanel panel_tabela;
    private javax.swing.JTable table_notas;
    private javax.swing.JTable table_ranking;
    // End of variables declaration//GEN-END:variables

    /**
     * Monta tabela com os dados
     *
     */
    private void montaTabelas() {
        try {
            if (!manager.listarItens().isEmpty()) {
                modelTableRanking.setNumRows(0);
                modelTableNotas.setNumRows(0);

                List<Item> listaRankingEmprestimo = new ArrayList<>(manager.rankingEmprestimo());
                List<Item> listaRankingNota = new ArrayList<>(manager.rankingNota());

                if (!listaRankingEmprestimo.isEmpty()) {
                    for (Item item : listaRankingEmprestimo) {
                        Object[] o = {item.getId(), item.getTitulo(), item.getTipo(), item.getTotalEmprestado()};
                        modelTableRanking.addRow(o);
                    }
                }

                if (!listaRankingNota.isEmpty()) {
                    for (Item item : listaRankingNota) {
                        Object[] o = {item.getId(), item.getTitulo(), item.getTipo(), item.getNota()};
                        modelTableNotas.addRow(o);
                    }
                }
            }
        } catch (PersonalCollectionsException ex) {
            JOptionPane.showMessageDialog(null, "Problema na tentativa de obter lista de empréstimos!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
