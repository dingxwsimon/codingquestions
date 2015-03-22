package LeetCode;

public class LongestSubstringAtMost2DistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
	if (s == null || s.length() == 0)
	    return 0;
	if (s.length() == 1)
	    return 1;
	int[] charMap = new int[256];
	int i = 0, max = 0, numDist = 0;
	for (int j = 0; j < s.length(); j++) {
	    if (charMap[s.charAt(j)] == 0)
		numDist++;
	    charMap[s.charAt(j)]++;
	    while (numDist > 2) {
		charMap[s.charAt(i)]--;
		if (charMap[s.charAt(i)] == 0)
		    numDist--;
		i++;
	    }
	    max = Math.max(max, j - i + 1);
	}
	return max;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
