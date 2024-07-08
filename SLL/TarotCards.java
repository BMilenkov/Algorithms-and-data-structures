package SLL;

import java.util.Scanner;

public class TarotCards {


    public static void TarotShuffle(MySLL<Integer> list1, MySLL<Integer> list2) {

        SLLNode<Integer> curr = list1.getFirst();
        list1.delete(curr);
        list2.insertLast(curr.data);

        curr = list2.getFirst();
        list2.delete(curr);
        list1.insertLast(curr.data);

        curr = list1.getFirst();
        while (curr.succ.succ != null)
            curr = curr.succ;

        list1.delete(curr);
        SLLNode<Integer> l2 = list2.getFirst();

        list2.insertAfter(curr.data, l2.succ.succ);


//        SLLNode<Integer> first1 = list1.getFirst();
//        SLLNode<Integer> first2 = list2.getFirst();
//        SLLNode<Integer> last1 = list1.getFirst();
//        SLLNode<Integer> last2 = list2.getFirst();
//
//        while (last2.succ != null) {
//            last2 = last2.succ;
//        }
//        while (last1.succ != null) {
//            last1 = last1.succ;
//        }
//        last1.succ = first2;
//        list2.setFirst(first2.succ);
//        first2.succ = null;
//        last2.succ = first1;
//        list1.setFirst(first1.succ);
//        first1.succ = null;
//
//        first1 = list1.getFirst();
//        first2 = list2.getFirst();
//        int counter = 0;
//        while (counter < 3) {
//            first1 = first1.succ;
//            counter++;
//        }
//        SLLNode<Integer> pretposleden = first1.succ;
//        first1.succ = first1.succ.succ;
//        counter = 0;
//        while (counter < 2) {
//            first2 = first2.succ;
//            counter++;
//        }
//        pretposleden.succ = first2.succ;
//        first2.succ = pretposleden;
    }

    public static void main(String[] args) {
        MySLL<Integer> list1 = new MySLL<>();
        MySLL<Integer> list2 = new MySLL<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            list1.insertLast(scanner.nextInt());
        }
        for (int i = 0; i < 6; i++) {
            list2.insertLast(scanner.nextInt());
        }

        TarotShuffle(list1, list2);
        System.out.println(list1);
        System.out.println(list2);
    }
}
