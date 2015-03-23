package stringoperation;

import java.util.ArrayList;
import java.util.HashSet;

public class Boggle {
    public static final int MAX_WORD_LEN = 100;

    // different from leetcode wordsearch
    // there are 8 direction u need to consider
    public void boggle(char[][] char_map, HashSet<String> dict) {
	int m = char_map.length;
	if (m == 0)
	    return;
	int n = char_map[0].length;
	if (n == 0)
	    return;
	boolean[][] status_map = new boolean[m][n]; // initilized to false
	String cur_str;
	ArrayList<String> results = new ArrayList<String>();

	// for each position as starting
	for (int x = 0; x < m; x++)
	    for (int y = 0; y < n; y++) {
		cur_str = char_map[x][y] + "";
		status_map[x][y] = true;
		search(char_map, status_map, dict, x, y, cur_str, results);
		status_map[x][y] = false;
	    }
    }

    public void search(char[][] char_map, boolean[][] visited,
	    HashSet<String> dict, int x, int y, String cur_str,
	    ArrayList<String> results) {
	if (dict.contains(cur_str))
	    results.add(cur_str);
	if (cur_str.length() == MAX_WORD_LEN)
	    return;
	if (x < 0 || y < 0 || x >= char_map.length || y >= char_map[0].length)
	    return;

	for (int i = x - 1; i < x + 2; i++) {
	    for (int j = y - 1; y < y + 2; y++) {
		if (i == x && j == y)
		    continue;
		cur_str += char_map[i][j];
		visited[i][j] = true;
		search(char_map, visited, dict, i, j, cur_str, results);
		visited[i][j] = false;
	    }
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
