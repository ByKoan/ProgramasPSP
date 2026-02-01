public class Consumidor extends Thread{
    private Buffer buffer;

    public Consumidor (Buffer buffer) {
        this.buffer=buffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.consume();
        }
    }

    public void start() {
    }
}
