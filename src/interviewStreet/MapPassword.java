package interviewStreet;

import java.util.ArrayList;
import java.util.HashMap;

public class MapPassword {

    public static HashMap<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();

    static {
        ArrayList<Character> m = new ArrayList<Character>();
        m.add('A');
        m.add('@');
        m.add('4');
        map.put('a', m);
        ArrayList<Character> m1 = new ArrayList<Character>();
        m1.add('E');
        m1.add('#');
        map.put('e', m1);
    }

    // similar with the tel words
    public static void password(String pw) {
        int n = pw.length();
        int answer[] = new int[n];
        while (true) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                char ch = pw.charAt(i);
                if (map.containsKey(ch))
                    sb.append(map.get(ch).get(answer[i]));
                else
                    sb.append(ch);
            }
            System.out.println(sb);

            int k = n - 1;
            while (k >= 0) {
                char c = pw.charAt(k);
                if (map.containsKey(c)) {
                    if (answer[k] < map.get(c).size() - 1) {
                        answer[k]++;
                        break;
                    } else {
                        answer[k] = 0;
                        k--;
                    }
                } else
                    k--;
            }
            if (k < 0)
                break;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        // password("facea");
    }

}
