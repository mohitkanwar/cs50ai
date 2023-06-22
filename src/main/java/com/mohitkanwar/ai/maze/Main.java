package com.mohitkanwar.ai.maze;

import com.mohitkanwar.ai.maze.models.Node;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        List<Node> path = mazeSolver.solve();
        if (path.isEmpty()) {
            System.out.println("No solution found");
        } else {
            for (Node node: path) {
                System.out.println("{"+node.getState().getRow() + ","+node.getState().getCol() + "}   |   " );
            }
        }


    }
}