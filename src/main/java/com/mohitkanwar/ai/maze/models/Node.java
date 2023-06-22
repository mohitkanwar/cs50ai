package com.mohitkanwar.ai.maze.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Node {
   private State state;
   private Node parent;

   private final List<Action> actions = new ArrayList<>();


}
