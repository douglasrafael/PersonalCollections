package br.edu.uepb.personalcollections.telas;

import br.edu.uepb.personalcollections.Usuario;
import br.edu.uepb.personalcollections.excecoes.ValidacaoException;
import br.edu.uepb.personalcollections.gerenciador.Gerenciador;
import br.edu.uepb.personalcollections.util.Validacao;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Tela para alteração dos dodos do usuário (administrador) do sistema Só é
 * possível um administrador
 *
 * @author Douglas Rafael
 */
public class TelaCadastroUsuario extends javax.swing.JDialog {

    private final int MINPASS = 5;
    private Gerenciador manager;
    private Usuario usuario;

    /**
     * Construtor Tela de cadastro de usuário
     *
     * @param parent
     * @param modal
     */
    public TelaCadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        manager = new Gerenciador();
        initComponents();
        preencheInterface();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group_sexo = new javax.swing.ButtonGroup();
        panel_dados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rb_masculino = new javax.swing.JRadioButton();
        rb_feminino = new javax.swing.JRadioButton();
        tf_password_atual = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        tf_re_novo_password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        tf_novo_password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        bt_atualizar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAdastro de Usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fecharJanela(evt);
            }
        });

        panel_dados.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar Dados de Usuário"));

        jLabel1.setText("Nome");

        tf_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_nome.setMargin(new java.awt.Insets(2, 5, 2, 2));

        jLabel3.setText("Sexo");

        jLabel4.setText("Password");

        tf_login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_login.setMargin(new java.awt.Insets(2, 5, 2, 2));

        jLabel2.setText("Login");

        group_sexo.add(rb_masculino);
        rb_masculino.setSelected(true);
        rb_masculino.setText("Masculino");

        group_sexo.add(rb_feminino);
        rb_feminino.setText("Feminino");

        tf_password_atual.setMargin(new java.awt.Insets(2, 5, 2, 2));

        javax.swing.GroupLayout panel_dadosLayout = new javax.swing.GroupLayout(panel_dados);
        panel_dados.setLayout(panel_dadosLayout);
        panel_dadosLayout.setHorizontalGroup(
            panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dadosLayout.createSequentialGroup()
                        .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 26, Short.MAX_VALUE)
                        .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_dadosLayout.createSequentialGroup()
                                .addComponent(rb_masculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_feminino))
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14))
                    .addGroup(panel_dadosLayout.createSequentialGroup()
                        .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tf_login, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_dadosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel_dadosLayout.createSequentialGroup()
                                .addComponent(tf_password_atual)
                                .addContainerGap())))))
        );
        panel_dadosLayout.setVerticalGroup(
            panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_masculino)
                    .addComponent(rb_feminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_login, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_password_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar Password"));

        tf_re_novo_password.setMargin(new java.awt.Insets(2, 5, 2, 2));

        jLabel5.setText("Novo Password");

        tf_novo_password.setMargin(new java.awt.Insets(2, 5, 2, 2));

        jLabel6.setText("Digite Novamente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_novo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_re_novo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_novo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_re_novo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_atualizar.setIcon(new ImageIcon("images/save.png"));
        bt_atualizar.setText("Atualizar");
        bt_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizar(evt);
            }
        });

        bt_cancelar.setIcon(new ImageIcon("images/cancel.png"));
        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        fecharJanela(null);
    }//GEN-LAST:event_cancelar

    private void fecharJanela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharJanela
        this.dispose();
    }//GEN-LAST:event_fecharJanela

    private void atualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizar
        try {
            if (Validacao.validarCamposVazios(panel_dados, getCamposValidar())) {
                throw new ValidacaoException("O prenechimento dos seguintes campos são obrigatórios:"
                        + "\nNome"
                        + "\nSexo"
                        + "\nLogin"
                        + "\nPassword");
            } else {
                Usuario u = getUsuarioInterface();
                if (u != null) {
                    if (!validaPasswordAtual()) {
                        tf_password_atual.grabFocus();
                        throw new ValidacaoException("O password atual não confere com o cadastrado!"
                                + "\nPara alterar qualquer dado o password atual deverá ser igual ao que já está cadastrado no sistema.");
                    } else if (tf_novo_password.getPassword().length > 0 && !validaPassword()) {
                        tf_novo_password.grabFocus();
                        throw new ValidacaoException("Os campos de alteração de password não coincidem!"
                                + "\nOu o novo password não possui no mínimo 5 caracteres...");
                    } else {
                        manager.atualizarUsuario(u);
                        JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (ValidacaoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Problema na validação", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_atualizar

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
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroUsuario dialog = new TelaCadastroUsuario(new javax.swing.JFrame(), true);
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
     * Retorna os campos que devem ser validados (obrigatórios)
     *
     * @return Lista com os components
     */
    public List<Component> getCamposValidar() {
        List<Component> components = new ArrayList<>();
        components.add(tf_nome);
        components.add(tf_login);
        components.add(tf_password_atual);
        return components;
    }

    /**
     * Preenche os campos da interfae com os dados dp usuário
     */
    private void preencheInterface() {
        Usuario u = manager.listarUsuario();
        if (u != null) {
            usuario = u;
            tf_nome.setText(u.getNome());
            tf_login.setText(u.getLogin());
            tf_password_atual.setText(Arrays.toString(u.getPassword()));

            if (u.getSexo() == 'M') {
                rb_masculino.setSelected(true);
            } else {
                rb_feminino.setSelected(true);
            }
        }
    }

    /**
     * Monta o objeto Usuário com os dados oriundos da interface
     *
     * @return <code>Usuario</code>
     */
    private Usuario getUsuarioInterface() {
        String nome = tf_nome.getText();
        String login = tf_login.getText();
        char[] password = tf_password_atual.getPassword();
        char[] password_novo = tf_novo_password.getPassword();
        char[] password_re_novo = tf_re_novo_password.getPassword();
        char sexo = rb_masculino.isSelected() ? 'M' : 'F';

        if (password_novo != null && password_novo.length > MINPASS) {
            password = tf_novo_password.getPassword();
        }
        System.out.println("CHER" + Arrays.toString(password));
        return new Usuario(nome, sexo, login, password);
    }

    /**
     * Valida os campos de nova senha
     *
     * @return <code>true</code> se a validção for bem-sucedida ou
     * <code>false</code> se não
     */
    private boolean validaPassword() {
        char[] passNovo = tf_novo_password.getPassword();
        char[] passReNovo = tf_re_novo_password.getPassword();
        if (!(passNovo.length < MINPASS)) {
            if (Arrays.equals(passNovo, passReNovo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida a senha atual.
     *
     * @return <code>true</code> se a validção for bem-sucedida ou
     * <code>false</code> se não
     */
    private boolean validaPasswordAtual() {
        if (Arrays.equals(usuario.getPassword(), tf_password_atual.getPassword())) {
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atualizar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.ButtonGroup group_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_dados;
    private javax.swing.JRadioButton rb_feminino;
    private javax.swing.JRadioButton rb_masculino;
    private javax.swing.JTextField tf_login;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JPasswordField tf_novo_password;
    private javax.swing.JPasswordField tf_password_atual;
    private javax.swing.JPasswordField tf_re_novo_password;
    // End of variables declaration//GEN-END:variables
}
