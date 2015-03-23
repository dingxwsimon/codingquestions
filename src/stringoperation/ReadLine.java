package stringoperation;

public class ReadLine {
    char[] arr = null;
    int p = 0;

    char[] read4096() {
	return new char[0];
    }

    char[] readLine() {
	StringBuffer sb = new StringBuffer();

	NEXT: while (true) {
	    if (arr == null) {
		arr = read4096();
		if (arr == null)
		    break;
		p = 0;
	    }

	    while (p < arr.length) {
		if (arr[p] != '\0')
		    sb.append(arr[p]);
		else {
		    p++;
		    break NEXT;
		}
	    }

	    arr = null;
	}

	return sb.toString().toCharArray();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
