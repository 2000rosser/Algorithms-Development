package P7;

import java.util.ArrayList;
import java.util.List;

public class Brute_force {
    public static List<Integer> searchString(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        List<Integer> occur = new ArrayList<>();

        for (int pos = 0; pos < n - m; pos++) {
            if (txt.substring(pos, pos+(m)).equals(pat)) {
                System.out.println("found the pattern at the index "+pos);
                occur.add(pos);
            }
        }

        return occur;
    }

    public static void main(String[] args) {


        String txt= "dnjsakdlrisap laskndalm";
        String pat="a";

        searchString(txt, pat);

        System.out.println(searchString(txt, pat));

    }
}
