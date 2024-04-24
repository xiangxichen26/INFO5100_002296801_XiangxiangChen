package org.example.imagemanagementtool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * This class handles image loading and updates the ObservableImage.
 */

public class ImagePanel extends JPanel {
    private JLabel imageLabel; // Label to display the image
    private JTextArea metadataText; // Text area to display image metadata
    private ObservableImage imageModel; // Reference to the shared image model
    private JTextArea imageName; // Scrollable container for text areas
    private JScrollPane scrollPane;
    public ImagePanel(ObservableImage imageModel) {
        this.imageModel = imageModel;
        setLayout(new BorderLayout());

        // Create components but do not add them yet
        imageLabel = new JLabel();
        imageName = new JTextArea(2,20);
        imageName.setEditable(false);
        metadataText = new JTextArea(3, 20);
        metadataText.setEditable(false);

        JButton openButton = new JButton("Open Image");
        openButton.addActionListener(e -> openImage());

        // Create a panel to hold both image name and metadata text areas
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(imageName);
        textPanel.add(metadataText);
        scrollPane = new JScrollPane(textPanel);

        add(openButton, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);
    }

    /**
     * Opens a file chooser to select an image, loads it, and updates the shared image model.
     * Once an image is loaded, image and metadata components are added.
     */
    private void openImage() {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                BufferedImage image = ImageIO.read(file);
                imageModel.setImage(image); // Update observable image
                ImageIcon icon = new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH));

                // Update the existing label and text areas
                imageLabel.setIcon(icon);
                imageName.setText("File Name: " + file.getName());
                metadataText.setText("Metadata: \n" + ImageUtils.extractBasicMetadata(file));

                // If scrollPane is not currently added, add it
                if (!isScrollPaneAdded()) {
                    add(scrollPane, BorderLayout.SOUTH);
                }

                // Refresh the panel to display new components
                revalidate();
                repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error loading image!");
            }
        }
    }

    // Helper method to check if scrollPane is already added to this panel
    private boolean isScrollPaneAdded() {
        for (Component comp : getComponents()) {
            if (comp.equals(scrollPane)) {
                return true;
            }
        }
        return false;
    }
}
