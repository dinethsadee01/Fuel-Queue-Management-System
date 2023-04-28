package com.example.classVersion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Choice {
    @FXML
    protected void PumpDetails() throws IOException {
        Stage newStage=new Stage();
        newStage.setTitle("Pump Queue Details");
        Parent root= FXMLLoader.load(getClass().getResource("PumpDetails.fxml"));
        newStage.setScene(new Scene(root));
        newStage.show();
    }
    @FXML
    protected void Search() throws IOException {
        Stage newStage=new Stage();
        newStage.setTitle("Search Passenger");
        Parent root= FXMLLoader.load(getClass().getResource("Search.fxml"));
        newStage.setScene(new Scene(root));
        newStage.show();
    }
}
