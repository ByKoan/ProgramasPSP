package cliente;

import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import static cliente.PrincipalChat.ip;

public class Main {
    public static void main(String[] args) {
        PrincipalChat main = new PrincipalChat();
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            main.mostrarMensaje("Buscando servidor ...");

            // El PDF usa getByName para obtener una única dirección válida
            Socket cliente = new Socket(InetAddress.getByName(PrincipalChat.ip), 11111);

            // Corregido: getInetAddress() devuelve el objeto para obtener el nombre del host [cite: 210]
            main.mostrarMensaje("Conectado a: " + cliente.getInetAddress().getHostName());

            main.habilitarTexto(true); // Activa el campo para escribir [cite: 211]

            // Se lanzan los hilos para gestionar envío y recepción simultáneos
            executor.execute(new ThreadRecibe(cliente, main));
            executor.execute(new ThreadEnvia(cliente, main));

        } catch (IOException ex) {
            Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        executor.shutdown();
    }
}
