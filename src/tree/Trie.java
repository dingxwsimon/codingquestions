package tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class Trie {
    public class TrieNode {
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

    private TrieNode root;

    public Trie() {
	root = new TrieNode(' ');
    }

    public void insert(String s) {
	TrieNode current = root;
	if (s.length() == 0) // For an empty character
	    current.isLeaf = true;
	for (int i = 0; i < s.length(); i++) {
	    TrieNode child = current.subNode(s.charAt(i));
	    if (child != null) {
		current = child;
	    } else {
		current.child.add(new TrieNode(s.charAt(i)));
		current = current.subNode(s.charAt(i));
	    }
	    // Set isLeaf to indicate end of the word
	    if (i == s.length() - 1)
		current.isLeaf = true;
	}
    }

    public int search(String s) {
	TrieNode current = root;
	while (current != null) {
	    for (int i = 0; i < s.length(); i++) {
		if (current.subNode(s.charAt(i)) == null)
		    return 0;
		else
		    current = current.subNode(s.charAt(i));
	    }
	    /*
	     * This means that a string exists, but make sure its a word by
	     * checking its 'isLeaf' flag
	     */
	    if (current.isLeaf == true)
		return 1;
	    else
		return 2;
	}
	return 0;
    }

    public static Trie constrDict() {
	Trie t = new Trie();
	BufferedReader br = null;
	try {
	    br = new BufferedReader(new FileReader("./dict.txt"));
	    String line = "";
	    while ((line = br.readLine()) != null) {
		t.insert(line);
	    }
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    try {
		br.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return t;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	Trie trie = constrDict();

	System.out.println(trie.search("mo"));
	System.out.println(trie.search("body"));
	System.out.println(trie.search("bone"));
	System.out.println(trie.search("v"));

    }

}
