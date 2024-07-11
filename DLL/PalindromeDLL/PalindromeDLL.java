package DLL.PalindromeDLL;

import java.util.Scanner;

public class PalindromeDLL {


    public static boolean isPalindrome(MyDLL<Integer> mylist) {
        DLLNode<Integer> poceten = mylist.first;
        DLLNode<Integer> kraen = mylist.last;

        while (poceten != kraen && poceten.succ != kraen) {
            if (!poceten.element.equals(kraen.element))
                return false;
            poceten = poceten.succ;
            kraen = kraen.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        MyDLL<Integer> mylist = new MyDLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            mylist.insertLast(sc.nextInt());
        }
        sc.close();
        System.out.println(isPalindrome(mylist));
    }
}
