package SLL.RemoveDuplicates;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Objects;
import java.util.Scanner;

public class RemoveDuplicates {

    public static void removeDuplicates(MySLL<Integer> mylist) {

        SLLNode<Integer> curr = mylist.getFirst();

        while (curr.succ != null) {

            if (Objects.equals(curr.data, curr.succ.data)) {
                mylist.delete(curr.succ);
            } else {
                curr = curr.succ;
            }
        }
    }

    public static void deleteDuplicates(MySLL<Integer> list) {

        SLLNode<Integer> curr = list.getFirst();


        // 1->1->2->2
        // 1->1->2->3->3
//Best first way:
        while (curr != null && curr.succ != null) {
            if (Objects.equals(curr.data, curr.succ.data)) {
                while (curr.succ != null && Objects.equals(curr.data, curr.succ.data)) {
                    list.delete(curr.succ);
                }
                list.delete(curr);
            }
            curr = curr.succ;
        }

//Worse second way:
//        MySLL<Integer> newList = new MySLL<>();
//
//        while (curr != null && curr.succ != null) {
//            if (Objects.equals(curr.data, curr.succ.data)) {
//                int info = curr.data;
//                while (curr != null && curr.data == info) {
//                    curr = curr.succ;
//                }
//            } else {
//                newList.insertLast(curr.data);
//                curr = curr.succ;
//            }
//        }
//
//        list.setFirst(null);
//        SLLNode<Integer> temp = newList.getFirst();
//        while (temp != null) {
//            list.insertLast(temp.data);
//            temp = temp.succ;
//        }
    }

    public static void main(String[] args) {
        MySLL<Integer> mylist = new MySLL<>();


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            mylist.insertLast(scanner.nextInt());
        }

        System.out.println("Listata pred brisenjeto: ");
        System.out.println(mylist);
//        removeDuplicates(mylist);
//        System.out.println("Listata po brisenjeto: ");
//        System.out.println(mylist);

        deleteDuplicates(mylist);
        System.out.println(mylist);

    }
}
