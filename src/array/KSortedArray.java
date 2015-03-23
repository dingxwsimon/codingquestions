package array;

public class KSortedArray {

    void sortK(int arr[], int n, int k) {
	// Create a Min Heap of first (k+1) elements from
	// input array
	int harr[] = new int[k + 1];
	for (int i = 0; i <= k; i++)
	    harr[i] = arr[i];
	MinHeap hp = new MinHeap(harr, k + 1);

	// i is index for remaining elements in arr[] and ti
	// is target index of for cuurent minimum element in
	// Min Heapm 'hp'.
	for (int i = k + 1, ti = 0; ti < n; i++, ti++) {
	    // If there are remaining elements, then place
	    // root of heap at target index and add arr[i]
	    // to Min Heap
	    if (i < n)
		arr[ti] = hp.replaceMin(arr[i]);

	    // Otherwise place root at its target index and
	    // reduce heap size
	    else
		arr[ti] = hp.extractMin();
	}
    }

    class MinHeap {
	int heap_size = 0;

	int[] harr;

	// FOLLOWING ARE IMPLEMENTATIONS OF STANDARD MIN HEAP METHODS FROM
	// CORMEN
	// BOOK
	// Constructor: Builds a heap from a given array a[] of given size
	MinHeap(int a[], int size) {
	    heap_size = size;
	    harr = a; // store address of array
	    int i = (heap_size - 1) / 2;
	    while (i >= 0) {
		MinHeapify(i);
		i--;
	    }
	}

	// Method to remove minimum element (or root) from min heap
	int extractMin() {
	    int root = harr[0];
	    if (heap_size > 1) {
		harr[0] = harr[heap_size - 1];
		heap_size--;
		MinHeapify(0);
	    }
	    return root;
	}

	// Method to change root with given value x, and return the old root
	int replaceMin(int x) {
	    int root = harr[0];
	    harr[0] = x;
	    if (root < x)
		MinHeapify(0);
	    return root;
	}

	// A recursive method to heapify a subtree with root at given index
	// This method assumes that the subtrees are already heapified
	void MinHeapify(int i) {
	    int l = 2 * i + 1;
	    int r = 2 * i + 2;
	    int smallest = i;
	    if (l < heap_size && harr[l] < harr[i])
		smallest = l;
	    if (r < heap_size && harr[r] < harr[smallest])
		smallest = r;
	    if (smallest != i) {
		swap(harr, i, smallest);
		MinHeapify(smallest);
	    }
	}

	// A utility function to swap two elements
	void swap(int[] harr, int i, int j) {
	    int temp = harr[i];
	    harr[i] = harr[j];
	    harr[j] = temp;
	}

    }

    // Driver program to test above functions
    public static void main(String[] args) {
	int k = 3;
	int arr[] = { 2, 6, 3, 12, 56, 8 };
	int n = 6;
	KSortedArray ks = new KSortedArray();
	ks.sortK(arr, n, k);
	System.exit(1);
    }

}
