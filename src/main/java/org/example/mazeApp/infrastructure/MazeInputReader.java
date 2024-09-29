package org.example.mazeApp.infrastructure;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MazeInputReader {

    public char[][] readMaze(String resourceName) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new Exception("Resource not found: " + resourceName);
        }

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        return parseMaze(scanner);
    }

    private char[][] parseMaze(Scanner scanner) {
        StringBuilder builder = new StringBuilder();
        int rows = 0;
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
            rows++;
        }
        String[] lines = builder.toString().split("\n");
        int cols = lines[0].length();

        char[][] maze = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            maze[i] = lines[i].toCharArray();
        }

        return maze;
    }
}