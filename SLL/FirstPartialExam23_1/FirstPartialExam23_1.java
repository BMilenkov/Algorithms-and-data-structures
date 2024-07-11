package SLL.FirstPartialExam23_1;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class FirstPartialExam23_1 {

    //4 -3 -6 0 7 7 -2 5
    public static void makeZigZag(MySLL<Integer> list) {

        SLLNode<Integer> curr = list.getFirst();

        while (curr.succ != null) {

            if(curr.data == 0){
                list.delete(curr);
                curr = curr.succ;
            }
            else if (curr.data > 0 && curr.succ.data > 0)
                list.delete(curr.succ);
            else if (curr.data < 0 && curr.succ.data < 0)
                list.insertAfter(Math.abs(curr.data), curr);
            else
                curr = curr.succ;
        }
        if(curr.data == 0)
            list.delete(curr);
    }

    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        System.out.println(list);
        makeZigZag(list);
        System.out.println(list);
    }
}
