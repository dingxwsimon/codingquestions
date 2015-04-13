package CrackingCoding;


public class c11_8 {
    
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
    
    private static RankNode root = null;

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
	int size = 100;
	int[] list = AssortedMethods.randomArray(size, -100, 100);
	for (int i = 0; i < list.length; i++) {
	    track(list[i]);
	}

	int[] tracker = new int[size];
	for (int i = 0; i < list.length; i++) {
	    int v = list[i];
	    int rank1 = root.getRank(list[i]);
	    tracker[rank1] = v;
	}

	for (int i = 0; i < tracker.length - 1; i++) {
	    if (tracker[i] != 0 && tracker[i + 1] != 0) {
		if (tracker[i] > tracker[i + 1]) {
		    System.out.println("ERROR at " + i);
		}
	    }
	}

	System.out.println("Array: " + AssortedMethods.arrayToString(list));
	System.out.println("Ranks: " + AssortedMethods.arrayToString(tracker));
    }
}
