package com.electrica.gameOfLife.models.cellState;

public class DeadCellState extends CellState {
    public String state() {
        return "Dead";
    }

    public String color() {
        return "Dark Gray";
    }

    public boolean isAlive() {
        return false;
    }

    public boolean isYoung() {
        return false;
    }

    @Override
    public int colorCode() {
       return 7;
    }
}
