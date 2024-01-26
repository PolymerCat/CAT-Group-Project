package com.example.groupproject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
// THis is for the line chart
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;


public class Page1Controller implements Initializable {

    @FXML
    private LineChart<Number, Number> lineChart;  // this is for line chart
    @FXML
    private Button testText;
    // ------------------------- DAY MONTH YEAR -----------------------
    @FXML
    private  Text day;
    @FXML
    private  Text month;
    @FXML
    private  Text year;
    // -----------------------------------------------------------------
    @FXML
    private Button acceptButton;
    @FXML
    private Button declineButton;
    @FXML
    private Text requestText;
    private SceneManager sceneManager;
    private  SystemTime time = new SystemTime();
    AudioPlayer buttonPlayer = new AudioPlayer();
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    protected void onSwitchSceneButtonClick() {
        buttonPlayer.play("src/main/resources/media/click.wav");
        if (sceneManager != null) {
            sceneManager.showPage("ReportCard.fxml", "Employee Health Report");
        }
    }
    @FXML
    protected void onSettingsClick(){
        if (sceneManager != null) {
            buttonPlayer.play("src/main/resources/media/backClick.wav");
            sceneManager.showPage("settings.fxml", "Employee Health Report");
        }
    }
    @FXML
    protected void onLogout(){
        if (sceneManager != null) {
            buttonPlayer.play("src/main/resources/media/backClick.wav");
            sceneManager.showPage("Login.fxml", "Employee Health Report");
        }
    }
    @FXML
    protected void onAccept(){
        buttonPlayer.play("src/main/resources/media/click2.wav");
        acceptButton.setText("Accepted Request");
        declineButton.setText("Decline");
        requestText.setText("Accepted");
    }
    @FXML
    protected void onDecline(){
        buttonPlayer.play("src/main/resources/media/click2.wav");
        declineButton.setText("Declined Request");
        acceptButton.setText("Accept");
        requestText.setText("Declined");
    }
    @FXML
    protected void onHelloButtonClick() {
        testText.setText("Welcome to JavaFX Application!");
    }

    // THESE ARE FUNCTIONS FOR THE LINE CHART
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configure the line chart
        configureLineChart();

        // Create series with data points
        XYChart.Series<Number, Number> series1 = createDataSeries("Series 1", new double[]{1, 2, 3, 4, 5}, new double[]{10, 15, 13, 17, 20});
        XYChart.Series<Number, Number> series2 = createDataSeries("Series 2", new double[]{1, 2, 3, 4, 5}, new double[]{5, 7, 6, 8, 11});

        // Use ObservableList instead of arrays
        ObservableList<XYChart.Series<Number, Number>> chartData = FXCollections.observableArrayList();
        chartData.addAll(series1, series2);

        // Add series to the line chart
        lineChart.setData(chartData);
        day.setText(time.getDay());
        month.setText(time.getDate() + " " + time.getMonth());
        year.setText(time.getYear());
        System.out.println("Line Chart initialized!");
        System.out.println(time.getDate());
    }

    private void configureLineChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);
    }

    private XYChart.Series<Number, Number> createDataSeries(String name, double[] xData, double[] yData) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(name);

        for (int i = 0; i < xData.length; i++) {
            series.getData().add(new XYChart.Data<>(xData[i], yData[i]));
        }

        return series;
    }
}
