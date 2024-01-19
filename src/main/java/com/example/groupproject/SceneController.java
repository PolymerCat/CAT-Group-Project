package com.example.groupproject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private Button Setting;

    @FXML
    private Button SettingBack;

    @FXML
    private AnchorPane Slider;

    @FXML
    private Text Exit;


    public void switchToSettingExit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingExit.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSettingHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingHome.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        Slider.setTranslateX(-200);

        Setting.setOnMouseClicked(Event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(Slider);

            slide.setToX(0);
            slide.play();

            Slider.setTranslateX(-200);
            
            slide.setOnFinished((ActionEvent e)-> {
                Setting.setVisible(false);
                SettingBack.setVisible(true);
            });
        });

        SettingBack.setOnMouseClicked(Event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(Slider);

            slide.setToX(-200);
            slide.play();

            Slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Setting.setVisible(true);
                SettingBack.setVisible(false);
            });
        });
    }
}