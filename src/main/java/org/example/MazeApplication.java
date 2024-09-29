package org.example;

import org.example.mazeApp.MazeRunner;
import org.example.mazeApp.infrastructure.MazeInputReader;
import org.example.mazeApp.io.MazeSolverService;
import org.example.mazeApp.solver.MazeSolver;

public class MazeApplication {

    public static void main(String[] args) throws Exception {
        MazeInputReader inputReader = new MazeInputReader();

        char[][] maze = inputReader.readMaze("maze.txt");

        MazeSolverService mazeSolverService = new MazeSolverService(4, new MazeSolver());

        MazeRunner runner = new MazeRunner(mazeSolverService);
        runner.run(maze);

        mazeSolverService.shutdown();
    }
}