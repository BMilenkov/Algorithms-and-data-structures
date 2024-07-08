package Graphs;

import Graphs.AdjacencyMatrixGraph;
import Graphs.Edge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Flood {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.next()); //nodes;
        int N = Integer.parseInt(scanner.next());//edges;

        int P = Integer.parseInt(scanner.next());

        Map<String, Integer> map = new HashMap<>();
        AdjacencyMatrixGraph<String> cityNetwork = new AdjacencyMatrixGraph<>(M);

        int[] trees = new int[M];

        for (int i = 0; i < M; i++) {
            String city = scanner.next();
            map.put(city, i);
            cityNetwork.addVertex(i, city);
            trees[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            String[] parts = scanner.nextLine().split("\\s++");
            cityNetwork.addEdge(map.get(parts[0]), map.get(parts[1]), Integer.parseInt(parts[2]));
        }

        for (int i = 0; i < P; i++) {
            String[] parts = scanner.next().split("\\s++");
//            cityNetwork.addEdge(map.get(parts[0]), map.get(parts[1]), 0);
            trees[map.get(parts[0])] = 0;
            trees[map.get(parts[1])] = 0;
        }


        List<Edge> filteredEdgesPaths = cityNetwork.adaptedKruskal(trees);

        System.out.println(filteredEdgesPaths.size() + " " +
                filteredEdgesPaths.stream().mapToInt(Edge::getWeight).sum());

        filteredEdgesPaths.forEach(e -> System.out.println(e.getFrom() + " " + e.getTo()));

    }
}
