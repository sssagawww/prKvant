package com.example.prkvant;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BtnController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnB;

    @FXML
    private Button btnR;

    @FXML
    public void initialize(ActionEvent event) throws IOException {
        if (event.getSource()==btnB) {
            Stage base = (Stage) btnB.getScene().getWindow();
            base.setResizable(false);
            Parent rootprofile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("kvant.fxml")));
            base.setTitle("База знаний");
            base.setScene(new Scene(rootprofile, 897, 589));
        }
    }

    public void raspisanie(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource()==btnR) {
            Stage rasp = (Stage) btnR.getScene().getWindow();
            rasp.setResizable(false);
            Parent rootprofile1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("raspisanie.fxml")));
            rasp.setTitle("Расписание");
            rasp.setScene(new Scene(rootprofile1, 897, 589));
        }
    }
}