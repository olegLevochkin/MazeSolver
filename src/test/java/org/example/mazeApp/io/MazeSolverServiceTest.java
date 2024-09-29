package org.example.mazeApp.io;


import org.example.mazeApp.solver.MazeSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MazeSolverServiceTest {

    @Mock
    private MazeSolver mazeSolver;

    private MazeSolverService mazeSolverService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mazeSolverService = new MazeSolverService(2, mazeSolver);
    }

    @Test
    void shouldSolveMazeAsync() throws ExecutionException, InterruptedException {
        char[][] maze = {
                {'S', '.', '#'},
                {'.', '.', '#'},
                {'#', '.', 'X'}
        };

        when(mazeSolver.findPath(maze, 0, 0, 2, 2)).thenReturn("ddr");

        Future<String> futureResult = mazeSolverService.solveMazeAsync(maze, 0, 0, 2, 2);

        String result = futureResult.get();
        assertEquals("ddr", result);

        verify(mazeSolver).findPath(maze, 0, 0, 2, 2);
    }
}