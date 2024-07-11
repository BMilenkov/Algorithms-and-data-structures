package DynamicProgramming.DivideAndConquer;

public class DivideAndConquer {

    void merge(int a[], int l, int mid, int r) {
        int numel = r - l + 1;
        int temp[] = new int[100];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while ((i <= mid) && (j <= r)) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= r) {
            temp[k] = a[j];
            j++;
            k++;
        }
        for (k = 0; k < numel; k++) {
            a[l + k] = temp[k];
        }
    }

    void mergesort(int a[], int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergesort(a, l, mid);
        mergesort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private int pow(int x, int n) {

        if (n == 1)
            return x;
        if (n == 0)
            return 1;
        if (n % 2 == 1) {
            int result = pow(x, n / 2);
            return result * result * x;
        } else {
            int result = pow(x, n / 2);
            return result * result;
        }
    }

    public static void main(String[] args) {
        int i;
        DivideAndConquer dac = new DivideAndConquer();
        System.out.println("pow: " + dac.pow(2, 10));
    }
}
