package Graphs.SubjectsAvailable;

import Graphs.AdjacencyListGraph.AdjacencyListGraph;
import java.util.Arrays;
import java.util.Scanner;

public class SubjectsAvailable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++) {
            graph.addVertex(scanner.nextLine());
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] parts = scanner.nextLine().split("\\s++");
            Arrays.stream(parts).skip(1).forEach(e -> graph.addEdge(e, parts[0], 1));
        }

        String subject = scanner.nextLine();

        if(graph.getNeighbors(subject).keySet().stream().findFirst().isPresent())
            System.out.println(graph.getNeighbors(subject).keySet().stream().findFirst().get());
        else
            System.out.println("shit!");

    }
}
