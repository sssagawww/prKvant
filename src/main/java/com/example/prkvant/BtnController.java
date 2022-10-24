package com.example.prkvant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BtnController {
    public Stage newStage = new Stage();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnB;

    @FXML
    private Button btnR;

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("kvant.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),897, 589);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.setTitle("Hello!");
        newStage.setScene(scene);
    }
    public void buttonAction(ActionEvent actionEvent) {
        newStage.show();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
