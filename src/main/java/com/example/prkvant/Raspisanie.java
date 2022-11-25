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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Raspisanie {
    public ResourceBundle resources;
    public URL location;

    public TreeItem<String> rootItem1 = new TreeItem<>("Расписание");
    public TreeItem<String> branchItem1_1 = new TreeItem<>("Java");
    public TreeItem<String> leafItem1_1_1 = new TreeItem<>("Java 2.1");

    public TreeItem<String> rootItem2 = new TreeItem<>("События");
    public TreeItem<String> branchItem2_1 = new TreeItem<>("Ноябрь");
    public TreeItem<String> leafItem2_1_1 = new TreeItem<>("Ноябрь - месяц искусств");
    public TreeItem<String> leafItem2_1_2 = new TreeItem<>("Комплимент осени");
    public TreeItem<String> leafItem2_1_3 = new TreeItem<>("Музыкальный листопад");

    @FXML
    private Pane imagePane1;
    @FXML
    private Pane imagePane2;
    @FXML
    private Pane imagePane3;
    @FXML
    private Button backBtn;
    @FXML
    private Button update;
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
    private Pane tablePane;
    @FXML
    private TextArea txArea;
    @FXML
    private TextArea txArea2;
    @FXML
    private TextArea txArea3;
    @FXML
    private TextArea txArea4;
    @FXML
    private TextArea txArea5;
    @FXML
    private TextArea txArea6;
    @FXML
    private TextArea txArea7;
    @FXML
    private TextArea txArea8;
    @FXML
    private Text text;

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
                text.setVisible(false);
                if (tableRasp.getColumn().equals("4.11")) {
                    txArea.setVisible(true);
                    txArea2.setVisible(false);
                    txArea3.setVisible(false);
                    txArea4.setVisible(false);
                    txArea5.setVisible(false);
                    txArea6.setVisible(false);
                    txArea7.setVisible(false);
                    txArea8.setVisible(false);
                } else if (tableRasp.getColumn().equals("7.11")) {
                    txArea2.setVisible(true);
                    txArea.setVisible(false);
                    txArea3.setVisible(false);
                    txArea4.setVisible(false);
                    txArea5.setVisible(false);
                    txArea6.setVisible(false);
                    txArea7.setVisible(false);
                    txArea8.setVisible(false);
                } else if (tableRasp.getColumn().equals("11.11")) {
                    txArea3.setVisible(true);
                    txArea.setVisible(false);
                    txArea2.setVisible(false);
                    txArea4.setVisible(false);
                    txArea5.setVisible(false);
                    txArea6.setVisible(false);
                    txArea7.setVisible(false);
                    txArea8.setVisible(false);
                } else if (tableRasp.getColumn().equals("14.11")) {
                    txArea4.setVisible(true);
                    txArea.setVisible(false);
                    txArea3.setVisible(false);
                    txArea2.setVisible(false);
                    txArea5.setVisible(false);
                    txArea6.setVisible(false);
                    txArea7.setVisible(false);
                    txArea8.setVisible(false);
                } else if (tableRasp.getColumn().equals("18.11")) {
                    txArea5.setVisible(true);
                    txArea.setVisible(false);
                    txArea3.setVisible(false);
                    txArea4.setVisible(false);
                    txArea2.setVisible(false);
                    txArea6.setVisible(false);
                    txArea7.setVisible(false);
                    txArea8.setVisible(false);
                } else if (tableRasp.getColumn().equals("21.11")) {
                    txArea6.setVisible(true);
                    txArea.setVisible(false);
                    txArea3.setVisible(false);
                    txArea4.setVisible(false);
                    txArea5.setVisible(false);
                    txArea2.setVisible(false);
                    txArea7.setVisible(false);
                    txArea8.setVisible(false);
                } else if (tableRasp.getColumn().equals("25.11")) {
                    txArea7.setVisible(true);
                    txArea.setVisible(false);
                    txArea3.setVisible(false);
                    txArea4.setVisible(false);
                    txArea5.setVisible(false);
                    txArea6.setVisible(false);
                    txArea2.setVisible(false);
                    txArea8.setVisible(false);
                } else if (tableRasp.getColumn().equals("28.11")){
                    txArea8.setVisible(true);
                    txArea.setVisible(false);
                    txArea3.setVisible(false);
                    txArea4.setVisible(false);
                    txArea5.setVisible(false);
                    txArea6.setVisible(false);
                    txArea7.setVisible(false);
                    txArea2.setVisible(false);
                }
               /* pw = new PrintWriter(file);
                br = new BufferedReader(new FileReader("Val.txt"));
                if (line == null) {
                    pw.println(txArea.getText());
                    while ((line = br.readLine()) != null){
                        System.out.println(":)");
                    }
                } else {
                    System.out.println(":O");
                    txArea.setText(line);
                }
                pw.close();
                br.close();
                // -------------
                pw = new PrintWriter(file);
                pw.println(txArea.getText());
                pw.close();
                br = new BufferedReader(new FileReader("Val.txt"));
                while ((line = br.readLine()) != null){
                   System.out.println(":)");
                }
                br.close();*/
            }
        }
    }
    @FXML
    void updateAction(ActionEvent actionEvent) throws IOException{
        ObservableList<TableRasp2> currentData = table.getItems();
        String currentDate = dateInp.getText();
        for (TableRasp2 tableRasp : currentData) {
            if (tableRasp.getColumn().equals(currentDate)){
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
        if (tableRaspclick == null) {
            System.out.println("null tableRaspclick");
        } else {
            dateInp.setText(String.valueOf(tableRaspclick.getColumn()));
            dowInp.setText(String.valueOf(tableRaspclick.getDow()));
            timeInp.setText(String.valueOf(tableRaspclick.getTime()));
        }
    }

    public void setTableColumn(URL url, ResourceBundle resourceBundle){
        col1.setCellValueFactory(new PropertyValueFactory<TableRasp2, String>("column"));
        col2.setCellValueFactory(new PropertyValueFactory<TableRasp2, String>("dow"));
        col3.setCellValueFactory(new PropertyValueFactory<TableRasp2, String>("time"));
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