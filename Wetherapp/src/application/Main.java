package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
        	Parent root = FXMLLoader.load(getClass().getResource("WeatherGUI.fxml"));
            Scene scene = new Scene(root);

            // Set the controller and scene
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Weather");

            // Set the stage size (width and height)
            stage.setWidth(400);
            stage.setHeight(600);

            // Make the stage not resizable
            stage.setResizable(false);

            stage.show();
        } catch (IOException e) {
            // Handle exceptions (e.g., connection error)
            e.printStackTrace();
            Throwable cause = e.getCause();
            if (cause != null) {
                cause.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
