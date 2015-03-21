package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions
{
	public void solve(char[][] board) {
	    if(board == null || board.length == 0) return;
	    int m = board.length, n = board[0].length;
	    for(int i = 0; i < n; i++) {bfs(0, i, board); bfs(m - 1, i, board);}
	    for(int j = 1; j < m- 1; j++) {bfs(j, 0, board); bfs(j, n - 1, board);}
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            if(board[i][j] == 'O') board[i][j] = 'X';
	            else if(board[i][j] == '+') board[i][j] = 'O';
	}
	public void bfs(int i, int j, char[][] board){
	    Queue<Integer> q = new LinkedList<Integer>(); 
	    visit(i, j, q, board);
	    while(!q.isEmpty()){
	        int cur = q.poll();
	        int t = cur / board[0].length;
	        int s = cur % board[0].length;
	        visit(t - 1, s, q, board);
	        visit(t, s - 1, q, board);
	        visit(t + 1, s, q, board);
	        visit(t, s + 1, q, board);
	    }
	}
	public void visit(int i, int j, Queue<Integer> q, char[][] board){
	    int m = board.length, n = board[0].length;
	    if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
	    board[i][j] = '+';
	    q.offer(i * n + j);
	}

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    char[][] board = new char[][] { "OXOOOX".toCharArray(),
        "OOXXXO".toCharArray(), "XXXXXO".toCharArray(), "OOOOXX".toCharArray(),
        "XXOOXO".toCharArray(), "OOXXXX".toCharArray() };
    SurroundedRegions s = new SurroundedRegions();
    s.solve(board);
  }

}
