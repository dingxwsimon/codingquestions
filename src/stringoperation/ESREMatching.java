package stringoperation;

public class ESREMatching {
    // EPI 6.5
    public static boolean is_Match(String r, String s) {

	if (r.startsWith("^"))
	    return is_match_here(r.substring(1), s);
	for (int i = 0; i <= s.length(); i++) {
	    if (is_match_here(r, s.substring(i))) {
		return true;
	    }
	}
	return false;
    }

    public static boolean is_match_here(String r, String s) {
	if (r.isEmpty())
	    return true;
	if (r == "$")
	    return s.isEmpty();
	if (r.length() >= 2 && r.charAt(1) == '*') {
	    for (int i = 0; i < s.length()
		    && (r.startsWith(".") || r.charAt(0) == s.charAt(i)); i++) {
		if (is_match_here(r.substring(2), s.substring(i + 1))) {
		    return true;
		}
	    }
	    return is_match_here(r.substring(2), s);
	}
	return !s.isEmpty()
		&& (r.startsWith(".") || r.charAt(0) == s.charAt(0))
		&& is_match_here(r.substring(1), s.substring(1));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(is_Match("^abc", "aabcdf"));
    }

}
