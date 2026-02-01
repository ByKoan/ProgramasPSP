public class Raton {

    private String nombre;
    private int tiempoAlimentacion;

    public Raton(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.println("El raton " + this.nombre + " Ha comenzado a alimentarse.");
            Thread.sleep(this.tiempoAlimentacion*1000);
            System.out.println("El raton " + this.nombre + " Ha terminado de comer.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
