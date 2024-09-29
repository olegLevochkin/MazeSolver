package org.example.mazeApp.solver.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    private Integer row;
    private Integer column;
    private String path;
}