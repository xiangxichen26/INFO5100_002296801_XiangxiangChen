module org.example.imagemanagementtool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires metadata.extractor;


    opens org.example.imagemanagementtool to javafx.fxml;
    exports org.example.imagemanagementtool;
}