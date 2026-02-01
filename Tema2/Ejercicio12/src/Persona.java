package pasoporpuente;

import java.util.Random;

public class Persona implements Runnable {

    private final int dni;
    private final int peso;
    private final int tMinPaso, tMaxPaso;
    private final Puente puente;

    public Persona(Puente puente, int peso, int tMinPaso, int tMaxPaso, int dni) {
        this.dni = dni;
        this.peso = peso;
        this.tMinPaso = tMinPaso;
        this.tMaxPaso = tMaxPaso;
        this.puente = puente;
    }

    public int getDNI() { return this.dni; }
    public int getPeso() { return this.peso; }
    public int getTMinPaso() { return this.tMinPaso; }
    public int getTMaxPaso() { return this.tMaxPaso; }
    public Puente getPuente() { return this.puente; }

    @Override
    public void run() {
        System.out.println(this.dni + " que pesa " + this.peso + "kg quiere cruzar. " +
                "En el puente hay " + puente.getNumPersonas() + " personas y " +
                "en total pesan " + puente.getPeso() + "Kg.");

        // PEDIR PASO
        Boolean autorizado = false;
        while (!autorizado) {
            synchronized (this.puente) {
                autorizado = this.puente.autorizacionPaso(this);
                if (!autorizado) {
                    System.out.println(this.dni + " NO tiene autorización para pasar.");
                    try {
                        this.puente.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(this.dni + " estaba esperando y recibe INTERRUPCIÓN.");
                    }
                }
            }
        }

        // CRUZAR
        System.out.println(this.dni + " que pesa " + this.peso + " tiene autorización. " +
                "Con ella, en el puente hay " + puente.getNumPersonas() + " personas y " +
                "en total pesan " + puente.getPeso() + "Kg.");

        Random r = new Random();
        int tEnCruzar = this.tMinPaso + r.nextInt(this.tMaxPaso - this.tMinPaso + 1);
        System.out.println(this.dni + " va a tardar " + tEnCruzar + " segundos en cruzar.");

        try {
            Thread.sleep(tEnCruzar * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupción mientras " + this.dni + " está cruzando.");
        }

        // SALIR DEL PUENTE
        synchronized (this.puente) {
            System.out.println(this.dni + " que pesa " + this.peso + " quiere salir del puente. " +
                    "En el puente hay " + puente.getNumPersonas() + " personas y " +
                    "en total pesan " + puente.getPeso() + "Kg.");

            this.puente.terminaPaso(this);

            System.out.println(this.dni + " ha salido del puente. " +
                    "Ahora en el puente hay " + puente.getNumPersonas() + " personas y " +
                    "en total pesan " + puente.getPeso() + "Kg.");

            puente.notifyAll();
        }
    }
}
