package com.example.linyanan.configuration.model;
//Cell : 定義遊戲內每一個 cell 的值
public class Cell {
    private Player value;

    public void setValue(Player value) {
        this.value = value;
    }

    public Player getValue() {
        return value;
    }
}
