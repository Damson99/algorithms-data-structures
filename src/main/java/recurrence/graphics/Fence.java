package recurrence.graphics;

import util.AppFrame;

import java.awt.*;

public class Fence extends Canvas {
    public void drawFence(int n, int straight, int x, int y) {
        Graphics g = this.getGraphics();
        if (n > 0) {
//            square
            g.drawLine(x, y, x + straight, y);
            g.drawLine(x + straight, y, x + straight, y + straight);
            g.drawLine(x + straight, y + straight, x, y + straight);
            g.drawLine(x, y + straight, x, y);
//            four inner circles
            g.drawOval(x, y, straight / 2, straight / 2);
            g.drawOval(x + straight / 2, y, straight / 2, straight / 2);
            g.drawOval(x, y + straight / 2, straight / 2, straight / 2);
            g.drawOval(x + straight / 2, y + straight / 2, straight / 2, straight / 2);
//            circles in circles with smaller size
            drawFence(n - 1, straight / 2, x, y);
            drawFence(n - 1, straight / 2, x + straight / 2, y);
            drawFence(n - 1, straight / 2, x, y + straight / 2);
            drawFence(n - 1, straight / 2, x + straight / 2, y + straight / 2);
        }
    }

    public void paint(Graphics g) {
        int width = this.getWidth();
        drawFence(5, width - width / 10, 5, 5);
    }

    public static void main(String[] args) {
        Fence fence = new Fence();
        Point location = new Point(100, 100);
        short sizeX = 1000;
        short sizeY = 1000;
        AppFrame appFrame = new AppFrame("Fence", location, sizeX, sizeY);
        appFrame.getContentPane().add(fence);
        appFrame.setVisible(true);
    }
}
