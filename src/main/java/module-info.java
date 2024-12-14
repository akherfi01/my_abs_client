module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics; // Add this line
    requires transitive java.net.http;
    requires transitive com.fasterxml.jackson.databind;


    // Opening controller for reflection (FXML use)
    opens com.example.controller to javafx.fxml;
    
    // Exports packages to allow use of other classes from this module
    exports com.example;
    exports com.example.controller;
    exports com.example.model;
    exports com.example.api; // If ApiClient and ApiService are being used in other modules
    exports com.example.util; // If you need to use JsonParser elsewhere
}
