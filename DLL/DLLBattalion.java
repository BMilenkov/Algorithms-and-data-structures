package DLL;

import java.util.Scanner;


public class DLLBattalion {

    public static void swap(DLLNode<Integer> a, DLLNode<Integer> b) {

        if (a.prev != null)
            a.prev.succ = b;
        if (b.succ != null)
            b.succ.prev = a;

        if (a.succ == b) {
            a.succ = b.succ;
            b.prev = a.prev;
            b.succ = a;
            a.prev = b;
            return;
        }
        if (a.succ != null) {
            a.succ.prev = b;
        }
        if (b.prev != null) {
            b.prev.succ = a;
        }
        DLLNode<Integer> temp;

        temp = a.succ;
        a.succ = b.succ;
        b.succ = temp;

        temp = a.prev;
        a.prev = b.prev;
        b.prev = temp;

    }


    //TODO: implement function
    public static void battalion(MyDLL<Integer> list, int a, int b) {

        DLLNode<Integer> A = list.find(a);
        DLLNode<Integer> B = list.find(b);


        // 1.
//        while (A != B.succ) {
//            list.insertBefore(A.element, AA);
//            AA = AA.pred;
//            A = A.succ;
//        }
//        while (true){
//            BB = BB.pred;
//            list.delete(BB.succ);
//            if(BB.element.equals(BB.pred.element)) {
//                list.delete(BB);
//                break;
//            }
//        }

        if (A == null || B == null || A == B) {
            return;
        }
        if (a == list.getFirst().element && b == list.getLast().element) {
            list.mirror();
            return;
        }


        if (A.equals(list.getFirst())) {
            list.setFirst(B);
        } else {
            A.prev.succ = B;
        }

        if (B == list.getLast()) {
            list.setLast(A);
        } else
            B.succ.prev = A;


        while (true) {
            DLLNode<Integer> next = A.succ;
            DLLNode<Integer> prev = B.prev;

            swap(A, B);
            A = next;

            if (A == B)
                break;
            B = prev;
        }

        // 2.
//        while (A != B) {
//            list.insertAfter(A.element, B);
//            A = A.succ;
//            list.delete(A.pred);
//        }


        // 3.
//        DLL<Integer> finalList = new DLL<>();
//
//        DLLNode<Integer> curr = list.getFirst();
//        while (curr != A) {
//            finalList.insertLast(curr.element);
//            curr = curr.succ;
//        }
//        curr = B;
//        while (curr != A.pred) {
//            finalList.insertLast(curr.element);
//            curr = curr.pred;
//        }
//        curr = B.succ;
//        if(curr!=null) {
//            while (curr != null) {
//                finalList.insertLast(curr.element);
//                curr = curr.succ;
//            }
//        }
//        list.deleteList();
//        list.setFirst(finalList.getFirst());
//        list.setLast(finalList.getLast());
//    }


    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        MyDLL<Integer> list = new MyDLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(input.nextInt());
        }

        int a = input.nextInt();
        int b = input.nextInt();

        battalion(list, a, b);

        System.out.println(list);
        System.out.println(list);


    }
}