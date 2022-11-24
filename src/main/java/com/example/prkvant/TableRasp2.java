package com.example.prkvant;

public class TableRasp2 {
    private String column;
    private String dow;
    private String time;
    public TableRasp2(String column, String dow, String time){
        this.column = column;
        this.dow = dow;
        this.time = time;
    }
    public void setColumn(String text) {
        this.column = column;
    }
    public void setDow(String dow) {
        this.dow = dow;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getColumn(){
        return column;
    }
    public String getDow(){
        return dow;
    }
    public String getTime(){
        return time;
    }
}
