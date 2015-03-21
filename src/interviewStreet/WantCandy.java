package interviewStreet;

import java.math.BigDecimal;
import java.math.MathContext;

// time complexity O(1)
public class WantCandy
{
  // actually the probability of "last candy is white" based on the initial red
  // and white candy number (numR, numW) will be:
  // P(numR, numW) = Probability(getting a red candy)*P(numR-1, numW) +
  // Probability(getting a white candy)*P(numR, numW-1)

  // Probability(getting a red candy) = Probability(get a red candy in first try
  // and get a red candy at the second try)
  // = (numR)^2/(numR + numW)^2

  // Probability(getting a white candy) = Probability(get a white candy in first
  // try) +
  // Probability(get a red candy in first try and get a white candy at the
  // second try)
  // = (numW)/(numR+numW) + (numR*numW)/(numR+numW)^2
  // = (numW)^2+2*(numR*numW)/(numR+numW)^2

  // and obviously we have P(numR, 0) = 0;
  // P(0, numW) = 1;
  // The time complexity of the method is O(numR*numW)
  public static double getProb1(int numR, int numW)
  {
    if (numW == 0)
      return 0.0;
    else if (numR == 0) return 1.0;
    double[][] resultMatrix = new double[numR + 1][numW + 1];
    for (int i = 0 ; i < numW + 1 ; i++) {
      resultMatrix[0][i] = 1;
    }
    for (int i = 0 ; i < numR + 1 ; i++) {
      resultMatrix[i][0] = 0;
    }
    int min = Math.min(numR, numW);
    for (int i = 1 ; i < min + 1 ; i++) {
      double doubleI = (double) i;
      for (int j = i ; j < numW + 1 ; j++) {
        double doubleJ = (double) j;
        resultMatrix[i][j] = Math.pow(doubleI, 2)
            / Math.pow(doubleI + doubleJ, 2) * resultMatrix[i - 1][j]
            + (Math.pow(doubleJ, 2) + 2 * doubleI * doubleJ)
            / Math.pow(doubleI + doubleJ, 2) * resultMatrix[i][j - 1];
      }
      for (int j = i ; j < numR + 1 ; j++) {
        double doubleJ = (double) j;
        resultMatrix[j][i] = Math.pow(doubleJ, 2)
            / Math.pow(doubleJ + doubleI, 2) * resultMatrix[j - 1][i]
            + (Math.pow(doubleI, 2) + 2 * doubleI * doubleJ)
            / Math.pow(doubleJ + doubleI, 2) * resultMatrix[j][i - 1];
      }

    }

    return resultMatrix[numR][numW];
  }

  // Of course if we use BigDecimal instead of double, we could still get the 60
  // decimal places
  // just the next solution is much simpler

  // by basic induction we can simplify the above recurrence relation to
  // P(numR, numW) = numW / ((numR + 1) * (numR + numW))
  // and this will also give you the 60 decimal places if you use some special
  // object
  // BigDecimal and the time complexity will be constant O(1)
  public static BigDecimal getProbSimple(int numR, int numW)
  {
    MathContext mc = new MathContext(60);
    BigDecimal dbR = new BigDecimal((double) numR, mc);
    BigDecimal dbW = new BigDecimal((double) numW, mc);
    return dbW.divide(
        dbR.add(new BigDecimal(1.0D, mc), mc).multiply(dbR.add(dbW)), mc);
  }

  public static void main(String[] args)
  {
    System.out.println(getProb1(10, 90));
    System.out.println(getProbSimple(10, 90));
  }

}
