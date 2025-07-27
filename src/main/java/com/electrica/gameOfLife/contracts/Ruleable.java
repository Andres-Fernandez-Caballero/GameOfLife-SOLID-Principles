package com.electrica.gameOfLife.contracts;

import com.electrica.gameOfLife.models.cellState.CellState;
import com.electrica.gameOfLife.models.context.CellContext;

public interface Ruleable {
    CellState evaluate(CellContext cellContext, CellState cellState) throws IllegalArgumentException;
}
