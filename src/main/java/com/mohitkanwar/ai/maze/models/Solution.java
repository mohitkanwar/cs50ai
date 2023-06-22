package com.mohitkanwar.ai.maze.models;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Solution {
    List<Node> selectedPath;
    boolean[][] visited;
}
