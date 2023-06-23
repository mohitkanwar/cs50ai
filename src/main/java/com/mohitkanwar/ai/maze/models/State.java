package com.mohitkanwar.ai.maze.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class State {
    private int row;
    private int col;

    CellType cellType;
}
