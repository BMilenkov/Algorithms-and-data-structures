package DynamicProgramming.Rocks;

public class Rocks {


    public static int maxRocks(int m, int n, int[][] rocks) {

        int[][] matrix = new int[m][n];
        matrix[0][0] = rocks[0][0];
        for (int j = 1; j < n; j++) {
            matrix[0][j] = matrix[0][j - 1] + rocks[0][j];
        }
        for (int i = 1; i < m; i++) {
            matrix[i][0] = matrix[i - 1][0] + rocks[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = rocks[i][j] + Math.max(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }
        return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 3;
        int[][] rocks = {{1, 2, 4}, {34, 5, 67}, {2, 2, 2}, {10, 20, 4}, {1, 98, 4}};
        System.out.println(maxRocks(m, n, rocks));
    }
}
