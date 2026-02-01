package cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class PrincipalChat extends JFrame {
    public JTextField campoTexto;
    public JTextArea areaTexto;
    private static Socket cliente;
    public static String ip = "127.0.0.1"; // IP del servidor [cite: 137]

    public PrincipalChat() {
        super("Cliente"); // Título de la ventana [cite: 140]

        // 1. Inicializar el campo de texto (arriba)
        campoTexto = new JTextField();
        campoTexto.setEditable(false);
        add(campoTexto, BorderLayout.NORTH);

        // 2. SOLUCIÓN AL ERROR: Inicializar areaTexto antes de usarla
        areaTexto = new JTextArea(); // <--- ESTA LÍNEA FALTABA [cite: 144]
        areaTexto.setEditable(false);

        // 3. Configurar apariencia
        areaTexto.setBackground(Color.orange); // Ahora ya no dará error [cite: 147]
        areaTexto.setForeground(Color.black);
        campoTexto.setForeground(Color.black);

        // 4. Añadir scroll al área de texto y ponerla en el centro
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Configuración del Menú
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem salir = new JMenuItem("Salir");
        menuArchivo.add(salir);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(menuArchivo);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(300, 320);
        setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        areaTexto.append(mensaje + "\n");
    }

    public void habilitarTexto(boolean editable) {
        campoTexto.setEditable(editable);
    }
}