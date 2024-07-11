package HashTables.KumanovskiDijalekt;

import HashTables.CBHT.CBHT;
import HashTables.CBHT.MapEntry;
import HashTables.CBHT.SLLNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KumanovskiDijalekt {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        CBHT<String, String> dictionary = new CBHT<>(100);

        String[] rechnik = new String[N];
        for (int i = 0; i < N; i++) {
            rechnik[i] = br.readLine();
            String[] parts = rechnik[i].split("\\s+");
            dictionary.insert(parts[0], parts[1]);
        }

        String tekst = br.readLine();

        String[] words = tekst.split("\\s+");

        for (String word : words) {

            String searchedWord = word.replace(".", "")
                    .replace(",", "").replace("!", "").replace("?", "").toLowerCase();

            SLLNode<MapEntry<String, String>> standardWord = dictionary.search(searchedWord);

            char lastChar = word.charAt(word.length() - 1);
            if (standardWord == null)
                System.out.print(word + " ");
            else {
                StringBuilder sb = new StringBuilder();
                if (Character.isUpperCase(word.charAt(0)))
                    sb.append(Character.toUpperCase(standardWord.element.value.charAt(0)));
                else
                    sb.append(standardWord.element.value.charAt(0));
                sb.append(standardWord.element.value.substring(1));

                if (lastChar == '.' || lastChar == ',' || lastChar == '!' || lastChar == '?')
                    sb.append(lastChar);

                System.out.print(sb.toString() + " ");
            }
        }
    }
}
