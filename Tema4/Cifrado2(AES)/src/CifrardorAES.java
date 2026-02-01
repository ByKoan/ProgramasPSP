import java.io.PrintWriter;
import java.security.Key;

public class CifrardorAES {
    public static void main(String[] args) {
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "Confucio";
        final String TEXTO_EN_CLARO = "La ignorancia es la noche de la mente, pero una noche sin luna ni estrellas";

        try {
            Key clave = ManejadorAES.obtenerClave(PASSWORD);
            String textoEnClaro = TEXTO_EN_CLARO;
            String textoCifrado = ManejadorAES.cifrar(textoEnClaro, clave);

            String donde = System.getProperty("os.name");
            donde = donde.substring(0, 3);
            String home = System.getProperty("user.home");
            String ubicacion="";
            if(donde.equals("Mac")) {
                System.out.println("El sistema es: " + donde);
                ubicacion = home + "/Documents/" + NOMBRE_FICHERO;
                System.out.println("El archivo se ha cifrado en: " + ubicacion);}
            else if(donde.equals("Win")) {
                System.out.println("El sistema es: " + donde);
                ubicacion = home + "\\Mis documentos\\" + NOMBRE_FICHERO;
                System.out.println("El archivo se ha cifrado en: " + ubicacion); }
            else
                ubicacion = NOMBRE_FICHERO;

            PrintWriter pw = new PrintWriter(ubicacion);
            pw.write(textoCifrado);
            pw.close();
            System.out.println("El mensaje se ha cifrado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
