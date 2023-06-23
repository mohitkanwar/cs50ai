package com.mohitkanwar.ai.maze.frontiers;

import com.mohitkanwar.ai.maze.models.Node;
import com.mohitkanwar.ai.maze.models.State;

public interface Frontier {
    void add  (Node node);

    Node remove();

    boolean contains (Node node);

    boolean isEmpty();

    void print();
}
