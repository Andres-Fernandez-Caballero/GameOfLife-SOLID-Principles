package com.electrica.gameOfLife.models;

import com.electrica.gameOfLife.contracts.Ruleable;
import com.electrica.gameOfLife.models.cellState.CellState;
import com.electrica.gameOfLife.models.context.CellContext;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class Cell implements Cloneable {
    @Getter
    @NonNull
    private CellState cellState;

    public Cell evolve(CellContext cellContext, Ruleable rulesOfLife) {
        Cell clone = null;
        try {
            clone = (Cell) this.clone();
            clone.cellState = rulesOfLife.evaluate(cellContext, this.cellState);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //System.out.println("Cell " + this + " evolved to " + clone);
        return clone;
    }

    @Override
    public String toString() {
        return "{" + cellState + "}";
    }
}
