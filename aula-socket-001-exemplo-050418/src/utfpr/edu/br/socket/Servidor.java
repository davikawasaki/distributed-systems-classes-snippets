package utfpr.edu.br.socket;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {

    public static ServerSocket servidor;
    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;
    

    public static void main(String[] args) {
        
        try {
            // iniciar o servidor
            servidor = new ServerSocket(5000);
            
            // receber requisicoes
            conexao = servidor.accept();
            entrada = new DataInputStream(conexao.getInputStream());
            String dados = entrada.readUTF();
            
            // tratar requisicoes
            String resultado = dados.toUpperCase();
            
            // enviar resposta
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(resultado);
            
            // fechar conexao
            conexao.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
    
}
