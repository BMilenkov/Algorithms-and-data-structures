package Hash;

import java.text.ParseException;
import java.util.*;

//        5
//        SK1234AA Anita Angelovska
//        OH1212BE Aleksandar Antov
//        ST0989OO Ognen Spirovski
//        ST0000AB Sara Spasovska
//        SK8888KD Dino Ackov
//        50
//        SK8888KD 48 14:00:00 ST0000AB 55 12:00:02 ST0989OO 60 08:10:00 SK1234AA 65 20:00:10 OH1212BE 50 22:00:21

//Ognen Spirovski
//Sara Spasovska
//Anita Angelovska
class Driver {
    private final String name;
    private final String surname;
    private String date;

    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}

public class Semafori {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        OBHT<String, Driver> table = new OBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String[] driver = scanner.nextLine().split("\\s++");
            table.insert(driver[0], new Driver(driver[1], driver[2]));
        }
        int maxSpeed = Integer.parseInt(scanner.nextLine());

        String[] informations = scanner.nextLine().split("\\s++");
        Set<Driver> drivers = new TreeSet<>(Comparator.comparing(Driver::getDate));

        for (int i = 0; i < informations.length; i += 3) {
            int speed = Integer.parseInt(informations[i + 1]);
            Driver d = table.getBucket(table.search(informations[i])).value;
            if (speed > maxSpeed) {
                d.setDate(informations[i + 2]);
                drivers.add(d);
            }
        }
        drivers.forEach(System.out::println);
    }
}
