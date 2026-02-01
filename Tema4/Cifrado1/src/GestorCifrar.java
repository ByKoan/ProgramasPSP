import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;

public class GestorCifrar implements ActionListener {
    JTextField tUser;
    JTextField tPassword;
    private static final String ENCODING_TYPE = "UTF-8";

    GestorCifrar(RegistroIdentificacion registro) {
        this.tUser = registro.getTUser();
        this.tPassword = registro.getTPassword();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("El usuario introducido es: " + tUser.getText());
        System.out.println("La contraseña introducida es: " + tPassword.getText());

        try {
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
            algoritmo.reset();
            algoritmo.update(tPassword.getText().getBytes(ENCODING_TYPE));
            byte[] resumen = algoritmo.digest();
            String resumenHexadecimal = String.format("%064x", new BigInteger(1, resumen));
            System.out.println("La clave cifrada es: " + resumenHexadecimal);
        } catch (Exception ex) {
            System.err.println("Ha ocurrido un error cifrando la contraseña");
        }
    }
}
