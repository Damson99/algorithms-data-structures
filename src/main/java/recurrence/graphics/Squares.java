package recurrence.graphics;

import util.AppFrame;

import java.awt.*;

public class Squares extends Canvas {
    public void drawSquares(int n, int straight, int x, int y) {
        Graphics g = this.getGraphics();
        if (n > 0) {
            g.drawLine(x, y, x + straight, y);
            g.drawLine(x + straight, y, x + straight, y + straight);
            g.drawLine(x + straight, y + straight, x, y + straight);
            g.drawLine(x, y + straight, x, y + straight / 2);
            g.drawLine(x, y + straight / 2, x + straight / 2, y + straight);
            g.drawLine(x + straight / 2, y + straight, x + straight, y + straight / 2);
            g.drawLine(x + straight, y + straight / 2, x + straight / 2, y);
            g.drawLine(x + straight / 2, y, x + straight / 4, y + straight / 4);

            drawSquares(n - 1, straight / 2, x + straight / 4, y + straight / 4);
            g.drawLine(x + straight / 4, y + straight / 4, x, y + straight / 2);
            g.drawLine(x, y + straight / 2, x, y);
        }
    }

    public void paint(Graphics g) {
        int with = this.getWidth();
        drawSquares(10, 700, 15, 15);
    }

    public static void main(String[] args) {
        Squares squares = new Squares();
        Point location = new Point(300, 500);
        short sizeX = 800;
        short sizeY = 800;
        AppFrame appFrame = new AppFrame("Recurrence Squares", location, sizeX, sizeY);

        appFrame.getContentPane().add(squares);
        appFrame.setVisible(true);
    }
}
