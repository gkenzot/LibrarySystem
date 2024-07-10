package br.com.senac.library.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A classe Criptografia fornece métodos estáticos para criptografar textos usando o algoritmo MD5.
 * 
 * Esta classe utiliza a implementação do algoritmo de hash MD5 fornecida pelo pacote java.security.
 * 
 * @author kenzo
 */
public class Criptografia {

    /**
     * Retorna a representação hexadecimal da hash MD5 do texto fornecido.
     * 
     * @param texto O texto a ser criptografado.
     * @return A representação hexadecimal da hash MD5 do texto.
     */
    public static String getMD5(String texto) {
        try {
            // O método estático getInstance é chamado com hash MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // O método digest() é chamado para calcular a hash da mensagem 
            // E enfim temos o vetor da mensagem
            byte[] messageDigest = md.digest(texto.getBytes());
            // Convertemos o vetor de bytes em um BigInt 
            BigInteger no = new BigInteger(1, messageDigest);
            // A mensagem em BigInt é convertid a para hexadecimal 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        // Em caso de erro, é lançada uma exceção
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
