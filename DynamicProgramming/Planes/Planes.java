package DynamicProgramming.Planes;

import java.util.Scanner;

public class Planes {


    public static int cheapestWay(int n, int[] tax, int[][] flightCost) {

        int min[] = new int[n];
        min[0] = tax[0];

        for (int i = 1; i < n; i++) {
            min[i] = flightCost[0][i] + tax[0] + tax[i];
            for (int j = 0; j < i; j++) {
                if ((min[j] + flightCost[j][i] + tax[i]) < min[i])
                    min[i] = min[j] + flightCost[j][i] + tax[i];
            }
        }
        return min[n - 1];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] tax = new int[n];
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            tax[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Najeftiniot let e:"
                + cheapestWay(n, tax, cost));

    }
}
