package LeetCode;

public class ImplementStrStr {

    // pass both
    // just O(k*n)
    public static String strStr(String haystack, String needle) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (needle == null || needle.isEmpty())
	    return haystack;
	if (haystack == null || haystack.isEmpty())
	    return null;
	int needleIndex = 0;

	for (int i = 0; i < haystack.length(); i++) {
	    if (needle.charAt(needleIndex) == haystack.charAt(i))
		needleIndex++;
	    else {
		i -= needleIndex;
		needleIndex = 0;
		continue;
	    }

	    if (needleIndex == needle.length())
		return haystack.substring(i - needle.length() + 1,
			haystack.length());
	}
	return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(strStr("mississippi", "issip"));
    }

}
