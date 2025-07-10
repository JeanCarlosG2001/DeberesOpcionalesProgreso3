import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtNombre;
    private JTextField txtRendimiento;
    private JComboBox cboPosicion;
    private JButton btnRegistrar;
    private JTextArea txtListado;
    private JSpinner spCodigo;
    private JButton btnBuscar;
    private JButton btnMostrar;
    private Equipo eq1 = new Equipo();
    public Ventana()
    {
        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //algoritmo solo para registrar jugador
                String nombre = txtNombre.getText();
                float ren = Float.parseFloat(txtRendimiento.getText());
                String pos = cboPosicion.getSelectedItem().toString();
                Jugador n = new Jugador(-1, nombre, ren, pos);
                eq1.agregarJugador(n);
                //para que se muestre, cada que agregamos 1 se va a refrescar y listar todos los jugadores
                txtListado.setText(eq1.listarTodos());
            }
        });
        //primero crear variable codigo
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int codigo = Integer.parseInt(spCodigo.getValue().toString());
                try
                {
                    Jugador j = eq1.buscarJugador(codigo);
                    //este jugador se lista con sus atributos en el text area
                    txtListado.setText(j.toString());
                }catch (Exception ex)
                        //si se muestra un error lo vamos a capturar y mostrar al usuario
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                }

            }
        });
        btnMostrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //mostrar otra vez todos los elmeentos
                txtListado.setText(eq1.listarTodos());
            }
        });
    }

    //generar for main

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
