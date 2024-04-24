package org.example.imagemanagementtool;

import javax.swing.SwingUtilities;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ObservableImage imageModel = new ObservableImage();
            ImageFrame frame = new ImageFrame(imageModel);
            frame.setVisible(true);
        });

    }
}
