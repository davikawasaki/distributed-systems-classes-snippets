package utfpr.edu.br.socket;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable {

    private Socket conexao;
    private Boolean status;

    ClientThread(Socket conexao) {
        this.conexao = conexao;
        this.status = true;
    }


    @Override
    public void run() {
        try {
            // produzir dados
            String dados = JOptionPane.showInputDialog("Enter your name");

            // enviar dados
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(dados);

            // receber retorno
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();

            // exibir os dados
            System.out.println("Answer from server : "+resposta);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
