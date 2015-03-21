package LeetCode;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * the basic idea is, keep a hashmap which stores the characters in string
     * as keys and their positions as values, and keep two pointers which define
     * the max substring. move the right pointer to scan through the string ,
     * and meanwhile update the hashmap. If the character is already in the
     * hashmap, then move the left pointer to the left of the same character
     * last found. Note that the two pointers can only move forward.
     */

    public int lengthOfLongestSubstring2(String s) {
	if (s == null || s.isEmpty())
	    return 0;
	int[] charMap = new int[256];
	Arrays.fill(charMap, -1);
	int i = 0, max = 0;
	for (int j = 0; j < s.length(); j++) {
	    if (charMap[s.charAt(j)] >= i) {
		i = charMap[s.charAt(j)] + 1;
	    }
	    charMap[s.charAt(j)] = j;
	    max = Math.max(j - i + 1, max);
	}
	return max;
    }

    public int lengthOfLongestSubstring1(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int n = s.length();
	if (n < 1)
	    return 0;
	int l = 0, r = 0;
	int[] found = new int[26];
	int mlen = 1;
	while (r < n) {
	    int rc = s.charAt(r) - 'a';
	    found[rc] = found[rc] + 1;
	    while (found[rc] > 1 && l <= r) {
		int lc = s.charAt(l) - 'a';
		found[lc] = found[lc] - 1;
		l++;
	    }
	    int len = r - l + 1;
	    mlen = Math.max(mlen, len);
	    r++;
	}
	return mlen;
    }

    /*
     * Given a string, find the length of the longest substring without
     * repeating characters. For example, the longest substring without
     * repeating letters for "abcabcbb" is "abc", which the length is 3. For
     * "bbbbb" the longest substring is "b", with the length of 1.
     */
    // pass both
    public int lengthOfLongestSubstring(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	int visited[] = new int[26];
	/*
	 * Initialize the visited array as -1, -1 is used to indicate that
	 * character has not been visited yet.
	 */
	for (int i = 0; i < 26; ++i)
	    visited[i] = -1;

	int curr_length = 0;
	int max_length = 0;

	for (int i = 0; i < s.length(); ++i) {
	    int curr_index = s.charAt(i) - 'a';
	    /*
	     * If the current character is not present in the already processed
	     * substring or it is not part of the current NRCS, then do
	     * cur_len++
	     */
	    if (-1 == visited[curr_index]
		    || visited[curr_index] < i - curr_length) {
		++curr_length;
	    }
	    /*
	     * If the current character is present in currently considered NRCS,
	     * then update NRCS to start from the next character of previous
	     * instance.
	     */
	    else {
		/*
		 * Also, when we are changing the NRCS, we should also check
		 * whether length of the previous NRCS was greater than max_len
		 * or not.
		 */
		max_length = (max_length > curr_length) ? max_length
			: curr_length;
		curr_length = i - visited[curr_index];
	    }
	    // update the index of current character
	    visited[curr_index] = i;
	}

	max_length = (max_length > curr_length) ? max_length : curr_length;

	return max_length;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
