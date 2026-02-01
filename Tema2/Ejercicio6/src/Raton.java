public class Raton implements Runnable{

    private String nombre;
    private int tiempoAlimentacion;
    private int alimentoConsumido;

    public Raton(String nombre, int tiempoAlimentacion, int alimentoConsumido) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
        this.alimentoConsumido = alimentoConsumido;
    }

    public void comer() {
        try {
            System.out.println("El raton " + this.nombre + " ha empezado a comer");
            Thread.sleep(this.tiempoAlimentacion*1000);
            this.alimentoConsumido++;
            System.out.println("El raton " + this.nombre + " ha terminado de comer");
            System.out.println("El raton " + this.nombre + " ha consumido " + this.alimentoConsumido + " alimentos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {this.comer();}
}
