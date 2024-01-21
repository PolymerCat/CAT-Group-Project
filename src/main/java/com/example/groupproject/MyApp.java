package com.example.groupproject;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.sound.sampled.*;
public class MyApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        SceneManager manager = new SceneManager(primaryStage);
        manager.showPage("Login.fxml","Login Page");
    }

}
