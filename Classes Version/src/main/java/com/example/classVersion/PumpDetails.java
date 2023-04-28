package com.example.classVersion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class PumpDetails {
    @FXML
    private TableView<Passenger> p1Tbl;
    @FXML
    private TableView<Passenger> p2Tbl;
    @FXML
    private TableView<Passenger> p3Tbl;
    @FXML
    private TableView<Passenger> p4Tbl;
    @FXML
    private TableView<Passenger> p5Tbl;
    @FXML
    private TableView<Passenger> p6Tbl;

    @FXML
    protected void ShowBtn (){
        for (int i = 0; i < Main.queues.length; i++) {
            ObservableList<Passenger> PumpDta = FXCollections.observableArrayList();
            for (int j = 0; j < Main.queues[i].length; j++) {
                if(Main.queues[i][j]!=null) PumpDta.add(Main.queues[i][j]);
            }
            if(i==0) p1Tbl.setItems(PumpDta);
            if(i==1) p2Tbl.setItems(PumpDta);
            if(i==2) p3Tbl.setItems(PumpDta);
            if(i==3) p4Tbl.setItems(PumpDta);
            if(i==4) p5Tbl.setItems(PumpDta);
        }
        ObservableList<Passenger> WpData = FXCollections.observableArrayList();
        for (int j = 0; j < Waiting.waitingList.length; j++) {
            if(Waiting.waitingList[j]!=null){
                WpData.add((Waiting.waitingList[j]));
            }
        }
        p6Tbl.setItems(WpData);
    }
}
