module com.example.prkvant {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prkvant to javafx.fxml;
    exports com.example.prkvant;
}