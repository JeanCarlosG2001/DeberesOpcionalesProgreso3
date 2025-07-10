import javax.swing.*;

public class Ventana {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.add(new MiPanel());
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
