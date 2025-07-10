public class Arbol {
    private Nodo raiz;
    public Arbol() {
        raiz = null;
    }


    private void insertar(Nodo actual, Computador dato) {
        if(actual.getComputador().getCodigo() > dato.getCodigo()) {
            if(actual.getIzquierda() == null) {
                actual.setIzquierda(new Nodo(dato));
            } else {
                insertar(actual.getIzquierda(), dato);
            }
        } else {
            if(actual.getDerecha() == null) {
                actual.setDerecha(new Nodo(dato));
            } else {
                insertar(actual.getDerecha(), dato);
            }
        }
    }
    public void insertar(Computador computador) {
        if (raiz == null) {
            raiz = new Nodo(computador);
        } else {
            insertar(raiz, computador);
        }
    }

    private String inorden(Nodo actual) {
        if (actual != null) {
            return inorden(actual.getIzquierda()) + actual.getComputador().toString() + inorden(actual.getDerecha());
        } else {
            return "";
        }
    }

    public String inorden() {
        if (raiz == null) {
            return "No hay elementos en el arbol";
        } else {
            return inorden(raiz);
        }
    }
}
