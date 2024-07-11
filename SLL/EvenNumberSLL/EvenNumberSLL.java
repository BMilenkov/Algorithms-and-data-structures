package SLL.EvenNumberSLL;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.Scanner;

public class EvenNumberSLL {

    public static int evenNumbers(MySLL<Integer> list) {
        SLLNode<Integer> temp = list.getFirst();
        int res = 0;
//        if(temp.data %2 == 0){
//            res++;
//        }
        while (temp != null) {
            if (temp.data % 2 == 0)
                res++;
            temp = temp.succ;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vnesete go brojot na elementi na listata!");
        int n = scanner.nextInt();
        MySLL<Integer> list1 = new MySLL<>();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scanner.nextInt());
        }
        System.out.println("Brojot na parni elemenenti vo listata e: " + evenNumbers(list1));
        System.out.println(list1);


        System.out.println("------------TESTING MIRROR FUNCTION!!!--------");

        MySLL<String> list2 = new MySLL<>();
        list2.insertLast("Ovaa");
        list2.insertLast("Lista");

        list2.insertLast("Ke");
        list2.insertLast("bide");
        list2.insertLast("PREVRTENA");
        System.out.println("Listata pred prevrtuvanjeto: " + list2);
        list2.mirror();
        System.out.println("Listata po prevrtuvanjeto : "+ list2);

    }
}
