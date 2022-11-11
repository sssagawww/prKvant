package com.example.prkvant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TableRasp {
    private String column;
    public TableRasp(String column){
        this.column = column;
    }
    /*public TableRasp(ObservableList<TableRasp> list) {
        list = FXCollections.observableArrayList(
                new TableRasp("Понедельник"),
                new TableRasp("Вторник"),
                new TableRasp("Среда"),
                new TableRasp("Четверг"),
                new TableRasp("Пятница"),
                new TableRasp("Суббота"),
                new TableRasp("Воскресенье")
        );
    }*/
    public String getColumn(){
        return column;
    }
}
