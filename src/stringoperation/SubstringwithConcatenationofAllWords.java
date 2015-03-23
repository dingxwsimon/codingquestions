package stringoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    private ArrayList<Integer> result = null;
    private Map<String, Integer> wordAdded = null;
    private Map<String, Integer> wordTotal = null;
    private int wordNum = 0;
    private int wordSize = 0;
    private int articleSize = 0;
    // current search position in a sentence
    private int scur = 0;
    // check if we have find a new index
    private boolean foundNew = false;

    private void addResult(int index) {
	foundNew = true;
	result.add(index);
    }

    private ArrayList<Integer> getResult() {
	return result;
    }

    // make sure S and L not be null
    private void init(String S, String[] L) {
	result = new ArrayList<Integer>();
	wordAdded = new HashMap<String, Integer>();
	wordTotal = new HashMap<String, Integer>();
	articleSize = S.length();
	wordNum = L.length;
	if (wordNum > 0) {
	    wordSize = L[0].length();
	    for (String word : L)
		inc(wordTotal, word);
	}
    }

    /**
     * Increase the occurrence of a word in map by 1. If word is not in the map,
     * create one and assign its occurrence as 1.
     * 
     * @param map
     * @param word
     * @return the new count
     */
    private int inc(Map<String, Integer> map, String word) {
	Integer count = map.get(word);
	if (count == null)
	    count = 0;
	map.put(word, count + 1);
	return count + 1;
    }

    /**
     * decrease the counters of a word.
     * 
     * @param word
     */
    private void decount(String word) {
	Integer count = wordAdded.get(word);
	if (count != null && count > 0)
	    wordAdded.put(word, count - 1);
    }

    /**
     * An sentence is the connection of all the words once in L.
     * 
     * @param S
     *            defined here as an article
     * @param L
     * @return
     */
    public ArrayList<Integer> findSubstring(String S, String[] L) {
	init(S, L);
	if (wordNum == 0)
	    return getResult();
	for (int abase = 0; abase < wordSize; abase++)
	    searchArticle(abase, S);
	return getResult();
    }

    private void searchArticle(int abase, String article) {
	// the base of a sentence
	int sbase = abase;
	// the current search position in a sentence
	scur = sbase;
	// if possible to go through a whole sentence
	while (sbase + wordSize * wordNum <= articleSize) {
	    if (foundNew) {
		// a matched sentence has been found somewhere
		foundNew = false;
		sbase = handleMatch(sbase, article);
	    } else {
		sbase = searchSentence(sbase, article);
	    }
	}
	wordAdded.clear();
    }

    /**
     * Search all the words in a sentence starts from sbase. If all the words in
     * the sentence is valid, add it to the result list.
     * 
     * @param sbase
     * @param article
     * @return the new sentence base or the original sentence and set foundNew
     *         to true.
     */
    private int searchSentence(int sbase, String article) {
	// current search position is not done
	while (scur <= sbase + (wordNum - 1) * wordSize) {
	    String str = article.substring(scur, scur + wordSize);
	    if (!wordTotal.containsKey(str)) {
		wordAdded.clear();
		sbase = scur + wordSize;
		scur = sbase;
		return sbase;
	    }
	    if (inc(wordAdded, str) <= wordTotal.get(str)) {
		scur += wordSize;
	    } else {
		decount(str);
		return handleOverMatch(sbase, scur, article);
	    }
	}
	// mark foundNew as true, return sbase so that the new
	// sentence can be handled by handeNewMatch.
	addResult(sbase);
	return sbase;
    }

    /**
     * @param sbase
     *            the base of a matched sentence.
     * @param article
     * @return the new sentence base, may update the new search position in the
     *         sentence. foundNew may also be updated.
     */
    private int handleMatch(int sbase, String article) {
	sbase += wordSize;
	// exceeds the end of article, returns new sbase
	if (sbase + wordNum * wordSize > articleSize) {
	    return sbase;
	}
	String prev = article.substring(sbase - wordSize, sbase);
	String last = article.substring(sbase + (wordNum - 1) * wordSize, sbase
		+ wordNum * wordSize);
	if (prev.equals(last)) {
	    // a new match
	    addResult(sbase);
	    return sbase;
	}
	// prev is not part of the new sentence, so decrease its counter
	decount(prev);
	if (!wordTotal.containsKey(last)) {
	    // sentence is not valid since its last word does not match.
	    // start a new sentence
	    sbase = sbase + wordSize * wordNum;
	    scur = sbase;
	    wordAdded.clear();
	} else {
	    // last string must appears somewhere ranged [ sbase,
	    // sbase+(wordSize-1)*wordNum )
	    sbase = handleOverMatch(sbase, sbase + (wordNum - 1) * wordSize,
		    article);
	}
	return sbase;
    }

    /**
     * Over match means the last string appears more than the maximum number in
     * a valid sentence. we assume here that the last string is not added to
     * wordAdded yet. scur will be updated to last, the first place to search in
     * a sentence started from sbase.
     * 
     * @param sbase
     *            the base of a sentence
     * @param last
     *            the last index where a over matched string is found
     * @param article
     * @return the new sentence base, update scur.
     */
    private int handleOverMatch(int sbase, int last, String article) {
	int cur = sbase;
	String target = article.substring(last, last + wordSize);
	String str = null;
	while (cur < last && !target.equals(str)) {
	    str = article.substring(cur, cur + wordSize);
	    decount(str);
	    cur += wordSize;
	}
	scur = last;
	return cur;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
