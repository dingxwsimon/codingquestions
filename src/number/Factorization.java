package number;

import java.util.ArrayList;

public class Factorization {

    public static void Factorize(int n) {
	int key = 1;
	int num = n;
	ArrayList<Integer> list = new ArrayList<Integer>();
	while (num > 1) {
	    for (int i = 2; i <= num; i++) { // use to check prime
		if (num % i == 0) { // find a prime factor
		    key = i;
		    list.add(key); // keep this prime factor
		    break;
		}
	    }
	    num = num / key; // keep factorize
	}
	System.out.print(list.toString());
    }

    public static void pFact(int n) {
	ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
	pfactHelper(n, n, output, new ArrayList<Integer>());
    }

    public static void pfactHelper(int mult, int fact,
	    ArrayList<ArrayList<Integer>> output, ArrayList<Integer> ret) {
	for (int i = fact; i >= 2; i--) {
	    int d = mult / i;
	    int m = mult % i;
	    System.out.println("f = " + i + " d = " + d + " m = " + m
		    + " ret = " + ret.toString());
	    if (m == 0) {
		ret.add(i);
		if (d == 1) {
		    output.add(new ArrayList<Integer>(ret));
		    System.out.println(ret.toString());
		} else {
		    pfactHelper(d, i, output, ret);
		}
		ret.remove(ret.size() - 1);
	    }
	}
    }

    public static void main(String[] args) {
	pFact(264);
    }
}
