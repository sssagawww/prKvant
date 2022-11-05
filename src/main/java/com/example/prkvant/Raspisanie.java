package com.example.prkvant;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Raspisanie {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    /*public Image image211 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img1.jpg");
    public Image image212 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img2.png");
    public Image image213 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img3.jpg");*/

    //public TreeItem<String>[] treeItems = new TreeItem[3];

    public TreeItem<String> rootItem1 = new TreeItem<>("Расписание");
    public TreeItem<String> branchItem1_1 = new TreeItem<>("Java");
    public TreeItem<String> leafItem1_1_1 = new TreeItem<>("Java 2.1");

    //public TreeItem<String> mainRoot = new TreeItem<>("не нужная строка");

    public TreeItem<String> rootItem2 = new TreeItem<>("События");
    public TreeItem<String> branchItem2_1 = new TreeItem<>("Октябрь");
    public TreeItem<String> leafItem2_1_1 = new TreeItem<>("Октябрь - месяц науки");
    public TreeItem<String> leafItem2_1_2 = new TreeItem<>("Маскарад");
    public TreeItem<String> leafItem2_1_3 = new TreeItem<>("День открытых дверей");

    @FXML
    private Pane imagePane1;
    @FXML
    private Pane imagePane2;
    @FXML
    private Pane imagePane3;
    @FXML
    private Button backBtn;
    @FXML
    public static ImageView p1_1_1 = new ImageView();
    @FXML
    public static ImageView p2_1_1 = new ImageView();
    @FXML
    public static ImageView p2_1_2 = new ImageView();
    @FXML
    public static ImageView p2_1_3 = new ImageView();
    @FXML
    private TreeView treeView;
    @FXML
    private TableView<TableRasp> table;
    @FXML
    private TableColumn<TableRasp, String> col1;
    @FXML
    private Pane tablePane;

    ObservableList<TableRasp> list = FXCollections.observableArrayList(
            new TableRasp("1"),
            new TableRasp("2"),
            new TableRasp("3"),
            new TableRasp("4")
    );
    @FXML
    void initialize() {
        //https://www.youtube.com/watch?v=3s8s0vyfLV8
        branchItem1_1.getChildren().addAll(leafItem1_1_1);
        branchItem2_1.getChildren().addAll(leafItem2_1_1, leafItem2_1_2, leafItem2_1_3);

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue == leafItem1_1_1) {
                tablePane.setVisible(true);
                imagePane1.setVisible(false);
                imagePane2.setVisible(false);
                imagePane3.setVisible(false);
            } else if (newValue != null && newValue == leafItem2_1_1) {
                tablePane.setVisible(false);
                imagePane1.setVisible(true);
                imagePane2.setVisible(false);
                imagePane3.setVisible(false);
            } else if (newValue != null && newValue == leafItem2_1_2) {
                tablePane.setVisible(false);
                imagePane1.setVisible(false);
                imagePane2.setVisible(true);
                imagePane3.setVisible(false);
            } else if (newValue != null && newValue == leafItem2_1_3) {
                tablePane.setVisible(false);
                imagePane1.setVisible(false);
                imagePane2.setVisible(false);
                imagePane3.setVisible(true);
            }
        });
        rootItem1.getChildren().addAll(branchItem1_1);
        rootItem2.getChildren().addAll(branchItem2_1);
        rootItem1.getChildren().addAll(rootItem2);
        treeView.setRoot(rootItem1);
        //setTableColumn(location, resources);
    }
    public void setTableColumn(URL location, ResourceBundle resource){
        col1.setCellValueFactory(new PropertyValueFactory<TableRasp, String>("column"));
        table.setItems(list);
    }
    public void setBackBtn(ActionEvent event) throws IOException {
        if (event.getSource()==backBtn) {
            Stage base = (Stage) backBtn.getScene().getWindow();
            base.setResizable(false);
            Parent rootprofile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("kvantPreview.fxml")));
            base.setTitle("Универсальный помощник");
            base.setScene(new Scene(rootprofile, 897, 589));
        }
    }
}