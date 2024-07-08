package SLL;

import java.util.Scanner;

public class RemoveNth {


    public static void RemoveNthFromEnd(MySLL<Integer> list, int n) {
        int size = list.getSize();
        int FromremovablePosition = size - n;
        int counter = 0;
        SLLNode<Integer> temp = list.getFirst();
        while (temp != null) {
            counter++;
            if (counter == FromremovablePosition) {
                temp.succ = temp.succ.succ;
                break;
            }
            temp = temp.succ;
        }
    }

    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int position = scanner.nextInt();
        RemoveNthFromEnd(list, position);
        System.out.println(list);
    }
}
