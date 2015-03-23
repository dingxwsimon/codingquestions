package LeetCode;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] num) {
	int l = 0;
	int r = num.length - 1;
	while (num[l] > num[r]) {
	    int m = (l + r) / 2;
	    if (num[m] > num[r]) {
		l = m + 1;
	    } else {
		r = m;
	    }
	}
	return num[l];
    }

    // for problem2 there is no way we coulddo O(log(n)) e.g. if all element is
    // the same

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
