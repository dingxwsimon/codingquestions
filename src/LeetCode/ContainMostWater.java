package LeetCode;

public class ContainMostWater {

    // elegant, need to understand
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int capability = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);

            if (water > capability)
                capability = water;

            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return capability;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
