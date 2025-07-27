package com.electrica.gameOfLife.models.grid;

import com.electrica.gameOfLife.contracts.CellGrid;
import com.electrica.gameOfLife.models.Cell;


public class CellGridMatrix implements CellGrid {
    private final Cell[][] cells;

    public CellGridMatrix(int width, int height) {
        cells = new Cell[width][height];
    }

    @Override
    public Cell cellAt(int x, int y) {
        return cells[x][y];
    }

    @Override
    public void setCellAt(int x, int y, Cell cell) {
        cells[x][y] = cell;
    }

    @Override
    public int getWidth() {
        return cells.length;
    }

    @Override
    public int getHeight() {
        return cells[0].length;
    }   
}
