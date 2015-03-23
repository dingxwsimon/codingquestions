package interviewStreet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.LinkedList;

public class Decode1 {

    public static class Trie {
	private TrieNode root;

	public Trie() {
	    root = new TrieNode(' ');
	}

	public void insert(String s) {
	    TrieNode current = root;
	    if (s.length() == 0)
		current.isLeaf = true;
	    for (int i = 0; i < s.length(); i++) {
		TrieNode child = current.subNode(s.charAt(i));
		if (child != null) {
		    current = child;
		} else {
		    current.child.add(new TrieNode(s.charAt(i)));
		    current = current.subNode(s.charAt(i));
		}
		if (i == s.length() - 1)
		    current.isLeaf = true;
	    }
	}

	public int is_word(String s) {
	    TrieNode current = root;
	    while (current != null) {
		for (int i = 0; i < s.length(); i++) {
		    if (current.subNode(s.charAt(i)) == null)
			return 0;
		    else
			current = current.subNode(s.charAt(i));
		}
		if (current.isLeaf == true)
		    return 1;
		else
		    return 2;
	    }
	    return 0;
	}
    }

    public static class TrieNode {
	char content;
	boolean isLeaf;
	Collection<TrieNode> child;

	public TrieNode(char c) {
	    child = new LinkedList<TrieNode>();
	    isLeaf = false;
	    content = c;
	}

	public TrieNode subNode(char c) {
	    if (child != null) {
		for (TrieNode eachChild : child) {
		    if (eachChild.content == c) {
			return eachChild;
		    }
		}
	    }
	    return null;
	}

    }

    private static Trie trie = new Trie();

    // for simplicity I put all the dictionary words into a file called dict.txt
    // and construct a trie out of all the words in that dictionary
    public static void constrDict() {
	try {
	    BufferedReader br = new BufferedReader(new FileReader("./dict.txt"));
	    String line = "";
	    while ((line = br.readLine()) != null) {
		trie.insert(line);
	    }
	} catch (Exception e) {
	    System.out
		    .println("Exception happned when construct the dictionary trie");
	    e.printStackTrace();
	}
    }

    // this array contains the mapping of integer to characters
    // for simplicity, i assume that all the characters in the words in the
    // dictionary are lower case
    private static String[] mapping = { "afkpuz", "bglqv", "chmrw", "dinsx",
	    "ejoty" };

    public static void decode(String message) {
	constrDict();
	int[] num = new int[message.length()];
	for (int i = 0; i < num.length; i++) {
	    num[i] = message.charAt(i) - 49;
	    if (num[i] > 5 || num[i] < 0) {
		System.out.println("invalid number in the message");
		return;
	    }
	}
	int n = num.length;
	int answer[] = new int[n];
	while (true) {
	    if (trie.is_word(getResult(num, answer, n - 1)) == 1)
		System.out.println(getResult(num, answer, n - 1));
	    int k = n - 1;
	    while (k >= 0) {
		answer[k]++;
		while (answer[k] <= mapping[num[k]].length() - 1
			&& trie.is_word(getResult(num, answer, k)) == 0) {
		    answer[k]++;
		}
		if (answer[k] <= mapping[num[k]].length() - 1)
		    break;
		else {
		    answer[k] = 0;
		    k--;
		}
	    }
	    if (k < 0)
		break;
	}
    }

    private static String getResult(int[] telNum, int[] answer, int k) {
	StringBuilder result = new StringBuilder();
	for (int i = 0; i <= k; i++)
	    result.append(mapping[telNum[i]].charAt(answer[i]));
	return result.toString();
    }

    public static void main(String[] args) {
	String message = "2545";
	Decode1.decode(message);
    }

}
