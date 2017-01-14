package LeetCode;

import java.util.Arrays;

public class TwoSum {

    /*
     * Two SumMar 14 '11 Given an array of integers, find two numbers such that
     * they add up to a specific target number. The function twoSum should
     * return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2. Please note that your returned
     * answers (both index1 and index2) are not zero-based. You may assume that
     * each input would have exactly one solution. Input: numbers={2, 7, 11,
     * 15}, target=9 Output: index1=1, index2=2
     */
    // hashmap will speed up

    // pass both
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Arrays.toString(Arrays.copyOfRange(new int[]{0, 1,
                2, 3, 4, 5, 6, 7}, 2, 8)));
    }

}
