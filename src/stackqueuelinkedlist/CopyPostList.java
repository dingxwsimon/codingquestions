package stackqueuelinkedlist;

public class CopyPostList
{
  //EPI 7.5
  public static class PostNode
  {
    PostNode jump;
    PostNode next;
    int val;

    public PostNode(PostNode jump, PostNode next, int val)
    {
      super();
      this.jump = jump;
      this.next = next;
      this.val = val;
    }
  }
  
  public static PostNode copy(PostNode L){
    if(L == null)
      return null;
    PostNode p = L;
    while(p != null){
      PostNode tmp = new PostNode(p.jump, p.next, p.val);
      p.next = tmp;
      p = tmp.next;
    }
    p = L;
    while(p != null){
      if(p.jump != null){
        p.next.jump = p.jump.next;
      }
      p = p.next.next;
    }
    p = L;
    PostNode copied = p.next;
    while(p.next!= null){
      PostNode tmp = p.next;
      p.next = tmp.next;
      p = tmp;
    }
    return copied;
    
    
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
