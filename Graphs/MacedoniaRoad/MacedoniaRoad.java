package Graphs.MacedoniaRoad;

import Graphs.AdjacencyListGraph.AdjacencyListGraph;
import java.util.Map;
import java.util.Scanner;


public class MacedoniaRoad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int numPaths = Integer.parseInt(sc.nextLine());

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < numPaths; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");

            graph.addEdge(parts[1], parts[3], Integer.parseInt(parts[4]));
        }
        String start = sc.nextLine();
        String destination = sc.nextLine();

        Map<String, Integer> map1 = graph.shortestPath(start);
        Map<String, Integer> map2 = graph.shortestPath(destination);

        graph.shortestPathVertex(start, destination).forEach(e -> System.out.print(e + " "));
        System.out.println();
        graph.shortestPathVertex(destination, start).forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println(map1.get(destination) + map2.get(start));
    }
}
