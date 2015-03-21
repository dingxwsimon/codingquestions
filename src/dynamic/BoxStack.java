package dynamic;

import java.util.ArrayList;
import java.util.HashMap;

public class BoxStack
{
  public static class Box
  {
    public int w;
    public int h;
    public int d;

    public boolean canBeAbove(Box other)
    {
      return other.w > w && other.h > h && other.d > d;
    }
  }

  // CC150
  public ArrayList<Box> createStack(Box[] boxes, Box bottom,
      HashMap<Box, ArrayList<Box>> stack_map)
  {
    if (bottom != null && stack_map.containsKey(bottom)) {
      return stack_map.get(bottom);
    }
    int max_height = 0;
    ArrayList<Box> max_stack = null;
    for (int i = 0 ; i < boxes.length ; i++) {
      if (boxes[i].canBeAbove(bottom)) {
        ArrayList<Box> new_stack = createStack(boxes, boxes[i], stack_map);
        int new_height = new_stack.size();
        if (new_height > max_height) {
          max_stack = new_stack;
          max_height = new_height;
        }
      }
    }
    if (max_stack == null) max_stack = new ArrayList<Box>();
    if (bottom != null) max_stack.add(0, bottom);
    stack_map.put(bottom, max_stack);
    return (ArrayList<Box>) max_stack.clone();
  }

  /*
   * Returns the height of the tallest stack that can be formed with give type
   * of boxes
   */
  int maxStackHeight(Box arr[], int n)
  {
    /*
     * Create an array of all rotations of given boxes
     * For example, for a box {1, 2, 3}, we consider three
     * instances{{1, 2, 3}, {2, 1, 3}, {3, 1, 2}}
     */
    Box[] rot = new Box[3 * n];
    int index = 0;
    for (int i = 0 ; i < n ; i++) {
      // Copy the original box
      rot[index] = arr[i];
      index++;

      // First rotation of box
      rot[index].h = arr[i].w;
      rot[index].d = Math.max(arr[i].h, arr[i].d);
      rot[index].w = Math.min(arr[i].h, arr[i].d);
      index++;

      // Second rotation of box
      rot[index].h = arr[i].d;
      rot[index].d = Math.max(arr[i].h, arr[i].w);
      rot[index].w = Math.min(arr[i].h, arr[i].w);
      index++;
    }

    // Now the number of boxes is 3n
    n = 3 * n;

    /*
     * Sort the array ¡®rot[]¡® in decreasing order, using library
     * function for quick sort
     */
    // qsort (rot, n, sizeof(rot[0]), compare);

    // Uncomment following two lines to print all rotations
    // for (int i = 0; i < n; i++ )
    // printf("%d x %d x %d\n", rot[i].h, rot[i].w, rot[i].d);

    /*
     * Initialize msh values for all indexes
     * msh[i] ¨C> Maximum possible Stack Height with box i on top
     */
    int[] msh = new int[n];
    for (int i = 0 ; i < n ; i++)
      msh[i] = rot[i].h;

    /* Compute optimized msh values in bottom up manner */
    for (int i = 1 ; i < n ; i++)
      for (int j = 0 ; j < i ; j++)
        if (rot[i].w < rot[j].w && rot[i].d < rot[j].d
            && msh[i] < msh[j] + rot[i].h) {
          msh[i] = msh[j] + rot[i].h;
        }

    /* Pick maximum of all msh values */
    int max = -1;
    for (int i = 0 ; i < n ; i++)
      if (max < msh[i]) max = msh[i];

    return max;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
