package array;

public class BinarySearchMatrix {

    public static class Result {
        int row;
        int column;

        public Result(int row, int col) {
            super();
            this.row = row;
            this.column = col;
        }

        public String toString() {
            return "row: " + row + " column: " + column;
        }
    }

    // CC150 11.6
    boolean binPart(int mat[][], int target, int l, int u, int r, int d,
                    Result result) {

        System.out.println("search the matrix with topleft [" + u + "," + l
                + "] and downright [" + d + "," + r + "]");
        if (l > r || u > d)
            return false; // this is very good check also check
        // outof bound
        if (target < mat[u][l] || target > mat[d][r])
            return false;
        int mid = l + (r - l) / 2;
        int row = u;
        while (row <= d && mat[row][mid] <= target) {
            if (mat[row][mid] == target) {
                result.row = row;
                result.column = mid;
                return true;
            }
            row++;
        }
        System.out.println("mid is " + mid + " and row is " + row);
        return binPart(mat, target, mid + 1, u, r, row - 1, result)
                || binPart(mat, target, l, row, mid - 1, d, result);
    }

    public Result bs(int mat[][], int target) {
        Result r = new Result(0, 0);
        binPart(mat, target, 0, 0, mat.length - 1, mat[0].length - 1, r);
        return r;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{15, 30, 50, 70, 73}, {35, 40, 100, 102, 120},
                {36, 42, 105, 110, 125}, {46, 51, 106, 111, 130},
                {48, 55, 109, 140, 150}};
        BinarySearchMatrix b = new BinarySearchMatrix();
        System.out.println(b.bs(matrix, 37).toString());
    }

}
