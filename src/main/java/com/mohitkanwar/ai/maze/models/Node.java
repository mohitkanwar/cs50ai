package com.mohitkanwar.ai.maze.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Node {
   private State state;
   @ToString.Exclude
   private Node parent;

   private final List<Action> actions = new ArrayList<>();


}
