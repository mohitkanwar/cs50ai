package org.example;

import java.util.Stack;

public class StateFrontier {
    Stack<Node> frontier = new Stack<>();

    void add  (Node node){
        frontier.push(node);
    }

    Node remove () {
        return frontier.pop();
    }
    boolean contains (State state) {
        // check if frontier contains a node which has same state as mentioned
        return false;
    }

    boolean isEmpty() {
        return frontier.isEmpty();
    }
}
