package com.mohitkanwar.ai.maze.frontiers.comparators;

import com.mohitkanwar.ai.maze.models.Node;
import com.mohitkanwar.ai.maze.models.State;

import java.util.Comparator;

public class GreedyBestFirstNodeComparator implements Comparator<Node> {
    private Node goal;

    public GreedyBestFirstNodeComparator(Node goal) {
        this.goal = goal;
    }

    public int compare(Node o1, Node o2) {
        double distanceO1 = calculateDistance(goal.getState(), o1.getState());
        double distanceO2 = calculateDistance(goal.getState(), o2.getState());
        if (distanceO1 == distanceO2) {
            if (o1.getState().getCol() == o2.getState().getCol()) {
                return o1.getState().getRow() - o2.getState().getRow();
            }
            return o1.getState().getCol() - o2.getState().getCol();
        }
        return  (int) Math.floor(distanceO1 - distanceO2);
    }

    private double calculateDistance(State cell1, State cell2) {
        int xDiff = cell2.getRow() - cell1.getRow();
        int yDiff = cell2.getCol() - cell1.getCol();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
