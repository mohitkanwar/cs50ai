package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueFrontier {
    Queue<Node> frontier = new LinkedList<>();

    void add  (Node node){
        frontier.add(node);
    }

    Node remove () {
        return frontier.remove();
    }
    boolean contains (State state) {
        // check if frontier contains a node which has same state as mentioned
        return false;
    }

    boolean isEmpty() {
        return frontier.isEmpty();
    }
}
