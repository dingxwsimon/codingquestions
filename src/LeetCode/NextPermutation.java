package LeetCode;


// http://en.wikipedia.org/wiki/Permutation
public class NextPermutation
{

  // Working!!!!
  // just remember it
  // pay special attention to the >= <=
  public static void nextPermutation(int[] num)
  {
    int a = num.length - 2;
    // find the largest a that num[a] < num[a+1]
    while (a >= 0 && num[a] >= num[a + 1]) {
      a--;
    }
    // if no such index, it is the last permutation
    // so go to the first one
    if (a == -1) {
      for (int i = 0, j = num.length - 1 ; i < j ; i++, j--) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
      }
      return;
    }
    // find the largest b that num[b] > num[a]
    int b = num.length - 1;
    while (num[b] <= num[a]) {
      b--;
    }
    // swap num[b], num[a]
    int t = num[a];
    num[a] = num[b];
    num[b] = t;
    // reverse num[a+1] till the end
    for (int i = a + 1, j = num.length - 1 ; i < j ; i++, j--) {
      t = num[i];
      num[i] = num[j];
      num[j] = t;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    nextPermutation(new int[] { 2, 1, 3, 7 });
  }

}
