package Labs.Lab3;

import java.util.Scanner;

public class MiceHoles {

    //TODO: implement function
    public static int minTime(int mice[], int holes[]) {
        int n = mice.length;
//        int max = 0;
//      Arrays.sort(mice);
//      Arrays.sort(holes);
//        for (int i = 0; i < n; i++) {
//            int diff = Math.abs(mice[i] - holes[i]);
//            if(diff > max){
//                max = diff;
//            }
//        }
//        return max;


        int maxMin = 0;
        int diff;
        for (int i = 0; i < n; i++) {
            int min = Math.abs(mice[i] - holes[0]);
            for (int j = 0; j < n; j++) {
                diff = Math.abs(mice[i] - holes[j]);
                if (diff < min)
                    min = diff;
            }
            if (min > maxMin) {
                maxMin = min;
            }
        }
        return maxMin;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}
