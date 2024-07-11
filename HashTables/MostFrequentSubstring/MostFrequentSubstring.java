package HashTables.MostFrequentSubstring;

import HashTables.CBHT.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MostFrequentSubstring {
    public static void main(String[] args) throws IOException {
        CBHT<String, Integer> tabela = new CBHT<String, Integer>(100);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();
        Set<String> keys = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                keys.add(word.substring(i, j));
                if (tabela.search(word.substring(i, j)) != null)
                    tabela.insert(word.substring(i, j), ++tabela.search(word.substring(i, j)).element.value);
                else
                    tabela.insert(word.substring(i, j), 1);
            }
        }

        int maxFreq = 0;
        String subString = "";

        for (String key : keys) {
            if (tabela.search(key).element.value > maxFreq) {
                maxFreq = tabela.search(key).element.value;
                subString = key;
            }
            else if (tabela.search(key).element.value == maxFreq) {
                int res = Integer.compare(tabela.search(key).element.key.length(), subString.length());
                if (res == 1) {
                    subString = tabela.search(key).element.key;
                }
            }
        }
        System.out.println(subString);
    }
}