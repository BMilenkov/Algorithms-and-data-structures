package Lab1;

import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int[] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }
    
    public int sales() {
        int sum = 0;
        for (int i = 0; i < this.numOfSales; i++) {
            sum += revenues[i];
        }
        return sum;
    }

}

class SalesPerson {

    private String name;
    private QuarterlySales[] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    public QuarterlySales getQuarters(int i) {
        return quarters[i];
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "   ");
        for (QuarterlySales qs : quarters) {
            sb.append(qs.sales() + "   ");
            sum += qs.sales();
        }
        sb.append(sum);
        return sb.toString();
    }
}


public class Main {
    public static int sumSales(SalesPerson sp) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += sp.getQuarters(i).sales();
        }
        return sum;
    }
    public static SalesPerson salesChampion(SalesPerson[] arr) {
        int max = 0;
        SalesPerson maxPerson = null;
        for (SalesPerson sp : arr) {
            if (sumSales(sp) > max) {
                maxPerson = sp;
                max = sumSales(sp);
            }
        }
        return maxPerson;
    }

    public static void table(SalesPerson[] arr) {
        System.out.println("SP   1   2   3   4   Total");
        for (SalesPerson sp : arr) {
            System.out.println(sp);
        }
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson[] arr = new SalesPerson[n];
        for (int i = 0; i < n; i++) {
            String name = input.next();
            QuarterlySales[] qs = new QuarterlySales[4];
            for (int j = 0; j < 4; j++) {
                int numOfSales = input.nextInt();
                int[] revenues = new int[numOfSales];
                for (int k = 0; k < numOfSales; k++) {
                    revenues[k] = input.nextInt();
                }
                qs[j] = new QuarterlySales(numOfSales, revenues, j + 1);
            }
            arr[i] = new SalesPerson(name, qs);
        }
        table(arr);
        System.out.println("\nSALES CHAMPION: " + salesChampion(arr).getName());

    }
}