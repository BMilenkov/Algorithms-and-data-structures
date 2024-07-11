package SLL.SplitList;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitList {
    public static void main(String[] args) throws IOException {
        MySLL<Integer> list = new MySLL<Integer>();
        MySLL<Integer> evenList = new MySLL<Integer>();
        MySLL<Integer> oddsList = new MySLL<Integer>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        s = br.readLine();
        String[] arr = s.split(" ");
        for (int i = 0; i < n; i++) {
            list.insertLast(Integer.parseInt(arr[i]));
        }

        SLLNode<Integer> temp = list.getFirst();

        while (temp != null) {

            if ((temp.succ != null && temp.data % 2 == 0 && temp.succ.data % 2 == 0)
                    || (temp.succ != null && temp.data % 2 == 1 && temp.succ.data % 2 == 1)) {
            } else {
                if (temp.data % 2 == 0)
                    evenList.insertLast(temp.data);
                else
                    oddsList.insertLast(temp.data);
            }
            temp = temp.succ;
        }

        System.out.println(evenList);
        System.out.println(oddsList);

    }
}
