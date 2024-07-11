package HashTables.Company;

import HashTables.OBHT.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Company {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        OBHT<String, Integer> table = new OBHT<>(2 * n);
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(",");

            if (table.search(parts[1]) == -1) {
                table.insert(parts[1], 1);
                map.put(parts[1], 1);
            } else {
                int v = table.getBucket(table.search(parts[1])).value;
                table.insert(parts[1], ++v);
                map.put(parts[1], v);
            }
        }
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
