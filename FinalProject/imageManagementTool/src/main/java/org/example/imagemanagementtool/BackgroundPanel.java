package org.example.imagemanagementtool;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * This class sets up the background of the panel
 */

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String filename) {
        setLayout(new BorderLayout());
        try {
            backgroundImage = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the background
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}

