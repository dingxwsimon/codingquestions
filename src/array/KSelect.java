package array;

import java.util.Random;

public class KSelect {

    // nlogk
    public static int select(int[] array, int i, int start, int end)
            throws Exception {
        if (array == null)
            throw new Exception();
        if (start == end)
            return array[start];

        int pIndex = random_partition(array, start, end);
        int k = pIndex - start + 1;
        if (i == k)
            return array[pIndex];
        else if (i < k)
            return select(array, i, start, pIndex - 1);
        else
            return select(array, i - k, pIndex + 1, end);
    }

    // like the quick sort
    public static int random_partition(int[] array, int start, int end) {
        Random r = new Random();
        int pIndex = start + r.nextInt(end - start);
        int temp = array[end];
        array[end] = array[pIndex];
        array[pIndex] = temp;

        return partition(array, start, end);

    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    public static int selectKth(int[] arr, int k) {
        if (arr == null || arr.length <= k)
            throw new Error();

        int from = 0, to = arr.length - 1;

        // if from == to we reached the kth element
        while (from < to) {
            int r = from, w = to;
            int mid = arr[(r + w) / 2];

            // stop if the reader and writer meets
            while (r < w) {

                if (arr[r] >= mid) { // put the large values at the end
                    int tmp = arr[w];
                    arr[w] = arr[r];
                    arr[r] = tmp;
                    w--;
                } else { // the value is smaller than the pivot, skip
                    r++;
                }
            }

            // if we stepped up (r++) we need to step one down
            if (arr[r] > mid)
                r--;

            // the r pointer is on the end of the first k elements
            if (k <= r) {
                to = r;
            } else {
                from = r + 1;
            }
        }

        return arr[k];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[]{10, 1, 2, 6, 4, 5, 3, 18};
        try {
            System.out.println(select(array, 3, 0, 6));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
