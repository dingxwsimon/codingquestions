package array;

import java.util.Arrays;

public class ThreeSubset {

    static void solve(int[] in) {
        Arrays.sort(in);
        int N = in.length;
        for (int i = 0; i < N - 2; i++) {
            if (i > 0 && in[i] == in[i - 1])
                continue;
            for (int j = i + 1; j < N - 1; j++) {
                if (j > i + 1 && in[j] == in[j - 1])
                    continue;
                for (int k = j + 1; k < N; k++) {
                    if (k > j + 1 && in[k] == in[k - 1])
                        continue;
                    System.out.println(in[i] + "," + in[j] + "," + in[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] in = new int[]{1, 2, 2, 3, 4, 6};
        solve(in);
    }

}
