package com.electrica.gameOfLife.models.cellState;

public class NewbornCellState extends CellState {

    @Override
    public String state() {
        return "Newborn";
    }

    @Override
    public String color() {
        return "Light Yellow";
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public boolean isYoung() {
        return true;
    }

    @Override
    public int colorCode() {
        return 5;
    }
}
