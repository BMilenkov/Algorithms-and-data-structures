package SLL.RemoveConditionalNodes;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class RemoveConditionalNodes {


    public static void removeNodes(MySLL<Integer> mylist, int num) {

        SLLNode<Integer> curr = mylist.getFirst().succ;
        SLLNode<Integer> prev = mylist.getFirst();

        while (curr != null) {

            if (prev.data.equals(num)) {
                prev = prev.succ;
                curr = curr.succ;
                mylist.setFirst(prev);
            } else {
                if (curr.data.equals(num)) {
                    curr = curr.succ;
                    prev.succ = curr;
                } else {
                    curr = curr.succ;
                    prev = prev.succ;
                }
            }
        }
    }

    public static void main(String[] args) {
        MySLL<Integer> mylist = new MySLL<>();


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            mylist.insertLast(scanner.nextInt());
        }
        int num = scanner.nextInt();

        System.out.println("Listata pred brisenjeto: ");
        System.out.println(mylist);
        removeNodes(mylist, num);
        System.out.println("Listata po brisenjeto: ");
        System.out.println(mylist);


    }
}
