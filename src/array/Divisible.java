package array;

public class Divisible {
    // similar to checkpairable
    public static boolean isDivisible(int[] a, int k) {
	if (a == null || a.length % 2 == 1)
	    return false;
	int[] count = new int[k];
	for (int i : a)
	    count[i % k]++;
	for (int i = 1; i <= (k + 1) / 2; i++) {
	    if (count[i] != count[k - i])
		return false;
	}
	return count[0] % 2 == 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] a = new int[] { 1, 2, 3, 4 };
	System.out.println(isDivisible(a, 5));
    }

}
