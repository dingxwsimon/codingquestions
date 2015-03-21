/**
 * @(#) EightQueen.java Feb 25, 2010 12:23:58 AM
 *      Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 *      All right reserved
 */
package old;

/**
 * Class <code>EightQueen</code>
 * 
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Feb 25, 2010 12:23:58 AM
 * 
 */
public class EightQueen
{

  public static int[] ColumnForRow = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // We use
                                                                    // row
                                                                    // numbers 1
                                                                    // through 8

  public static boolean Check(int row)
  {
    for (int cur = 1 ; cur < row ; ++cur) {
      int diff = Math.abs(ColumnForRow[cur] - ColumnForRow[row]);
      if (diff == 0 || diff == row - cur) {
        return false;
      }
    }
    return true;
  }

  public static void PlaceQueen(int row)
  {
    if (row == 9) {
      for (int i = 1 ; i <= 8 ; ++i) {
        System.out.println(i + " " + ColumnForRow[i]);
      }
      return;
      /* line (a) - see note below */
    }
    /* line (b) - see note below */
    else {
      for (ColumnForRow[row] = 1 ; ColumnForRow[row] <= 8 ; ++ColumnForRow[row]) {
        if (Check(row)) {
          PlaceQueen(row + 1);
        }
      }
    }
    /* line (c) - see note below */
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    EightQueen.PlaceQueen(1);
  }

}
