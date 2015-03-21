package array;

public class MaxProduct {
	public static int maxSubarrayProduct(int arr[]) {
		int n = arr.length;
		// max positive product ending at the current position
		int max_ending_here = 1;

		// min negative product ending at the current position
		int min_ending_here = 1;

		// Initialize overall max product
		int max_so_far = 1;

		/*
		 * Traverse throught the array. Following values are maintained after
		 * the ith iteration: max_ending_here is always 1 or some positive
		 * product ending with arr[i] min_ending_here is always 1 or some
		 * negative product ending with arr[i]
		 */
		for (int i = 0; i < n; i++) {
			/*
			 * If this element is positive, update max_ending_here. Update
			 * min_ending_here only if min_ending_here is negative
			 */
			if (arr[i] > 0) {
				max_ending_here = max_ending_here * arr[i];
				min_ending_here = Math.min(min_ending_here * arr[i], 1);
			}

			/*
			 * If this element is 0, then the maximum product cannot end here,
			 * make both max_ending_here and min_ending_here 0 Assumption:
			 * Output is alway greater than or equal to 1.
			 */
			else if (arr[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			}

			/*
			 * If element is negative. This is tricky max_ending_here can either
			 * be 1 or positive. min_ending_here can either be 1 or negative.
			 * next min_ending_here will always be prev. max_ending_here *
			 * arr[i] next max_ending_here will be 1 if prev min_ending_here is
			 * 1, otherwise next max_ending_here will be prev min_ending_here *
			 * arr[i]
			 */
			else {
				int temp = max_ending_here;
				max_ending_here = Math.max(min_ending_here * arr[i], 1);
				min_ending_here = temp * arr[i];
			}

			// update max_so_far, if needed
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}

		return max_so_far;
	}

	public static int func(int[] a) {
		int n = a.length;
		int[] max = new int[n];
		int[] min = new int[n];
		max[0] = min[0] = a[0];
		int value = max[0];
		for (int i = 1; i < n; ++i) {
			max[i] = Math.max(Math.max(a[i], max[i - 1] * a[i]), min[i - 1]
					* a[i]);
			min[i] = Math.min(Math.min(a[i], max[i - 1] * a[i]), min[i - 1]
					* a[i]);
			value = Math.max(value, max[i]);
		}
		return value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{-2,4,0,3,-5,8,-1};
		System.out.println(maxSubarrayProduct(a));
		System.out.println(func(a));
	}

}
