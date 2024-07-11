package DLL.DLLBattalion1;

import DLL.DLLBattalion1.DLLNode;

import java.util.Scanner;

public class DLLBattalion1 {



    public static MyDLL<Integer> vojska(MyDLL<Integer> list, int a, int b, int c, int d) {

        DLLNode<Integer> A = list.find(a);
        DLLNode<Integer> B = list.find(b);
        DLLNode<Integer> C = list.find(c);
        DLLNode<Integer> D = list.find(d);

        C.prev.succ = A;
        if (A == list.first) {
            A.prev = C.prev;
            C.prev = null;
            list.first = C;
        } else {
            A.prev.succ = C;
            DLLNode<Integer> temp = A.prev;
            A.prev = C.prev;
            C.prev = temp;
        }

        B.succ.prev = D;
        if (D == list.last) {
            D.succ = B.succ;
            B.succ = null;
            list.last = B;
        } else {
            D.succ.prev = B;
            DLLNode<Integer> tmp = B.succ;
            B.succ = D.succ;
            D.succ = tmp;
        }
//        while (curr != null) {
//            if (curr.element.equals(a)) {
//                A = curr;
//            } else if (curr.element.equals(b)) {
//                B = curr;
//            } else if (curr.element.equals(c)) {
//                C = curr;
//            } else if (curr.element.equals(d)) {
//                D = curr;
//            }
//            curr = curr.succ;
//        }
//        MyDLL<Integer> myFinalList = new MyDLL<>();
//        DLLNode<Integer> temp = list.first;
//        DLLNode<Integer> temp1 = A;
//        DLLNode<Integer> temp2 = C;
//
//        while (temp != A) {
//            myFinalList.insertLast(temp.element);
//            temp = temp.succ;
//        }
//        while (temp2 != D.succ) {
//            myFinalList.insertLast(temp2.element);
//            temp2 = temp2.succ;
//        }
//        temp = B.succ;
//        if (temp != C) {
//            while (temp != C) {
//                myFinalList.insertLast(temp.element);
//                temp = temp.succ;
//            }
//        }
//        while (temp1 != B.succ) {
//            myFinalList.insertLast(temp1.element);
//            temp1 = temp1.succ;
//        }
//        if (temp2 != null) {
//            while (temp2 != null) {
//                myFinalList.insertLast(temp2.element);
//                temp2 = temp2.succ;
//            }
//        }
//        return myFinalList;

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyDLL<Integer> mylist = new MyDLL<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.insertLast(scanner.nextInt());
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();


        System.out.println("Listata pred promenite:\n");
        System.out.println(mylist);
        System.out.println("Listata po promenite:\n");
        System.out.println(vojska(mylist, a, b, c, d));
    }
}

