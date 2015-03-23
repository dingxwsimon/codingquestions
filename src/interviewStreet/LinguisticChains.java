package interviewStreet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

// time complexity O((word length)^2 * (number of words)^2)
public class LinguisticChains {
    // store the words in the dictionary with the same length in an arraylist
    public ArrayList<String> dictionary[];
    // put the possible shorterOne words in the stack, easy for back track
    public Stack<String> stack;
    // store the words chain here.
    public String[] visitedWords = new String[LONGEST_WORD];
    // assuming the longest word has length 38,
    // of course we can go through the dictionary once and get the accurate
    // length
    // of the longest words
    // this is just a simple assumption
    private static final int LONGEST_WORD = 38;

    public LinguisticChains(String dictionarypath) {

	init(dictionarypath);
    }

    // check whether two words different by only one characters.
    // longerStr == shorterStr + one more character in any places
    // the time complexity of this check function is O(length of the longerStr)
    // since it compare each character of the longerStr with the corrseponding
    // shorterStr
    // at most once.
    public boolean check(char[] longerStr, char[] shorterStr) {
	int i, j;
	int k, m;
	for (i = 0, j = 0; i < shorterStr.length && j < longerStr.length; i++, j++)
	    if (shorterStr[i] != longerStr[j]) {
		break;
	    }
	if (i == shorterStr.length && j == longerStr.length - 1)
	    return true;
	for (k = shorterStr.length - 1, m = longerStr.length - 1; k >= 0
		&& m >= 0; k--, m--)
	    if (shorterStr[k] != longerStr[m]) {
		break;
	    }
	if (k == -1 && m == 0)
	    return true;
	if (j == m && i - k == 1)
	    return true;
	return false;
    }

    // get all the shortone words for a given words
    public void addAllShortOneWords(String words) {
	int shorterStrSize = words.length() - 1;
	int shorterListSize = dictionary[shorterStrSize].size();
	String shorter = "";
	for (int i = 0; i < shorterListSize; i++) {
	    shorter = dictionary[shorterStrSize].get(i);
	    if (check(words.toCharArray(), shorter.toCharArray()))
		stack.push(shorter);
	}
    }

    public void printChain(String start, String end) {
	String next = "", prev = end;
	int j = end.length();
	String output = end;
	for (int i = j - 1; i >= 1; i--) {
	    next = visitedWords[i];
	    // if (check(prev.toCharArray(), next.toCharArray())) {
	    output += " => " + next;
	    prev = next;
	    // }
	}
	System.out.println(output);
    }

    // basically construct the dictionary
    public void init(String dictionarypath) {
	dictionary = new ArrayList[LONGEST_WORD + 1];
	for (int i = 0; i < LONGEST_WORD + 1; i++)
	    dictionary[i] = new ArrayList<String>();
	BufferedReader br = null;
	try {
	    br = new BufferedReader(new FileReader(dictionarypath));
	} catch (Exception e) {
	    System.out.println("Could not find dictionary file: "
		    + dictionarypath);
	    System.exit(1);
	}
	boolean ready = true;
	String line;
	try {
	    while (ready = br.ready()) {
		line = br.readLine();
		dictionary[line.length()].add(line);
	    }
	} catch (Exception e) {
	    System.out.println("Error reading the dictionary file");
	    System.exit(1);
	}
    }

    // basically for the worst situation for all different word length
    // the program needs to compare every pair of the words
    // to see if they can form a chain or not
    // and the check function runs in O(word length)
    // so the total time complexity is O((word length)^2 * (number of words) ^
    // 2)
    public void getLongestChain() {
	ArrayList<String> wordsSameLen;
	boolean longest = false;
	// top down appraoch, which consider from the longest words
	for (int i = LONGEST_WORD; i > 0; i--) {
	    wordsSameLen = dictionary[i];
	    // System.out.println("word length now is " + i);
	    // if we already found some chain in the previous length
	    // we do not have to consider the smaller length
	    if (longest)
		return;
	    for (String word : wordsSameLen) {
		stack = new Stack<String>();
		visitedWords = new String[LONGEST_WORD];
		stack.push(word);
		while (!stack.empty()) {
		    String tmp = stack.pop();
		    addAllShortOneWords(tmp);
		    visitedWords[tmp.length()] = tmp;
		    if (tmp.length() == 1) {
			printChain(tmp, word);
			longest = true;
			// the code will print all the different chains from the
			// same word
			// if that is not desired, just break when found one
			// chain of a word
			// break;
		    }
		}
	    }
	}
    }

    public static void main(String args[]) {
	if (args.length < 1) {
	    System.out.println("no input for dictionary path, system exit");
	    System.exit(1);
	}

	LinguisticChains a = new LinguisticChains(args[0]);
	a.getLongestChain();

    }
}
