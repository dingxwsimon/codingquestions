package stringoperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static final Pattern p1 = Pattern
	    .compile(
		    "\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b",
		    Pattern.CASE_INSENSITIVE);

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Matcher m1 = p1.matcher("fjdkalfdhsi 192.168.1.1 dfnhjaklfhdsajklfh");
	System.out.println(m1.find());
    }

}
