package array;

import java.util.ArrayList;

public class MinSubArray {
    static int key = 2;

    static int count = 0;

    public static void main(String args[]) {
	int[] nums = { 1, 2, 3 };

	printSubset(nums);
    }

    public static void printSubset(int[] nums) {
	for (int i = 0; i < nums.length; i++) {
	    boolean[] ifPrint = new boolean[nums.length];
	    printSubset(nums, ifPrint, 0, i);
	}
    }

    public static void printSubset(int[] nums, boolean[] ifPrint, int start,
	    int remain) {
	int sum = 0;
	if (remain == 0) {
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    System.out.print("{");
	    for (int i = 0; i < ifPrint.length; i++) {
		if (ifPrint[i]) {
		    temp.add(nums[i]);
		    System.out.print(nums[i] + ",");
		}
	    }
	    System.out.print("}\n");

	    for (int i = 0; i < temp.size(); i++) {
		sum += temp.get(i);
	    }
	    if (sum > key)
		System.out.println("My Array" + temp);
	} else {
	    if (start + remain > nums.length)
		;
	    else {
		for (int i = 0; i < nums.length; i++) {
		    if (!ifPrint[i]) {
			ifPrint[i] = true;

			printSubset(nums, ifPrint, i + 1, remain - 1);

			ifPrint[i] = false;
		    }

		}
	    }

	}
    }

}
