package com.example.prkvant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    void initialize() {
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("kvant.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),897, 589);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.setTitle("Hello!");
        newStage.setScene(scene);
        btnB.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                newStage.show();//??? можно сделать всё в одном fxml и просто по нажатию кнопки скрывать
            }
        });

    }

}
