package org.example.mazeApp.io;

import org.example.mazeApp.solver.MazeSolver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MazeSolverService {

    private final ExecutorService executor;
    private final MazeSolver mazeSolver;  // Add MazeSolver as a dependency

    // Constructor that accepts MazeSolver as a dependency
    public MazeSolverService(int threadPoolSize, MazeSolver mazeSolver) {
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
        this.mazeSolver = mazeSolver;
    }

    // Asynchronously solve the maze using MazeSolver
    public Future<String> solveMazeAsync(char[][] maze, int startRow, int startCol, int targetRow, int targetCol) {
        return executor.submit(() -> mazeSolver.findPath(maze, startRow, startCol, targetRow, targetCol));
    }

    public void shutdown() {
        executor.shutdown();
    }
}