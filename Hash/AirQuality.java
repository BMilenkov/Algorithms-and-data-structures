package Hash;

import java.util.Scanner;

public class AirQuality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        CBHT<String, Double> table = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\s++");
            table.insert(parts[0], Double.parseDouble(parts[1]));
        }
        String mun = scanner.nextLine();
        double sum = 0;
        SLLNode<MapEntry<String, Double>> curr = table.search(mun);
        int counter = 0;
        while (curr != null) {
            counter++;
            sum += curr.element.value;
            curr = curr.succ;
        }

        System.out.printf("%.02f\n", sum/counter);
    }
}
