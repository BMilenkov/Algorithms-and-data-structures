package Hash;


//1
//5043 courses.finki.ukim.mk
//3
//courses.finki.ukim.mk
//finki.ukim.mk
//ukim.mk
//mk

import java.util.Scanner;

public class WebDomains {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        OBHT<String, Integer> table = new OBHT<>(100);

        for (int i = 0; i < n; i++) {
            String[] domain = scanner.nextLine().split("\\s++");
            int views = Integer.parseInt(domain[0]);
            String[] domainParts = domain[1].split("\\.");

            for (String domainPart : domainParts) {
                if (table.search(domainPart) == OBHT.NONE) {
                    table.insert(domainPart, views);
                } else {
                    int p = table.getBucket(table.search(domainPart)).value;
                    table.insert(domainPart, p + views);
                }
            }
        }
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] domainParts = scanner.nextLine().split("\\.");
            if (table.search(domainParts[0]) == OBHT.NONE) {
                System.out.println("Not found\n");
                continue;
            }
            System.out.println(table.getBucket(table.search(domainParts[0])).value);
        }
    }
}
