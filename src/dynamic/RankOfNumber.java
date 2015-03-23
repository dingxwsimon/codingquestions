package dynamic;

import java.util.ArrayList;
import java.util.Random;

public class RankOfNumber { // BST idea CC150 11.8
    public static class RankNode {
	public int left_size = 0;
	public RankNode left;
	public RankNode right;
	public int data = 0;

	public RankNode(int d) {
	    data = d;
	}

	public void insert(int d) {
	    if (d <= data) {
		if (left != null) {
		    left.insert(d);
		} else {
		    left = new RankNode(d);
		}
		left_size++;
	    } else {
		if (right != null) {
		    right.insert(d);
		} else {
		    right = new RankNode(d);
		}
	    }
	}

	public int getRank(int d) {
	    if (d == data) {
		return left_size;
	    } else if (d < data) {
		if (left == null) {
		    return -1;
		} else {
		    return left.getRank(d);
		}
	    } else {
		int right_rank = right == null ? -1 : right.getRank(d);
		if (right_rank == -1) {
		    return -1;
		} else {
		    return left_size + 1 + right_rank;
		}
	    }
	}
    }

    public static RankNode root = null;

    public static void track(int number) {
	if (root == null) {
	    root = new RankNode(number);
	} else {
	    root.insert(number);
	}
    }

    public static int getRankOfNumber(int number) {
	return root.getRank(number);
    }

    public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	Random r = new Random(10);
	for (int i = 0; i < 100; i++) {
	    int x = r.nextInt(100000);
	    list.add(x);
	    track(x);
	}

	for (int i : list) {
	    int rank1 = root.getRank(i);
	    System.out.println(i + " has rank " + rank1);
	}
    }

}
