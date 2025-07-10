import java.awt.*;

public class Arista {
    private int x1, y1, x2, y2;

    public Arista(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void pintar(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

}

