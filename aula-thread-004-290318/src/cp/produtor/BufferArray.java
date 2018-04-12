package cp.produtor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// Aplicativo mostra duas threads que manipulam um buffer sincronizado.

public class BufferArray {

    public static void main(String[] args) {
        // cria novo pool de threads com duas threads
        ExecutorService application = Executors.newFixedThreadPool(2);

        // cria SynchronizedBuffer para armazenar ints
        //Buffer locacaoCompartilhada = new BufferSincronizado();
        Buffer locacaoCompartilhada = new BufferSincronizadoArray();

        System.out.println("Ação\t\t\t\tArrayPos\t\tOperação");
        System.out.println("----\t\t\t\t-----\t\t-------\n");

        //iniciar a produtora e a consumidora        
        application.execute(new Produtor(locacaoCompartilhada));
        application.execute(new Consumidor(locacaoCompartilhada));

        application.shutdown();
    } // fim de main
} // fim da classe BufferArray
