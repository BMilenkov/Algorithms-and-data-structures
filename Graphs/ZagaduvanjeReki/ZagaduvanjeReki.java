package Graphs.ZagaduvanjeReki;

import Graphs.AdjacencyListGraph.AdjacencyListGraph;
import java.io.IOException;
import java.util.*;

//7 7
//A B C D E F G H
//A B 2
//C D 3
//B E 5
//D E 7
//E F 3
//E G 4
//F H 1
//G H 2
//A 8

public class ZagaduvanjeReki {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        String[] parts = scanner.nextLine().split("\\s++");
        int M = Integer.parseInt(parts[0]);
        int N = Integer.parseInt(parts[1]);

        String[] locations = scanner.nextLine().split("\\s++");
        for (int i = 0; i <= M; i++) {
            graph.addVertex(locations[i]);
        }
        for (int i = 0; i <= N; i++) {
            String[] link = scanner.nextLine().split("\\s++");
            graph.addEdge(link[0], link[1], Integer.parseInt(link[2]));
        }

        String[] pom = scanner.nextLine().split("\\s++");
        String start = pom[0];
        int distance = Integer.parseInt(pom[1]);

        Map<String, Integer> map = graph.shortestPath(start);
        map.entrySet().stream()
                .filter(e -> e.getValue() <= distance && e.getValue() >= 0)
                .forEach(e -> System.out.println(e.getKey()));
    }
}
