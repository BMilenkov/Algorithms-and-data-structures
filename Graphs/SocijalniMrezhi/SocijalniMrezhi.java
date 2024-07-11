package Graphs.SocijalniMrezhi;

import Graphs.AdjacencyListGraph.AdjacencyListGraph;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SocijalniMrezhi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();


        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < edges; i++) {
            String[] links = scanner.nextLine().split("\\s+");
            graph.addEdge(links[0], links[1], 1);
        }

        String start = scanner.nextLine().trim();

        Map<String, Integer> map = graph.shortestPath(start);

        map.forEach((key, value) -> System.out.println(key + " " + value));


        System.out.println();
        System.out.println(map.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(",")));
    }
}
