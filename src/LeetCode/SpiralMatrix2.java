package LeetCode;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int num = 1;
        int[][] numbers = new int[n][n];
        if (n == 0)
            return numbers;
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            for (int k = j; k < i; k++)
                numbers[j][k] = num++;
            for (int k = j; k < i; k++)
                numbers[k][i] = num++;
            for (int k = i; k > j; k--)
                numbers[i][k] = num++;
            for (int k = i; k > j; k--)
                numbers[k][j] = num++;
        }
        if (numbers[n / 2][n / 2] == 0)
            numbers[n / 2][n / 2] = num;
        return numbers;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpiralMatrix2 s = new SpiralMatrix2();
        System.out.println(s.generateMatrix(3));

    }

}
