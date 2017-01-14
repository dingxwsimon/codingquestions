package array;

public class HammingDistance {
    // get hamming distance of list of binary number
    // distance (for a bit) = number of '1's * number of '0's
    int hammingDist(int[] nums) {

        int[] bits = new int[32];

        for (int i = 0; i < nums.length; i++) {
            int one = 1;
            int j = 0;

            while (nums[i] != 0) {
                if ((nums[i] & one) != 0)
                    bits[j]++;
                j++;
                nums[i] = nums[i] >> 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += bits[i] * (nums.length - bits[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
