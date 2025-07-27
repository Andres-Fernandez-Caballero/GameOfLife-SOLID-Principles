package com.electrica.gameOfLife.models.cellState;

public abstract class CellState {
    public abstract String state();

    public abstract String color();

    public abstract boolean isAlive();

    public abstract boolean isYoung();

    public abstract int colorCode();

    @Override
    public String toString() {
        return "( " + state() + " )";
    }
}
