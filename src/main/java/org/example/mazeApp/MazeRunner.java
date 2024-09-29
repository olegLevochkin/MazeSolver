package org.example.mazeApp;

import org.example.mazeApp.io.MazeSolverService;

import java.util.concurrent.Future;

public class MazeRunner {

    private final MazeSolverService mazeSolverService;

    public MazeRunner(MazeSolverService mazeSolverService) {
        this.mazeSolverService = mazeSolverService;
    }

    public void run(char[][] maze) throws Exception {
        int startRow = -1, startCol = -1, targetRow = -1, targetCol = -1;
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == 'S') {
                    startRow = row;
                    startCol = col;
                } else if (maze[row][col] == 'X') {
                    targetRow = row;
                    targetCol = col;
                }
            }
        }

        if (startRow == -1 || targetRow == -1) {
            return;
        }

        Future<String> future = mazeSolverService.solveMazeAsync(maze, startRow, startCol, targetRow, targetCol);

        String result = future.get();
        System.out.println("Result: " + result);
    }

    public void shutdown() {
        mazeSolverService.shutdown();
    }
}