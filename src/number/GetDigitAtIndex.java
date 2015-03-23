package number;

public class GetDigitAtIndex {
    public static char getDigit(int index) {
	int digits = 0;
	int min = 0;
	int max = -1;
	while (true) {
	    digits += 1;
	    min = max + 1;
	    max += (9 * digits);
	    int size = (max - min + 1) * digits;
	    if (size > index)
		break;
	    index -= size;
	}
	int number = min + (index / digits);
	int digit = index % digits;
	return (number + "").charAt(digit);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(getDigit(1000));
    }

}
