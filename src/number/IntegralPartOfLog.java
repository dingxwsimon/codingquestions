package number;

public class IntegralPartOfLog {
    int integralPartOfLog(int n) {

	int ret = 0;

	while (n > 0) {
	    n = n >> 1;
	    ret++;
	}

	return ret - 1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
