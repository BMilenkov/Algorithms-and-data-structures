package SLL;

import java.util.Scanner;

public class DuplicatesEven {

    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        int number = scanner.nextInt();

        int counter = 0;
        SLLNode<Integer> curr = list.getFirst();
        SLLNode<Integer> temp = null;
        while (curr != null) {
            if (curr.data == number) {
                counter++;
                temp = curr;
            }
            curr = curr.succ;
        }

        if (counter % 2 == 1)
            list.delete(temp);

        System.out.println(list);
    }
}
