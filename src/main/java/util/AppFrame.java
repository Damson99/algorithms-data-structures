package util;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame
{
    private String title;
    private Point location;
    private int sizeX;
    private int sizeY;

    public AppFrame(String title, Point location, short sizeX, short sizeY)
    {
        this.title = title;
        this.location = location;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.setTitle(title);
        this.setLocation(location);
        this.setSize(sizeX, sizeY);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
