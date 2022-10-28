package com.example.prkvant;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Raspisanie {

    public Image image211 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img1.jpg");
    public Image image212 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img2.png");
    public Image image213 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img3.jpg");

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
    public static ImageView p2_1_1 = new ImageView();
    @FXML
    public static ImageView p2_1_2 = new ImageView();
    @FXML
    public static ImageView p2_1_3 = new ImageView();
    @FXML
    private TreeView treeView;

    @FXML
    void initialize() {
        /*p2_1_1.setImage(image211);
        p2_1_2.setImage(image212);
        p2_1_3.setImage(image213);*/

        branchItem1_1.getChildren().addAll(leafItem1_1_1);
        branchItem2_1.getChildren().addAll(leafItem2_1_1, leafItem2_1_2, leafItem2_1_3);

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            /*if (newValue != null && newValue == leafItem1_1_1) {
                p1_1_1.setVisible(true);
                p2_1_1.setVisible(false);
                p2_1_2.setVisible(false);
                p2_1_3.setVisible(false);
            }*/ /*else*/ if (newValue != null && newValue == leafItem2_1_1) {
                //p1_1_1.setVisible(false);
                p2_1_1.setVisible(true);
                p2_1_2.setVisible(false);
                p2_1_3.setVisible(false);
            } else if (newValue != null && newValue == leafItem2_1_2) {
                //p1_1_1.setVisible(false);
                p2_1_1.setVisible(false);
                p2_1_2.setVisible(true);
                p2_1_3.setVisible(false);
            } else if (newValue != null && newValue == leafItem2_1_3) {
                //p1_1_1.setVisible(false);
                p2_1_1.setVisible(false);
                p2_1_2.setVisible(false);
                p2_1_3.setVisible(true);
            }
        });
        rootItem1.getChildren().addAll(branchItem1_1);
        rootItem2.getChildren().addAll(branchItem2_1);
        rootItem1.getChildren().addAll(rootItem2);
        treeView.setRoot(rootItem1);
    }
}