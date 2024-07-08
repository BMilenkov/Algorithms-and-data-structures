package Hash;

import java.util.*;


class Name implements Comparable<Name> {
    private final String name;

    public Name(String name) {
        this.name = name.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return (100 * (100 * (name.charAt(2)) + name.charAt(1)) + name.charAt(0)) % 656565;
    }

    @Override
    public int compareTo(Name o) {
        return name.compareTo(o.name);
    }
}


class Medicine {
    private final String name;
    private final int posList;
    private final int price;
    private int quantity;

    public Medicine(String name, int posList, int price, int quantity) {
        this.name = name;
        this.posList = posList;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPosList() {
        return posList;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d", name, posList == 1 ? "POS" : "NEG", price, quantity);
    }
}

public class Pharmacy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int medNum = Integer.parseInt(scanner.nextLine());
        CBHT<Name, Medicine> table = new CBHT<>(656565);


        //not recommended
//        int medNum = Integer.parseInt(scanner.nextLine());
//        CBHT<Name, ArrayList<Medicine>> table = new CBHT<>(2 * medNum);
//
//        for (int i = 0; i < medNum; i++) {
//            String[] med = scanner.nextLine().split("\\s++");
//            Name name = new Name(med[0].toUpperCase());
//            Medicine medicine = new Medicine(med[0], Integer.parseInt(med[1]), Integer.parseInt(med[2]), Integer.parseInt(med[3]));
//
//            if (table.search(name) == null) {
//                table.insert(name, new ArrayList<>());
//                table.search(name).element.value.add(medicine);
//            } else {
//                table.search(name).element.value.add(medicine);
//            }
//        }
//
//        String line;
//        while (!(line = scanner.nextLine().toUpperCase()).equals("END")) {
//
//            SLLNode<MapEntry<Name, ArrayList<Medicine>>> med = table.search(new Name(line));
//
//            if (med == null) {
//                System.out.println("No such drug");
//                scanner.nextLine();
//            } else {
//                String a = line;
//                List<Medicine> medicines = med.element.value;
//                Optional<Medicine> m = medicines.stream().filter(medicine -> medicine.getName().equals(a)).findAny();
//                if (m.isEmpty()) {
//                    System.out.println("No such drug");
//                    scanner.nextLine();
//                } else {
//                    int quantity = Integer.parseInt(scanner.nextLine());
//                    if (quantity > m.get().getQuantity())
//                        System.out.println("No drugs available");
//                    else {
//                        System.out.println(m.get());
//                        System.out.println("Order made");
//                        m.get().setQuantity(quantity);
//                    }
//                }
//            }
//        }


        //good one using hashcode of Name class!!!
        for (int i = 0; i < medNum; i++) {
            String[] med = scanner.nextLine().split("\\s++");
            Name name = new Name(med[0].toUpperCase());
            Medicine medicine = new Medicine(med[0], Integer.parseInt(med[1]), Integer.parseInt(med[2]), Integer.parseInt(med[3]));
            table.insert(name, medicine);
        }

        String line;
        while (!(line = scanner.nextLine().toUpperCase()).equals("END")) {

            SLLNode<MapEntry<Name, Medicine>> med = table.search(new Name(line));

            if (med == null) {
                System.out.println("No such drug");
                scanner.nextLine();
            } else {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > med.element.value.getQuantity())
                    System.out.println("No drugs available");
                else {
                    System.out.println(med.element.value);
                    System.out.println("Order made");
                    med.element.value.setQuantity(quantity);
                    table.insert(new Name(line), med.element.value);
                }
            }
        }
    }
}
