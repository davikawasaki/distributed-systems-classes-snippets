package utfpr.edu.br.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket conexao;
    private Boolean status;

    ServerThread(Socket conexao) {
        this.conexao = conexao;
        this.status = true;
    }

    @Override
    public void run() {

        try {
            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            String nome = entrada.readUTF();

            System.out.println("Received name from client: " + nome);

            // processar esses dados
            String retorno = nome.toUpperCase();

            // enviar dados para o cliente
            DataOutputStream saida = new DataOutputStream(this.conexao.getOutputStream());
            saida.writeUTF(retorno);

            if (nome.equalsIgnoreCase("CLOSE")) status = false;
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public Boolean isRunning() {
        return status;
    }
}
