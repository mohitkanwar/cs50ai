package com.mohitkanwar.ai.maze;

import com.mohitkanwar.ai.maze.frontiers.Frontier;
import com.mohitkanwar.ai.maze.models.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MazeSolver {

    boolean[][] visited;


    public Solution solve (MazeMeta mazeMeta, Frontier frontier){

        this.visited = new boolean[mazeMeta.getMaze().length][mazeMeta.getMaze()[0].length];

        frontier.add(mazeMeta.getInitialNode());

        while (!frontier.isEmpty()) {

            frontier.print();
            Node currentNode = frontier.remove();
            this.visited[currentNode.getState().getRow()][currentNode.getState().getCol()] = true;
            if (currentNode.getState().getCellType().equals(CellType.DESTINATION)){
                List<Node> path = new LinkedList<>();
                Node node = currentNode;
                while (node != null) {
                    path.add(0, node);
                    node = node.getParent();
                }
                Solution solution = new Solution();
                solution.setSelectedPath(path);
                solution.setVisited(visited);
                return solution;
            }


                List<Action> availableActions = currentNode.getActions();
                for (Action action : availableActions) {
                    int newRow = currentNode.getState().getRow() + action.getRow();
                    int newCol = currentNode.getState().getCol() + action.getCol();
                    if (!visited[newRow][newCol]) {
                        // Mark the neighbor as visited and add it to the queue
                        //visited[newRow][newCol] = true;
                        Node neighbor = mazeMeta.getMaze()[newRow][newCol];
                        if (neighbor.getState().getCellType().equals(CellType.PATH)
                        ||neighbor.getState().getCellType().equals(CellType.DESTINATION)) {
                            neighbor.setParent(currentNode);
                            neighbor.setCost(currentNode.getCost() + 1);
                            frontier.add(neighbor);
                        }

                    }
                }
        }
        Solution solution = new Solution();
        solution.setSelectedPath(Collections.emptyList());
        solution.setVisited(visited);
        return solution;
    }
}
