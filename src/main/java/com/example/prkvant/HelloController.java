package com.example.prkvant;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane;

    @FXML
    private ScrollBar scrollBar;

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

    public TreeItem<String>[] treeItems = new TreeItem[6];

    public TreeItem<String> rootItem = new TreeItem<>("Глава 1. Введение");
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
    private TreeView treeView;

    @FXML
    void initialize() {
        pane.translateYProperty().bind(scrollBar.valueProperty().multiply(-8));

        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem3, leafItem4);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue == leafItem1) {
                textArea1.setVisible(true);
                textArea2.setVisible(false); //?????
            } else if (newValue != null && newValue == leafItem2) {
                textArea2.setVisible(true);
            } else if (newValue != null && newValue == leafItem3) {
                textArea3.setVisible(true);
            } else if (newValue != null && newValue == leafItem4) {
                textArea4.setVisible(true);
            } else if (newValue != null && newValue == leafItem5) {
                textArea5.setVisible(true);
            } else if (newValue != null && newValue == leafItem6) {
                textArea6.setVisible(true);
        }
        });
        rootItem.getChildren().addAll(branchItem1,branchItem2,branchItem3);
        treeView.setRoot(rootItem);
    }

   /* void selectItem(){
        for (int i = 0; i <= treeItems.length; i++) {
         treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
             if (newValue != null && newValue == treeItems[i]) {
                 textArea.setVisible(true);
             }
         });
        }
    }

    public TreeItem<String>[] getTreeItems() {
        return treeItems;
    }*/
}
