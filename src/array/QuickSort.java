package array;

public class QuickSort {
    public static void qsort1(int[] array, int l, int u) {
        if (l >= u)
            return;

        int pivot = array[l];

        int m = l;
        for (int i = l + 1; i <= u; i++) {
            if (array[i] < pivot) {
                ++m;
                int tmp = array[m];
                array[m] = array[i];
                array[i] = tmp;
            }
        }

        array[l] = array[m];
        array[m] = pivot;

        qsort1(array, l, m - 1);
        qsort1(array, m + 1, u);
    }

    public void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left + (right - left) / 2];
        while (left <= right) {
            while (arr[left] < pivot)
                left++;
            while (arr[right] > pivot)
                right++;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
