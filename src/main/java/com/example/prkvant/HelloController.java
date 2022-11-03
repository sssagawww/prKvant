package com.example.prkvant;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextArea textArea3;

    @FXML
    private TextArea textArea4;

    @FXML
    private TextArea textArea5;

    @FXML
    private TextArea textArea6;

    //public TreeItem<String>[] treeItems = new TreeItem[6];

    public TreeItem<String> rootItem = new TreeItem<>("Глава 1. Основы");
    public TreeItem<String> branchItem1 = new TreeItem<>("Containers");
    public TreeItem<String> branchItem2 = new TreeItem<>("Controls");
    public TreeItem<String> branchItem3 = new TreeItem<>("Charts");
    public TreeItem<String> leafItem1 = new TreeItem<>("AnchorPane");
    public TreeItem<String> leafItem2 = new TreeItem<>("BorderPane");
    public TreeItem<String> leafItem3 = new TreeItem<>("Button");
    public TreeItem<String> leafItem4 = new TreeItem<>("Label");
    public TreeItem<String> leafItem5 = new TreeItem<>("AreaChart");
    public TreeItem<String> leafItem6 = new TreeItem<>("PieChart");

    @FXML
    private Button backBtnB;
    @FXML
    private TreeView treeView;

    @FXML
    void initialize() {
        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem3, leafItem4);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue == leafItem1) {
                textArea1.setVisible(true);
                textArea2.setVisible(false); //?????
                textArea3.setVisible(false);
                textArea4.setVisible(false);
                textArea5.setVisible(false);
                textArea6.setVisible(false);
            } else if (newValue != null && newValue == leafItem2) {
                textArea2.setVisible(true);
                textArea1.setVisible(false);
                textArea3.setVisible(false);
                textArea4.setVisible(false);
                textArea5.setVisible(false);
                textArea6.setVisible(false);
            } else if (newValue != null && newValue == leafItem3) {
                textArea3.setVisible(true);
                textArea1.setVisible(false);
                textArea2.setVisible(false);
                textArea4.setVisible(false);
                textArea5.setVisible(false);
                textArea6.setVisible(false);
            } else if (newValue != null && newValue == leafItem4) {
                textArea4.setVisible(true);
                textArea1.setVisible(false);
                textArea2.setVisible(false);
                textArea3.setVisible(false);
                textArea5.setVisible(false);
                textArea6.setVisible(false);
            } else if (newValue != null && newValue == leafItem5) {
                textArea5.setVisible(true);
                textArea1.setVisible(false);
                textArea2.setVisible(false);
                textArea3.setVisible(false);
                textArea4.setVisible(false);
                textArea6.setVisible(false);
            } else if (newValue != null && newValue == leafItem6) {
                textArea6.setVisible(true);
                textArea1.setVisible(false);
                textArea2.setVisible(false);
                textArea3.setVisible(false);
                textArea4.setVisible(false);
                textArea5.setVisible(false);
        }
        });

        rootItem.getChildren().addAll(branchItem1,branchItem2,branchItem3);
        treeView.setRoot(rootItem);
    }

    public void setBackBtnB(ActionEvent event) throws IOException {
        if (event.getSource()==backBtnB) {
            Stage base = (Stage) backBtnB.getScene().getWindow();
            base.setResizable(false);
            Parent rootprofile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("kvantPreview.fxml")));
            base.setTitle("Универсальный помощник");
            base.setScene(new Scene(rootprofile, 897, 589));
        }
    }

}
