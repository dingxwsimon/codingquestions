package stringoperation;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchStrInList
{
  // CC150 18.8
  public static class SuffixTree
  {
    SuffixTreeNode root = new SuffixTreeNode();

    public SuffixTree(String s)
    {
      for (int i = 0 ; i < s.length() ; i++) {
        String suffix = s.substring(i);
        root.insertString(suffix, i);
      }
    }

    public ArrayList<Integer> search(String s)
    {
      return root.search(s);
    }
  }

  public static class SuffixTreeNode
  {
    HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();

    char value;
    ArrayList<Integer> indexes = new ArrayList<Integer>();

    public SuffixTreeNode()
    {}

    public void insertString(String s, int index)
    {
      indexes.add(index);
      if (s != null && s.length() > 0) {
        value = s.charAt(0);
        SuffixTreeNode child = null;
        if (children.containsKey(value)) {
          child = children.get(value);
        }
        else {
          child = new SuffixTreeNode();
          children.put(value, child);
        }
        String remainder = s.substring(1);
        child.insertString(remainder, index);
      }
    }

    public ArrayList<Integer> search(String s)
    {
      if (s == null || s.length() == 0) {
        return indexes;
      }
      else {
        char first = s.charAt(0);
        if (children.containsKey(first)) {
          String remainder = s.substring(1);
          return children.get(first).search(remainder);
        }
      }
      return null;
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    String testString = "mississippi";
    String[] stringList = { "is", "sip", "hi", "sis" };
    SuffixTree tree = new SuffixTree(testString);
    for (String s : stringList) {
      ArrayList<Integer> list = tree.search(s);
      if (list != null) {
        System.out.println(s + ": " + list.toString());
      }
    }
  }

}
