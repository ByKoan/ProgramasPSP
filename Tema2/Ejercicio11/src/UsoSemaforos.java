import java.util.concurrent.Semaphore;

public class UsoSemaforos implements Runnable{

    Semaphore semaforo = new Semaphore(3);

    public void run() {
        try {
            semaforo.acquire();
            System.out.println("Paso1");
            Thread.sleep(1000);
            System.out.println("Paso2");
            Thread.sleep(1000);
            System.out.println("Paso3");
            Thread.sleep(1000);
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
