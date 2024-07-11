package Graphs.CoperationOrganisation;

import Graphs.AdjacencyMatrixGraph.AdjacencyMatrixGraph;
import Graphs.AdjacencyMatrixGraph.Edge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CoperationOrganisation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int members = Integer.parseInt(scanner.nextLine());
        int relations = Integer.parseInt(scanner.nextLine());

        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(members);
        Map<String, Integer> membersByName = new HashMap<>();

        //0 Ilinkalvanoska 9 Slobodankalajdziski 5
        for (int i = 0; i < relations; i++) {
            String[] parts = scanner.nextLine().split("\\s++");
            membersByName.put(parts[1], Integer.parseInt(parts[0]));
            membersByName.put(parts[3], Integer.parseInt(parts[2]));
            graph.addEdge(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]), Integer.parseInt(parts[4]));
        }
        String president = scanner.nextLine();
        List<Edge> edges = graph.prim(membersByName.get(president));
        System.out.println(edges.stream().mapToInt(Edge::getWeight).sum());
    }
}