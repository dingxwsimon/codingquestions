package LeetCode;

public class TrapingRainWater {

    public int trap1(int[] A) {
	if (A == null || A.length == 0) {
	    return 0;
	}

	int len = A.length;
	int left = 0;
	int right = len - 1;
	int leftHeight = 0;
	int rightHeight = 0;
	int water = 0;

	while (left < right) {
	    leftHeight = Math.max(leftHeight, A[left]);
	    rightHeight = Math.max(rightHeight, A[right]);
	    // Two ways to write the following if-condition
	    // This would also work: if (A[left] < A[right]) {
	    if (leftHeight < rightHeight) {
		// increase left pointer
		water += leftHeight - A[left];
		left++;
	    } else {
		water += rightHeight - A[right];
		right--;
	    }
	}
	return water;
    }

    // pass both
    // can solve the google interview problem as well
    public int trap(int[] A) {
	// Start typing your Java solution below
	// DO NOT write main() function

	int n = A.length;
	int i = 0, j = n - 1, sum = 0;

	while (i < j) {
	    // get the first one that is
	    // larger than the right one from the left
	    while (i < j && A[i] < A[i + 1]) {
		// google interview
		// sum+=A[i]
		i++;
	    }
	    // get the first one that is
	    // larger than the left on the right
	    while (i < j && A[j] < A[j - 1]) {
		j--;
	    }

	    if (i == j) {
		break;
	    }

	    if (A[i] > A[j]) {
		int k = j - 1;// which is smaller than A[j]
		while (A[k] < A[j] && k > i) {
		    sum += A[j] - A[k];
		    k--;
		}
		// now A[k] is greater than A[j]
		j = k;
	    } else {
		int k = i + 1;// which is smaller than A[i]
		// till we find the k that
		// A[k]>=A[i]
		while (A[k] < A[i] && k < j) {
		    sum += A[i] - A[k];
		    k++;
		}

		i = k;
	    }
	}

	return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	TrapingRainWater t = new TrapingRainWater();
	System.out.println(t.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2,
		1 }));
    }

}
