package utfpr.edu.br.socket;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerMultipleRequests {

    public static ServerSocket servidor;
    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;
    
    public static void main(String[] args) {
        
        try {
            System.out.println("Starting socket server in port 5000...");
            // iniciar o servidor
            servidor = new ServerSocket(5000);

            Boolean status = true;

            while (status) {
                // receber dados do cliente
                conexao = servidor.accept();

                entrada = new DataInputStream(conexao.getInputStream());
                String nome = entrada.readUTF();

                if (nome.equalsIgnoreCase("CLOSE")) status = false;

                System.out.println("Received name from client: " + nome);

                // processar esses dados
                String retorno = nome.toUpperCase();

                // enviar dados para o cliente
                saida = new DataOutputStream(conexao.getOutputStream());
                saida.writeUTF(retorno);

                // fechar a conexao
                if (!status) {
                    System.out.println("Shutting down server socket...");
                    conexao.close();
                }
            }

            
        } catch (IOException ex) {
            Logger.getLogger(ServerMultipleRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
