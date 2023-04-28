package com.example.classVersion;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Search {
    @FXML
    private Label lblFN;
    @FXML
    private Label lblLN;
    @FXML
    private Label lblVN;
    @FXML
    private Label lblLR;
    @FXML
    private Label lblPN;
    @FXML
    private TextField tfInpt;

    @FXML
    protected void SearchBtn() {
        for (int i = 0; i < Main.queues.length; i++) {
            for (int j = 0; j < Main.queues[i].length; j++) {
                if (Main.queues[i][j] != null) {
                    if (Main.queues[i][j].getFName().equalsIgnoreCase(tfInpt.getText())) {
                        lblFN.setText(Main.queues[i][j].getFName());
                        lblLN.setText(Main.queues[i][j].getLName());
                        lblVN.setText(Main.queues[i][j].getVNo());
                        lblLR.setText(String.valueOf(Main.queues[i][j].getFAmount()));
                        lblPN.setText(String.valueOf(i + 1));
                    }
                }
            }
        }
    }
}