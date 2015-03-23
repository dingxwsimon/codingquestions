package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	List<List<Integer>> result = new LinkedList<List<Integer>>();
	Arrays.sort(candidates);
	helper(candidates, result, new LinkedList<Integer>(), target, 0);
	return result;
    }

    public void helper(int[] candidates, List<List<Integer>> result,
	    LinkedList<Integer> path, int target, int pos) {
	if (target < 0) {
	    return;
	} else if (target == 0) {
	    result.add(new LinkedList<Integer>(path));
	    return;
	}
	for (int i = pos; i < candidates.length; i++) {
	    path.add(candidates[i]);
	    helper(candidates, result, path, target - candidates[i], i);
	    path.remove(path.size() - 1);
	}
    }

    // this backtracking is typical, remember it
    public ArrayList<ArrayList<Integer>> combinationSum1(int[] candidates,
	    int target) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> index = new ArrayList<Integer>();
	index.add(0);
	Arrays.sort(candidates);
	comb(candidates, target, 0, index, 0, result);
	return result;
    }

    public void comb(int[] candidates, int target, int sum,
	    ArrayList<Integer> index, int level,
	    ArrayList<ArrayList<Integer>> result) {
	if (sum > target)
	    return;
	if (sum == target) {
	    // System.out.println("condition matched, the level is " + level +
	    // " and backtrack is " + Arrays.toString(index));
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    for (int i = 1; i <= level; i++) {
		arr.add(candidates[index.get(i)]);
	    }
	    result.add(arr);
	}
	// this is slightly different from other dfs, because we can use one
	// element
	// again and again
	for (int i = index.get(level); i < candidates.length; i++) {
	    index.add(i);
	    // System.out.println("the level is " + level + " and i is " + i +
	    // " and sum is " + sum + " and backtrack is " +
	    // Arrays.toString(index));
	    comb(candidates, target, sum + candidates[i], index, level + 1,
		    result);
	    index.remove(index.size() - 1);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] can = new int[] { 8, 7, 4, 3, 1 };
	int target = 11;
	CombinationSum c = new CombinationSum();
	System.out.println(c.combinationSum1(can, target).toString());

    }

}
