package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {

    // Working!! O(n^3)
    // time limit
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        HashSet<String> set = new HashSet<String>();
        int n = num.length;
        for (int i = 0; i < n - 3; ) {
            for (int j = i + 1; j < n - 2; ) {
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int a = num[i];
                    int b = num[j];
                    int c = num[l];
                    int d = num[r];
                    String str4 = a + " " + b + " " + c + " " + d;
                    if (a + b + c + d == target) {
                        if (!set.contains(str4)) {
                            ArrayList<Integer> out = new ArrayList<Integer>();
                            out.add(a);
                            out.add(b);
                            out.add(c);
                            out.add(d);
                            ret.add(out);
                            set.add(str4);
                        }
                        while (l < n - 1 && num[l] == c)
                            l++;
                        while (r > 2 && num[r] == d)
                            r--;
                    } else if (a + b + c + d < target) {
                        l++;
                    } else {
                        r--;
                    }
                    int jprev = num[j];
                    while (j < n - 2 && num[j] == jprev)
                        j++;
                }
                int iprev = num[i];
                while (i < n - 3 && num[i] == iprev)
                    i++;
            }
        }
        return ret;

    }

    public static ArrayList<ArrayList<Integer>> fourSum1(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;
        for (int i = 0; i < n - 3; ) {
            for (int j = i + 1; j < n - 2; ) {
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    System.out.println(i + " " + j + " " + k + " " + l);
                    if (num[i] + num[j] + num[k] + num[l] == target) {
                        ArrayList<Integer> out = new ArrayList<Integer>();
                        out.add(num[i]);
                        out.add(num[j]);
                        out.add(num[k]);
                        out.add(num[l]);
                        ret.add(out);
                        while (k < n - 1 && num[k] == out.get(2))
                            k++;
                        while (2 < l && num[l] == out.get(3))
                            l--;
                    } else if (num[i] + num[j] + num[k] + num[l] > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
                int jprev = num[j];
                while (j < n - 2 && num[j] == jprev)
                    j++;
            }
            int iprev = num[i];
            while (i < n - 3 && num[i] == iprev)
                i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        fourSum1(new int[]{1, 0, -1, 0, -2, 2}, 0);

    }
}
