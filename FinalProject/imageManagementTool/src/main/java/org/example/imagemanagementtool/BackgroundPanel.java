package org.example.imagemanagementtool;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

/**
 * This class sets up the background of the panel
 */

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String resourcePath)  {
        setLayout(new BorderLayout());
        try {
            // Use getResourceAsStream to read the file as a stream
            backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(resourcePath)));
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

