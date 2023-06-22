package com.mohitkanwar.ai.maze.models;

import lombok.Data;

@Data
public class State {
    private int row;
    private int col;

    CellType cellType;
}
