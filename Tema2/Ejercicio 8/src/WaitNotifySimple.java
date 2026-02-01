public class WaitNotifySimple implements Runnable{
    private volatile boolean ejecutandoMetodo1 = false;

    public synchronized void metodo1 () {
        for (int i = 0; i < 10; i++) {
            System.out.println("Ejecucion " + i);
            if (i==5) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void metodo2() {
        for (int i=10; i<20; i++) {
            System.out.println("Ejecucion "+ i);
            this.notifyAll();
        }
    }

    public void run() {
        if (ejecutandoMetodo1==false) {
            ejecutandoMetodo1 = true;
            metodo1();
        } else {
            metodo2();
        }
    }
}
