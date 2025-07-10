import java.awt.*;

public class Vertice {

    private int x,y;
    public static final int diametro = 60;

    public Vertice(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void pintar(Graphics g) {
        g.drawOval(x-diametro/2, y-diametro/2, diametro, diametro);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
