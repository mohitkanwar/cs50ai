package com.mohitkanwar.ai.maze.frontiers;

import com.mohitkanwar.ai.maze.frontiers.comparators.GreedyBestFirstNodeComparator;
import com.mohitkanwar.ai.maze.models.Node;

import java.util.*;

public class InformedSearchFrontier implements Frontier{

    // Last in first out
    private final SortedSet<Node> frontier;
    private final Node goal;

    public InformedSearchFrontier(Node goal, Comparator<Node> comparator) {
        this.goal = goal;
        this.frontier = new TreeSet<>(comparator);
    }

    public void add  (Node node){
        boolean added = frontier.add(node);
        if (!added) {
            System.out.println("was trying to add node" + node.getState() + "but failed to add the same.");
        }
    }

    public Node remove () {
        Node node = frontier.first();
        frontier.remove(node);
        return node;
    }
    public boolean contains (Node node) {
        // check if frontier contains a node which has same state as mentioned
        return frontier.contains(node);
    }

    public boolean isEmpty() {
        return frontier.isEmpty();
    }

    @Override
    public void print() {
        System.out.println("===============");
        frontier.forEach(node -> {
            System.out.println("(" + node.getState().getRow() + ", " + node.getState().getCol() + ")");
        });
        System.out.println("===============");
    }
}
