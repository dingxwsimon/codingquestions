package array;

public class SearchSortMatrix {

    public static boolean FindElem(int[][] mat, int elem) {
        int row = 0, col = mat[0].length - 1;
        while (row < mat.length && col > 0) {
            if (mat[row][col] == elem) {
                return true;
            } else if (mat[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
