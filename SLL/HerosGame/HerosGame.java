package SLL.HerosGame;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class HerosGame {


    public static void startHerosGame(MySLL<Integer> list1, MySLL<Integer> list2) {

        SLLNode<Integer> temp = list1.getFirst();
        SLLNode<Integer> bestCard = list1.getFirst();
        int max = -1;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
                bestCard = temp;
            }
            temp = temp.succ;
        }
        temp = list1.getFirst();
        while (temp.succ != bestCard) {
            temp = temp.succ;
        }
        temp.succ = temp.succ.succ;

        SLLNode<Integer> temp1 = list2.getFirst();

        int counter = 0;
        while (counter < 2) {
            temp1 = temp1.succ;
            counter++;
        }
        bestCard.succ = temp1.succ;
        temp1.succ = bestCard;
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

        startHerosGame(list1, list2);
        System.out.println(list1);
        System.out.println(list2);
    }
}

