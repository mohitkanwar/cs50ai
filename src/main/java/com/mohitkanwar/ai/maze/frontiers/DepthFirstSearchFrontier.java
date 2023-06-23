package com.mohitkanwar.ai.maze.frontiers;

import com.mohitkanwar.ai.maze.models.Node;
import com.mohitkanwar.ai.maze.models.State;

import java.util.Stack;

public class DepthFirstSearchFrontier implements Frontier{
    // Last in first out
    Stack<Node> frontier = new Stack<>();

    public void add  (Node node){
        frontier.push(node);
    }

    public Node remove () {
        return frontier.pop();
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
