package array;

import java.util.HashMap;

public class BSinShiftArray {

    // search in a increasing array right shift
    public static int bs(int[] array, int k) {
        int l = 0;
        int u = array.length - 1;
        while (u >= l) {
            int m = l + ((u - l) >> 1);
            if (array[m] == k)
                return m;
            if (array[l] < array[m]) {
                if (k >= array[l] && k < array[m])
                    u = m - 1;
                else
                    l = m + 1;
            } else if (array[l] > array[m]) {
                if (array[m] < k && k <= array[u])
                    l = m - 1;
                else
                    u = m + 1;
            }
        }
        return -1;
    }

    // find max in a shifted sorted array
    public static int max(int array[]) {
        int l = 0;
        int u = array.length - 1;
        int m = 0;
        while (u >= l) {
            m = l + (u - l) / 2;
            if (m == array.length - 1 || m == 0)
                return m;
            if ((array[m] > array[m + 1] && array[m] > array[m - 1])
                    && m < array.length - 1 && m > 0)
                return m;
            if (array[m] > array[l])
                l = m + 1;
            if (array[m] < array[u])
                u = m - 1;
        }
        return m;
    }

    public static int findMax(int array[]) {
        int l = 0;
        int u = array.length - 1;
        int m = 0;
        while (array[u] > array[l]) {
            m = l + (u - l) / 2;
            if (array[m] > array[l])
                l = m;
            else
                u = m - 1;
        }
        return u;
    }

    // this is elegant!!!!
    public static int findMinimum(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (arr[low] > arr[high]) {
            int mid = (low + high) >>> 1;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int findMin(int arr[], int low, int high) {
        // This condition is needed to handle the case when array is not
        // rotated at all
        if (high < low)
            return arr[0];

        // If there is only one element left
        if (high == low)
            return arr[low];

        // Find mid
        int mid = low + (high - low) / 2; /* (low + high)/2; */

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid + 1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid - 1);
        return findMin(arr, mid + 1, high);
    }

    public static void missingNumber(int[] array) {
        if (array == null)
            return;
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = min; i <= max; i++)
            map.put(i, 1);

        for (int i = 0; i < array.length; i++)
            if (map.containsKey(array[i]))
                map.put(array[i], 0);

        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                System.out.print(key + " ");
        }
        System.out.print("\n");
        return;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] data = new int[]{4, 1, 3};
        System.out.println(findMax(data));
    }

}
