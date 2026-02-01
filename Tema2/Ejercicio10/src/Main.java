void main() {
    Hilo h1 = new Hilo();
    Hilo h2 = new Hilo();
    Hilo h3 = new Hilo();

    h1.start();
    try {
        h1.join();
    } catch (InterruptedException e) {
        System.out.println(e);
    }

    h2.start();
    h3.start();
}
