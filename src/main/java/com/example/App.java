package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URISyntaxException;

import com.example.api.ApiClient;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    
    private  static Parent loadFXML(String fxml) throws IOException {
    try {
        // Adjust the path to reflect the new location under com/example/fxml
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/example/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}


    public static void main(String[] args) {
        launch();

        // login to ABS
        try {
            ApiClient.setUsername("root");
            ApiClient.setPassword("spock");
            ApiClient.setUri("https://abs.reda-akherfi.me/login");

            ApiClient.login();
        }catch (URISyntaxException e) {
            System.out.println("-------- Incorrect URI: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("-------- IO exception " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("-------- interrupted" + e.getMessage());
        }
    }

}
