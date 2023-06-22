package com.mohitkanwar.ai.maze.frontiers;

import com.mohitkanwar.ai.maze.models.Node;
import com.mohitkanwar.ai.maze.models.State;

import java.util.LinkedList;
import java.util.Queue;

public class QueueFrontier implements Frontier{
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
    public boolean contains(State state) {
        // check if frontier contains a node which has same state as mentioned
        return false;
    }
    @Override
    public boolean isEmpty() {
        return frontier.isEmpty();
    }
}
