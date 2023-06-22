package com.mohitkanwar.ai.maze.mazeprinter;

import com.mohitkanwar.ai.maze.models.CellType;
import com.mohitkanwar.ai.maze.models.Node;

import java.util.*;

public class ImagePrinter {


    public static void print(Node[][] maze, Set<Node> solution, boolean[][] visited) {


        // Print the array as an image.
        for (Node[] row : maze) {
            String line = "";
            for (Node cell : row) {
                char representation = cell.getState().getCellType().getRepresentation();
                if (cell.getState().getCellType().equals(CellType.PATH)) {
                    if(solution.contains(cell) ) {
                        representation = 'X';
                    } else if (visited[cell.getState().getRow()][cell.getState().getCol()]) {
                        representation = 'O';
                    }
                }

                line += String.format("%3c ", representation);
            }
            System.out.println(line);
        }
    }
}