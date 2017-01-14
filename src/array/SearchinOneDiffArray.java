package array;

public class SearchinOneDiffArray {
    /*
     * Given an array of integers such that each element is either +1 or -1 to
     * its preceding element. Find 1st occurrence of a given number in that
     * array without using linear search.
     */

    public int findElementInArray(int[] input, int expected) {
        int current = 0;
        int difference = Math.abs(input[current] - expected);

        while (difference != 0 && current < input.length) {
            difference = Math.abs(input[current] - expected);
            if (difference == 0) {
                return current;
            }
            current += difference;
        }

        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
