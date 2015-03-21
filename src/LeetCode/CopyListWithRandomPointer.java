package LeetCode;

import java.util.HashMap;

public class CopyListWithRandomPointer
{

  public class RandomListNode
  {
    int label;
    RandomListNode next, random;

    RandomListNode(int x)
    {
      this.label = x;
    }
  };

  public RandomListNode copyRandomList(RandomListNode head)
  {
    if (head == null) return null;
    RandomListNode copy = new RandomListNode(head.label);
    RandomListNode h = head;
    RandomListNode copyh = copy;
    HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    map.put(head, copy);
    while (head.next != null) {
      head = head.next;
      copy.next = new RandomListNode(head.label);
      copy = copy.next;
      map.put(head, copy);
    }
    head = h;
    copy = copyh;
    copy.random = map.get(head.random);
    while (head.next != null) {
      head = head.next;
      copy = copy.next;
      copy.random = map.get(head.random);
    }
    return copyh;
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
