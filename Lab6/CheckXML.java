package Lab6;


import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class CheckXML {


    public static int isValid(String[] redovi) {

        Stack<String> openTags = new Stack<>();

        for (String s : redovi) {

            if (s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']')
                if (s.charAt(1) == '/' && !openTags.isEmpty()) {
                    String openTag = openTags.pop();
                    if (!s.equals(openTag.charAt(0) + "/" + openTag.substring(1)))
                        return 0;
                } else
                    openTags.push(s);
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        System.out.println(isValid(redovi));
        br.close();
    }
}
