package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import LeetCode.InsertInterval.Interval;

public class MergeIntervals {

    // Working!!!!
    class MyComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval x, Interval y) {
	    if (x.start < y.start)
		return -1;
	    else if (x.start > y.start)
		return 1;
	    return 0;
	}
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<Interval> res = new ArrayList<Interval>();

	int size = intervals.size();
	if (size < 1) {
	    return res;
	}

	Collections.sort(intervals, new MyComparator());
	res.add(intervals.get(0));
	if (size == 1) {
	    return res;
	}

	for (int i = 1; i < size; i++) {
	    Interval cur = intervals.get(i);
	    Interval prev = res.get(res.size() - 1);
	    if (cur.start <= prev.end) {
		if (cur.end > prev.end)
		    prev.end = cur.end;
	    } else
		res.add(new Interval(cur.start, cur.end));
	}
	return res;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Interval a = new Interval(1, 3);
	// Interval b = new Interval(1, 4);
	ArrayList<Interval> input = new ArrayList<Interval>();
	input.add(a);
	// input.add(b);
	MergeIntervals mi = new MergeIntervals();
	mi.merge(input);
	System.out.println("finish");
    }

}
