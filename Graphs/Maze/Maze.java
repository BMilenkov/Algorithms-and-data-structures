package Graphs.Maze;

import Graphs.AdjacencyListGraph.AdjacencyListGraph;
import java.util.Scanner;

// The maze must have walls on all sides!!!
//
//6,6
//######
//# # ##
//# # S#
//# # ##
//# E ##
//######

//2,4 2,3 3,3 4,3 4,2

public class Maze {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split(",");
        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        String start = null, end = null;
        Character[][] maze = new Character[m][n];

        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (maze[i][j] == 'S')
                    start = i + "," + j;
                if (maze[i][j] == 'E')
                    end = i + "," + j;

                if (maze[i][j] != '#' && maze[i - 1][j] != '#')
                    graph.addEdge(i + "," + j, (i - 1) + "," + j, 1);
                if (maze[i][j] != '#' && maze[i + 1][j] != '#')
                    graph.addEdge(i + "," + j, (i + 1) + "," + j, 1);
                if (maze[i][j] != '#' && maze[i][j - 1] != '#')
                    graph.addEdge(i + "," + j, i + "," + (j - 1), 1);
                if (maze[i][j] != '#' && maze[i][j + 1] != '#')
                    graph.addEdge(i + " " + j, i + " " + (j + 1), 1);
            }
        }
        graph.printPath(start, end);
    }
}
