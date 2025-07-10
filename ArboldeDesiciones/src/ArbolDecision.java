import java.util.Scanner;

public class ArbolDecision {

    private Nodo raiz;

    public ArbolDecision() {
        // Nivel 1
        raiz = new Nodo("¿Tiene fiebre superior a 38°C?");

        // Nivel 2
        raiz.izquierda = new Nodo("¿La fiebre lleva más de 3 días?");
        raiz.derecha = new Nodo("¿Tiene dolor de garganta?");

        /*********************************************************************/
        // Nivel 3 - Rama izquierda
        raiz.izquierda.izquierda = new Nodo("¿Tiene erupciones en la piel?");
        raiz.izquierda.derecha = new Nodo("¿Tiene dolor de cabeza intenso?");

        // Nivel 3 - Rama derecha
        raiz.derecha.izquierda = new Nodo("¿Tiene congestión nasal?");
        raiz.derecha.derecha = new Nodo("¿Tiene dolor muscular generalizado?");
        /**********************************************************************/

        // Nivel 4 - Hojas del árbol

        // Resultados para fiebre > 3 días
        raiz.izquierda.izquierda.izquierda = new Nodo("Posible varicela - Consulte a un médico");
        raiz.izquierda.izquierda.derecha = new Nodo("Posible infección bacteriana - Consulte a un médico");

        raiz.izquierda.derecha.izquierda = new Nodo("Posible meningitis - Busque atención médica inmediata");
        raiz.izquierda.derecha.derecha = new Nodo("Posible gripe - Descanse y tome líquidos");

        // Resultados para dolor de garganta
        raiz.derecha.izquierda.izquierda = new Nodo("Posible resfriado común - Descanse y tome líquidos");
        raiz.derecha.izquierda.derecha = new Nodo("Posible alergia - Considere antihistamínicos");

        raiz.derecha.derecha.izquierda = new Nodo("Posible gripe - Considere antivirales");
        raiz.derecha.derecha.derecha = new Nodo("Probablemente está sano - Descanse y manténgase hidratado");
    }

    public Nodo getRaiz() {
        return raiz;
    }

}
