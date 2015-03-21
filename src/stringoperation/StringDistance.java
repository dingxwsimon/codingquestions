package stringoperation;

public class StringDistance
{

  public static int distance(String strA, int aBegin, int aEnd, String strB,
      int bBegin, int bEnd)
  {
    if (aBegin > aEnd) {
      if (bBegin > bEnd)
        return 0;
      else
        return bEnd - bBegin + 1;
    }

    if (bBegin > bEnd) {
      if (aBegin > aEnd)
        return 0;
      else
        return aEnd - aBegin + 1;
    }

    if (strA.charAt(aEnd) == strB.charAt(bBegin)) {
      return distance(strA, aBegin + 1, aEnd, strB, bBegin + 1, bEnd);
    }
    else {
      int t1 = distance(strA, aBegin, aEnd, strB, bBegin + 1, bEnd);
      int t2 = distance(strA, aBegin + 1, aEnd, strB, bBegin, bEnd);
      int t3 = distance(strA, aBegin + 1, aEnd, strB, bBegin + 1, bEnd);
      return Math.min(Math.min(t1, t2), t3) + 1;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
