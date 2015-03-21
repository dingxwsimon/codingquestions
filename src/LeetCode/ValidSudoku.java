package LeetCode;

public class ValidSudoku
{
  // pass both
  public static boolean isValidSudoku(char[][] board)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int row = board.length;
    if (row != 9) return false;
    int column = board[0].length;
    if (column != 9) return false;

    // check row
    for (int i = 0 ; i < row ; i++) {
      int[] check = new int[10];
      for (int j = 0 ; j < column ; j++) {
        char c = board[i][j];
        if (c == '.')
          check[0] = check[0] + 1;
        else {
          int num = c - '0';
          if (check[num] == 0)
            check[num] = 1;
          else
            return false;
        }

      }
    }

    // check column
    for (int i = 0 ; i < column ; i++) {
      int[] check = new int[10];
      for (int j = 0 ; j < row ; j++) {
        char c = board[j][i];
        if (c == '.')
          check[0] = check[0] + 1;
        else {
          int num = c - '0';
          if (check[num] == 0)
            check[num] = 1;
          else
            return false;
        }

      }
    }

    // check 3X3
    for (int i = 0 ; i < row ; i += 3) {
      for (int j = 0 ; j < column ; j += 3) {
        int[] check = new int[10];
        for (int p = i ; p < i + 3 ; p++) {
          for (int q = j ; q < j + 3 ; q++) {
            char c = board[p][q];
            if (c == '.')
              check[0] = check[0] + 1;
            else {
              int num = c - '0';
              if (check[num] == 0)
                check[num] = 1;
              else
                return false;
            }
          }
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
    String[] input = new String[] { "53..7....", "6..195...", ".98....6.",
        "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5",
        "....8..79" };
    char[][] board = new char[9][9];
    for (int i = 0 ; i < 9 ; i++) {
      board[i] = input[i].toCharArray();
    }
    System.out.println(isValidSudoku(board));
  }

}
