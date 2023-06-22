package com.mohitkanwar.ai.maze.models;

import lombok.Data;

@Data
public class MazeMeta {
    private Node[][] maze;
    private Node initialNode;
    
    private Node destinationNode;
}
