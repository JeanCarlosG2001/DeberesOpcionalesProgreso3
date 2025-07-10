import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MiPanel extends JPanel implements MouseListener {
    private ArrayList<Vertice> vertices;
    private ArrayList<Arista> aristas;
    private Point p1, p2;

    public MiPanel() {
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
        this.addMouseListener(this);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Vertice v : vertices) {
            v.pintar(g);
        }
        for (Arista a : aristas) {
            a.pintar(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            vertices.add(new Vertice(e.getX(), e.getY()));
            repaint();
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            for(Vertice v : vertices) {
                if (new Rectangle(v.getX() - Vertice.diametro / 2,
                                  v.getY() - Vertice.diametro / 2,
                                    Vertice.diametro,
                        Vertice.diametro).contains(e.getPoint())) {
                    if (p1 == null) {
                        p1 = new Point(e.getX(), e.getY());
                    }else {
                        p2 = new Point(e.getX(), e.getY());
                        aristas.add(new Arista(p1.x, p1.y, p2.x, p2.y));
                        repaint();
                        p1 = null;
                        p2 = null;
                    }


                }
            }

        }
    }
    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
