package HashTables.Speluvanje;

import HashTables.OBHT.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Zbor implements Comparable<Zbor> {
    String zbor;

    public Zbor(String zbor) {
        this.zbor = zbor;
    }

    @Override
    public boolean equals(Object obj) {
        Zbor pom = (Zbor) obj;
        return this.zbor.equals(pom.zbor);
    }

    @Override
    public int hashCode() {
        return zbor.hashCode();
    }

    @Override
    public String toString() {
        return zbor;
    }

    @Override
    public int compareTo(Zbor arg0) {
        return zbor.compareTo(arg0.zbor);
    }
}

public class Speluvanje {
    public static void main(String[] args) throws IOException {
        OBHT<Zbor, String> tabela;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tabela = new OBHT<Zbor, String>(2 * N - 1);
        List<String> incorrectWords = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            tabela.insert(new Zbor(word), word);
        }

        String[] words = br.readLine().split("\\s++");
        if (words.length == 1)
            System.out.println("Bravo");

        for (String s : words) {
            String word = s.replace(".", "").replace(",", "").replace("!", "")
                    .replace("?", "").toLowerCase();
            if (tabela.search(new Zbor(word)) == -1) {
                incorrectWords.add(word);
            }
        }

        if (incorrectWords.isEmpty())
            System.out.println("Bravo");
        else {
            incorrectWords.forEach(System.out::println);
        }
    }
}
