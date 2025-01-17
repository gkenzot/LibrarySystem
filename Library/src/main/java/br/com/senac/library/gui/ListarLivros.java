/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.senac.library.gui;

import br.com.senac.library.dao.EmprestimoDAO;
import br.com.senac.library.dao.LivroDAO;
import br.com.senac.library.model.Emprestimo;
import br.com.senac.library.model.Livro;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kenzo
 */
public class ListarLivros extends javax.swing.JFrame {

    /**
     * Creates new form ListagemLivros
     */
    public ListarLivros() {
        initComponents();
        LivroDAO livroDao = new LivroDAO();
        List<Livro> livros = livroDao.listar("");
        listagemLivrosCompleta(livros);
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
        jLabel1 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterarStatus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LS - Listagem Livros");

        jLabel1.setText("NOME:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tblConsulta);
        tblConsulta.getAccessibleContext().setAccessibleName("Tabela Livros");
        tblConsulta.getAccessibleContext().setAccessibleDescription("Lista dos livros encontrados no acervo");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterarStatus.setText("Alterar Status");
        btnAlterarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterarStatus)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterarStatus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPesquisar.getAccessibleContext().setAccessibleName("Nome");
        txtPesquisar.getAccessibleContext().setAccessibleDescription("Campo para o nome do livro a ser buscado no acervo");
        btnPesquisar.getAccessibleContext().setAccessibleDescription("Confirmar a busca ,pesquisa do livro");
        btnEditar.getAccessibleContext().setAccessibleDescription("Editar as informações de um livro");
        btnExcluir.getAccessibleContext().setAccessibleDescription("Excluir o livro do acervo");
        btnAlterarStatus.getAccessibleContext().setAccessibleDescription("Abrir a janela de emprestimos e devoluções de livros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            LivroDAO livroDao = new LivroDAO();
            List<Livro> livros = livroDao.listar(txtPesquisar.getText());
            listagemLivrosCompleta(livros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            CadastrarLivro cadastroLivro = new CadastrarLivro();
            if (tblConsulta.getSelectedRow() >= 0) {
                String id = (String) tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0);
                LivroDAO livroDao = new LivroDAO();
                Livro livroSelected = livroDao.obter(Integer.parseInt(id)
                );
                cadastroLivro.preencheEdicao(livroSelected);
                cadastroLivro.setVisible(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (tblConsulta.getSelectedRow() >= 0) {
                String id = (String) tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0);
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir este livro, id = " + id + " ?");
                if (resposta == 0) {
                    LivroDAO livroDao = new LivroDAO();

                    // Verifica se há empréstimos associados ao livro
                    if (livroDao.verificarEmprestimos(Integer.parseInt(id))) {
                        JOptionPane.showMessageDialog(this, "Não é possível excluir este livro porque há empréstimos associados a ele.");
                    } else {
                        livroDao.excluir(Integer.parseInt(id));
                        JOptionPane.showMessageDialog(this, "Livro excluído com sucesso");
                        btnPesquisarActionPerformed(evt);
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarStatusActionPerformed
        try {
            AlterarStatus alterarStatus = new AlterarStatus();
            if (tblConsulta.getSelectedRow() >= 0) {
                String id = (String) tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0);
                LivroDAO livroDao = new LivroDAO();
                Livro livroSelected = livroDao.obter(Integer.parseInt(id));

                if ("emprestado".equalsIgnoreCase(livroSelected.getStatus())) {
                    EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
                    Emprestimo emprestimo = emprestimoDAO.obterPorLivro(livroSelected.getId());

                    if (emprestimo != null && emprestimo.getUsuario() != null) {
                        alterarStatus.preencheAlterarStatus(livroSelected, emprestimo.getUsuario(), emprestimo);
                    } else {
                        alterarStatus.preencheAlterarStatus(livroSelected, null, null);
                    }
                } else {
                    alterarStatus.preencheAlterarStatus(livroSelected, null, null);
                }
                alterarStatus.setVisible(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnAlterarStatusActionPerformed

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
            java.util.logging.Logger.getLogger(ListarLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListarLivros().setVisible(true);
        });
    }

    public void listagemLivrosCompleta(List<Livro> livros) {
        String columns[] = {"Id", "Titulo", "Autor", "ISBN", "Categoria", "Copia", "Status"};
        String dados[][] = new String[livros.size()][columns.length];
        int i = 0;
        for (Livro l : livros) {
            dados[i] = new String[]{
                String.valueOf(l.getId()),
                l.getTitulo(),
                l.getAutor(),
                String.valueOf(l.getISBN()),
                l.getCategoria(),
                String.valueOf(l.getCopia()),
                l.getStatus()
            };
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(dados, columns);
        tblConsulta.setModel(model);

        ajustarListagemLivrosComp();
    }

    public void ajustarListagemLivrosComp() {
        // Ajustar larguras das colunas da tblConsulta
        tblConsulta.getColumnModel().getColumn(0).setPreferredWidth(30); // Id
        tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(250); // Titulo
        tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(150); // Autor
        tblConsulta.getColumnModel().getColumn(3).setPreferredWidth(100); // ISBN
        tblConsulta.getColumnModel().getColumn(4).setPreferredWidth(100); // Categoria
        tblConsulta.getColumnModel().getColumn(5).setPreferredWidth(30);  // Copia
        tblConsulta.getColumnModel().getColumn(6).setPreferredWidth(80); // Status
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarStatus;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
