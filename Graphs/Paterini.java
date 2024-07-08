package Graphs;

import Graphs.AdjacencyListGraph;

import java.util.Map;
import java.util.Scanner;

public class Paterini {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AdjacencyListGraph<Integer> cities = new AdjacencyListGraph<>();

        int N = Integer.parseInt(scanner.nextLine()); //num of cities == nodes

        String[] ids = scanner.nextLine().split("\\s++");

        int Skopje = Integer.parseInt(ids[0]);
        int Berlin = Integer.parseInt(ids[1]);

        int M = Integer.parseInt(scanner.nextLine()); // num of Paths == edges

        for (int i = 0; i < M; i++) {
            String[] path = scanner.nextLine().split("\\s++");
            cities.addEdge(Integer.parseInt(path[0]), Integer.parseInt(path[1]), Integer.parseInt(path[2]));
        }

        Map<Integer, Integer> map = cities.shortestPath(Skopje);
        System.out.println(map.get(Berlin));
    }
}
