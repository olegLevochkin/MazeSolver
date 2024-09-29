package org.example.mazeApp.solver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeSolverTest {

    private MazeSolver mazeSolver;

    @BeforeEach
    void setUp() {
        mazeSolver = new MazeSolver();
    }

    @Test
    void shouldFindShortestPathInSimpleMaze() {
        char[][] maze = {
                {'S', '.', '#'},
                {'.', '.', '#'},
                {'#', '.', 'X'}
        };

        String result = mazeSolver.findPath(maze, 0, 0, 2, 2);

        assertEquals("drdr", result);
    }

    @Test
    void shouldReturnErrorIfNoPathExists() {
        char[][] maze = {
                {'S', '#', '#'},
                {'#', '#', '#'},
                {'#', '.', 'X'}
        };

        String result = mazeSolver.findPath(maze, 0, 0, 2, 2);

        assertEquals("Error: No path exists", result);
    }

    @Test
    void shouldHandleMazeWithDirectPath() {
        char[][] maze = {
                {'S', '.', 'X'}
        };

        String result = mazeSolver.findPath(maze, 0, 0, 0, 2);

        assertEquals("rr", result);
    }

    @Test
    void shouldHandleLargerMaze() {
        char[][] maze = {
                {'S', '.', '.', '.', '#'},
                {'.', '#', '#', '.', '#'},
                {'.', '#', 'X', '.', '#'},
                {'.', '.', '.', '.', '.'},
                {'#', '#', '#', '#', '#'}
        };

        String result = mazeSolver.findPath(maze, 0, 0, 2, 2);

        assertEquals("dddrru", result);
    }

    @Test
    void shouldHandleAlreadySolvedMaze() {
        char[][] maze = {
                {'S', '.', 'X'}
        };

        String result = mazeSolver.findPath(maze, 0, 0, 0, 0);

        assertEquals("", result);
    }
}