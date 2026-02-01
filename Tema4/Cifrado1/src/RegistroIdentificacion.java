import javax.swing.*;

public class RegistroIdentificacion extends JFrame{

    private JTextField tUser;
    private JTextField tPassword;

    public RegistroIdentificacion () {
        super("Registro");
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel();
        JLabel lUser = new JLabel("Usuario");
        tUser = new JTextField("");
        tUser.setColumns(15);

        JLabel lPassword = new JLabel ("Contraseña");
        tPassword = new JTextField("");
        tPassword.setColumns(15);

        p1.add(lUser);
        p1.add(tUser);
        p1.add(lPassword);
        p1.add(tPassword);

        this.add(p1);

        JPanel p2 = new JPanel();
        JButton bGuardar = new JButton("Cifrar");
        bGuardar.addActionListener(new GestorCifrar(this));

        JButton bSalir = new JButton("Salir");
        bSalir.addActionListener(new GestorSalir());

        p2.add(bGuardar);
        p2.add(bSalir);
        this.add(p2);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getTUser() {
        return tUser;
    }

    public JTextField getTPassword() {
        return tPassword;
    }
}
