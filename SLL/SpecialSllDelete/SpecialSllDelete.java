package SLL.SpecialSllDelete;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class SpecialSllDelete {


    public static void specialDelete(MySLL<Integer> list, int m) {

        //7
        //1 2 5 6 3 4 7
        //3
        // 1 2 6 3 7
        SLLNode<Integer> curr = list.getFirst();
        int counter = 1;
        while (curr != null) {
            if (counter == m) {
                list.delete(curr);
                counter = 1;
            } else {
                counter++;
            }
            curr = curr.succ;
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        MySLL<Integer> mylist = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.insertLast(scanner.nextInt());
        }
        int m = scanner.nextInt();
        specialDelete(mylist, m);
    }
}
