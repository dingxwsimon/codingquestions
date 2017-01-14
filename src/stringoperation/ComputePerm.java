package stringoperation;

public class ComputePerm {
    /*
     * You are given an array of n elements [1,2,....n]. For example
     * {3,2,1,6,7,4,5}. Now we create a signature of this array by comparing
     * every consecutive pir of elements. If they increase, write I else write
     * D. For example for the above array, the signature would be "DDIIDI". The
     * signature thus has a length of N-1. Now the question is given a
     * signature, compute the lexicographically smallest permutation of
     * [1,2,....n]. Write the below function in language of your choice. vector*
     * FindPermute(const string& signature);
     */

    public static void main(String[] args) {
        System.out.println(findPermutation("DDIIDDI"));
    }

    private static String reverse(int begin, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = end; i >= begin; i--) {
            sb.append(i + " ");
        }
        return sb.toString();
    }

    public static String findPermutation(String signature) {
        StringBuffer sb = new StringBuffer();
        int lasti = 1;
        for (int i = 0; i < signature.length(); i++) {
            if ('I' == signature.charAt(i)) {
                sb.append(reverse(lasti, i + 1));
                lasti = i + 2;
            }
        }
        sb.append(reverse(lasti, signature.length() + 1));
        return sb.toString();
    }

}
