package number;

import java.util.Arrays;

public class MovingAverage {
    public static double[] movingAverage(double[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k < 1)
            return null;
        double[] result = new double[n];
        int begin = 0, end = 0;
        double sum = 0;
        while (end < n) {
            sum += prices[end];
            if (end - begin + 1 > k) {
                sum -= prices[begin];
                begin++;
            }
            result[end] = sum / (end - begin + 1);
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double set[] = {1.0, 2.0, 3.0, 4.0, 5.0, 2.0, 5.0};
        int sum = 100;
        System.out.println(Arrays.toString(movingAverage(set, sum)));

    }

}
