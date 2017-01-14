package array;

import java.util.Arrays;
import java.util.HashMap;

import LeetCode.InsertInterval.Interval;

public class PointIntersectMostIntervals {
    // giving lots of intervals [ai, bi], find a point intersect with the most
    // number of intervals
    // not tested yet

    // ai, bi sorted together but tag it a or b //using the hashmap
    // iterate from begin to end, +1 if a, -1 if b
    // max number k, then point is in k, k+1
    public static Interval findTheMostOverlappedInterval(Interval[] interArr) {
        HashMap<Integer, Integer> begin = new HashMap<Integer, Integer>(), end = new HashMap<Integer, Integer>();
        int[] startAndEnd = new int[interArr.length * 2];
        int index = 0, count = 0, max = 0;
        for (int i = 0; i < interArr.length; i++) {
            if (begin.containsKey(interArr[i].start))
                begin.put(interArr[i].start, begin.get(interArr[i].start) + 1);
            else
                begin.put(interArr[i].start, 1);
            if (end.containsKey(interArr[i].end))
                end.put(interArr[i].end, end.get(interArr[i].end) + 1);
            else
                end.put(interArr[i].end, 1);
            startAndEnd[index++] = interArr[i].start;
            startAndEnd[index++] = interArr[i].end;
        }
        Arrays.sort(startAndEnd);
        for (int i = 0; i < startAndEnd.length; i++) {
            if (begin.containsKey(startAndEnd[i])) {
                count++;
                if (count > max) {
                    max = count;
                    index = i;
                }
                begin.put(startAndEnd[i], begin.get(startAndEnd[i]) - 1);
                if (begin.get(startAndEnd[i]) == 0)
                    begin.remove(startAndEnd[i]);
            } else
                count--;
        }
        return new Interval(startAndEnd[index], startAndEnd[index + 1]);
    }

    /*
     * Hi, we can do this in O(n logn). 1. Have two arrays, one sorted on
     * arrival time and the other sorted on departure time. O(n logn) 2. Then,
     * we can do a walk on the arrival array from time 0 to max, finding total
     * no of people at any moment. Will be no of arrivals till time T (index of
     * arrival array for time T) - no of departures till time T (index of
     * departure array for time less than or equal to T). This operation will be
     * O(n) (by using one index each on arrival and departure arrays). 3. The
     * max of total no of people at any moment will be the answer. Hence order
     * O(n logn); (Data structure mentioned in post below)*./ /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
