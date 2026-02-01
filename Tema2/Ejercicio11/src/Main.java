void main() {
    UsoSemaforos us = new UsoSemaforos();
    for (int i = 0; i < 5; i++) {
        new Thread(us).start();
    }
}
