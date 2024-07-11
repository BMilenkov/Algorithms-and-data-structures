package Graphs.Plumbing;

import Graphs.AdjacencyListGraph.AdjacencyListGraph;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Plumbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.next()); //nodes

        AdjacencyListGraph<Integer> waterNetwork = new AdjacencyListGraph<>();
        Map<Integer, Integer> nodeInfo = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int index = scanner.nextInt();
            int altitude = scanner.nextInt();
            waterNetwork.addVertex(index);
            nodeInfo.put(index, altitude);
        }
        int sourcePresure = nodeInfo.get(0);

        int M = scanner.nextInt(); //edges

        for (int i = 0; i < M; i++) {
            waterNetwork.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        int P = scanner.nextInt();

        for (int i = 0; i < P; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            int increaseFactor = scanner.nextInt();

            int oldAltitude = waterNetwork.getNeighbors(source).get(dest);
            waterNetwork.addEdge(source, dest, oldAltitude * increaseFactor);
        }
        scanner.close();

        Map<Integer, Integer> shortestPaths = waterNetwork.shortestPath(0);
        //nodeIndex , Altitude(start_Presure,0)

        nodeInfo.entrySet().stream().skip(1).filter(e -> e.getValue() != 0)
                .filter(e -> e.getValue() >= (sourcePresure - (shortestPaths.get(e.getKey()))))
                .forEach(e -> System.out.print(e.getKey() + " "));
    }
}
