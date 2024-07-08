package Lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {

        int counter = 1;
        int maxCounter = 0;
        for (int i = 1; i < a.length; i++) {
            if ((a[i - 1] < 0 && a[i] > 0) || (a[i - 1] > 0 && a[i] < 0))
                counter++;
            else counter = 1;
            if(counter > maxCounter)
                maxCounter = counter;
        }
        return maxCounter;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i = 0; i < N; i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
