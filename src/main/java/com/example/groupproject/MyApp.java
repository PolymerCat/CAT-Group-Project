package com.example.groupproject;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SceneManager manager = new SceneManager(primaryStage);
        manager.showPage("Page1.fxml","Dashboard");
    }
}
