package array;

public class NUmShapesInMatrix {

    public static int count_shapes(int[][] matrix) {
        int num_shapes = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    fill_with_2(matrix, i, j);
                    num_shapes++;
                }
            }
        }
        return num_shapes;
    }

    public static void fill_with_2(int[][] matrix, int i, int j) {
        matrix[i][j] = 2;
        int m = matrix.length;
        int n = matrix[0].length;
        if (i > 0 && matrix[i - 1][j] == 1)
            fill_with_2(matrix, i - 1, j);
        if (i + 1 < m && matrix[i + 1][j] == 1)
            fill_with_2(matrix, i + 1, j);
        if (j > 0 && matrix[i][j - 1] == 1)
            fill_with_2(matrix, i, j - 1);
        if (j + 1 < n && matrix[i][j + 1] == 1)
            fill_with_2(matrix, i, j + 1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] test_matrix = new int[][]{{1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0}, {1, 1, 0, 1, 0}, {0, 0, 1, 0, 0},};

        System.out.println(count_shapes(test_matrix));
    }

}
