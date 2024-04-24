package org.example.imagemanagementtool;

import java.awt.image.BufferedImage;

// This interface will be used to notify interested parties (observers) when a new image is loaded.
public interface ImageChangeListener {
    void imageChanged(BufferedImage newImage);
}
