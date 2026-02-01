void main() {
    WaitNotifySimple objetoComun = new WaitNotifySimple();

    new Thread(objetoComun).start();
    new Thread(objetoComun).start();
}
