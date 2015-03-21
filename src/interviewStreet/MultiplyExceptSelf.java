package interviewStreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultiplyExceptSelf
{

  public static void main(String args[])
      throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    int N = Integer.parseInt(line);
    int arr[] = new int[N];
    for (int i = 0 ; i < N ; i++) {
      line = br.readLine();
      arr[i] = Integer.parseInt(line);
    }
    int i = 0;
    long temp = 1;
    long[] prod = new long[N];
    for (i = 0 ; i < N ; i++)
      prod[i] = 1;

    for (i = 0 ; i < N ; i++) {
      prod[i] = temp;
      temp *= arr[i];
    }
    temp = 1;
    for (i = N - 1 ; i >= 0 ; i--) {
      prod[i] *= temp;
      temp *= arr[i];
    }
    for (i = 0 ; i < N ; i++) {
      System.out.println(prod[i]);
    }
  }

}
