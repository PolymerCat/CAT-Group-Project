package com.example.groupproject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController2 implements Initializable {

    

    @FXML
    private Button Exit;
    //For SettingPage2.fxml
    @FXML
    private Button Setting2;
    @FXML
    private Button SettingBack2;
    @FXML
    private ScrollPane Slider2;
    @FXML
    private Button GoToDashboard;

    @FXML
    private AnchorPane Slider3;
    @FXML
    private Button ChangePassword;

    @FXML
    private AnchorPane IntergrationAP;
    @FXML
    private Button IntergrationButton;

    @FXML
    private AnchorPane ProfileAP;

    @FXML
    private Button ProfileButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Exit.setOnMouseClicked(event -> System.exit(0));

        Slider2.setTranslateX(-302);

        Setting2.setOnMouseClicked(Event -> {
            Slider3.setVisible(false);
            ProfileAP.setVisible(false);
            IntergrationAP.setVisible(false);

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(Slider2);

            slide.setToX(0);
            slide.play();

            Slider2.setTranslateX(-302);

            slide.setOnFinished((ActionEvent e)-> {
                Setting2.setVisible(false);
                SettingBack2.setVisible(true);
            });
        });

        SettingBack2.setOnMouseClicked(Event -> {
            Slider3.setVisible(false);
            ProfileAP.setVisible(false);
            IntergrationAP.setVisible(false);

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(Slider2);

            slide.setToX(-302);
            slide.play();

            Slider2.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Setting2.setVisible(true);
                SettingBack2.setVisible(false);
            });
        });

        Slider3.setTranslateX(-1000);

        ChangePassword.setOnMouseClicked(Event -> {
            Slider3.setVisible(true);
            ProfileAP.setVisible(false);
            IntergrationAP.setVisible(false);
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.6));
            slide.setNode(Slider3);

            slide.setToX(0);
            slide.play();

            Slider3.setTranslateX(-1000);

        });

        ProfileButton.setOnMouseClicked(Event ->{
            ProfileAP.setVisible(true);
            IntergrationAP.setVisible(false);
            Slider3.setVisible(false);

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.6));
            slide.setNode(ProfileAP);

            slide.setToX(0);
            slide.play();

            ProfileAP.setTranslateX(-1000);
        });

        IntergrationButton.setOnMouseClicked(Event ->{
            ProfileAP.setVisible(false);
            IntergrationAP.setVisible(true);
            Slider3.setVisible(false);

            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.6));
            slide.setNode(IntergrationAP);

            slide.setToX(0);
            slide.play();

            IntergrationAP.setTranslateX(-1000);
        });



    }

    public void switchToDashboard() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Page1.fxml"));
        Stage window = (Stage) GoToDashboard.getScene().getWindow();
        window.setScene(new Scene(root));
    }








}