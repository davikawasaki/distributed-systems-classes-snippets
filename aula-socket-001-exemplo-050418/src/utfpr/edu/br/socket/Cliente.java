package utfpr.edu.br.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente {

    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;

    
    public static void main(String[] args) {
        try {
            // abrir conexao
            conexao = new Socket("localhost",5000);
            
            // pegar dados cliente
            String requisicao = JOptionPane.showInputDialog("Digite seu nome");
            
            // enviar dados
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(requisicao);
            
            // receber dados
            entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();
            
            // mostrados dados
            System.out.println("Resposta do servidor : "+resposta);
            
            // fechar conexao
            conexao.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
