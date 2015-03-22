package LeetCode;

/*Given an unsorted array, find the maximum difference between 
 * the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.*/
public class MaxGap {
    static class Bucket {
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;

	void add(int n) {
	    min = Math.min(n, min);
	    max = Math.max(n, max);
	}
    }

    public static int maximumGap(int[] num) {
	if (num == null || num.length < 2) {
	    return 0;
	}
	int n = num.length;
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	for (int i = 0; i < n; i++) {
	    max = Math.max(max, num[i]);
	    min = Math.min(min, num[i]);
	}
	int gap = (int) Math.ceil((double) (max - min) / (n - 1));
	int s = (max - min) / gap + 1;
	Bucket[] buckets = new Bucket[s];
	for (int i = 0; i < n; i++) {
	    int idx = (num[i] - min) / gap;
	    if (buckets[idx] == null) {
		buckets[idx] = new Bucket();
	    }
	    buckets[idx].add(num[i]);
	}
	int ret = Integer.MIN_VALUE;
	int prev = min;
	for (int i = 0; i < s; i++) {
	    if (buckets[i] == null)
		continue;
	    ret = Math.max(ret, buckets[i].min - prev);
	    prev = buckets[i].max;
	}
	return ret;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	maximumGap(new int[] { 1, 10000000 });
    }

}
