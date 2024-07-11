package Graphs.Fish;

import Graphs.AdjacencyMatrixGraph.AdjacencyMatrixGraph;
import java.util.*;

public class Fish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int u = scanner.nextInt();
        int r, q;

        AdjacencyMatrixGraph<Integer> graph = new AdjacencyMatrixGraph<>(n);

        for (int i = 0; i < u; i++) {
            r = scanner.nextInt();
            q = scanner.nextInt();
            graph.addEdge(r, q, 1);
        }

        int L = scanner.nextInt();
        System.out.println(graph.sendFishes(L));
        scanner.close();
    }
}