package com.electrica.gameOfLife.cellGeneratorSeeder;

import com.electrica.gameOfLife.contracts.CellGrid;
import com.electrica.gameOfLife.models.Cell;
import com.electrica.gameOfLife.models.cellState.CellStateEnum;
import com.electrica.gameOfLife.models.cellState.CellStateFactory;
import com.electrica.gameOfLife.models.grid.CellGridMatrix;

public class ChessStyleCellGeneratorSeeder implements CellGeneratorSeeder {
    @Override
    public CellGrid create(int width, int height) {
        CellGrid cellGrid = new CellGridMatrix(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Alterna entre ALIVE y DEAD para formar un patrón de tablero de ajedrez
                CellStateEnum state = ((x + y) % 2 == 0) ? CellStateEnum.ALIVE : CellStateEnum.DEAD;
                cellGrid.setCellAt(x, y, new Cell(CellStateFactory.create(state)));
            }
        }

        return cellGrid;
    }
}
