package LeetCode;

import java.util.ArrayList;

/**
 * Working!!!!!
 * 
 */
public class NQueens {

    /*
     * Check if (row1, column1) is a valid spot for a queen by checking if there
     * is a queen in the same column or diagonal. We don't need to check it for
     * queens in the same row because the calling placeQueen only attempts to
     * place one queen at a time. We know this row is empty.
     */
    public static boolean checkValid(Integer[] columns, int row1, int column1) {
	for (int row2 = 0; row2 < row1; row2++) {
	    int column2 = columns[row2];
	    /*
	     * Check if (row2, column2) invalidates (row1, column1) as a queen
	     * spot.
	     */

	    /* Check if rows have a queen in the same column */
	    if (column1 == column2) {
		return false;
	    }

	    /*
	     * Check diagonals: if the distance between the columns equals the
	     * distance between the rows, then they're in the same diagonal.
	     */
	    int columnDistance = Math.abs(column2 - column1);
	    int rowDistance = row1 - row2; // row1 > row2, so no need to use
					   // absolute
					   // value
	    if (columnDistance == rowDistance) {
		return false;
	    }
	}
	return true;
    }

    public static void placeQueens(int row, Integer[] columns,
	    ArrayList<Integer[]> results, int GRID_SIZE) {
	if (row == GRID_SIZE) { // Found valid placement
	    results.add(columns.clone());
	} else {
	    for (int col = 0; col < GRID_SIZE; col++) {
		if (checkValid(columns, row, col)) {
		    columns[row] = col; // Place queen
		    placeQueens(row + 1, columns, results, GRID_SIZE);
		}
	    }
	}
    }

    public static void clear(Integer[] columns, int GRID_SIZE) {
	for (int i = 0; i < GRID_SIZE; i++) {
	    columns[i] = -1;
	}
    }

    public static String[] printBoard(Integer[] columns, int GRID_SIZE) {
	String[] result = new String[GRID_SIZE];
	// System.out.println("-----------------");
	for (int i = 0; i < GRID_SIZE; i++) {
	    // System.out.print("|");
	    String columnStr = "";
	    for (int j = 0; j < GRID_SIZE; j++) {
		if (columns[i] == j) {
		    // System.out.print("Q|");
		    columnStr += "Q";
		} else {
		    // System.out.print(" |");
		    columnStr += ".";
		}
	    }
	    result[i] = columnStr;
	    // System.out.println("\n-----------------");
	}
	// System.out.println("");
	return result;
    }

    public static ArrayList<String[]> printBoards(ArrayList<Integer[]> boards,
	    int n) {
	ArrayList<String[]> result = new ArrayList<String[]>();
	for (int i = 0; i < boards.size(); i++) {
	    Integer[] board = boards.get(i);
	    result.add(printBoard(board, n));
	}
	return result;
    }

    public ArrayList<String[]> solveNQueens(int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<Integer[]> results = new ArrayList<Integer[]>();
	Integer[] columns = new Integer[n];
	clear(columns, n);
	placeQueens(0, columns, results, n);
	return printBoards(results, n);
    }

    public int totalNQueens(int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<Integer[]> results = new ArrayList<Integer[]>();
	Integer[] columns = new Integer[n];
	clear(columns, n);
	placeQueens(0, columns, results, n);
	return results.size();
    }

    public static void main(String[] args) {
	NQueens q = new NQueens();
	q.solveNQueens(8);
    }
}
