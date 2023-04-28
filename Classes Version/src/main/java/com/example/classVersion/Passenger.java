package com.example.classVersion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Passenger extends Application {
    static FuelQueue[][] queues = new FuelQueue[5][6]; //array for 5 pumps
    static FuelQueue[][] copies = new FuelQueue[5][6]; //temporary arrays for sorting method
    private String fName;
    private String lName;
    private String vNo;
    private int fAmount;

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getVNo() {
        return vNo;
    }

    public void setVNo(String vNo) {
        this.vNo = vNo;
    }

    public int getFAmount() {
        return fAmount;
    }

    public void setFAmount(int fAmount) {
        this.fAmount = fAmount;
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Choice.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fuel Queue Management");
        stage.setScene(scene);
        stage.show();
    }
}
