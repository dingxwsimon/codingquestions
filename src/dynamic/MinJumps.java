package dynamic;

public class MinJumps {

    /*
     * Given an array of integers where each element represents the max number
     * of steps that can be made forward from that element. Write a function to
     * return the minimum number of jumps to reach the end of the array
     * (starting from the first element). If an element is 0, then cannot move
     * through that element. Example: I nput: arr[] = {1, 3, 5, 8, 9, 2, 6, 7,
     * 6, 8, 9} Output: 3 (1-> 3 -> 8 ->9)
     */
    public static int minJumps(int[] array) {
        int n = array.length;
        int[] jumps = new int[n];
        if (n == 0 || array[0] == 0)
            return Integer.MAX_VALUE;
        jumps[0] = 0;
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + array[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = jumps[j] + 1;
                    break;
                }
            }
        }

        return jumps[n - 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(array));
    }

}
