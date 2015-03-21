package LeetCode;

public class JumpGame2
{
  
  public int jump2(int[] A) {
    int len = A.length;
    if (len <= 1) return 0;
    int[] dp = new int[len];
    if (A[0] == 0) return 0;
    int cur = 1;
    for (int i = 0; i < len; i ++) {
        if (i != 0 && dp[i] == 0) 
            return 0;
        // array dp represent the steps to reach point i
        for (; cur < len && cur <= i + A[i]; cur ++) {
            dp[cur] = dp[i] + 1;
        }
        if (dp[len - 1] != 0) 
            return dp[len - 1];
    }
    return 0;
}
  
  

  // pass both
  // very good
  //this can solve jumgame also
  public int jump1(int[] A)
  {
    int max = A[0]; // the max index of the next jump
    int min = 1; // the min index of the next jump
    int step = 0;

    if (A.length == 1) {
      return 0;
    }
    while (max < A.length - 1) {
      if (min > max) return -1;
      int m = max;
      for (int i = min ; i <= max ; i++) {
        if (m < A[i] + i) {
          m = A[i] + i;
        }
      }
      min = max + 1;
      max = m;

      step++;
    }

    return step + 1;
  }

  //http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
  int minJumps(int arr[], int l, int h)
  {
     // Base case: when source and destination are same
     if (h == l)
       return 0;
   
     // When nothing is reachable from the given source
     if (arr[l] == 0)
       return Integer.MAX_VALUE;
   
     // Traverse through all the points reachable from arr[l]. Recursively
     // get the minimum number of jumps needed to reach arr[h] from these
     // reachable points.
     int min = Integer.MAX_VALUE;
     for (int i = l+1; i <= h && i <= l + arr[l]; i++)
     {
         int jumps = minJumps(arr, i, h);
         if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
             min = jumps + 1;
     }
   
     return min;
  }
  
  
  
  
  // pass small, correct idea
  // ETL DP
  public int jump(int[] A)
  {
    // Start typing your Java solution below
    // DO NOT write main() function
    int n = A.length;
    int[] jumps = new int[n];
    if (n <= 1) return 0;
    jumps[0] = 0;
    for (int i = 1 ; i < A.length ; i++) {
      jumps[i] = Integer.MAX_VALUE;
      for (int j = 0 ; j < i ; j++) {
        if (j + A[j] >= i && jumps[j] != Integer.MAX_VALUE
            && jumps[i] > jumps[j] + 1) jumps[i] = jumps[j] + 1;
      }
    }
    return jumps[n - 1];
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    JumpGame2 j = new JumpGame2();
    // int[] A = new
    // int[]{5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0};
    int[] A = new int[] { 1, 1, 1, 0, 4 };
    System.out.println(j.jump1(A));
  }

}
