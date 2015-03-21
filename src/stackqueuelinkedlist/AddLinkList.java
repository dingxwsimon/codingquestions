package stackqueuelinkedlist;

public class AddLinkList
{
  public static class ListNode
  {
    int val;

    ListNode next;

    ListNode(int x)
    {
      val = x;
      next = null;
    }

    public String toString()
    {
      return val + "";
    }
  }

  public static class PartialSum
  {
    public ListNode sumNode = null;
    public int carry = 0;
  }

  private static int length(ListNode l)
  {
    if (l == null) {
      return 0;
    }
    else {
      return 1 + length(l.next);
    }
  }

  private static PartialSum addListsHelper(ListNode l1, ListNode l2)
  {
    if (l1 == null && l2 == null) {
      PartialSum sum = new PartialSum();
      return sum;
    }
    PartialSum sum = addListsHelper(l1.next, l2.next);
    int val = sum.carry + l1.val + l2.val;
    ListNode full_result = insertBefore(sum.sumNode, val % 10);
    sum.sumNode = full_result;
    sum.carry = val / 10;
    return sum;
  }

  private static ListNode addLists(ListNode l1, ListNode l2)
  {
    int len1 = length(l1);
    int len2 = length(l2);
    if (len1 < len2) {
      l1 = padList(l1, len2 - len1);
    }
    else {
      l2 = padList(l2, len1 - len2);
    }
    PartialSum sum = addListsHelper(l1, l2);
    if (sum.carry == 0) {
      return sum.sumNode;
    }
    else {
      ListNode result = insertBefore(sum.sumNode, sum.carry);
      return result;
    }
  }

  private static ListNode padList(ListNode l, int padding)
  {
    ListNode head = l;
    for (int i = 0 ; i < padding ; i++) {
      ListNode n = new ListNode(0);
      n.next = head;
      head = n;
    }
    return head;
  }

  private static ListNode insertBefore(ListNode list, int data)
  {
    ListNode node = new ListNode(data);
    if (list != null) {
      node.next = list;
    }
    return node;
  }

  public static int linkedListToInt(ListNode node)
  {
    int value = 0;
    while (node != null) {
      value = value * 10 + node.val;
      node = node.next;
    }
    return value;
  }

  public static void main(String[] args)
  {
    ListNode lA1 = new ListNode(3);
    lA1.next = new ListNode(1);
    lA1.next.next = new ListNode(5);

    ListNode lB1 = new ListNode(5);
    lB1.next = new ListNode(9);
    lB1.next.next = new ListNode(1);

    ListNode list3 = addLists(lA1, lB1);

    int l1 = linkedListToInt(lA1);
    int l2 = linkedListToInt(lB1);
    int l3 = linkedListToInt(list3);

    System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
    System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
  }

}
