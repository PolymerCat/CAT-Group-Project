package com.example.groupproject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class ReportController {
    SceneManager sceneManager ;
    AudioPlayer player = new AudioPlayer();
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    protected void onClick(){
        if (sceneManager != null) {
            player.play("src/main/resources/media/backClick.wav");
            sceneManager.showPage("Page1.fxml", "Employee Health Report");
        }
    }

}
