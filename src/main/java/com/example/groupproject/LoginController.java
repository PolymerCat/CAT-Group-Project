package com.example.groupproject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.sound.sampled.*;
import java.io.File;
public class LoginController {
    @FXML
    String nextPage;
    @FXML
    private Button loginButton;
    @FXML
    private TextField username;
    @FXML
    private  TextField password;
    private SceneManager sceneManager;
   AudioPlayer player = new AudioPlayer();
   AudioPlayer bgPlayer = new AudioPlayer();
    public void setSceneManager(SceneManager sceneManager)
    {
        this.sceneManager = sceneManager;
//        bgPlayer.play("src/main/resources/media/9am-in-calabasas.wav");
    }
    @FXML
    protected void onLoginButtonClick(){
        if (sceneManager != null) {
            if(username.getText().equals("admin@gmail.com") && password.getText().equals("123456")){
                bgPlayer.stop();
                player.play("src/main/resources/media/click.wav");
                sceneManager.showPage("Page1.fxml", "Admin Dashboard");
            }

            else if (username.getText().equals("user@gmail.com") && password.getText().equals("123456")) {
                bgPlayer.stop();
                player.play("src/main/resources/media/click.wav");
                sceneManager.showPage("Employee.fxml", "Employee");

            }
            else if(username.getText().isEmpty() && password.getText().isEmpty() || (!username.getText().equals("admin@gmail.com") || !password.getText().equals("123456"))){
                username.setPromptText("Please enter your username");
                password.setPromptText("Please enter your password");
            }
        }
    }
    @FXML
    protected void onTroubleSigningInClick(){
        if (sceneManager != null) {
            bgPlayer.stop();
            player.play("src/main/resources/media/click.wav");
            sceneManager.showPage("cannot-login.fxml","Cannot Login");
        }
    }


}
