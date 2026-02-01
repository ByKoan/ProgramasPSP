package servidor;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        PrincipalChat main = new PrincipalChat();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            // 1. Usar ServerSocket para esperar conexiones en el puerto 11111
            // El '100' es el 'backlog' o cola máxima de clientes esperando
            ServerSocket servidor = new ServerSocket(11111, 100);
            main.mostrarMensaje("Esperando cliente ...");

            while (true) {
                try {
                    // 2. accept() bloquea el programa hasta que llega un cliente [cite: 494]
                    // Devuelve un objeto de tipo Socket para la 'conexion' [cite: 401]
                    Socket conexion = servidor.accept();

                    // 3. Corregido: getInetAddress (doble 'd')
                    main.mostrarMensaje("Conectado a: " + conexion.getInetAddress().getHostName());
                    main.habilitarTexto(true);

                    // 4. Se lanzan los hilos para este cliente específico [cite: 514, 515]
                    executor.execute(new ThreadRecibe(conexion, main));
                    executor.execute(new ThreadEnvia(conexion, main));

                } catch (IOException ex) {
                    Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        executor.shutdown();
    }
}
