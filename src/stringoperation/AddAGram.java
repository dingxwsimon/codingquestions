package stringoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Vector;

// same as LinguisticChains
public class AddAGram {
    private Vector[] wordList;
    private HashSet dictionary;
    private static final int LONGEST_WORD = 28;

    public int words = 0;
    public int wordskept = 0;
    public int recursions = 0;

    // *******************************************
    // AddAGram()
    // *******************************************
    public AddAGram() {
	// -------------------------------------------
	// initialization
	// -------------------------------------------
	dictionary = new HashSet();
	wordList = new Vector[LONGEST_WORD + 1];
	for (int i = 0; i < LONGEST_WORD + 1; i++)
	    wordList[i] = new Vector();

	// -------------------------------------------
	// scan data, add to word lists + dictionary
	// -------------------------------------------
	BufferedReader br = null;
	try {
	    br = new BufferedReader(new FileReader("word.lst"));
	} catch (Exception e) {
	    System.out.println("Could not find file 'word.lst': " + e
		    + "\nexiting.\n\n");
	    System.exit(1);
	}
	try {
	    // loop body
	    String tmpS = null;
	    boolean ready = true;

	    while (ready = br.ready()) {
		tmpS = br.readLine();
		tmpS = tmpS.trim(); // just in case whitespace are present

		words++;

		// Add-a-grams start with length >= 3
		if (tmpS.length() >= 1) {
		    wordskept++;

		    // add word to wordlist
		    wordList[tmpS.length()].add(tmpS);
		    // "sort" the letters of the word for fast hash lookup
		    tmpS = sortWord(tmpS);
		    // add sorted word to hashset
		    dictionary.add(tmpS);
		}
	    }
	} catch (Exception e) {
	    System.out.println("Error scanning file: " + e + "\nexiting.\n\n");
	    System.exit(1);
	}

	// -------------------------------------------
	// go from longest lists backwards, hashing permutations recursively
	// -------------------------------------------
	boolean found = false;
	boolean done = false;
	// this is a little more work than required, but I wanted to find all of
	// the
	// longest Add-a-grams
	for (int i = LONGEST_WORD; i > 3 && !done; i--) {
	    for (int j = 0; j < wordList[i].size(); j++) {
		found = scan(sortWord((String) wordList[i].elementAt(j)));
		if (found) {
		    done = true;
		    System.out.println("A longest Add-A-Gram is '"
			    + (String) wordList[i].elementAt(j) + "'");
		}
	    } // for j
	} // for i
    } // AddAGram

    // *******************************************
    // sortWord() - go from "good" to "dgoo"
    // *******************************************
    private static String sortWord(String s) {
	byte[] tmpB = s.getBytes();
	byte B;
	// viva la bubble sort!
	for (int i = 0; i < tmpB.length; i++)
	    for (int j = 0; j < tmpB.length - 1; j++)
		if (tmpB[j] > tmpB[j + 1]) { // swap!
		    B = tmpB[j];
		    tmpB[j] = tmpB[j + 1];
		    tmpB[j + 1] = B;
		} // if
	return new String(tmpB);
    }

    // *******************************************
    // scan() - trace a word's lineage, recursively
    // *******************************************
    private boolean scan(String s) {
	boolean local = false;

	recursions++;

	// is s.length shorter than 3? if so, return true
	if (s.length() < 3)
	    return true;

	// is 's' in hashset? if not, return false
	if (!dictionary.contains(s))
	    return false;

	// now test substrings of 's'
	for (int i = 0; i < s.length() && !local; i++)
	    local = scan(shorter(s, i));
	return local;
    }

    // *******************************************
    // shorter() - returns a String minus the ith letter
    // *******************************************
    private static String shorter(String s, int i) {
	byte[] tmpB = s.getBytes();
	tmpB[i] = tmpB[tmpB.length - 1];
	return (sortWord(new String(tmpB, 0, tmpB.length - 1)));
    }

    // *******************************************
    // main()
    // *******************************************
    public static void main(String[] args) {
	System.out.println("va!");
	AddAGram addAGram1 = new AddAGram();
	System.out.println("fin!");
	System.out.println("words:      " + addAGram1.words);
	System.out.println("wordskept:  " + addAGram1.wordskept);
	System.out.println("recursions: " + addAGram1.recursions);
    }

}
