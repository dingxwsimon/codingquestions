/**
 * @(#) ThreeSum.java Apr 3, 2010 3:15:09 PM
 * Copyright (C) 2009 GeeYee Inc. 60606, Chicago, IL, USA
 * All right reserved
 */
package old;

import java.util.Arrays;

/**
 * Class <code>ThreeSum</code>
 *
 * @author Xiaowen dingxwsimon@gmail.com
 * @since Apr 3, 2010 3:15:09 PM
 *
 */
public class ThreeSum {
    // First sort the array. -- O(nlogn)
    // Then find a pivot such that divide the array into two part, the first
    // part
    // a1, is less than n/3, while the second part a2, is larger than n/3. --
    // O(n)
    // Then divide the problem into two subproblem:
    // 1) use two pointers to look for two elements in a1, one pointer to look
    // for
    // one element in a2, so that the sum is n. -- O(nlogn)
    // 2) use one pointer to look for one elements in a1, use two pointers to
    // look
    // for two elements in a2, so that the sum is n. -- O(nlogn)
    public static boolean hasSum(int[] a, int t) {
        int n = a.length;
        if (n < 3)
            return false;

        // Sort the array - O (n lg n)
        Arrays.sort(a);

        // Initialize three pointers.
        int lo = 0;
        int mid = 1;
        int hi = n - 1;
        boolean midUp = false;

        // While we are still pointing to three separate numbers and
        // we haven't gone off the end of the list, do the following.
        // We won't go off the beginning of the list because the hi
        // pointer can't pass over the lo and mid pointers.
        while ((lo != mid) && (mid != hi) && (lo != hi) && (lo < n)
                && (mid < n)) {

            // Check if we have our sum
            int sum = a[lo] + a[mid] + a[hi];
            if (sum == t) {
                System.out.println(lo + " " + mid + " " + hi);
                return true;
            }

            if (sum > t) {

                // If the lo and mid points are next to each other, the current
                // sum is the smallest sum we can make with the current hi
                // pointer. If this sum is too big, move the hi pointer down.
                if (lo == mid - 1) {
                    hi--;
                    midUp = false;
                }

                // If we last moved the mid pointer up and now the sum is too
                // big, we need to move the mid pointer back down. We have
                // already checked that sum (lo + mid-- + hi) and we know
                // it is too small, so we also have to move the lo pointer up.
                if (midUp) {

                    // If the mid pointer is less than three spaces above the
                    // lo pointer, we can't move it back down, so move the hi
                    // pointer down instead.
                    if (mid < lo + 3) {
                        hi--;
                    } else {
                        lo++;
                    }
                    mid = lo + 1;
                    midUp = false;
                }

            } else { // sum < t

                // If the mid and hi pointers are next to each other, the
                // current sum is the largest sum we can make with the current
                // lo pointer. If this sum is too small, move the lo pointer
                // up and reset mid to lo+1.
                if (mid == hi - 1) {
                    lo++;
                    mid = lo + 1;
                    midUp = false;
                }
                // Else, move the mid pointer up.
                else {
                    mid++;
                    midUp = true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(ThreeSum.hasSum(a, 24));
    }

}
