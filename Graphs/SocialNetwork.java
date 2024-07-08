package Graphs;

import Graphs.AdjacencyListGraph;

import java.util.*;

public class SocialNetwork {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++) {
            String vertex = scanner.nextLine();
            graph.addVertex(vertex);
            int friends = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < friends; j++) {
                String friend = scanner.nextLine();
                graph.addEdge(vertex, friend, 1);
            }
        }
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();

        Map<String, Integer> map = graph.shortestPath(firstName);
        System.out.println(map.get(secondName));
    }
}
