package com.electrica.gameOfLife.models.cellState;

public class AliveCellState extends CellState {
    public String state() {
        return "Alive";
    }

    public int colorCode() {
        return 2; // ANSI code for green
    }

    public boolean isAlive() {
        return true;
    }

    public boolean isYoung() {
        return false;
    }

    public String color() {
        return "Green";
    }
}
