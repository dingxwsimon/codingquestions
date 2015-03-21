package stringoperation;

public class RegexMatch1 {

	//not working
	static boolean stringWildCard(String pattern, String str, int i, int j) {
		if (i == pattern.length() && j == str.length())
			return true;
		else if (pattern.charAt(i) == '*' && i < pattern.length()
				&& j == str.length())// in case of 'a*' and '' it should
										// return true as a* means 0 or more
										// occurences
			return true;
		else if (pattern.charAt(i) == '*' && pattern.charAt(i) != str.charAt(j)
				&& pattern.charAt(i) != str.charAt(j))
			return false;

		else if (pattern.charAt(i) == '*')
			return stringWildCard(pattern, str, i + 1, j)
					|| stringWildCard(pattern, str, i, j + 1);
		else if (pattern.charAt(i) == str.charAt(j))
			return stringWildCard(pattern, str, i + 1, j + 1);
		else if (pattern.charAt(i) != str.charAt(j)
				&& pattern.charAt(i + 1) == '*')
			return stringWildCard(pattern, str, i + 2, j);
		else if (pattern.charAt(i) == '+'
				&& pattern.charAt(i - 1) == str.charAt(j - 1))
			return stringWildCard(pattern, str, i, j + 1)
					|| stringWildCard(pattern, str, i + 1, j);
		return false;
	}
	
	static boolean isMatched(String regex, String str) {
        if (str.length() == 0) {
            // Match is true when regex is exhausted or it's last char is "*" - allowing optional str
            return regex.length() == 0 || regex.charAt(regex.length() - 1) == '*';
        }

        if (regex.length() == 0) {
            // Match is true only if str is fully consumed
            return str.length() == 0;
        }

        Character curReg = regex.charAt(0);
        Character nextReg = regex.length() >= 2 ? regex.charAt(1) : null;
        Character curStr = str.length() != 0 ? str.charAt(0) : null;

        if (nextReg == null || (nextReg != '*' && nextReg != '+')) {
            // This is a simple match - just take the first char from both regex and str and recurse IFF current match is detected
            return isCharMatched(curReg, curStr) && isMatched(regex.substring(1), str.substring(1));
        } else {
            if (nextReg == '*') {
                // The current regex char is followed by "*" - create 2 branches:
                // - one with unmodified regex and reduced str IFF current match detected - meaning to continue repetition if possible
                // - the other one with reduced regex and unmodified str - meaning to try out the optional nature of "*"
                return (isCharMatched(curReg, curStr) && isMatched(regex, str.substring(1)))
                        || isMatched(regex.substring(2), str);
            } else if (nextReg == '+') {
                // The current regex char is followed by "+" - reduce to 1 branch with "*" instead of "+"
                return isCharMatched(curReg, curStr) && isMatched(curReg + "*" + regex.substring(2), str.substring(1));
            } else {
                return false;
            }
        }
    }

    static boolean isCharMatched(Character regexCh, Character strCh) {
        return regexCh == strCh || (regexCh == '.' && strCh >= 'a' && strCh <='z');
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatched("b*", "bbbb"));
	}

}
