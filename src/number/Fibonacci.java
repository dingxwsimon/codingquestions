package number;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci
{

  public static int Fibonacci_1(int n)
  {
    if (n <= 0) return 0;
    int a = 0;
    int b = 1;
    for (int i = 2 ; i < n + 1 ; i++) {
      int tmp = b;
      // assert(Integer.MAX_VALUE - b < a);
      if (Integer.MAX_VALUE - b < a) {
        System.out.println("over flow" + Integer.MAX_VALUE);
        return 0;
      }
      b = a + b;
      a = tmp;
    }
    return b;
  }

  public static int fib2(int n)
  {
    if (n < 2) {
      return n;
    }
    else {
      return fib2(n - 1) + fib2(n - 2);
    }
  }

  private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
  static {
    fibCache.add(BigInteger.ZERO);
    fibCache.add(BigInteger.ONE);
  }

  public static BigInteger fib(int n)
  {
    if (n >= fibCache.size()) {
      fibCache.add(n, fib(n - 1).add(fib(n - 2)));
    }
    return fibCache.get(n);
  }

  // /////////////////////////////////////////////////////////////////////
  // A 2 by 2 matrix
  // m_00 m_01
  // m_10 m_11
  // /////////////////////////////////////////////////////////////////////
  public static class Matrix2By2
  {
    Matrix2By2(int m00, int m01, int m10, int m11)
    {
      m_00 = m00;
      m_01 = m01;
      m_10 = m10;
      m_11 = m11;
    }

    int m_00 = 0;
    int m_01 = 0;
    int m_10 = 0;
    int m_11 = 0;
  }

  // /////////////////////////////////////////////////////////////////////
  // Multiply two matrices
  // Input: matrix1 - the first matrix
  // matrix2 - the second matrix
  // Output: the production of two matrices
  // /////////////////////////////////////////////////////////////////////
  public static Matrix2By2 MatrixMultiply(Matrix2By2 matrix1, Matrix2By2 matrix2)
  {
    return new Matrix2By2(matrix1.m_00 * matrix2.m_00 + matrix1.m_01
        * matrix2.m_10, matrix1.m_00 * matrix2.m_01 + matrix1.m_01
        * matrix2.m_11, matrix1.m_10 * matrix2.m_00 + matrix1.m_11
        * matrix2.m_10, matrix1.m_10 * matrix2.m_01 + matrix1.m_11
        * matrix2.m_11);
  }

  // /////////////////////////////////////////////////////////////////////
  // The nth power of matrix
  // 1 1
  // 1 0
  // /////////////////////////////////////////////////////////////////////
  public static Matrix2By2 MatrixPower(int n)
  {
    assert (n > 0);

    Matrix2By2 matrix = new Matrix2By2(0, 0, 0, 0);
    if (n == 1) {
      matrix = new Matrix2By2(1, 1, 1, 0);
    }
    else if (n % 2 == 0) {
      matrix = MatrixPower(n / 2);
      matrix = MatrixMultiply(matrix, matrix);
    }
    else if (n % 2 == 1) {
      matrix = MatrixPower((n - 1) / 2);
      matrix = MatrixMultiply(matrix, matrix);
      matrix = MatrixMultiply(matrix, new Matrix2By2(1, 1, 1, 0));
    }

    return matrix;
  }

  // /////////////////////////////////////////////////////////////////////
  // Calculate the nth item of Fibonacci Series using devide and conquer
  // /////////////////////////////////////////////////////////////////////
  public static int Fibonacci_Solution3(int n)
  {
    int result[] = { 0, 1 };
    if (n < 2) return result[n];

    Matrix2By2 PowerNMinus2 = MatrixPower(n - 1);
    return PowerNMinus2.m_00;
  }

  public static Matrix2By2 MatrixPow(int n)
  {
    Matrix2By2 matrix = new Matrix2By2(1, 1, 1, 0);
    Matrix2By2 result = new Matrix2By2(1, 0, 0, 1);
    for ( ; n > 0 ; n >>= 1) {
      if ((n & 1) > 0) // odd
        result = MatrixMultiply(result, matrix);
      matrix = MatrixMultiply(matrix, matrix);
    }
    return result;
  }

  public static int Fibonacci_4(int n)
  {
    int f0 = 0;
    int f1 = 1;
    Matrix2By2 m = MatrixPow(n - 1);
    return m.m_00 * f1 + m.m_10 * f0;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(Fibonacci_4(10));
  }

}
