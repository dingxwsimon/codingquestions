package LeetCode;

public class SudokuSolver
{

  // pass both
  // brute force
  public void solveSudoku(char[][] board)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    solver(board);
  }

  public boolean solver(char[][] board)
  {
    for (int r = 0 ; r < 9 ; r++) {
      for (int c = 0 ; c < 9 ; c++) {
        if (board[r][c] == '.') {
          for (int k = 1 ; k <= 9 ; k++) {
            board[r][c] = (char) ('0' + k);
            if (isValid(board, r, c)) {
              if (solver(board)) return true;
            }
            board[r][c] = '.';
          }
          return false;
        }
      }
    }
    return true;
  }

  public static boolean isValid(char[][] board, int r, int c)
  {
    // ////////////CHECK ROW/////////////////////
    boolean[] Row = new boolean[9];
    for (int i = 0 ; i < 9 ; i++) {
      if (board[r][i] >= '1' && board[r][i] <= '9') {
        if (Row[board[r][i] - '1'] == false)
          Row[board[r][i] - '1'] = true;
        else
          return false;
      }
    }

    // ///////////CHECK COLUMN//////////////////
    boolean[] Col = new boolean[9];
    for (int i = 0 ; i < 9 ; i++) {
      if (board[i][c] >= '1' && board[i][c] <= '9') {
        if (Col[board[i][c] - '1'] == false)
          Col[board[i][c] - '1'] = true;
        else
          return false;
      }
    }

    // ///////////CHECK GRID///////////////////
    boolean[] Grid = new boolean[9];
    // r / 3 * 3 = beginning row number of that grid
    // c / 3 * 3 = beginning column number of that grid
    for (int i = (r / 3) * 3 ; i < (r / 3) * 3 + 3 ; i++) {
      for (int j = (c / 3) * 3 ; j < (c / 3) * 3 + 3 ; j++) {
        if (board[i][j] >= '1' && board[i][j] <= '9') {
          if (Grid[board[i][j] - '1'] == false)
            Grid[board[i][j] - '1'] = true;
          else
            return false;
        }
      }
    }

    return true;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
