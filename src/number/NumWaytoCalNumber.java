package number;

public class NumWaytoCalNumber
{
  public int getNoOfWays(int [] array, int index, int value)
  {
    if(index == array.length && value != 0)
      return 0;
    else if(index == array.length)
      return 1;
    int count = 0;
    if(value == 0)
      count++;
    return count+ 
        getNoOfWays(array, index+1, value) + 
        getNoOfWays(array, index+1, value- array[index]) + 
        getNoOfWays(array, index+1, value+array[index]);
  }
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
