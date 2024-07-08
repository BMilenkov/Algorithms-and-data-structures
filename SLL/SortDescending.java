package SLL;

import java.util.Scanner;

public class SortDescending {

    public static MySLL<Integer> sort_opagjacki(MySLL<Integer> mylist) {

        SLLNode<Integer> node, prev1, prev2, temp;
        for (int i = 0; i < mylist.getSize(); i++) {
            node = mylist.getFirst().succ;
            prev1 = mylist.getFirst();
            prev2 = mylist.getFirst();

            while (node != null) {
                if (prev1.data < node.data) {
                    temp = node.succ;
                    node.succ = prev1;
                    prev1.succ = temp;

                    if (prev1 == mylist.getFirst()) {
                        mylist.setFirst(node);
                    } else {
                        prev2.succ = node;
                    }
                    prev2 = node;
                    node = temp;
                } else {
                    if (prev1 != mylist.getFirst())
                        prev2 = prev2.succ;

                    prev1 = prev1.succ;
                    node = node.succ;

                }
            }
        }
        return mylist;
    }

    public static void main(String[] args) {
        MySLL<Integer> mylist = new MySLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.insertLast(sc.nextInt());
        }
        System.out.println(sort_opagjacki(mylist));
    }
}
