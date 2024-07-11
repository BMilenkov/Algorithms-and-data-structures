package SLL.APS2007;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.*;

//16 2 1 3 1 4 1 2 5 3 1 6 7 8 10 6 2

public class APS2007 {
    public static void main(String[] args) {
        MySLL<Integer> list = new MySLL<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(scanner.nextInt());
        }
        transformList(list);
        System.out.println(list);
    }

    private static void transformList(MySLL<Integer> list) {

        SLLNode<Integer> curr = list.getFirst();
        Map<Integer, Integer> freq = new HashMap<>();
        Set<Integer> removed = new HashSet<>();
        while (curr != null) {
            if (freq.containsKey(curr.data)) {
                freq.put(curr.data, freq.get(curr.data) + 1);
            } else {
                freq.put(curr.data, 1);
            }
            curr = curr.succ;
        }

        list.mirror();

        curr = list.getFirst();
        while (curr != null) {
            if (!removed.contains(curr.data) && (freq.get(curr.data) >= 2)) {
                list.delete(curr);
                removed.add(curr.data);
            }
            curr = curr.succ;
        }
        list.mirror();
    }
}
