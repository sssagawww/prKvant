package com.example.prkvant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Raspisanie {

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

    /*class JThread extends Thread {
        JThread(String name){
            super(name);
        }
        public void run(){
            System.out.println("работает");
            });
        }
    }*/

    @FXML
    void initialize() {
        //https://stackoverflow.com/questions/32349910/javafx-8-setvisible-is-blocked
        //https://overcoder.net/q/2903031/%D0%BA%D0%B0%D0%BA-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D1%82%D0%B8%D1%82%D1%8C-%D0%BE%D0%B4%D0%B8%D0%BD-%D0%BF%D0%BE%D1%82%D0%BE%D0%BA-%D0%B4%D0%BB%D1%8F-%D0%BC%D0%BE%D0%B5%D0%B3%D0%BE-%D0%BA%D0%BE%D0%B4%D0%B0-%D0%B8-%D0%BE%D0%B4%D0%B8%D0%BD-%D0%B4%D0%BB%D1%8F-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-javafx
        branchItem1_1.getChildren().addAll(leafItem1_1_1);
        branchItem2_1.getChildren().addAll(leafItem2_1_1, leafItem2_1_2, leafItem2_1_3);

        //new JThread("JThread").start();
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            /*if (newValue != null && newValue == leafItem1_1_1) {
                p1_1_1.setVisible(true);
                p2_1_1.setVisible(false);
                p2_1_2.setVisible(false);
                p2_1_3.setVisible(false);
            } else*/ if (newValue != null && newValue == leafItem2_1_1) {
                //p1_1_1.setVisible(false);
                imagePane1.setVisible(true);
                imagePane2.setVisible(false);
                imagePane3.setVisible(false);
            } else if (newValue != null && newValue == leafItem2_1_2) {
                //p1_1_1.setVisible(false);
                imagePane1.setVisible(false);
                imagePane2.setVisible(true);
                imagePane3.setVisible(false);
            } else if (newValue != null && newValue == leafItem2_1_3) {
                //p1_1_1.setVisible(false);
                imagePane1.setVisible(false);
                imagePane2.setVisible(false);
                imagePane3.setVisible(true);
            }
        });
        rootItem1.getChildren().addAll(branchItem1_1);
        rootItem2.getChildren().addAll(branchItem2_1);
        rootItem1.getChildren().addAll(rootItem2);
        treeView.setRoot(rootItem1);
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