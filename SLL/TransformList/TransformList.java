package SLL.TransformList;


import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class TransformList {
    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int k = scanner.nextInt();

        transform(list, k);

        System.out.println(list);
    }
//10
//4 32 2 51 8 9 14 5 2 1
//14
    private static void transform(MySLL<Integer> list, int k) {

        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> temp = list.getFirst();

        while (temp.data != k) {
            temp = temp.succ;
        }

        SLLNode<Integer> greater = temp;

        while (curr != temp) {
            if (curr.data > temp.data) {
                list.insertAfter(curr.data, greater);
                greater = greater.succ;
                list.delete(curr);
            }
            curr = curr.succ;
        }
        while (curr != null) {
            if (curr.data < temp.data) {
                list.insertBefore(curr.data, temp);
                list.delete(curr);
            }
            curr = curr.succ;
        }
    }

}
