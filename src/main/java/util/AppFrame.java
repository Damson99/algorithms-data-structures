package util;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public AppFrame(String title, Point location, short sizeX, short sizeY) {
        this.setTitle(title);
        this.setLocation(location);
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
