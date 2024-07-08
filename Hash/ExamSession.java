package Hash;

import java.util.*;
import java.util.stream.Collectors;


class E {
    String time;
    String room;
    String subject;

    public E(String time, String room, String subject) {
        this.time = time;
        this.room = room;
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    //08:00 Laboratories Algoritmi i podatochni strukturi
    @Override
    public String toString() {

        return String.format("%s %s %s", time, room, subject);
    }
}


public class ExamSession {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        //FIRST WAY WITH CBHT:
//        CBHT<String, E> table = new CBHT<>(2 * n);
//        for (int i = 0; i < n; i++) {
//            String[] parts = scanner.nextLine().split("\\s++");
//            String subj = Arrays.stream(parts).skip(3).collect(Collectors.joining(" "));
//            table.insert(parts[0], new E(parts[1], parts[2], subj));
//        }
//        String date = scanner.nextLine();
//        SLLNode<MapEntry<String, E>> curr = table.search(date);
//        Set<E> set = new TreeSet<>(Comparator.comparing(E::getTime));
//        while (curr != null) {
//            set.add(curr.element.value);
//            curr = curr.succ;
//        }
//        set.forEach(System.out::println);

        //SECOND WAY WITH OBHT:
        OBHT<String, Set<E>> table = new OBHT<>(2 * n);
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\s++");
            if (table.search(parts[0]) != -1) {
                String subj = Arrays.stream(parts).skip(3).collect(Collectors.joining(" "));
                table.getBucket(table.search(parts[0])).value.add(new E(parts[1], parts[2], subj));
            } else {
                table.insert(parts[0], new TreeSet<>(Comparator.comparing(E::getTime)));
                String subj = Arrays.stream(parts).skip(3).collect(Collectors.joining(" "));
                table.getBucket(table.search(parts[0])).value.add(new E(parts[1], parts[2], subj));
            }
        }
        String date = scanner.nextLine();
        table.getBucket(table.search(date)).value.forEach(System.out::println);
    }
}
