package old;

public class Permutation {
    public static void getPermutes(char[] array, int i) {
	int j;
	if (i == array.length) {
	    System.out.println(array);
	} else {
	    for (j = i; j < array.length; j++) {
		char tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
		getPermutes(array, i + 1);
		tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	    }
	}

    }

    public static char[][] telnum = { {}, {}, { 'a', 'b', 'c' },
	    { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
	    { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
	    { 'w', 'x', 'y', 'z' } };

    public static void telPermut(int[] array) {
	int[] num = new int[array.length];
	for (int i = 0; i < num.length; i++) {
	    num[i] = 0;
	}
	while (true) {
	    for (int i = 0; i < array.length; i++)
		System.out.print(telnum[array[i]][num[i]]);
	    System.out.print('\n');
	    int k = array.length - 1;
	    while (k >= 0) {
		if (num[k] < telnum[array[k]].length - 1) {
		    num[k]++;
		    break;
		} else {
		    num[k] = 0;
		    k--;
		}
	    }
	    if (k < 0)
		break;
	}
    }

    public static void interlace(int[] array, int n) {
	for (int i = 0, j = 1; i < n; i++, j += 2) {
	    rightrotate(array, j, n + i);
	}
	System.out.println("");
    }

    public static void rightrotate(int[] array, int start, int end) {
	int tmp = array[end];
	int i = 0;
	for (i = end; i > start; i--) {
	    array[i] = array[i - 1];
	}
	array[i] = tmp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	getPermutes("abc".toCharArray(), 0);
	// telPermut(new int[]{8,2,3,2,6,2});
	// interlace(new int[]{1,3,5,7,9,2,4,6,8,10}, 5);
    }

}
