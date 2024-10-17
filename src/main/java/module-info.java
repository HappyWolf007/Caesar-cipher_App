module com.example.caesarcipher_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.caesarcipher_app to javafx.fxml;
    exports com.example.caesarcipher_app;
}