package stackqueuelinkedlist;

import java.util.ArrayList;

import stackqueuelinkedlist.AddLinkList.ListNode;

public class MergeSort
{
  public ListNode mergeSort(ListNode head){
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    if(head == null || head.next == null){
      return head;
    }
    ArrayList<ListNode> ret = new ArrayList<ListNode>();
    ret = split(head);
    
    ListNode left = mergeSort(ret.get(0));
    ListNode right = mergeSort(ret.get(1));
    
    return sortMerge(left, right);
  }
  
  
  public ListNode sortMerge(ListNode l1, ListNode l2)
  {
    ListNode head = new ListNode(0);
    ListNode h = head;
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        h.next = l1;
        l1 = l1.next;
      }
      else {
        h.next = l2;
        l2 = l2.next;
      }
      h = h.next;
    }
    if (l1 != null) {
      h.next = l1;
    }
    else if (l2 != null) {
      h.next = l2;
    }
    return head.next;
  }

  public ArrayList<ListNode> split(ListNode head){
    ArrayList<ListNode> ret = new ArrayList<ListNode>();
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    fast = head;
    while(fast.next != slow){
      fast = fast.next;
    }
    fast.next = null;
    ret.add(head);
    ret.add(slow);
    return ret;
  }
  
  
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    MergeSort m = new MergeSort();
    ListNode myListNode = new ListNode(1);
    myListNode.next = new ListNode(7);
    myListNode.next.next = new ListNode(4);
    //System.out.println(m.split(myListNode).get(1));
    
    myListNode.next.next.next = new ListNode(10);
    myListNode.next.next.next.next = new ListNode(5);//1,2,3,4,5 so the mid point is expected to be 3
    myListNode.next.next.next.next.next = new ListNode(8);
    myListNode.next.next.next.next.next.next = new ListNode(7);//1,2,3,4,5,6,7 so mid point expected to be 4
    ListNode s = m.mergeSort(myListNode);
    System.out.println(s.val);
  }

}
