package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets3(int[] num) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if (num == null || num.length == 0) {
	    return result;
	}
	Arrays.sort(num);
	subsetsHelper(result, new ArrayList<Integer>(), num, 0);
	return result;
    }

    private void subsetsHelper(List<List<Integer>> result, List<Integer> list,
	    int[] num, int pos) {
	result.add(new ArrayList<Integer>(list));
	for (int i = pos; i < num.length; i++) {
	    list.add(num[i]);
	    subsetsHelper(result, list, num, i + 1);
	    list.remove(list.size() - 1);
	}
    }

    // pass both, similar with subsets2,
    // remember backtracking
    public ArrayList<ArrayList<Integer>> subsets1(int[] num) {
	// Start typing your Java solution below
	// DO NOT write main() function

	// almost the same backtrack algorithm of combination sum II
	if (num.length == 0) {
	    return null;
	}
	Arrays.sort(num);

	int[] backtrack = new int[num.length + 1];
	backtrack[0] = -1;
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	ss(num, result, 0, backtrack);

	return result;
    }

    // backtrack array contains the indexes
    public void ss(int[] num, ArrayList<ArrayList<Integer>> result, int level,
	    int[] backtrack) {
	ArrayList<Integer> x = new ArrayList<Integer>();
	for (int i = 1; i <= level; i++) {
	    x.add(num[backtrack[i]]);
	}
	result.add(x);

	for (int i = backtrack[level] + 1; i < num.length; i++) {
	    backtrack[level + 1] = i;
	    System.out.println("the level is " + level + " and i is " + i
		    + " and backtrack is " + Arrays.toString(backtrack));
	    ss(num, result, level + 1, backtrack);
	}

    }

    // shorter...
    public ArrayList<ArrayList<Integer>> subsets2(int[] num) {
	if (num.length == 0) {
	    return null;
	}
	Arrays.sort(num);
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	result.add(new ArrayList<Integer>());
	for (int i = 0; i < num.length; ++i) {
	    int j = result.size();
	    while (j-- > 0) {
		result.add(new ArrayList<Integer>(result.get(j)));
		result.get(result.size() - 1).add(num[i]);
	    }
	}
	return result;
    }

    // pass both
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	result.add(new ArrayList<Integer>());
	Arrays.sort(S);
	int n = S.length;
	long i;
	long c = 1 << n;
	for (i = 1; i < c; ++i) {
	    long tmp = i;
	    int elem = 0;
	    ArrayList<Integer> subset = new ArrayList<Integer>();
	    while (tmp > 0) {
		if ((tmp & 1) == 1)
		    subset.add(S[elem]);
		tmp >>= 1;
		++elem;
	    }
	    result.add(subset);
	}
	return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Subsets s = new Subsets();
	System.out.println(s.subsets1(new int[] { 2, 3, 1, 4 }));
    }

}
