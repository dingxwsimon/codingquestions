package regex;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Digraph
{
  private final int V;
  private int E;
  private ArrayList<Integer>[] adj;
  
 /**
   * Create an empty digraph with V vertices.
   * @throws java.lang.IllegalArgumentException if V < 0
   */
  public Digraph(int V) {
      if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
      this.V = V;
      this.E = 0;
      adj = (ArrayList<Integer>[]) new ArrayList[V];
      for (int v = 0; v < V; v++) {
          adj[v] = new ArrayList<Integer>();
      }
  }

 /**
   * Create a digraph from input stream.
 * @throws IOException 
   */  
  public Digraph(InputStream in) throws IOException {
      try {
          this.V = in.read();
          if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
          adj = (ArrayList<Integer>[]) new ArrayList[V];
          for (int v = 0; v < V; v++) {
              adj[v] = new ArrayList<Integer>();
          }
          int E = in.read();
          if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
          for (int i = 0; i < E; i++) {
              int v = in.read();
              int w = in.read();
              addEdge(v, w); 
          }
      }
      catch (NoSuchElementException e) {
          throw new InputMismatchException("Invalid input format in Digraph constructor");
      }
  }

 /**
   * Copy constructor.
   */
  public Digraph(Digraph G) {
      this(G.V());
      this.E = G.E();
      for (int v = 0; v < G.V(); v++) {
          // reverse so that adjacency list is in same order as original
          Stack<Integer> reverse = new Stack<Integer>();
          for (int w : G.adj[v]) {
              reverse.push(w);
          }
          for (int w : reverse) {
              adj[v].add(w);
          }
      }
  }
      
 /**
   * Return the number of vertices in the digraph.
   */
  public int V() {
      return V;
  }

 /**
   * Return the number of edges in the digraph.
   */
  public int E() {
      return E;
  }

 /**
   * Add the directed edge v->w to the digraph.
   * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
   */
  public void addEdge(int v, int w) {
      if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
      if (w < 0 || w >= V) throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V-1));
      adj[v].add(w);
      E++;
  }

 /**
   * Return the list of vertices pointed to from vertex v as an Iterable.
   * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
   */
  public Iterable<Integer> adj(int v) {
      if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
      return adj[v];
  }

 /**
   * Return the reverse of the digraph.
   */
  public Digraph reverse() {
      Digraph R = new Digraph(V);
      for (int v = 0; v < V; v++) {
          for (int w : adj(v)) {
              R.addEdge(w, v);
          }
      }
      return R;
  }

 /**
   * Return a string representation of the digraph.
   */
  public String toString() {
      StringBuilder s = new StringBuilder();
      String NEWLINE = System.getProperty("line.separator");
      s.append(V + " vertices, " + E + " edges " + NEWLINE);
      for (int v = 0; v < V; v++) {
          s.append(String.format("%d: ", v));
          for (int w : adj[v]) {
              s.append(String.format("%d ", w));
          }
          s.append(NEWLINE);
      }
      return s.toString();
  }

 /**
   * Test client.
   */
  public static void main(String[] args) {
      //Digraph G = new Digraph();
  }

}
