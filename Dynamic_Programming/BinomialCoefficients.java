package Dynamic_Programming;

public class BinomialCoefficients {

    public static void binomial(int n) {

        int[][] matrix = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 0; i <= n; i++) {
            matrix[i][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        binomial(5);
    }
}
