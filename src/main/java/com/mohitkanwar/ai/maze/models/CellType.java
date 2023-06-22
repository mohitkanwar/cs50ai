package com.mohitkanwar.ai.maze.models;

public enum CellType {
    START('A'), DESTINATION('B'), PATH(' '), WALL('#');

    char representation;
    CellType(char c) {
        this.representation = c;
    }

    public char getRepresentation() {
        return representation;
    }
}
