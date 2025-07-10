public class Nodo {
    private Computador computador;
    private Nodo izquierda;
    private Nodo derecha;


    public Nodo(Computador computador) {
        this.computador = computador;
        izquierda = null;
        derecha = null;
    }
    public Nodo(Computador computador, Nodo izquierda, Nodo derecha) {
        this.computador = computador;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }


}
