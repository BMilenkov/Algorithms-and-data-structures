package SLL;

import java.util.Scanner;

public class RotateList {


    public static void ShiftListRight(MySLL<Integer> mylist, int k) {

//        for (int i = 0; i < k; i++) {
//            SLLNode<Integer> posleden = mylist.getFirst();
//            while (posleden.succ != null) {
//                posleden = posleden.succ;
//            }
//            SLLNode<Integer> curr = mylist.getFirst();
//            mylist.delete(posleden);
//            mylist.insertFirst(posleden.data);
//        }

        for (int i = 0; i < k; i++) {
            SLLNode<Integer> pretposleden = mylist.getFirst();
            while (pretposleden.succ.succ != null) {
                pretposleden = pretposleden.succ;
            }
            SLLNode<Integer> posleden = pretposleden.succ;
            posleden.succ = mylist.getFirst();
            pretposleden.succ = null;
            mylist.setFirst(posleden);
        }
    }


    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int k = scanner.nextInt();
        ShiftListRight(list, k);
        System.out.println(list);
    }

}
