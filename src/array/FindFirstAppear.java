package array;

public class FindFirstAppear
{
  int binarySearch(int arr[], int start, int end, int key)
  {
    if(end < start) return -1;
    int mid = start + (end - start) / 2;
    if(arr[mid] == key)
    {
      int leftIndex = binarySearch(arr, start, mid - 1, key);
      return (leftIndex == -1 ? mid : leftIndex);
    }
    else if(arr[mid] > key)
    {
      return binarySearch(arr, start, mid - 1, key);
    }
    else
    {
      return binarySearch(arr, mid + 1, end, key);
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
