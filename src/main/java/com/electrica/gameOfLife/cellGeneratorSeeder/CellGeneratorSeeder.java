package com.electrica.gameOfLife.cellGeneratorSeeder;

import com.electrica.gameOfLife.contracts.CellGrid;

public interface CellGeneratorSeeder {
    CellGrid create(int width, int height);

}