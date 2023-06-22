package com.mohitkanwar.ai.maze.frontiers;

import com.mohitkanwar.ai.maze.models.Node;
import com.mohitkanwar.ai.maze.models.State;

import java.util.Stack;

public class StateFrontier implements Frontier{
    Stack<Node> frontier = new Stack<>();

    public void add  (Node node){
        frontier.push(node);
    }

    public Node remove () {
        return frontier.pop();
    }
    public boolean contains (State state) {
        // check if frontier contains a node which has same state as mentioned
        return false;
    }

    public boolean isEmpty() {
        return frontier.isEmpty();
    }
}
