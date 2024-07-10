package Labs.Lab1;

import java.util.Scanner;

//public class ReversedWords {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            String a = scanner.next();
//            StringBuilder sb = new StringBuilder();
//            sb.append(a);
//            sb.reverse();
//            System.out.println(sb);
//        }
//    }
//}

public class ReversedWords {

    public static void printReversed(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        sb.reverse();
        System.out.println(sb);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String a = scanner.next();
            printReversed(a);
        }
    }
}


