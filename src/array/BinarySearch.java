package array;

public class BinarySearch {
    public static int bs(int[] array, int x) {
	if (array == null)
	    return -1;
	int start = 0;
	int end = array.length - 1;
	while (start <= end) {
	    int m = start + ((end - start) >> 1);
	    if (array[m] == x)
		return m;
	    else if (array[m] < x)
		start = m + 1;
	    else
		end = m - 1;
	}
	return -1;
    }

    // return the index of the biggest element smaller than or equal to x
    // if any element in a is bigger than x, return -1
    // the following is used often, just remember it.
    public int bslower(int[] a, int x) {
	int start = 0, end = a.length - 1, mid = (a.length - 1) / 2;
	int ret = -1;

	while (start <= end) {
	    mid = (start + end) / 2;
	    if (a[mid] > x) {
		end = mid - 1;
	    } else {
		start = mid + 1;
		ret = mid;
	    }
	}

	return ret;
    }

    public static int bsNear(int[] array, int x, int endP) {
	if (array == null)
	    return -1;
	int start = 0;
	int end = endP;
	while (start <= end) {
	    int m = start + ((end - start) >> 1);
	    if (array[m] == x)
		return m;
	    else if (array[m] < x)
		start = m + 1;
	    else
		end = m;
	}
	return -1;
    }

    public static int bsCloest(int[] arr, int n) {
	int len = arr.length;
	if (len == 1)
	    return arr[0];
	if (n < arr[0])
	    return arr[0];
	if (n > arr[len - 1])
	    return arr[len - 1];

	int low = 0;
	int up = len - 1;

	while (low <= up) {
	    int mid = low + (up - low) / 2;

	    if (arr[mid] == n) {
		return n;
	    } else if (arr[mid] > n) {
		up = mid - 1;
	    } else {
		low = mid + 1;
	    }
	}

	return Math.abs(arr[low] - n) > Math.abs(arr[up] - n) ? arr[up]
		: arr[low];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] array = { 1, 3, 4, 8, 16, 20, 30, 41, 17 };
	System.out.println(bsNear(array, 15, 8));
    }

}
