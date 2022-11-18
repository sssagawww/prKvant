package com.example.prkvant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Raspisanie {
    public ResourceBundle resources;
    public URL location;

    /*public Image image211 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img1.jpg");
    public Image image212 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img2.png");
    public Image image213 = new Image("E:/IdeaProjects/prKvant/src/main/resources/com/example/prkvant/img3.jpg");*/

    //public TreeItem<String>[] treeItems = new TreeItem[3];

    public TreeItem<String> rootItem1 = new TreeItem<>("Расписание");
    public TreeItem<String> branchItem1_1 = new TreeItem<>("Java");
    public TreeItem<String> leafItem1_1_1 = new TreeItem<>("Java 2.1");

    //public TreeItem<String> mainRoot = new TreeItem<>("не нужная строка");

    public TreeItem<String> rootItem2 = new TreeItem<>("События");
    public TreeItem<String> branchItem2_1 = new TreeItem<>("Ноябрь");
    public TreeItem<String> leafItem2_1_1 = new TreeItem<>("Музыкальный листопад");
    public TreeItem<String> leafItem2_1_2 = new TreeItem<>("Комплимент осени");
    public TreeItem<String> leafItem2_1_3 = new TreeItem<>("Ноябрь - месяц искусств");

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
    private TableView<TableRasp2> table;
    @FXML
    private TableColumn<TableRasp2, String> col1;
    @FXML
    private TableColumn<TableRasp2, String> col2;
    @FXML
    private TableColumn<TableRasp2, String> col3;
    @FXML
    private TextField dateInp;
    @FXML
    private TextField dowInp;
    @FXML
    private TextField timeInp;
    @FXML
    private Button submit;
    @FXML
    private Pane tablePane;
    @FXML
    private TextArea txArea;

    public BufferedReader br = null;
    public File file = new File("Val.txt");
    public PrintWriter pw;
    public String line;

    ObservableList<TableRasp2> list = FXCollections.observableArrayList(
            new TableRasp2("4.11",  "Пятница", "18:35"),
            new TableRasp2("7.11",  "Понедельник", "18:35"),
            new TableRasp2("11.11", "Пятница", "18:35"),
            new TableRasp2("14.11", "Понедельник", "18:35"),
            new TableRasp2("18.11", "Пятница", "18:35"),
            new TableRasp2("21.11", "Понедельник", "18:35"),
            new TableRasp2("25.11", "Пятница", "18:35"),
            new TableRasp2("28.11", "Понедельник", "18:35")
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
        setTableColumn(location, resources);
    }

    @FXML
    void submitAction(ActionEvent event) throws IOException {
        System.out.println("работает");
        ObservableList<TableRasp2> currentData = table.getItems();
        String currentDate = dateInp.getText();
        for (TableRasp2 tableRasp : currentData) {
            if (tableRasp.getColumn().equals(currentDate)) {
                //txArea.setText();
                line = (String.valueOf(txArea)); // !!!
                pw = new PrintWriter(file);
                pw.println(line);
                br = new BufferedReader(new FileReader("Val.txt"));
                while ((line = br.readLine()) != null){
                    pw.println(":)");
                }
                br.close();
                pw.close();

                tableRasp.setDow(dowInp.getText());
                tableRasp.setTime(timeInp.getText());
                table.setItems(currentData);
                table.refresh();
                break;
            }
        }
    }

    @FXML
    void rowClicked (MouseEvent event){
        TableRasp2 tableRaspclick = table.getSelectionModel().getSelectedItem();
        dateInp.setText(String.valueOf(tableRaspclick.getColumn()));
        dowInp.setText(String.valueOf(tableRaspclick.getDow()));
        timeInp.setText(String.valueOf(tableRaspclick.getTime()));
    }

    public void setTableColumn(URL url, ResourceBundle resourceBundle){
        col1.setCellValueFactory(new PropertyValueFactory<TableRasp2, String>("column"));
        col2.setCellValueFactory(new PropertyValueFactory<TableRasp2, String>("dow"));
        col3.setCellValueFactory(new PropertyValueFactory<TableRasp2, String>("time"));
        table.setItems(list);
        //table.setColumns().add(col1);
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