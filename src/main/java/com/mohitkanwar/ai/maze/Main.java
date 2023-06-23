package com.mohitkanwar.ai.maze;

import com.mohitkanwar.ai.maze.frontiers.Frontier;
import com.mohitkanwar.ai.maze.frontiers.GreedyBestFirstSearchFrontier;
import com.mohitkanwar.ai.maze.frontiers.WidthFirstSearchFrontier;
import com.mohitkanwar.ai.maze.mazeprinter.ImagePrinter;
import com.mohitkanwar.ai.maze.mazereader.MazeReader;
import com.mohitkanwar.ai.maze.models.MazeMeta;
import com.mohitkanwar.ai.maze.models.Solution;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        MazeReader mazeReader = new MazeReader();
        MazeMeta mazeMeta = mazeReader.getMaze("maze2");
//       Frontier frontier = new StateFrontier();
//       Frontier frontier = new WidthFirstSearchFrontier();
       Frontier frontier = new GreedyBestFirstSearchFrontier(mazeMeta.getDestinationNode());
        Solution solution = mazeSolver.solve(mazeMeta, frontier);
        if (solution.getSelectedPath().isEmpty()) {
            System.out.println("No solution found");
        } else {
//            for (Node node: path) {
//                System.out.println("{"+node.getState().getRow() + ","+node.getState().getCol() + "}   |   " );
//            }
            ImagePrinter.print(mazeMeta.getMaze(), new HashSet<>(solution.getSelectedPath()), solution.getVisited());
        }


    }
}