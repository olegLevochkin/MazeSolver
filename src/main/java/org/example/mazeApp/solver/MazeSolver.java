package org.example.mazeApp.solver;


import org.example.mazeApp.solver.models.Direction;
import org.example.mazeApp.solver.models.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MazeSolver {

    public String findPath(char[][] maze, int startRow, int startColumn, int targetRow, int targetColumn) {
        int rows = maze.length;
        int columns = maze[0].length;
        boolean[][] visited = new boolean[rows][columns];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startRow, startColumn, ""));

        visited[startRow][startColumn] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.getRow() == targetRow && current.getColumn() == targetColumn) {
                return current.getPath();
            }

            for (Direction direction : Direction.values()) {
                int newRow = current.getRow() + direction.getRow();
                int newColumn = current.getColumn() + direction.getColumn();

                if (isValidMove(newRow, newColumn, maze, visited)) {
                    visited[newRow][newColumn] = true;
                    queue.offer(new Node(newRow, newColumn, current.getPath() + direction.getSymbol()));
                }
            }
        }

        return "Error: No path exists";
    }

    private boolean isValidMove(int row, int column, char[][] maze, boolean[][] visited) {
        return row >= 0 && row < maze.length && column >= 0 && column < maze[0].length
                && maze[row][column] != '#' && !visited[row][column];
    }
}