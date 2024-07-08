package SLL;

import java.util.Scanner;

public class AlternatelyMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        MySLL<Integer> list1 = new MySLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }
        int m = scanner.nextInt();
        MySLL<Integer> list2 = new MySLL<>();
        for (int i = 0; i < m; i++) {
            list2.insertLast(scanner.nextInt());
        }
        mergeThem(list1, list2);
    }

    private static void mergeThem(MySLL<Integer> list1, MySLL<Integer> list2) {
        MySLL<Integer> res = new MySLL<>();
        SLLNode<Integer> curr1 = list1.getFirst();
        SLLNode<Integer> curr2 = list2.getFirst();

        while (curr1 != null && curr2 != null) {

            res.insertLast(curr1.data);
            curr1 = curr1.succ;
            if (curr1 != null) {
                res.insertLast(curr1.data);
                curr1 = curr1.succ;
            }

            res.insertLast(curr2.data);
            curr2 = curr2.succ;
            if (curr2 != null) {
                res.insertLast(curr2.data);
                curr2 = curr2.succ;
            }
        }
        while (curr1 != null) {
            res.insertLast(curr1.data);
            curr1 = curr1.succ;
        }
        while (curr2 != null) {
            res.insertLast(curr2.data);
            curr2 = curr2.succ;
        }
        System.out.println(res);

    }
}
