package org.example.imagemanagementtool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.UUID;

/**
 * Acts as an observer that reacts to image changes and provides conversion functionality.
 * This class allows users to choose a format, convert, and download the image.
 */

public class ConversionPanel extends JPanel implements ImageChangeListener {
    private final JComboBox<String> formatBox; // Dropdown for selecting the image format
    private BufferedImage image;  // Holds the current image to be saved

    public ConversionPanel() {
        setLayout(new FlowLayout());

        formatBox = new JComboBox<>(new String[]{"JPEG", "PNG", "BMP","JPG"});
        JButton saveButton = new JButton("Save Image");

        saveButton.addActionListener(e -> saveImage()); // Add action listener to save button

        add(formatBox);
        add(saveButton);
    }

    /**
     * This method updates the current image when an image change is notified.
     * @param newImage The new image to be set.
     */
    @Override
    public void imageChanged(BufferedImage newImage) {
        this.image = newImage;
    }

    /**
     * Saves the current image to a file in the selected format.
     */
    private void saveImage() {
        if (image == null) {
            JOptionPane.showMessageDialog(this, "No image loaded to save!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        String selectedFormat = (String) formatBox.getSelectedItem(); // Get the selected format from the dropdown
        assert selectedFormat != null;

        UUID uuid = UUID.randomUUID(); // get a  random uuid

        fileChooser.setSelectedFile(new File("saved_image_" + uuid + "."  + selectedFormat.toLowerCase()));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                // Check if the selected format is JPEG and if the original image has an alpha channel (transparency).
                if ("JPEG".equalsIgnoreCase(selectedFormat) || "JPG".equalsIgnoreCase(selectedFormat) && image.getColorModel().hasAlpha()) {
                    // Create a new BufferedImage without an alpha channel (transparency) to ensure compatibility with JPEG format,
                    // which does not support transparency.
                    BufferedImage rgbImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

                    // Create a Graphics2D object from the new image, which allows us to draw the original image onto the new image.
                    Graphics2D g = rgbImage.createGraphics();

                    // Draw the original image onto the new image. Since the new image is TYPE_INT_RGB, this effectively removes the alpha channel.
                    g.drawImage(image, 0, 0, null);

                    // Dispose of the Graphics2D object to release system resources and allow the image to be saved without holding extra resources.
                    g.dispose();

                    // Replace the original image with the new image that has no alpha channel.
                    // This step is crucial for saving as JPEG, which does not support transparency.
                    image = rgbImage;
                }

                if (!ImageIO.write(image, selectedFormat, fileToSave)) {
                    JOptionPane.showMessageDialog(this, "Failed to save the image.");
                } else {
                    JOptionPane.showMessageDialog(this, "Image saved successfully!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

