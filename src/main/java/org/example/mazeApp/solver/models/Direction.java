package org.example.mazeApp.solver.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Direction {
    UP(-1, 0, "u"),
    DOWN(1, 0, "d"),
    LEFT(0, -1, "l"),
    RIGHT(0, 1, "r");

    private final Integer row;
    private final Integer column;
    private final String symbol;
}
