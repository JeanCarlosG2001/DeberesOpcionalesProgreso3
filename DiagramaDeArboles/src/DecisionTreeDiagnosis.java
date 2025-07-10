import java.util.Scanner;

// Clase Node: Representa un nodo del árbol (pregunta o resultado)
class Node {
    String pregunta; // Pregunta o resultado final
    Node izquierda;  // Respuesta "sí"
    Node derecha;    // Respuesta "no"

    public Node(String pregunta) {
        this.pregunta = pregunta;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class DecisionTreeDiagnosis {
    // Método para evaluar el árbol recursivamente
    public void evaluar(Node nodo, Scanner sc) {
        // Si es una hoja (sin hijos), muestra el resultado
        if (nodo.izquierda == null && nodo.derecha == null) {
            System.out.println("Resultado: " + nodo.pregunta);
            return;
        }
        // Muestra la pregunta y espera respuesta
        System.out.print(nodo.pregunta + " (sí/no): ");
        String respuesta = sc.nextLine().toLowerCase();
        // Avanza según la respuesta
        if (respuesta.equals("sí") || respuesta.equals("si")) {
            evaluar(nodo.izquierda, sc);
        } else {
            evaluar(nodo.derecha, sc);
        }
    }

    // Método para construir el árbol completo
    public Node construirArbol() {
        // Nodo raíz: Pregunta inicial
        Node raiz = new Node("¿Tiene fiebre?");
        // Rama "sí" para fiebre
        raiz.izquierda = new Node("¿Tiene tos?");
        raiz.izquierda.izquierda = new Node("¿Tiene dolor de garganta?");
        raiz.izquierda.izquierda.izquierda = new Node("Posible gripe");
        raiz.izquierda.izquierda.derecha = new Node("Posible infección leve");
        raiz.izquierda.derecha = new Node("Posible infección leve");
        // Rama "no" para fiebre
        raiz.derecha = new Node("¿Tiene tos?");
        raiz.derecha.izquierda = new Node("Posible infección leve");
        raiz.derecha.derecha = new Node("Probablemente está sano");
        return raiz;
    }

    // Método para simular poda (limitando profundidad)
    public Node podarArbol(Node raiz, int nivel, int maxNivel) {
        if (raiz == null || nivel > maxNivel) {
            return null;
        }
        // Conserva el nodo actual, pero poda los hijos si excede el nivel
        Node nuevoNodo = new Node(raiz.pregunta);
        nuevoNodo.izquierda = podarArbol(raiz.izquierda, nivel + 1, maxNivel);
        nuevoNodo.derecha = podarArbol(raiz.derecha, nivel + 1, maxNivel);
        // Si es un nodo intermedio sin hijos tras la poda, convierte en hoja
        if (nuevoNodo.izquierda == null && nuevoNodo.derecha == null && nivel < maxNivel) {
            nuevoNodo.pregunta = "Resultado indeterminado";
        }
        return nuevoNodo;
    }

    public static void main(String[] args) {
        DecisionTreeDiagnosis arbol = new DecisionTreeDiagnosis();
        Scanner sc = new Scanner(System.in);

        // Construir árbol completo
        System.out.println("=== Árbol de Decisión: Diagnóstico Médico ===");
        Node raiz = arbol.construirArbol();

        // Evaluar árbol completo
        System.out.println("Evaluando árbol completo:");
        arbol.evaluar(raiz, sc);

        // Simular poda (limitando a 2 niveles)
        System.out.println("\n=== Árbol Podado (máximo 2 niveles) ===");
        Node raizPodada = arbol.podarArbol(raiz, 1, 2);
        arbol.evaluar(raizPodada, sc);

        sc.close();

        // Nota sobre mejoras con Weka:
        // Para datasets reales, usa Weka con J48:
        // import weka.classifiers.trees.J48;
        // J48 tree = new J48();
        // tree.buildClassifier(data);
        // Esto genera árboles dinámicos desde archivos CSV.
    }
}