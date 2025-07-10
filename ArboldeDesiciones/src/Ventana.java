import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtArea;
    private JButton SIButton;
    private JButton NOButton;
    private JLabel lblNivel;
    private JLabel lblPosicion;

    private Nodo nodoActual;
    private int nivel;
    private String posicion;

    public Ventana() {
        // Crear el árbol
        ArbolDecision arbol = new ArbolDecision();
        nodoActual = arbol.getRaiz();
        nivel = 1;
        posicion = "Raíz";

        // Mostrar la primera pregunta
        actualizarInterfaz();

        // Acción botón SÍ
        SIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nodoActual.izquierda != null) {
                    nodoActual = nodoActual.izquierda;
                    nivel++;
                    posicion += " -> Izquierda";
                    actualizarInterfaz();
                }
            }
        });

        // Acción botón NO
        NOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nodoActual.derecha != null) {
                    nodoActual = nodoActual.derecha;
                    nivel++;
                    posicion += " -> Derecha";
                    actualizarInterfaz();
                }
            }
        });
    }


    private void actualizarInterfaz() {
        lblNivel.setText("Nivel: " + nivel);
        lblPosicion.setText("Posición: " + posicion);

        if (nodoActual.izquierda == null && nodoActual.derecha == null) {
            txtArea.setText("Resultado: " + nodoActual.pregunta);
            SIButton.setEnabled(false);
            NOButton.setEnabled(false);
        } else {
            txtArea.setText(nodoActual.pregunta + " (Sí/No)");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Árbol de Decisión");
        Ventana ventana = new Ventana();
        frame.setContentPane(ventana.principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
