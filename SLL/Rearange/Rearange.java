package SLL.Rearange;


import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class Rearange {


    public static SLLNode<Integer> reverselist(SLLNode<Integer> node) {
        SLLNode<Integer> prev = null, curr = node, next;
        while (curr != null) {
            next = curr.succ;
            curr.succ = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public static void reArrange(MySLL<Integer> list) {

        SLLNode<Integer> half = list.getFirst();

        for (int i = 1; i < list.getSize() / 2; i++) {
            half = half.succ;
        }

        SLLNode<Integer> B = half.succ;
        half.succ = null;

        SLLNode<Integer> A = list.getFirst();


        SLLNode<Integer> curr = new SLLNode<>(null, null);
        while (A != null || B != null) {

            if (A != null) {
                curr.succ = A;
                curr = A;
                A = A.succ;
            }

            if (B != null) {
                curr.succ = B;
                curr = B;
                B = B.succ;
            }
        }

    }


    public static void rearrange(MySLL<Integer> list) {

        SLLNode<Integer> half = list.getFirst();
        for (int i = 1; i < (list.getSize() / 2); i++) {
            half = half.succ;
        }


        SLLNode<Integer> node1 = list.getFirst();
        SLLNode<Integer> node2 = half.succ;
        half.succ = null;

        node2 = reverselist(node2);

//
//        SLLNode<Integer> node = new SLLNode<>(null, null);
//        SLLNode<Integer> curr = node;

        SLLNode<Integer> curr = list.getFirst();

        while (node1 != null || node2 != null) {


            if (curr == node1) {
                curr.succ = node2;
                curr = node2;
                node2 = node2.succ;
                node1 = node1.succ;
            }

            if (curr == node2) {
                curr.succ = node1;
                curr = node1;
                node2 = node2.succ;
                node1 = node1.succ;
            }


//            if (node1 != null) {
//                curr.succ = node1;
//                curr = curr.succ;
//                node1 = node1.succ;
//            }
//
//            if (node2 != null) {
//                curr.succ = node2;
//                curr = curr.succ;
//                node2 = node2.succ;
//            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MySLL<Integer> list = new MySLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }

        REARANGE(list);
        System.out.println(list);
//        reArrange(list);
    }

    //5
//1 2 3 4 5
//1->5->2->4->3
    private static void REARANGE(MySLL<Integer> list) {

        MySLL<Integer> newList = new MySLL<>();
        SLLNode<Integer> curr = list.getFirst();
        while (curr != null) {
            newList.insertFirst(curr.data);
            curr = curr.succ;
        }

        curr = list.getFirst();
        SLLNode<Integer> temp = newList.getFirst();

        while (curr != null) {
            list.insertAfter(temp.data, curr);
            curr = curr.succ.succ;
            temp = temp.succ;
        }

        curr = list.getFirst();
        for (int i = 1; i < list.getSize() / 2; i++) {
            curr = curr.succ;
        }
        curr.succ = null;
    }
}
