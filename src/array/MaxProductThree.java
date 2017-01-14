package array;

import java.util.Arrays;

public class MaxProductThree {

    // sort then compare 2neg product and two pos product
    public int maxPro() { // -5, -4, -3, -2 , 0
        int array[] = new int[]{4, 5, 6, 0, -5, -7, -2, -10};
        Arrays.sort(array);
        // -10,-7,-5,-2,0,4,5,6
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0)
                count = count + 1;
        }
        int maxProduct = 1;
        if (array.length < 3) {
            return -1;
        } else if (array.length >= 3) {
            int a = 1, b = 2;
            if (count >= 2) {
                a = array[0] * array[1] * array[array.length - 1];
                b = array[array.length - 1] * array[array.length - 2]
                        * array[array.length - 3];
                maxProduct = Math.max(a, b);

            } else if (count == 0 || count == 1 || count == array.length) {
                maxProduct = array[array.length - 1] * array[array.length - 2]
                        * array[array.length - 3];
            }
        }
        return maxProduct;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
