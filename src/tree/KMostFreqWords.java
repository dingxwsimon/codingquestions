package tree;

import java.util.PriorityQueue;

public class KMostFreqWords
{
  public static class TrieNode
  {
    boolean isEnd;
    int freq;
    int indexMinHeap;
    TrieNode[] children;

    public TrieNode()
    {
      isEnd = false;
      freq = 0;
      indexMinHeap = -1;
      children = new TrieNode[26];
    }
  }

  public static class MinHeapNode
  {
    TrieNode root;
    int req;
    String word;
  }

  public static PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<MinHeapNode>();

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
