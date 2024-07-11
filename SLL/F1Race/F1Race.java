package SLL.F1Race;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class F1Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        MySLL<String> driversList = new MySLL<>();
        Map<String, Integer> driverOil = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\s++");
            driverOil.put(parts[0], Integer.parseInt(parts[1]));
            String driver = String.format(" %s(%d) ", parts[0], Integer.parseInt(parts[1]));
            driversList.insertFirst(driver);
        }

        int M = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < M; i++) {
            String[] updatesInfo = scanner.nextLine().split("\\s++");
            String name = updatesInfo[0];
            Integer oil = Integer.parseInt(updatesInfo[1]); // position move on;

            String driver = String.format(" %s(%d) ", name, driverOil.get(name));
            String driverNew = String.format(" %s(%d) ", name, oil);

            SLLNode<String> prev = driversList.find(driver);
            SLLNode<String> curr = driversList.find(driver);

            //to get the last position of the sll, first driver position!
            SLLNode<String> start = driversList.getFirst();
            while (start.succ != null)
                start = start.succ;

            if (curr == null || start.data.equals(driver)) {
                System.out.println(driversList);
                continue;
            } else {
                if (driverOil.get(name) < oil) {
                    driversList.delete(curr);
                    driverOil.remove(name);
                } else {
                    int counter = 0;
                    while (counter != oil && curr != null) {
                        curr = curr.succ;
                        counter++;
                    }
                    driversList.delete(prev);
                    if (curr == null) {
                        driversList.insertLast(driverNew);
                    } else {
                        driversList.insertAfter(driverNew, curr);
                    }
                    driverOil.put(name, oil);
                }
                System.out.println(driversList);
            }
        }
    }
}
