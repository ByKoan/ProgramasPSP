void main() {
    Buffer buffer = new Buffer();

    Productor pr = new Productor(buffer);
    Consumidor cs = new Consumidor(buffer);

    pr.start();
    cs.start();
}
