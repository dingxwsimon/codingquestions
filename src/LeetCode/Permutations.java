package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0) {
            return ans;
        }
        helper(ans, new LinkedList<Integer>(), num);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> path, int[] num) {
        if (path.size() == num.length) {
            ans.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!path.contains(num[i])) {
                path.add(num[i]);
                helper(ans, path, num);
                path.remove(path.size() - 1);
            }
        }
    }

    // another solution
    public ArrayList<ArrayList<Integer>> permute1(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // assume no duplicates
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] perm = new int[num.length];
        boolean[] used = new boolean[num.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        dopermute(num, 0, perm, used, result);

        return result;
    }

    public void dopermute(int[] num, int level, int[] perm, boolean[] used,
                          ArrayList<ArrayList<Integer>> result) {
        if (num.length == level) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            for (int i = 0; i < perm.length; i++) {
                x.add(perm[i]);
            }
            result.add(x);
            return;
        }

        // used[i] = true means num[i] is used
        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[level] = num[i];
                System.out.println("the level is " + level + " and i is " + i
                        + " and used is " + Arrays.toString(used)
                        + " and backtrack is " + Arrays.toString(perm));
                dopermute(num, level + 1, perm, used, result);
                used[i] = false;
            }
        }
    }

    // pass both
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        dopermute(num, 0, result);
        return result;
    }

    public void dopermute(int[] num, int i, ArrayList<ArrayList<Integer>> result) {
        if (i == num.length) {
            ArrayList<Integer> permute = new ArrayList<Integer>();
            for (int n : num)
                permute.add(n);
            result.add(permute);
            return;
        }
        for (int j = i; j < num.length; j++) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            dopermute(num, i + 1, result);
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Permutations p = new Permutations();
        p.permute1(new int[]{1, 2, 3});

    }

}
