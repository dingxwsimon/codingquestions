package tree;

public class CheckSubTree
{
  // CC150
  public static boolean matchTree(Node r1, Node r2)
  {
    if (r2 == null) return true;
    if (r1 == null) return false;

    if (r1.value != r2.value) return false;

    return matchTree(r1.left, r2) && matchTree(r1.left, r2);

  }

  // check is r2 is a subtree of r1
  public static boolean subTree(Node r1, Node r2)
  {

    if (r1 == null && r2 != null) return false;
    if (r1 != null && r2 == null) return false;
    if (r1 == null && r2 == null) return true;

    if (r1.value == r2.value) if (matchTree(r1, r2)) return true;
    return subTree(r1.left, r2) || subTree(r1.right, r2);
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
