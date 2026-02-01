public class Hilo extends Thread{

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println(i);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}
