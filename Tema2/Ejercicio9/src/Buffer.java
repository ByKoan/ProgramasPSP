public class Buffer {
    private int data;
    private boolean empty = true;

    public synchronized void produce(int value) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        data = value;
        empty = false;
        System.out.println("Producido: " + value);
        notify();
    }

    public synchronized int consume() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        empty = true;
        System.out.println("Consumido " + data);
        notify();
        return data;
    }
}
