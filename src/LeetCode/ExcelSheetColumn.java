package LeetCode;

public class ExcelSheetColumn {
    public String convertToTitle(int n) {
	String ret = "";
	if (n < 0)
	    return ret;
	while (n > 0) {
	    ret = (char) ('A' + (n - 1) % 26) + ret;
	    n = (n - 1) / 26;
	}
	return ret;
    }

    public int titleToNumber(String s) {
	if (s == null || s.length() == 0)
	    return 0;
	int ret = 0;
	for (int i = 0; i < s.length(); i++) {
	    ret = ret * 26 + (s.charAt(i) - 'A') + 1;
	}
	return ret;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ExcelSheetColumn esc = new ExcelSheetColumn();
	System.out.println(esc.convertToTitle(345));
	System.out.println(esc.titleToNumber("aax"));
    }

}
