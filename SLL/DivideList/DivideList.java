package SLL.DivideList;

import SLL.SLLNode.MySLL;
import SLL.SLLNode.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideList {

    public static void main(String[] args) throws IOException {
        MySLL<Integer> lista = new MySLL<>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        MySLL<Integer> parni = new MySLL<>();
        MySLL<Integer> neparni = new MySLL<>();
        SLLNode<Integer> curr = lista.getFirst();

        while (curr.succ != null) {
            if (curr.data % 2 == 0 && curr.succ.data % 2 != 0)
                parni.insertLast(curr.data);
            if (curr.data % 2 != 0 && curr.succ.data % 2 == 0)
                neparni.insertLast(curr.data);
            curr = curr.succ;
        }
        if (curr.data % 2 == 0)
            parni.insertLast(curr.data);
        else neparni.insertLast(curr.data);
        System.out.println(parni);
        System.out.println(neparni);

    }
}
