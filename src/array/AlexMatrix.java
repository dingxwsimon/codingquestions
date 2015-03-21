package array;

public class AlexMatrix {
	public static int solve(int n, int m) {
		if (n == 1 || m == 1) {
			return (n + m - 1);
		} else if ((n % 2 == 1) && (m % 2 == 1)) {
			return (n * m);
		} else if (n % 2 == 1) {
			return ((n * m) - ((n - 2) * (m - 2)));
		} else {
			return (n * 2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(7,4));
	}

}
