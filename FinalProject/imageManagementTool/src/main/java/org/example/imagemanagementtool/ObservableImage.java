package org.example.imagemanagementtool;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

// This class acts as the subject that notifies observers about the image change.
public class ObservableImage {
    private BufferedImage image;
    private List<ImageChangeListener> listeners = new ArrayList<>();

    public void setImage(BufferedImage img) {
        this.image = img;
        notifyListeners();
    }

    public void addListener(ImageChangeListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (ImageChangeListener listener : listeners) {
            listener.imageChanged(image);
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}

