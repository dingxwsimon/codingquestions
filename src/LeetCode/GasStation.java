package LeetCode;

public class GasStation
{
  public int canCompleteCircuit1(int[] gas, int[] cost) {
    int i = 0, j = 0;
    int sum = 0;
    int total = 0;
    while (j < gas.length) {
        int diff = gas[j] - cost[j];
        if (sum + diff < 0) {
            i = j + 1;
            sum = 0;
        } else {
            sum += diff;
        }
        j++;
        total += diff;
    }
    return total >= 0 ? i : -1;
}
  
  
  
  //brute force
  public static int canCompleteCircuit(int[] gas, int[] cost)
  {
    int n = gas.length;

    for (int i = 0 ; i < n ; i++) {
      boolean negative = false;
      int start = i != n - 1
                            ? i + 1
                            : 0;
      int sum = gas[i] - cost[i];
      if (sum < 0) {
        negative = true;
        continue;
      }
      for (int j = start ; j != i ; j++) {
        sum += gas[j] - cost[j];
        if (sum < 0) {
          negative = true;
          break;
        }
        if (j == n - 1) {
          j = -1;
        }
      }
      if (negative)
        continue;
      else
        return i;
    }
    return -1;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(canCompleteCircuit(new int[] { 67, 68, 69, 70, 71, 72,
        73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
        91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
        47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64,
        65, 66 }, new int[] { 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56,
        57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92,
        93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
        13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 }));
  }

}
