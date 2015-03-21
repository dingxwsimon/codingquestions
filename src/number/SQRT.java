package number;

public class SQRT
{//http://en.wikipedia.org/wiki/Methods_of_computing_square_roots
  
  //fast reverse square root
  public static float invSqrt(float x)
  {
    float xhalf = 0.5f * x;
    int i = Float.floatToIntBits(x); // get bits for floating value
    i = 0x5f3759df - (i >> 1); // gives initial guess y0
    x = Float.intBitsToFloat(i); // convert bits back to float
    x = x * (1.5f - xhalf * x * x); // Newton step, repeating increases accuracy

    return x;
  }

  public static double invSqrt(double x)
  {
    double xhalf = 0.5d * x;
    long i = Double.doubleToLongBits(x);
    i = 0x5fe6ec85e7de30daL - (i >> 1);
    x = Double.longBitsToDouble(i);
    x = x * (1.5d - xhalf * x * x);
    return x;
  }

  //newton method
  public static double sqrt(double c)
  {
    if (c < 0) return Double.NaN;
    double EPS = 1E-15;
    double t = c;
    while (Math.abs(t - c / t) > EPS * t)
      t = (c / t + t) / 2.0;
    return t;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
