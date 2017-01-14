package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permuteUnique4(int[] num) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (num == null || num.length == 0) {
            return ans;
        }
        Arrays.sort(num);
        helper(ans, new LinkedList<Integer>(), new int[num.length], num);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> path,
                        int[] visited, int[] num) {
        if (path.size() == num.length) {
            ans.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (i > 0 && visited[i - 1] == 0 && num[i - 1] == num[i]) {
                continue;
            }
            visited[i] = 1;
            path.add(num[i]);
            helper(ans, path, visited, num);
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    // another solution
    public ArrayList<ArrayList<Integer>> permuteUnique1(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        // assume no duplicates
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] perm = new int[num.length];
        boolean[] used = new boolean[num.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        // difference
        Arrays.sort(num);

        permute(num, 0, perm, used, result);

        return result;
    }

    public void permute(int[] num, int level, int[] perm, boolean[] used,
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
                permute(num, level + 1, perm, used, result);
                used[i] = false;
                while (i + 1 < num.length && num[i] == num[i + 1]) {
                    i++;
                }
            }
        }
    }

    // working!!!
    public static void permutateHelperDuplicate(ArrayList<Integer> prefix,
                                                ArrayList<Integer> rest, ArrayList<ArrayList<Integer>> result) {
        int N = 0;
        if (rest != null)
            N = rest.size();
        if (N == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < rest.size(); i++) {

                // test if rest[i] is unique.
                boolean found = false;
                for (int j = 0; j < i; j++) {
                    if (rest.get(j) == rest.get(i)) // rest[j]==rest[i]
                        found = true;
                }
                if (found)
                    continue;
                ArrayList<Integer> newPrefix = new ArrayList<Integer>(prefix);
                newPrefix.add(rest.get(i));
                ArrayList<Integer> newRest = new ArrayList<Integer>(rest);
                newRest.remove(i);
                permutateHelperDuplicate(newPrefix, newRest, result);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> rest = new ArrayList<Integer>();
        for (int k = 0; k < num.length; k++) {
            rest.add(num[k]);
        }
        ArrayList<Integer> intList = new ArrayList<Integer>();
        permutateHelperDuplicate(intList, rest, result);
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // permutateHelperDuplicate("", "1233");
        Permutations2 p = new Permutations2();
        System.out.println(p.permuteUnique1(new int[]{1, 2, 3, 3})
                .toString());
    }

}
