package com.electrica.gameOfLife.models.context;

import com.electrica.gameOfLife.contracts.Evolutionable;

public record CellContext(
    int posX,
    int posY,
    Evolutionable ecosystem
) {}   
