package recurrence.graphics;

import util.AppFrame;

import java.awt.*;

public class Spiral extends Canvas
{
    private final int alpha = 10;

    public void drawSpiral(int straight, int x, int y)
    {
        Graphics g = this.getGraphics();
        if(straight > 0)
        {
            g.drawLine(x, y, x + straight, y);
            g.drawLine(x + straight, y, x + straight, y + straight);
            g.drawLine(x + straight, y + straight, x + alpha, y + straight);
            g.drawLine(x + alpha, y + straight, x + alpha, y + alpha);

            drawSpiral(straight - 2 * alpha, x + alpha, y + alpha);
        }
    }

    public void paint(Graphics g)
    {
        int with = this.getWidth();
        drawSpiral(with - 50, 15, 15);
    }

    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        Point location = new Point(300, 500);
        short sizeX = 800;
        short sizeY = 800;
        AppFrame appFrame = new AppFrame("Recurrence Spiral", location, sizeX, sizeY);

        appFrame.getContentPane().add(spiral);
        appFrame.setVisible(true);
    }
}
