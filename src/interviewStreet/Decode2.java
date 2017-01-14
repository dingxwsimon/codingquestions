package interviewStreet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Decode2 {
    static HashMap<String, ArrayList<String>> tranDict = new HashMap<String, ArrayList<String>>();

    public static void transformDict() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./dict.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String transformedStr = transformWord(line);
                if (tranDict.containsKey(transformedStr)) {
                    tranDict.get(transformedStr).add(line);
                } else {
                    ArrayList<String> wordLists = new ArrayList<String>();
                    wordLists.add(line);
                    tranDict.put(transformedStr, wordLists);
                }
            }
        } catch (Exception e) {
            System.out
                    .println("Exception happned when construct the dictionary trie");
            e.printStackTrace();
        }
    }

    private static String transformWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(((word.charAt(i) - 97) % 5 + 1) + "");
        }
        return sb.toString();
    }

    public static void decode(String message) {
        transformDict();
        if (tranDict.containsKey(message)) {
            for (String word : tranDict.get(message)) {
                System.out.println(word);
            }
        }
    }

    public static void main(String[] args) {
        String message = "2545";
        Decode2.decode(message);
    }

}
