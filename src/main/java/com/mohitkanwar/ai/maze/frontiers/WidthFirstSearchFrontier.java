package com.mohitkanwar.ai.maze.frontiers;

import com.mohitkanwar.ai.maze.models.Node;
import com.mohitkanwar.ai.maze.models.State;

import java.util.LinkedList;
import java.util.Queue;

public class WidthFirstSearchFrontier implements Frontier{
    // First in first out
    Queue<Node> frontier = new LinkedList<>();

    @Override
    public void add(Node node){
        frontier.add(node);
    }
    @Override
    public Node remove() {
        return frontier.remove();
    }
    @Override
    public boolean contains(Node node) {
        // check if frontier contains a node which has same state as mentioned
        return frontier.contains(node);
    }
    @Override
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
