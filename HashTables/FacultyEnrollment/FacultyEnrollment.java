package HashTables.FacultyEnrollment;

import HashTables.OBHT.*;
import java.util.Scanner;

public class FacultyEnrollment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        OBHT<String, Double> candidates = new OBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String[] student = scanner.nextLine().split("\\s++");
            candidates.insert(student[0], Double.parseDouble(student[1]));
        }

        int m = Integer.parseInt(scanner.nextLine());
        OBHT<String, Double> gradebook = new OBHT<>(2 * m);

        for (int i = 0; i < m; i++) {
            String[] student = scanner.nextLine().split("\\s++");
            gradebook.insert(student[0], Double.parseDouble(student[1]));
        }

        String searchFor = scanner.nextLine();

        if (gradebook.search(searchFor) == -1)
            System.out.println("Empty");
        else {
            double gradeByCandidate = candidates.getBucket(candidates.search(searchFor)).value;
            double gradebookGrade = gradebook.getBucket(gradebook.search(searchFor)).value;

            if (gradebookGrade == gradeByCandidate)
                System.out.println("OK");
            else System.out.println("Error");
        }

    }
}
