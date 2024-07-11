package SLL.KeepMRemoveN;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class KeepMRemoveN {

    public static void main(String[] args) {

        MySLL<Integer> list = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();


        for (int i = 0; i < size; i++) {
            list.insertLast(scanner.nextInt());
        }
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        SLLNode<Integer> curr = list.getFirst();

//        while (curr != null) {
//
//            int count = 0;
//            while (count != m && curr != null) {
//                curr = curr.succ;
//                count++;
//            }
//            count = 0;
//            while (count != n && curr != null) {
//                list.delete(curr);
//                curr = curr.succ;
//                count++;
//            }
//        }
        int counter = 1;
        boolean flag = true; // true -> ostavi , false -> removewhile (curr != null) {
        if (counter == m && flag) {
            flag = false;
            counter = 0;
        } else if (counter == n && !flag) {
            list.delete(curr);
            flag = true;
            counter = 0;
        } else if (!flag) {
            list.delete(curr);
        }
        counter++;
        curr = curr.succ;


        System.out.println(list);
    }
}

