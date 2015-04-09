package LeetCode;

import java.util.ArrayDeque;

public class SurroundedRegions {
    static class Pair {
	public int first;
	public int second;

	public Pair(int f, int s) {
	    first = f;
	    second = s;
	}
    }

    public void solve(char[][] board) {
	if (board == null || board.length == 0) {
	    return;
	}
	for (int i = 0; i < board[0].length; ++i) {
	    if (board[0][i] == 'O') {
		markUnflippable(board, 0, i);
	    }
	}
	for (int i = 0; i < board[board.length - 1].length; ++i) {
	    if (board[board.length - 1][i] == 'O') {
		markUnflippable(board, board.length - 1, i);
	    }
	}
	for (int i = 0; i < board.length; ++i) {
	    if (board[i][0] == 'O') {
		markUnflippable(board, i, 0);
	    }
	}
	for (int i = 0; i < board.length; ++i) {
	    if (board[i][board[i].length - 1] == 'O') {
		markUnflippable(board, i, board[i].length - 1);
	    }
	}

	// modify the board
	for (int i = 0; i < board.length; ++i) {
	    for (int j = 0; j < board[i].length; ++j) {
		if (board[i][j] == 'O') {
		    board[i][j] = 'X';
		} else if (board[i][j] == 'U') {
		    board[i][j] = 'O';
		}
	    }
	}
    }

    public void markUnflippable(char[][] board, int r, int c) {
	int[] dirX = { -1, 0, 1, 0 };
	int[] dirY = { 0, 1, 0, -1 };
	ArrayDeque<Pair> stack = new ArrayDeque<Pair>();
	stack.push(new Pair(r, c));
	while (!stack.isEmpty()) {
	    Pair p = stack.pop();
	    board[p.first][p.second] = 'U';
	    for (int i = 0; i < dirX.length; ++i) {
		if (p.first + dirX[i] >= 0 && p.first + dirX[i] < board.length
			&& p.second + dirY[i] >= 0
			&& p.second + dirY[i] < board[p.first + dirX[i]].length
			&& board[p.first + dirX[i]][p.second + dirY[i]] == 'O') {
		    stack.push(new Pair(p.first + dirX[i], p.second + dirY[i]));
		}
	    }
	}
    }

    int[] unionSet; // union find set
    boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of
			// the matrix

    public void solve1(char[][] board) {
	if (board.length == 0 || board[0].length == 0)
	    return;

	// init, every char itself is an union
	int height = board.length, width = board[0].length;
	unionSet = new int[height * width];
	hasEdgeO = new boolean[unionSet.length];
	for (int i = 0; i < unionSet.length; i++)
	    unionSet[i] = i;
	for (int i = 0; i < hasEdgeO.length; i++) {
	    int x = i / width, y = i % width;
	    hasEdgeO[i] = (board[x][y] == 'O' && (x == 0 || x == height - 1
		    || y == 0 || y == width - 1));
	}

	// iterate the matrix, for each char, union it + its upper char + its
	// right char if they equals to each other
	for (int i = 0; i < unionSet.length; i++) {
	    int x = i / width, y = i % width, up = x - 1, right = y + 1;
	    if (up >= 0 && board[x][y] == board[up][y])
		union(i, i - width);
	    if (right < width && board[x][y] == board[x][right])
		union(i, i + 1);
	}

	// for each char in the matrix, if it is an 'O' and its union doesn't
	// has an 'edge O', the whole union should be setted as 'X'
	for (int i = 0; i < unionSet.length; i++) {
	    int x = i / width, y = i % width;
	    if (board[x][y] == 'O' && !hasEdgeO[findSet(i)])
		board[x][y] = 'X';
	}
    }

    private void union(int x, int y) {
	int rootX = findSet(x);
	int rootY = findSet(y);
	// if there is an union has an 'edge O',the union after merge should be
	// marked too
	boolean hasEdgeO = this.hasEdgeO[rootX] || this.hasEdgeO[rootY];
	unionSet[rootX] = rootY;
	this.hasEdgeO[rootY] = hasEdgeO;
    }

    private int findSet(int x) {
	if (unionSet[x] == x)
	    return x;
	unionSet[x] = findSet(unionSet[x]);
	return unionSet[x];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	char[][] board = new char[][] { "XOXOXO".toCharArray(),
		"OXOXOX".toCharArray(), "XOXOXO".toCharArray(),
		"OXOXOX".toCharArray() };
	SurroundedRegions s = new SurroundedRegions();
	s.solve(board);
	System.out.println(board.toString());
    }

}
