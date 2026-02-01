void main() {
    Raton raton = new Raton();

    Thread hilo = new Thread(raton);
    hilo.start();

    MiHilo miHilo = new MiHilo();
    miHilo.start();
}
