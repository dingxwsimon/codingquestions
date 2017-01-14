package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (n == 0 || k == 0 || n < k) {
            return ans;
        }
        helper(ans, new LinkedList<Integer>(), n, k, 1);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> path, int n,
                        int k, int pos) {
        if (path.size() == k) {
            ans.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = pos; i <= n; i++) {
            path.add(i);
            helper(ans, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    // another approach
    // quite similar to dfs
    public ArrayList<ArrayList<Integer>> combine1(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0 || n < k)
            return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] backtrack = new int[n + 1];
        backtrack[0] = -1;
        dfs(n, k, result, backtrack, 0);
        return result;
    }

    public void dfs(int n, int k, ArrayList<ArrayList<Integer>> result,
                    int[] backtrack, int level) {
        if (level == k) {
            ArrayList<Integer> out = new ArrayList<Integer>();
            for (int i = 1; i <= level; i++) {
                out.add(backtrack[i] + 1); // data[backtrack[i]]
            }
            result.add(out);
            return;
        }
        for (int i = backtrack[level] + 1; i < n; i++) {
            backtrack[level + 1] = i;
            System.out.println("the level is " + level + " and i is " + i
                    + " and backtrack is " + Arrays.toString(backtrack));
            dfs(n, k, result, backtrack, level + 1);
        }

    }

    // pass both
    // study kcombination <> k subset
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // base case k==1
        if (k == 1) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                ret.add(temp);
            }
            return ret;
        }

        if (k > n) {
            return new ArrayList<ArrayList<Integer>>();
        }

        if (k == n) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                temp.add(i);
            }
            ret.add(temp);
        }
        ArrayList<ArrayList<Integer>> f1 = combine(n - 1, k - 1); // choose n
        ArrayList<ArrayList<Integer>> f2 = combine(n - 1, k); // don't choose n

        for (int i = 0; i < f1.size(); i++) {
            f1.get(i).add(n);
        }

        // merge f1 and f2
        f1.addAll(f2);
        return f1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Combinations c = new Combinations();
        System.out.println(c.combine1(5, 2).toString());

    }

}
