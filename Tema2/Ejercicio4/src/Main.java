void main() {
    Raton fievel = new Raton("Fievel", 4);
    Raton jerry = new Raton("Jerry", 5);
    Raton pinky = new Raton("Pinky", 3);
    Raton mickey = new Raton("Mickey", 6);

    new Thread(fievel).start();
    new Thread(jerry).start();
    new Thread(pinky).start();
    new Thread(mickey).start();
}
