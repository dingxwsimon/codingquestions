package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
	map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    public boolean find(int value) {
	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	    int i = entry.getKey();
	    int j = value - i;
	    if ((i == j && entry.getValue() > 1)
		    || (i != j && map.containsKey(j))) {
		return true;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
