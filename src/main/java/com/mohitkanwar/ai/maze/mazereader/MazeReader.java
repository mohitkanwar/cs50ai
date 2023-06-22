package com.mohitkanwar.ai.maze.mazereader;

import com.mohitkanwar.ai.maze.models.*;

public class MazeReader {
    public MazeMeta getMaze1() {
        MazeMeta mazeMeta = new MazeMeta();
        char[][] maze1 = {
                {'#', '#', ' ', ' ', ' ', ' ', 'B'},
                {'#', '#', ' ', '#', '#', '#', '#'},
                {'#', '#', ' ', '#', '#', '#', '#'},
                {'#', '#', ' ', '#', '#', '#', '#'},
                {'#', '#', ' ', '#', '#', '#', '#'},
                {'#', '#', ' ', '#', '#', '#', '#'},
                {'A', ' ', ' ', '#', '#', '#', '#'}
        };
        int rows = maze1.length;
        int cols = maze1[0].length;
        Node[][] maze = new Node[rows][cols];

        for (int i = 0; i< rows; i++) {
            for (int j = 0; j <cols; j++) {
                Node node = new Node();
                State state = new State();
                state.setRow(i);
                state.setCol(j);
                CellType cellType = getCellType(maze1[i][j]);
                if (cellType.equals(CellType.START)) {
                    mazeMeta.setInitialNode(node);
                } else if (cellType.equals(CellType.DESTINATION)) {
                    mazeMeta.setDestinationNode(node);
                }
                state.setCellType(cellType);
                node.setState(state);

                for(Action action: Action.values()) {
                    int testRowIndex = node.getState().getRow() + action.getRow();
                    int testColIndex = node.getState().getCol() + action.getCol();

                    if ((testRowIndex >= 0 && testRowIndex < maze.length)
                        && (testColIndex>=0 && testColIndex < maze[testRowIndex].length)) {
                        if ((maze1[testRowIndex][testColIndex] == CellType.PATH.getRepresentation())
                        ||((maze1[testRowIndex][testColIndex] == CellType.DESTINATION.getRepresentation()))){
                            node.getActions().add(action);
                        }

                    }
                }
                maze[i][j] =   node;
            }
        }
        mazeMeta.setMaze(maze);
        return mazeMeta;
    }

    private CellType getCellType(char representation) {
        for (CellType cellType: CellType.values()) {
            if (cellType.getRepresentation() == representation) {
                return cellType;
            }
        }
        throw new RuntimeException("Cannot understand the representation :" + representation);
    }
}
