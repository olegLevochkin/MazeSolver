package org.example.mazeApp;

import org.example.mazeApp.io.MazeSolverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Future;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MazeRunnerTest {

    @Mock
    private MazeSolverService mazeSolverService;

    @InjectMocks
    private MazeRunner mazeRunner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldRunAndSolveMaze() throws Exception {
        char[][] maze = {
                {'S', '.', '#'},
                {'.', '.', '#'},
                {'#', '.', 'X'}
        };

        Future<String> mockFuture = mock(Future.class);
        when(mockFuture.get()).thenReturn("ddr");
        when(mazeSolverService.solveMazeAsync(maze, 0, 0, 2, 2)).thenReturn(mockFuture);

        mazeRunner.run(maze);

        verify(mazeSolverService).solveMazeAsync(maze, 0, 0, 2, 2);
    }
}