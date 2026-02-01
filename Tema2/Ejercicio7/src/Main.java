void main() {
    HiloTrabajando hilo = new HiloTrabajando();

    hilo.start();

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    hilo.interrupt();
}
