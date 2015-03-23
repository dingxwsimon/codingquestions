package stringoperation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestWordsByOtherWords {
    public static class LengthComparator implements Comparator<String> {
	public int compare(String o1, String o2) {
	    if (o1.length() < o2.length())
		return 1;
	    if (o1.length() > o2.length())
		return -1;
	    return 0;
	}
    }

    // CC150 18.7
    public static String printLongestWord(String arr[]) {
	HashMap<String, Boolean> unused = new HashMap<String, Boolean>();
	for (String str : arr) {
	    unused.put(str, true);
	}
	Arrays.sort(arr, new LengthComparator()); // Sort by length
	for (String s : arr) {
	    if (canBuildWord(s, true, unused)) {
		System.out.println(s);
		return s;
	    }
	}
	return "";
    }

    public static boolean canBuildWord(String str, boolean isOriginalWord,
	    HashMap<String, Boolean> unused) {
	if (unused.containsKey(str) && !isOriginalWord) {
	    return unused.get(str);
	}
	for (int i = 1; i < str.length(); i++) {
	    String left = str.substring(0, i);
	    String right = str.substring(i);
	    if (unused.containsKey(left) && unused.get(left) == true
		    && canBuildWord(right, false, unused)) {
		return true;
	    }
	}
	unused.put(str, false);
	return false;
    }

    public static void main(String[] args) {
	String[] arr = createGiantArray();
	printLongestWord(arr);
    }

    public static String[] createGiantArray() {
	ArrayList<String> list = new ArrayList<String>();
	BufferedReader br = null;
	try {
	    br = new BufferedReader(new FileReader("./bigdict.txt"));
	    String line = "";
	    while ((line = br.readLine()) != null) {
		list.add(line);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (br != null)
		try {
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	String[] arr = new String[list.size()];
	for (int i = 0; i < list.size(); i++) {
	    arr[i] = list.get(i);
	}
	return arr;
    }

}
