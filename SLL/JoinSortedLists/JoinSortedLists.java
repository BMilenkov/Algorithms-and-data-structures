package SLL.JoinSortedLists;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

public class JoinSortedLists<E extends Comparable<E>> {

    public MySLL<E> join(MySLL<E> list1, MySLL<E> list2) {
        MySLL<E> finalList = new MySLL<E>();
        SLLNode<E> j1 = list1.getFirst();
        SLLNode<E> j2 = list2.getFirst();

        while (j1 != null && j2 != null) {
            if (j1.data.compareTo(j2.data) < 0) {
                finalList.insertLast(j1.data);
                j1 = j1.succ;
            } else {
                finalList.insertLast(j2.data);
                j2 = j2.succ;
            }
        }

        while (j1 != null) {

            finalList.insertLast(j1.data);
            j1 = j1.succ;

        }

        while (j2 != null) {
            finalList.insertLast(j2.data);
            j2 = j2.succ;
        }
        return finalList;
    }

    public static void main(String[] args) {

        MySLL<String> list1 = new MySLL<>();
        list1.insertLast("Ana");
        list1.insertLast("Bojana");

        list1.insertLast("Dejan");

        MySLL<String> list2 = new MySLL<>();
        list2.insertLast("Adrijana");
        list2.insertLast("Biljana");
        list2.insertLast("Darko");


        JoinSortedLists<String> js = new JoinSortedLists<String>();
        System.out.println(js.join(list1,list2));
        


    }
}