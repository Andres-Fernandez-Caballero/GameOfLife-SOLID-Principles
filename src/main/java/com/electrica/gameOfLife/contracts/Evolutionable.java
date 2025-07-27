package com.electrica.gameOfLife.contracts;

import com.electrica.gameOfLife.models.Cell;

public interface Evolutionable {
    int countNeighbors(int x, int y);

    void evolve();

    int width();

    int height();

    Cell cellAt(int x, int y);
}
