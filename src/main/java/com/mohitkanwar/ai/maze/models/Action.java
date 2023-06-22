package com.mohitkanwar.ai.maze.models;

public enum Action {
    UP(-1, 0), DOWN(1,0), LEFT (0,-1), RIGHT(0, 1);

    private final int row;
    private final int col;
    Action(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
