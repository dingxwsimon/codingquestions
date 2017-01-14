package interviewStreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopFour {
    public static void main(String args[]) throws Exception {
        Comparator minHeapComparator = new Comparator<Integer>() {
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
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(4,
                minHeapComparator);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < 4; i++) {
            line = br.readLine();
            minHeap.offer(Integer.parseInt(line));
        }
        for (int i = 4; i < N; i++) {
            line = br.readLine();
            int next = Integer.parseInt(line);
            if (next > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(next);
            }
        }
        int[] ret = new int[4];
        for (int i = 0; i < 4; i++) {
            if (!minHeap.isEmpty())
                ret[3 - i] = minHeap.poll();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(ret[i]);
        }
    }
}
