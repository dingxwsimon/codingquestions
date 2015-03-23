package LeetCode;

public class ClimbingStairs {
    // pass both
    public int climbStairs(int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (n < 1)
	    return 0;
	int result = 0;
	int a = 0;
	int b = 1;
	while (n > 0) {
	    result = a + b;
	    a = b;
	    b = result;
	    n--;
	}
	return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ClimbingStairs c = new ClimbingStairs();
	System.out.println(c.climbStairs(3));
    }

}
