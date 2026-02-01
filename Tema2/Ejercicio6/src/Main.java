void main() {
    Raton fievel = new Raton("Fievel", 4, 0);
    new Thread(fievel).start();
    new Thread(fievel).start();
    new Thread(fievel).start();
    new Thread(fievel).start();
}
