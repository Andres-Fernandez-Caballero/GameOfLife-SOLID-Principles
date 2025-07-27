package com.electrica.gameOfLife.rules;


import com.electrica.gameOfLife.contracts.Ruleable;
import com.electrica.gameOfLife.models.cellState.CellState;
import com.electrica.gameOfLife.models.cellState.CellStateEnum;
import com.electrica.gameOfLife.models.cellState.CellStateFactory;
import com.electrica.gameOfLife.models.context.CellContext;

/*
 * 📜 Reglas del Juego de la Vida (Conway)
Las reglas clásicas son:

Una célula viva con menos de 2 vecinos vivos muere (soledad).

Una célula viva con 2 o 3 vecinos vivos sigue viva.

Una célula viva con más de 3 vecinos vivos muere (sobrepoblación).

Una célula muerta con exactamente 3 vecinos vivos revive (reproducción). Agregado personal revive como "Newborn" celula
 */

public class RulesOfLife implements Ruleable {

    @Override
    public CellState evaluate(CellContext cellContext, CellState cellState) throws IllegalArgumentException {
        if (cellContext == null || cellContext.ecosystem() == null)
            throw new IllegalArgumentException("Cell context or ecosystem cannot be null");

        if(cellState == null) {
            throw new IllegalArgumentException("Cell state cannot be null");
        }

        if (cellState.isAlive()) {
            if (cellState.isYoung()) {
                return CellStateFactory.create(CellStateEnum.ALIVE);
            } else {
                // alive cell
                if (cellContext.ecosystem().countNeighbors(cellContext.posX(), cellContext.posY()) < 2) {
                    return CellStateFactory.create(CellStateEnum.DEAD);
                } else if (cellContext.ecosystem().countNeighbors(cellContext.posX(), cellContext.posY()) == 2 || cellContext.ecosystem().countNeighbors(cellContext.posX(), cellContext.posY()) == 3) {
                    return CellStateFactory.create(CellStateEnum.ALIVE);
                } else if (cellContext.ecosystem().countNeighbors(cellContext.posX(), cellContext.posY()) > 3) {
                    return CellStateFactory.create(CellStateEnum.DEAD);
                }
            }
            // dead cell
        } else if (!cellState.isAlive() && cellContext.ecosystem().countNeighbors(cellContext.posX(), cellContext.posY()) == 3) {
            return CellStateFactory.create(CellStateEnum.NEWBORN);
        } else {
            return CellStateFactory.create(CellStateEnum.DEAD);
        }
        return CellStateFactory.create(CellStateEnum.DEAD);
    }
}
