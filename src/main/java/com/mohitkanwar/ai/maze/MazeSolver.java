package com.mohitkanwar.ai.maze;

import com.mohitkanwar.ai.maze.frontiers.Frontier;
import com.mohitkanwar.ai.maze.frontiers.QueueFrontier;
import com.mohitkanwar.ai.maze.mazereader.MazeReader;
import com.mohitkanwar.ai.maze.models.Action;
import com.mohitkanwar.ai.maze.models.CellType;
import com.mohitkanwar.ai.maze.models.MazeMeta;
import com.mohitkanwar.ai.maze.models.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MazeSolver {
    private Frontier frontier;
    boolean[][] visited;

    MazeMeta mazeMeta;

    MazeReader mazeReader = new MazeReader();
    public List<Node> solve (){
        this.mazeMeta = mazeReader.getMaze1();
        this.visited = new boolean[mazeMeta.getMaze().length][mazeMeta.getMaze()[0].length];
        this.frontier = new QueueFrontier();
        this.frontier.add(this.mazeMeta.getInitialNode());

        while (!this.frontier.isEmpty()) {
            Node currentNode = this.frontier.remove();
            this.visited[currentNode.getState().getRow()][currentNode.getState().getCol()] = true;
            if (currentNode.getState().getCellType().equals(CellType.DESTINATION)){
                List<Node> path = new LinkedList<>();
                Node node = currentNode;
                while (node != null) {
                    path.add(0, node);
                    node = node.getParent();
                }
                return path;
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
                            frontier.add(neighbor);
                        }

                    }
                }
        }
        return Collections.emptyList();
    }
}
