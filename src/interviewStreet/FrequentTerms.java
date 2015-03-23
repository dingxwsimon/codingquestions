package interviewStreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FrequentTerms {

    public static void main(String args[]) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();
	int N = Integer.parseInt(line);
	HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
	for (int i = 0; i < N; i++) {
	    line = br.readLine();
	    if (freqMap.containsKey(line)) {
		freqMap.put(line, freqMap.get(line) + 1);
	    } else {
		freqMap.put(line, 1);
	    }
	}
	line = br.readLine();
	int K = Integer.parseInt(line);
	Comparator minHeapComparator = new Comparator<Entry<String, Integer>>() {

	    @Override
	    public int compare(Entry<String, Integer> o1,
		    Entry<String, Integer> o2) {
		if (o1.getValue() == o2.getValue()) {
		    return o2.getKey().compareTo(o1.getKey());
		} else if (o1.getValue() > o2.getValue())
		    return 1;
		else
		    return -1;
	    }
	};

	PriorityQueue<Entry<String, Integer>> minHeap = new PriorityQueue<Entry<String, Integer>>(
		K, minHeapComparator);
	int cnt = 0;
	for (Entry<String, Integer> elem : freqMap.entrySet()) {
	    if (cnt < K) {
		minHeap.add(elem);
	    } else {
		if (minHeapComparator.compare(elem, minHeap.peek()) > 0) {
		    minHeap.poll();
		    minHeap.offer(elem);
		}
	    }
	    cnt++;
	}
	String[] ret = new String[K];
	for (int i = 0; i < K; i++) {
	    ret[K - 1 - i] = minHeap.poll().getKey();
	}
	for (int i = 0; i < K; i++)
	    System.out.println(ret[i]);
    }

}
