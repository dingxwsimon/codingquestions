package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum3(int[] candidates,
	    int target) {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	Arrays.sort(candidates);
	helper(ans, new ArrayList<Integer>(), candidates, 0, target);
	return ans;
    }

    private void helper(ArrayList<ArrayList<Integer>> ans,
	    ArrayList<Integer> path, int[] nums, int pos, int target) {
	if (target < 0) {
	    return;
	} else if (target == 0) {
	    ans.add(new ArrayList<Integer>(path));
	    return;
	}
	for (int i = pos; i < nums.length; i++) {
	    if (i > pos && nums[i - 1] == nums[i]) {
		continue;
	    }
	    path.add(nums[i]);
	    helper(ans, path, nums, i + 1, target - nums[i]);
	    path.remove(path.size() - 1);
	}
    }

    // pass both need understand
    // compare with the second method of combinationsum
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	// Start typing your Java solution below
	// DO NOT write main() function
	Arrays.sort(num);
	System.out.println("the candidates are " + Arrays.toString(num));
	int[] backtrack = new int[num.length + 1];
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	backtrack[0] = -1;
	solve(num, 0, target, backtrack, result, 0);
	return result;
    }

    public void solve(int[] num, int sum, int target, int[] backtrack,
	    ArrayList<ArrayList<Integer>> result, int level) {
	// backtrack records the indexes in num array
	// what is my next number's index? start trying from backtrack[n] + 1 to
	// num's end
	if (target < sum) {
	    return;
	}
	if (target == sum) {
	    // add everything in backtrack to result
	    System.out.println("condition matched, the level is " + level
		    + " and backtrack is " + Arrays.toString(backtrack));
	    ArrayList<Integer> ret = new ArrayList<Integer>();
	    for (int i = 1; i <= level; i++) {
		ret.add(num[backtrack[i]]);
	    }
	    result.add(ret);
	}
	for (int i = backtrack[level] + 1; i < num.length; i++) {
	    backtrack[level + 1] = i;
	    System.out.println("the level is " + level + " and i is " + i
		    + " and sum is " + sum + " and backtrack is "
		    + Arrays.toString(backtrack));
	    solve(num, sum + num[i], target, backtrack, result, level + 1);

	    while (i + 1 < num.length && num[i + 1] == num[i]) {
		i++;
	    }
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] can = new int[] { 10, 1, 2, 7, 6, 1, 5 };
	int target = 8;
	CombinationSum2 c = new CombinationSum2();
	System.out.println(c.combinationSum2(can, target).toString());
    }

}
