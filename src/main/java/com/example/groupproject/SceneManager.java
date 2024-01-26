// SceneManager.java
package com.example.groupproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {

    private final Stage primaryStage;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Main function to load and show the scenes
    public void showPage(String fileName, String title) {
        loadAndShowScene(fileName, title);
    }

    // Function to load and show the scenes
    private void loadAndShowScene(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();

            // Pass the SceneManager to the controller
            if (loader.getController() instanceof Page1Controller) {
                ((Page1Controller) loader.getController()).setSceneManager(this);
            } else if (loader.getController() instanceof EmployeeController) {
                ((EmployeeController) loader.getController()).setSceneManager(this);
            } else if (loader.getController() instanceof LoginController) {
                ((LoginController) loader.getController()).setSceneManager(this);
            } else if (loader.getController() instanceof CannotLoginController) {
                ((CannotLoginController) loader.getController()).setSceneManager(this);
            } else if (loader.getController() instanceof SettingsController) {
                ((SettingsController) loader.getController()).setSceneManager(this);
            } else if (loader.getController() instanceof Settings2Controller) {
                ((Settings2Controller) loader.getController()).setSceneManager(this);
            } else if (loader.getController() instanceof ReportController) {
                ((ReportController) loader.getController()).setSceneManager(this);
            }

            Scene scene = new Scene(root);
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}