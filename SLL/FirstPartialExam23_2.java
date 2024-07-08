package SLL;

import java.util.Scanner;

public class FirstPartialExam23_2 {

    //input:
    //c a t , d o g , c o w

    //output:
    // c->a->t->,->d->o->g->,->c->o->w
    //cat->dog->cow

    public static void putWordsTogether(MySLL<String> list) {

        SLLNode<String> curr = list.getFirst();
        while (curr.succ != null) {
            if (!curr.succ.data.equals(",")) {
                curr.data = curr.data + curr.succ.data;
                list.delete(curr.succ);
            } else {
                list.delete(curr.succ);
                curr = curr.succ;
            }
        }
    }

    public static void main(String[] args) {
        MySLL<String> list = new MySLL<>();

        Scanner scanner = new Scanner(System.in);

        String[] characters = scanner.nextLine().split("\\s++");

        for (String character : characters) {
            list.insertLast(character);
        }
        System.out.println(list);
        putWordsTogether(list);
        System.out.println(list);
    }
}
