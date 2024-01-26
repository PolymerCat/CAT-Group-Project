package com.example.groupproject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    // ------------------------- DAY MONTH YEAR -----------------------
    private  SystemTime time = new SystemTime();
    @FXML
    private Text day;
    @FXML
    private  Text month;
    @FXML
    private  Text year;
    // --------------------------- Buttons ------------------------
    @FXML
    private Button submit;
    @FXML
    private ToggleButton feeling;
    @FXML
    private ToggleButton requestMC;
    private AudioPlayer player = new AudioPlayer();
    private SceneManager sceneManager;
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        day.setText(time.getDay());
        month.setText(time.getDate() + " " + time.getMonth());
        year.setText(time.getYear());
        // Set initial styles
        feeling.setStyle("-fx-text-fill: black; -fx-background-color: lightgray;");

        // Add event handler to the button
    }

    @FXML
    protected void SettingsClick(){
        if (sceneManager != null) {
            player.play("src/main/resources/media/backClick.wav");
            sceneManager.showPage("settings2.fxml", "Employee Health Report");
        }
    }
    @FXML
    protected void setFeeling(){
        if(feeling.isSelected()){
            // Button is pressed
            player.play("src/main/resources/media/click2.wav");
            feeling.setText("Well");
            feeling.setStyle("-fx-text-fill: black; -fx-background-color: #1CAAB4;");
        }
        else if(!feeling.isSelected()) {
            // Button is released
            player.play("src/main/resources/media/click2.wav");
            feeling.setText("Unwell");
            feeling.setStyle("-fx-text-fill: black; -fx-background-color: #FA5B5B;");
        }
    }
    @FXML
    protected void setSubmit(){
        player.play("src/main/resources/media/click2.wav");
        submit.setText("Report Submitted!");
        submit.setStyle("-fx-text-fill: black; -fx-background-color: #1CAAB4;");

//        if(submit.getText().equals("Submit Health Report")){
//            submit.setText("Report Submitted!");
//            submit.setStyle("-fx-text-fill: black; -fx-background-color: #1CAAB4;");
//        }
//        if(submit.getText().equals("Report Submitted!")){
//            submit.setText("Submit Health Report");
//            submit.setStyle("-fx-text-fill: black; -fx-background-color: lightgray;");
//        }
    }
    @FXML
    protected void setRequestMC(){
        if(requestMC.isSelected()){
            // Button is pressed
            player.play("src/main/resources/media/click2.wav");
            requestMC.setText("Well");
            requestMC.setStyle("-fx-text-fill: white; -fx-background-color: #1CAAB4;");
        }
        else if(!requestMC.isSelected()) {
            // Button is released
            player.play("src/main/resources/media/click2.wav");
            requestMC.setText("Unwell");
            requestMC.setStyle("-fx-text-fill: black; -fx-background-color: #FA5B5B;");
        }
    }
    @FXML
    protected void onLogout(){
        if (sceneManager != null) {
            player.play("src/main/resources/media/backClick.wav");
            sceneManager.showPage("Login.fxml", "Employee Health Report");
        }
    }

}
