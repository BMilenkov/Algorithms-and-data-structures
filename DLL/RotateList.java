package DLL;

import java.util.Scanner;

public class RotateList {

    public static void main(String[] args) {

        MyDLL<Integer> list = new MyDLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int k = scanner.nextInt();

//        insertAverage(list);
        rotateList(list, k);


        System.out.println(list);

    }

    private static void insertAverage(MyDLL<Integer> list) {

        DLLNode<Integer> curr = list.getFirst();

        while (curr.succ != null) {
            int average = Math.round((float) (curr.element + curr.succ.element) / 2);
            list.insertAfter(average, curr);
            curr = curr.succ.succ;
        }
    }

    private static void rotateList(MyDLL<Integer> list, int k) {

        DLLNode<Integer> temp = list.getFirst();
        DLLNode<Integer> curr = list.getLast();

        while (k != 0) {
            list.insertBefore(curr.element, temp);
            temp = temp.prev;
            list.delete(curr);
            curr = curr.prev;
            --k;
        }
    }
}

