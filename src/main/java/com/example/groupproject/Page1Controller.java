package com.example.groupproject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class Page1Controller {
    @FXML
    private Button testText;
    @FXML
    private Button acceptButton;
    @FXML
    private Button declineButton;
    @FXML
    private Text requestText;
    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    protected void onSwitchSceneButtonClick() {
        if (sceneManager != null) {
            sceneManager.showPage("hello-view.fxml", "New Page");
        }
    }
    @FXML
    protected void onAccept(){
        acceptButton.setText("Accepted Request");
        declineButton.setText("Decline");
        requestText.setText("Accepted");
    }
    @FXML
    protected void onDecline(){
        declineButton.setText("Declined Request");
        acceptButton.setText("Accept");
        requestText.setText("Declined");
    }
    @FXML
    protected void onHelloButtonClick() {
        testText.setText("Welcome to JavaFX Application!");
    }
}
