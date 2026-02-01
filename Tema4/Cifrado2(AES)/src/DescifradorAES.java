import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;

public class DescifradorAES {

    public static void main(String[] args) {
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "Confucio";

        String donde = System.getProperty("os.name");
        donde = donde.substring(0, 3);
        String home = System.getProperty("user.home");
        String ubicacion = "";
        if(donde.equals("Mac")) {
            ubicacion = home + "/Documents/" + NOMBRE_FICHERO;
            System.out.println("El sistema es: " + donde); }
        else if (donde.equals("Win")) {
            System.out.println("El sistema es: " + donde);
            ubicacion = home+"\\Mis documentos\\" + NOMBRE_FICHERO;}
        else
            ubicacion = NOMBRE_FICHERO;

        try {
            File fichero = new File(ubicacion);
            Key clave = ManejadorAES.obtenerClave(PASSWORD);
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String textoCifrado = br.readLine();
            String TextoEnClaro = ManejadorAES.descifrar(textoCifrado, clave);
            br.close();
            System.out.println("El mensaje cifrado es: " + TextoEnClaro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
