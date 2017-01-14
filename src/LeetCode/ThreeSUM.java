package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSUM {

    // Working!
    public static int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(num);
        int n = num.length;
        for (int i = 0; i <= n - 3; i++) {
            int a = num[i];
            int k = i + 1;
            int l = n - 1;
            while (k < l) {
                int b = num[k];
                int c = num[l];
                if (a + b + c == target) {
                    return target;
                } else if (a + b + c > target) {
                    l = l - 1;
                    if (Math.abs(target - a - b - c) < diff) {
                        diff = Math.abs(target - a - b - c);
                        sum = a + b + c;
                    }
                } else {
                    k = k + 1;
                    if (Math.abs(target - a - b - c) < diff) {
                        diff = Math.abs(target - a - b - c);
                        sum = a + b + c;
                    }
                }
            }
        }

        return sum;

    }

    // Working!!
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;
        HashSet<String> hash = new HashSet<String>();
        for (int i = 0; i <= n - 3; i++) {
            int a = num[i];
            int k = i + 1;
            int l = n - 1;
            while (k < l) {
                int b = num[k];
                int c = num[l];
                if (a + b + c == 0) {
                    if (!hash.contains(a + " " + b + " " + c)) {
                        ArrayList<Integer> onposs = new ArrayList<Integer>();
                        onposs.add(a);
                        onposs.add(b);
                        onposs.add(c);
                        result.add(onposs);
                        hash.add(a + " " + b + " " + c);
                    }
                    l--;
                    k++;
                } else if (a + b + c > 0)
                    l--;
                else
                    k++;
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum3(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return ret;
        Arrays.sort(num);
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        HashSet<String> found = new HashSet<String>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int a = num[i];
                int b = num[j];
                int c = 0 - a - b;
                if (set.contains(c)) {
                    ArrayList<Integer> oneRet = addThree(a, b, c);
                    String sign = getSign(oneRet);
                    if (!found.contains(sign)) {
                        ret.add(oneRet);
                        found.add(sign);
                    }
                }
            }
        }
        return ret;
    }

    public ArrayList<Integer> addThree(int a, int b, int c) {
        ArrayList<Integer> oneRet = new ArrayList<Integer>();
        if (c < a) {
            oneRet.add(c);
            oneRet.add(a);
            oneRet.add(b);
        } else if (a >= c && c < b) {
            oneRet.add(a);
            oneRet.add(c);
            oneRet.add(b);
        } else {
            oneRet.add(a);
            oneRet.add(b);
            oneRet.add(c);
        }
        return oneRet;
    }

    public String getSign(ArrayList<Integer> oneRet) {
        StringBuilder sb = new StringBuilder();
        sb.append(oneRet.get(0));
        sb.append(" ");
        sb.append(oneRet.get(1));
        sb.append(" ");
        sb.append(oneRet.get(2));
        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        threeSum(new int[]{3, 0, -2, -1, 1, 2});
    }

}
