package org.example.imagemanagementtool;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.*;

/**
 * This class sets up the main window and initializes components.
 */
public class ImageFrame extends JFrame {
    public ImageFrame(ObservableImage imageModel) {
        super("Image Management Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        setLayout(new BorderLayout(10,10)); // set the gap

        getContentPane().setBackground(new Color(245, 245, 245)); // set the background color

        // customize the background
        BackgroundPanel backgroundPanel = new BackgroundPanel("src/background.jpg");
        backgroundPanel.setBorder(new EmptyBorder(20, 10, 20, 10));
        setContentPane(backgroundPanel);

        ImagePanel imagePanel = new ImagePanel(imageModel);
        ConversionPanel conversionPanel = new ConversionPanel();

        imageModel.addListener(conversionPanel); // Registering the observer

        // Set panel transparency to display custom background
        imagePanel.setOpaque(false);
        conversionPanel.setOpaque(false);

        backgroundPanel.add(imagePanel, BorderLayout.CENTER);
        backgroundPanel.add(conversionPanel, BorderLayout.SOUTH);
    }
}
