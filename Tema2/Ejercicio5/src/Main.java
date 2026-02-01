void main() {
    Raton mickey = new Raton("Mickey", 3);

    ArrayList<Thread.State> estadoHilo = new ArrayList();

    Thread h = new Thread(mickey);

    estadoHilo.add(h.getState());
    h.start();

    while (h.getState() != Thread.State.TERMINATED) {
        if (!estadoHilo.contains(h.getState())) {
            estadoHilo.add(h.getState());
        }
    }

    estadoHilo.add(h.getState());
    for (int i=0; i < estadoHilo.size(); i++){
        System.out.println(estadoHilo.get(i));
    }
}
