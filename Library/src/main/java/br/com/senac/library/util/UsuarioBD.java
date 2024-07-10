package br.com.senac.library.util;

import br.com.senac.library.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável pela interação com o banco de dados para operações
 * relacionadas a usuários.
 *
 * Esta classe possui um método para validar um usuário no banco de dados,
 * recebendo um usuário como entrada e retornando o usuário correspondente, se
 * encontrado, ou null caso contrário.
 *
 * Utiliza uma conexão JDBC para executar consultas parametrizadas no banco de
 * dados MySQL.
 *
 * @author kenzo
 */
public class UsuarioBD {

    /**
     * Valida um usuário no banco de dados.
     *
     * @param usuario O usuário a ser validado.
     * @return O usuário correspondente se encontrado, ou null caso contrário.
     */
    public static Usuario validarUsuarioSeguro(Usuario usuario) {

        // Criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        Usuario usuarioEncontrado = null;
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "123456");
            PreparedStatement statement = conexao.prepareStatement(sql);
            // Atribuindo os valores na consulta
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getSenha());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setEmail(rs.getString("email"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setPermissao(rs.getString("permissao"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }
        return usuarioEncontrado;
    }

}
