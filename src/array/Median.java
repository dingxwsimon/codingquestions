package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author dingxwsimon Numbers are randomly generated and passed to a method.
 *         Write a program to find and maintain the median value as new values
 *         are generated.
 */
// CC150 18.9
public class Median {

    private Comparator<Integer> maxHeapComparator, minHeapComparator;

    private PriorityQueue<Integer> maxHeap, minHeap;

    public Median() {
	maxHeapComparator = new Comparator<Integer>() {

	    @Override
	    public int compare(Integer o1, Integer o2) {
		if (o1 == o2)
		    return 0;
		else if (o1 > o2)
		    return -1;
		else
		    return 1;
	    }
	};

	minHeapComparator = new Comparator<Integer>() {

	    @Override
	    public int compare(Integer o1, Integer o2) {
		if (o1 == o2)
		    return 0;
		else if (o1 > o2)
		    return 1;
		else
		    return -1;
	    }
	};

	maxHeap = new PriorityQueue<Integer>(16, maxHeapComparator);
	minHeap = new PriorityQueue<Integer>(16, minHeapComparator);
    }

    public void addNumber(int num) {
	if (maxHeap.size() == minHeap.size()) {
	    if ((minHeap.peek() != null) && num > minHeap.peek()) {
		maxHeap.offer(minHeap.poll());
		minHeap.offer(num);
	    } else
		maxHeap.offer(num);
	} else {
	    if (num < maxHeap.peek()) {
		minHeap.offer(maxHeap.poll());
		maxHeap.offer(num);
	    } else
		minHeap.offer(num);
	}
    }

    public int getMedian() {
	if (maxHeap.isEmpty())
	    return minHeap.peek();
	else if (minHeap.isEmpty())
	    return maxHeap.peek();
	if (maxHeap.size() == minHeap.size()) {
	    return (minHeap.peek() + maxHeap.peek()) / 2;
	} else if (maxHeap.size() > minHeap.size()) {
	    return maxHeap.peek();
	} else {
	    return minHeap.peek();
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Median m = new Median();
	m.addNumber(10);
	m.addNumber(4);
	m.addNumber(5);
	m.addNumber(6);
	m.addNumber(2);
	m.addNumber(3);
	m.addNumber(9);
	m.addNumber(8);
	m.addNumber(7);
	m.addNumber(1);
	System.out.println(m.getMedian());
    }

}
