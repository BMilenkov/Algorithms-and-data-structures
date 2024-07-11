package DynamicProgramming.MaximumSubarray;

import java.util.Scanner;

public class MaximumSubarray {


    public static int largestSum(int[] arr, int n) {

//        O(n^2) complexity
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += arr[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(largestSum(array,n));
    }
}
