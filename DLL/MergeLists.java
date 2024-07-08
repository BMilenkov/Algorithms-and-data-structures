package DLL;

import java.util.Scanner;

public class MergeLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyDLL<Integer> list1 = new MyDLL<>();
        MyDLL<Integer> list2 = new MyDLL<>();
        MyDLL<Integer> finalList = new MyDLL<>();

        String[] sizes = scanner.nextLine().split("\\s++");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        String[] L1 = scanner.nextLine().split("\\s++");
        String[] L2 = scanner.nextLine().split("\\s++");
        for (int i = 0; i < n; i++) {
            list1.insertLast(Integer.parseInt(L1[i]));
        }
        for (int i = 0; i < m; i++) {
            list2.insertLast(Integer.parseInt(L2[i]));
        }

        DLLNode<Integer> curr1 = list1.getLast();
        DLLNode<Integer> curr2 = list2.getFirst();

        while (curr1 != null && curr2 != null) {
            if(curr2.element >= curr1.element){
                finalList.insertLast(curr2.element);
                curr2 = curr2.succ;
            }
            else {
                finalList.insertLast(curr1.element);
                curr1 = curr1.prev;
            }
        }

        if(curr1 != null) {
            while (curr1 != null) {
                finalList.insertLast(curr1.element);
                curr1 = curr1.prev;
            }
        }
        if(curr2 != null) {
            while (curr2 != null) {
                finalList.insertLast(curr2.element);
                curr2 = curr2.succ;
            }
        }

        System.out.println(finalList);

        finalList.mirror();

        System.out.println(finalList);

    }
}
