package com.electrica.gameOfLife.contracts;

import com.electrica.gameOfLife.models.Cell;

public interface CellGrid {
    Cell cellAt(int x, int y);
    void setCellAt(int x, int y, Cell cell);
    int getWidth();
    int getHeight();

   
}
