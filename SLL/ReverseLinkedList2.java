package SLL;

import java.util.Scanner;

public class ReverseLinkedList2 {


    public static SLLNode<Integer> reverseNodes(SLLNode<Integer> LeftNode) {
        SLLNode<Integer> prev = null;
        SLLNode<Integer> curr = LeftNode;
        SLLNode<Integer> next;

        while (curr.succ != null) {
            next = curr.succ;
            curr.succ = prev;
            prev = curr;
            curr = next;
        }
        LeftNode = prev;
        return LeftNode;
    }

    public static void ReverseLinkedList(MySLL<Integer> list, int left, int right) {


        //RESHENIE SO POMOSNA!!!
//        MySLL<Integer> temp = new MySLL<>();
//        SLLNode<Integer> BeforeLeftNode = list.getFirst();
//        int counter = 0;
//        while (BeforeLeftNode != null) {
//            counter++;
//            if (counter == left - 1)
//                break;
//            BeforeLeftNode = BeforeLeftNode.succ;
//        }
//        SLLNode<Integer> LeftNode = BeforeLeftNode.succ;
//        counter = 0;
//        SLLNode<Integer> AfterRightNode = list.getFirst();
//        while (AfterRightNode != null) {
//            counter++;
//            if (counter == right + 1)
//                break;
//            AfterRightNode = AfterRightNode.succ;
//        }
//        while (LeftNode!=AfterRightNode){
//            temp.insertLast(LeftNode.data);
//            list.delete(LeftNode);
//            LeftNode = LeftNode.succ;
//        }
//        temp.mirror();
//        SLLNode<Integer> firstTemp = temp.getFirst();
//        while (firstTemp!=null){
//            list.insertAfter(firstTemp.data,BeforeLeftNode);
//            BeforeLeftNode = BeforeLeftNode.succ;
//            firstTemp = firstTemp.succ;
//        }


        //RESHENIE BEZ POMOSHNA!!!
        SLLNode<Integer> BeforeLeftNode = list.getFirst();
        int counter = 0;
        while (BeforeLeftNode != null) {
            counter++;
            if (counter == left - 1)
                break;
            BeforeLeftNode = BeforeLeftNode.succ;
        }
        SLLNode<Integer> LeftNode = BeforeLeftNode.succ;
        SLLNode<Integer> AfterRightNode = list.getFirst();
        counter = 0;
        while (AfterRightNode != null) {
            counter++;
            if (counter == right + 1)
                break;
            AfterRightNode = AfterRightNode.succ;
        }
        BeforeLeftNode.succ = reverseNodes(LeftNode);
        list.insertLast(AfterRightNode.data);
    }

    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        ReverseLinkedList(list, left, right);
        System.out.println(list);
    }
}
