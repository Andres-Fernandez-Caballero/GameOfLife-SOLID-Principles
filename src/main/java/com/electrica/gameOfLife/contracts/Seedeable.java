package com.electrica.gameOfLife.contracts;

import com.electrica.gameOfLife.cellGeneratorSeeder.CellGeneratorSeeder;

public interface Seedeable {
    public void seed(CellGeneratorSeeder generator, int width, int height);
}
