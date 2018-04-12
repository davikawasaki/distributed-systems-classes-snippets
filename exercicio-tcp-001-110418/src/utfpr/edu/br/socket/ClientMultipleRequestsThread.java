package utfpr.edu.br.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientMultipleRequestsThread {

    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            // conectar com o servidor
            conexao = new Socket("localhost",5000);

            ClientThread client = new ClientThread(conexao);
            client.run();

            // fechar conexao
            conexao.close();


        } catch (IOException ex) {
            Logger.getLogger(ClientMultipleRequests.class.getName()).log(Level.SEVERE, null, ex);
        }





    }

}
