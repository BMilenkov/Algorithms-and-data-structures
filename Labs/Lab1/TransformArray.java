package Labs.Lab1;//package LABS1;
//
//import Aud1.Array.Array.Array;
//
//import java.util.Scanner;
//
//public class TransformArray {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = scanner.nextInt();
//        }
////        int first = 0;
////        for (int i = 0; i < array.length; i++) {
////            if (array[i] == 0) {
////                for (int j = i; j > first; j--) {
////                    int temp = array[j];
////                    array[j] = array[j - 1];
////                    array[j - 1] = temp;
////                }
////                first++;
////            }
////        }
//        int curr = array.length - 1;
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (array[i] != 0) {
//                array[curr--] = array[i];
//            }
//        }
//        for (int i = curr; i >= 0; i--) {
//            array[i] = 0;
//        }
//        System.out.println("Transformiranata niza e:");
//        for (int i = 0; i < n; i++) {
//            System.out.print(array[i] + " ");
//        }
//
//    }
//}

import java.util.Scanner;

public class TransformArray {
    static void pushZerosToBeginning(int arr[], int n) {
        int curr = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[curr--] = arr[i];
            }
        }
        for (int i = curr; i >= 0; i--) {
            arr[i] = 0;
        }
        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        pushZerosToBeginning(array,n);
    }
}