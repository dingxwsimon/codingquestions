package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FindOverNth {
    // http://www.geeksforgeeks.org/given-an-array-of-of-
    // size-n-finds-all-the-elements-that-appear-more-than-nk-times/
    // given an array, find the element that appear more than length/n number of
    // times
    public static ArrayList<Integer> findOverNth(int[] array, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int total = 0;
        //
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
                map.put(array[i], map.get(array[i]) + 1);
            else
                map.put(array[i], 1);
            total++;
            // could not be more than n results
            if (total == n) {
                Iterator<Entry<Integer, Integer>> iter = map.entrySet()
                        .iterator();
                while (iter.hasNext()) {
                    Map.Entry<Integer, Integer> entry = iter.next();
                    if (entry.getValue() == 1)
                        iter.remove();
                    else
                        entry.setValue(entry.getValue() - 1);
                }
            }

        }
        for (int key : map.keySet()) {
            map.put(key, 0);
        }
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
                map.put(array[i], map.get(array[i]) + 1);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int key : map.keySet()) {
            if (map.get(key) >= array.length / n)
                result.add(key);
        }
        return result;
    }

    // just remember it
    public static int findMoreThanHalf(int[] array) {
        int cand = array[0];
        int mtime = 0;
        for (int i = 0; i < array.length; i++) {
            if (mtime == 0) {
                cand = array[i];
                mtime++;
            } else {
                if (cand == array[i])
                    mtime++;
                else
                    mtime--;
            }
        }
        return cand;
    }

    public int findMajorityElement(int arr[]) {
        if (arr == null)
            return Integer.MIN_VALUE;
        int length = arr.length;
        int majorIndex = 0;
        int count = 1;
        for (int i = 0; i < length; i++) {
            if (arr[majorIndex] == arr[i])
                count++;
            else
                count--;
            if (count == 0) {
                majorIndex = i;
                count = 1;
            }
        }
        return arr[majorIndex];
    }

    public boolean isMajority(int arr[]) {
        if (arr == null)
            return false;
        int element = findMajorityElement(arr);
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == element)
                count++;
        }
        if (count > length / 2)
            return true;
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {8, 8, 8, 8, 8, 8, 3, 3, 3, 3};
        // System.out.println(findOverNth(array, 3));
        System.out.println(findMoreThanHalf(array));
    }

}
