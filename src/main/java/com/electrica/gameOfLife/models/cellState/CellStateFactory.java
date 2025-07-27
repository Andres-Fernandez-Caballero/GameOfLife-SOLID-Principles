package com.electrica.gameOfLife.models.cellState;

public class CellStateFactory {
    public static CellState create(CellStateEnum state) {
        switch (state) {
            case NEWBORN:
                return new NewbornCellState();
            case ALIVE:
                return new AliveCellState();
            case DEAD:
                return new DeadCellState();
            default:
                throw new IllegalArgumentException("Unknown cell state: " + state);
        }
    }
}
