package com.electrica.gameOfLife.cellGeneratorSeeder;

import java.util.Random;

import com.electrica.gameOfLife.contracts.CellGrid;
import com.electrica.gameOfLife.models.Cell;
import com.electrica.gameOfLife.models.cellState.CellStateEnum;
import com.electrica.gameOfLife.models.cellState.CellStateFactory;
import com.electrica.gameOfLife.models.grid.CellGridMatrix;

public class RandomCellGeneratorSeeder implements CellGeneratorSeeder{
    @Override
    public CellGrid create(int width, int height) {
        CellGrid cellGrid = new CellGridMatrix(width, height);
        Random random = new Random();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                CellStateEnum state = random.nextBoolean() ? CellStateEnum.ALIVE : CellStateEnum.DEAD;
                cellGrid.setCellAt(x, y, new Cell(CellStateFactory.create(state)));
            }
        }

        return cellGrid;
    }
}
