public class Puente {
    private static final int PESO_MAXIMO = 200;
    private static final int MAX_PERSONAS = 3;
    private int peso;
    private int numPersonas;

    public Puente(){
        this.peso = 0;
        this.numPersonas = 0;
    }

    public Puente(int peso, int numPersonas) {
        this.peso = peso;
        this.numPersonas = numPersonas;
    }

    synchronized public int getPeso() {return peso;}
    synchronized public int getNumPersonas() {return numPersonas;}
    synchronized public boolean autorizacionPaso(Persona persona) {

    }
}
