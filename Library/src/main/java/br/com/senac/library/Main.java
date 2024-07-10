package br.com.senac.library;

import br.com.senac.library.gui.Login;

/**
 *
 * @author kenzo
 */
public class Main {

    /**
     * O método inicializador do programa
     *
     * @param args Os argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        // Inicializa a interface gráfica do usuário dentro do thread de eventos AWT/Swing.
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
