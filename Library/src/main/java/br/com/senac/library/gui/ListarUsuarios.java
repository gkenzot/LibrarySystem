/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.senac.library.gui;

import br.com.senac.library.dao.UsuarioDAO;
import br.com.senac.library.model.Usuario;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kenzo
 */
public final class ListarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form ListagemUsuarios
     */
    public ListarUsuarios() {
        initComponents();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDao.listar("");
        listagemUsuarios(usuarios);
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
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LS - Listagem Usuario");

        jLabel1.setText("NOME:");

        jScrollPane1.setViewportView(tblConsulta);
        tblConsulta.getAccessibleContext().setAccessibleName("Tabela Usuarios");
        tblConsulta.getAccessibleContext().setAccessibleDescription("Tabela com os dados dos usuários");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addContainerGap(782, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPesquisar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnPesquisar)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(btnPesquisar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        txtPesquisar.getAccessibleContext().setAccessibleName("Nome");
        txtPesquisar.getAccessibleContext().setAccessibleDescription("Campo para pesquisar o nome do usuário");
        btnEditar.getAccessibleContext().setAccessibleDescription("Botao de editar o usuário");
        btnPesquisar.getAccessibleContext().setAccessibleDescription("Botão de Pesquisar o usuário");
        btnExcluir.getAccessibleContext().setAccessibleDescription("Botão de excluir o usuário");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            CadastrarUsuario cadastroUsuario = new CadastrarUsuario();
            if (tblConsulta.getSelectedRow() >= 0) {
                String id = (String) tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0);
                UsuarioDAO usuarioDao = new UsuarioDAO();
                Usuario usuarioSelected = usuarioDao.obter(Integer.parseInt(id)
                );
                cadastroUsuario.preencheEdicao(usuarioSelected);
                cadastroUsuario.setVisible(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDao.listar(txtPesquisar.getText());
            listagemUsuarios(usuarios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (tblConsulta.getSelectedRow() >= 0) {
                String id = (String) tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0);
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir este usuário, id = " + id + " ?");
                if (resposta == 0) {
                    UsuarioDAO usuarioDao = new UsuarioDAO();

                    // Verifica se há empréstimos associados ao usuário
                    if (usuarioDao.verificarEmprestimos(Integer.parseInt(id))) {
                        JOptionPane.showMessageDialog(this, "Não é possível excluir este usuário porque há empréstimos associados a ele.");
                    } else {
                        usuarioDao.excluir(Integer.parseInt(id));
                        JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso");
                        btnPesquisarActionPerformed(evt);
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListarUsuarios().setVisible(true);
        });
    }

    public void listagemUsuarios(List<Usuario> usuarios) {
        String columns[] = {"Id", "Nome", "CPF", "Email", "Telefone", "Endereco", "Permissao"};
        String dados[][] = new String[usuarios.size()][columns.length];
        int i = 0;
        for (Usuario u : usuarios) {
            dados[i] = new String[]{
                String.valueOf(u.getId()),
                u.getNome(),
                u.getCPF(),
                u.getEmail(),
                u.getTelefone(),
                u.getEndereco(),
                u.getPermissao(),};
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(dados, columns);
        tblConsulta.setModel(model);

        ajustarListagemUsuarios();
    }

    public void ajustarListagemUsuarios() {
        // Ajustar larguras das colunas da tblConsulta
        tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(20); // Id
        tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(180); // Nome
        tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(70); // CPF
        tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(130); // Email
        tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(70); // Telefone
        tblConsulta.getColumnModel().getColumn(5).setPreferredWidth(100);  // Endereco
        tblConsulta.getColumnModel().getColumn(6).setPreferredWidth(60); // Permissao
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}