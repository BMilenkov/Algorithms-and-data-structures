package SLL;

import java.util.Scanner;

public class SwapPairs {

    public static void SwapNodes(MySLL<Integer> mylist) {

        // 1. NEPRAKTICNO SO MENUVANJE NA ELEMENTITE, A NE JAZLITE!
//        SLLNode<Integer> curr = mylist.getFirst();
//        while (curr != null) {
//            if (curr.succ == null)
//                break;
//            int k = curr.data;
//            curr.data = curr.succ.data;
//            curr.succ.data = k;
//            curr = curr.succ.succ;
//        }


        // 2. NAJPRAVILNO SAMO SO NODOVI!!!
//        SLLNode<Integer> curr = mylist.getFirst();
//        SLLNode<Integer> temp;
//        mylist.setFirst(curr.succ);
//        while (true) {
//            temp = curr.succ.succ;
//            if (temp == null)
//                break;
//            curr.succ.succ = curr;
//            curr.succ = temp.succ;
//            curr = temp;
//        }
//        mylist.insertLast(curr.data);
//    }


//        3. SO METODI GOTOVI!!!(BEZ POMOSHNA)
//        SLLNode<Integer> curr = mylist.getFirst();
//        while (curr != null) {
//            mylist.insertBefore(curr.succ.data,curr);
//            mylist.delete(curr.succ);
//            curr = curr.succ;
//        }
    }

    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++)     {
            list.insertLast(scanner.nextInt());
        }
        SwapNodes(list);
        System.out.println(list);
    }
}
