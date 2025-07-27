package com.electrica.gameOfLife.models;

import com.electrica.gameOfLife.cellGeneratorSeeder.CellGeneratorSeeder;
import com.electrica.gameOfLife.contracts.CellGrid;
import com.electrica.gameOfLife.contracts.Evolutionable;
import com.electrica.gameOfLife.contracts.Ruleable;
import com.electrica.gameOfLife.contracts.Seedeable;
import com.electrica.gameOfLife.models.cellState.CellState;
import com.electrica.gameOfLife.models.context.CellContext;
import com.electrica.gameOfLife.models.grid.CellGridMatrix;

public class Ecosystem implements Evolutionable, Seedeable {
    private final int width;
    private final int height;

    private final CellGrid cells;
    private final CellGrid newCells;
    private final Ruleable rulesOfLife;

    public Ecosystem(Ruleable rulesOfLife, int width, int height, CellGeneratorSeeder generator) {
        this.width = width;
        this.height = height;
        this.cells = new CellGridMatrix(width, height);
        this.newCells = new CellGridMatrix(width, height);

        this.rulesOfLife = rulesOfLife;
        seed(generator, width, height);
    }

    @Override
    public void seed(CellGeneratorSeeder generator, int width, int height) {
        CellGrid initialCells = generator.create(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells.setCellAt(x, y, initialCells.cellAt(x, y));
            }
        }
    }

    @Override
    public Cell cellAt(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Cell coordinates out of bounds");
        }
        return cells.cellAt(x, y);
    }

    @Override
    public void evolve() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell cell = cells.cellAt(x, y);

                CellContext context = new CellContext(x, y, this);
                newCells.setCellAt(x, y, cell.evolve(context, rulesOfLife));
            }
        }

        // Update the cells with the new states
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells.setCellAt(x, y, newCells.cellAt(x, y));
            }
        }
    }

    @Override
    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue; // Skip the cell itself
                try {
                    CellState neighborState = cells.cellAt(x + i, y + j).getCellState();
                    if (neighborState.isAlive()) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Ignore out of bounds exceptions
                }
            }
        }
        return count;
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }
}
