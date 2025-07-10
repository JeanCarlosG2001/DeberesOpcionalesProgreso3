import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JComboBox cboMarca;
    private JComboBox cboProcesador;
    private JComboBox cboRam;
    private JButton BtnAgregar;
    private JTextArea txtListar;
    private JTextField txtCodigo;
    private JPanel Ventana;
    private Arbol arbol= new Arbol();


    public Ventana() {
        BtnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtCodigo.getText());
                String marca = cboMarca.getSelectedItem().toString();
                String procesador = cboProcesador.getSelectedItem().toString();
                int ram = Integer.parseInt(cboRam.getSelectedItem().toString());
                Computador nuevo = new Computador(id, marca, procesador, ram);
                arbol.insertar(nuevo);
                txtListar.setText(arbol.inorden());


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
