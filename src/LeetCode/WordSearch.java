package LeetCode;

public class WordSearch {
    public boolean exist1(char[][] board, String word) {
	char[] w = word.toCharArray();
	for (int y = 0; y < board.length; y++) {
	    for (int x = 0; x < board[y].length; x++) {
		if (exist(board, y, x, w, 0))
		    return true;
	    }
	}
	return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
	if (i == word.length)
	    return true;
	if (y < 0 || x < 0 || y == board.length || x == board[y].length)
	    return false;
	if (board[y][x] != word[i])
	    return false;
	board[y][x] ^= 256;
	boolean exist = exist(board, y, x + 1, word, i + 1)
		|| exist(board, y, x - 1, word, i + 1)
		|| exist(board, y + 1, x, word, i + 1)
		|| exist(board, y - 1, x, word, i + 1);
	board[y][x] ^= 256;
	return exist;
    }

    public boolean exist(char[][] board, String word) {
	if (board == null)
	    return false;
	if (word == null || word.length() == 0)
	    return true;
	boolean[][] visited = new boolean[board.length][board[0].length];
	for (int i = 0; i < board.length; i++)
	    for (int j = 0; j < board[0].length; j++)
		if (DFS(board, i, j, word, 0, visited))
		    return true;
	return false;
    }

    public boolean DFS(char[][] b, int i, int j, String word, int index,
	    boolean[][] v) {
	if (v[i][j] || b[i][j] != word.charAt(index))
	    return false;
	if (index == word.length() - 1)
	    return true;
	v[i][j] = true;
	if (i != 0 && DFS(b, i - 1, j, word, index + 1, v))
	    return true;
	if (i != b.length - 1 && DFS(b, i + 1, j, word, index + 1, v))
	    return true;
	if (j != 0 && DFS(b, i, j - 1, word, index + 1, v))
	    return true;
	if (j != b[0].length - 1 && DFS(b, i, j + 1, word, index + 1, v))
	    return true;
	v[i][j] = false;
	return false;
    }

    // ETL

    // recursive, one more matrix to store the info whether this
    // char has been used or not
    public boolean exist2(char[][] board, String word) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int m = board.length;
	if (m == 0)
	    return word.length() == 0;
	;
	int n = board[0].length;
	if (n == 0)
	    return false;
	boolean[][] visited = new boolean[m][n];

	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (exist(board, word, 0, visited, i, j)) {
		    return true;
		}
		visited[i][j] = false;
	    }
	}
	return false;
    }

    public boolean exist(char[][] board, String word, int level,
	    boolean[][] visited, int r, int c) {
	int m = board.length;
	int n = board[0].length;
	if (board[r][c] != word.charAt(level))
	    return false;
	if (level == word.length() - 1)
	    return true;

	boolean up = false, down = false, left = false, right = false;
	visited[r][c] = true;
	// up
	if (r - 1 >= 0 && !visited[r - 1][c]) {
	    up = exist(board, word, level + 1, visited, r - 1, c);
	    visited[r - 1][c] = false;
	}
	if (up)
	    return true;
	// down
	if (r + 1 < m && !visited[r + 1][c]) {
	    down = exist(board, word, level + 1, visited, r + 1, c);
	    visited[r + 1][c] = false;
	}
	if (down)
	    return true;

	// left
	if (c - 1 >= 0 && !visited[r][c - 1]) {
	    left = exist(board, word, level + 1, visited, r, c - 1);
	    visited[r][c - 1] = false;
	}
	if (left)
	    return true;

	// right
	if (c + 1 < n && !visited[r][c + 1]) {
	    right = exist(board, word, level + 1, visited, r, c + 1);
	    visited[r][c + 1] = false;
	}
	if (right)
	    return true;

	return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	WordSearch w = new WordSearch();
	System.out.println(w.exist1(new char[][] { { 'a', 'a' } }, "aa"));

    }

}
