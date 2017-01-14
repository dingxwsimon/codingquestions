package stringoperation;

public class LexiRank {

    public static int factorial(int n) {
        int ret = 1;
        for (int i = 1; i <= n; ++i)
            ret *= i;
        return ret;
    }

    // not working yet
    public static int rank(char[] str, int index) {
        int size = str.length;
        if (index >= size)
            return 0;
        int[] hash = new int[26];
        int i = 0;
        for (i = 0; i < 26; i++)
            hash[i] = 0;
        int j, count = 0, k;
        for (j = 1; j < size; j++) {
            if (str[j] < str[0])
                count++;

        }

        j = (count) * (factorial(size - 1));

        for (i = 0; i < size; i++)
            hash[str[i] - 97]++;

        for (i = 0; i < 26; i++) {
            if (hash[i] != 0 && hash[i] != 1)
                j /= factorial(hash[i]);
        }

        k = rank(str, index + 1);
        return (j + k);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char str[] = "string".toCharArray();
        System.out.println(rank(str, 0));
    }

}
