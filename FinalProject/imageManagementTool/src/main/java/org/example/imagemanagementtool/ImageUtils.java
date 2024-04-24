package org.example.imagemanagementtool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {

    /**
     * Extracts basic properties from a given image file.
     * @param imageFile The image file to extract properties from.
     * @return A formatted string containing image properties.
     */
    public static String extractBasicMetadata(File imageFile) {
        StringBuilder metadataString = new StringBuilder();
        try {
            BufferedImage image = ImageIO.read(imageFile);
            if (image != null) {
                metadataString.append("Width: ").append(image.getWidth()).append(" px\n");
                metadataString.append("Height: ").append(image.getHeight()).append(" px\n");
            }
        } catch (IOException e) {
            metadataString.append("Error reading image: ").append(e.getMessage());
        }
        return metadataString.toString();
    }
}
