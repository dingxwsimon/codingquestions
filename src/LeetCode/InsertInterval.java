package LeetCode;

import java.util.ArrayList;

public class InsertInterval {

    public static class Interval {
        public int start;
        public int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    // study
    public ArrayList<Interval> insert1(ArrayList<Interval> intervals,
                                       Interval newInterval) {
        // the start and end index of the intervals to be removed
        int s = -1, e = -1;
        for (int i = 0; i < intervals.size(); i++) {
            if (s == -1 && intervals.get(i).end >= newInterval.start) {
                // find the first interval that new interval start inside
                s = i;
            } // special case: intervals.get(i).end is always <
            // newInterval.start.
            // i.e. newInterval should be inserted at the end
            if (intervals.get(i).start <= newInterval.end) {
                // find the last interval that the new interval end inside
                e = i;
            } // special case: intervals.get(i).start is always >
            // newInterval.end.
            // i.e. newIntervals should be inserted at the start
        }

        // handle special cases of s and e
        if (s == -1) // insert in the end
        {
            intervals.add(newInterval);
            return intervals;
        }
        if (e == -1) // insert in the start
        {
            intervals.add(0, newInterval);
            return intervals;
        }

        // now s and e are in the range of [0, intervals.size()-1]
        int start = Math.min(intervals.get(s).start, newInterval.start);
        int end = Math.max(intervals.get(e).end, newInterval.end);

        intervals.subList(s, e + 1).clear(); // inclusive, exclusive
        intervals.add(s, new Interval(start, end));
        return intervals;
    }

    // Working!!!
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
                                             Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> result = new ArrayList<Interval>();
        boolean inprev = false;
        boolean done = false;
        int start = 0;
        for (Interval inte : intervals) {
            if (!inprev && !done) {
                if (newInterval.start < inte.start) {
                    if (newInterval.end < inte.start) {
                        // newinterval outside and infront of inte
                        result.add(newInterval);
                        result.add(inte);
                        done = true;
                    } else if (newInterval.end <= inte.end) {
                        // newinterval start + inte end
                        newInterval.end = inte.end;
                        result.add(newInterval);
                        done = true;
                    } else if (newInterval.end > inte.end) {
                        // inte inside newinterval
                        start = newInterval.start;
                        inprev = true;
                    }
                } else {
                    if (newInterval.start > inte.end) {
                        result.add(inte);
                    } else if (newInterval.end <= inte.end) {
                        // newinterval inside inte
                        result.add(inte);
                        done = true;
                    } else if (newInterval.end > inte.end) {
                        start = inte.start;
                        inprev = true;
                    }
                }
            } else if (inprev) {
                if (newInterval.end < inte.start) {
                    newInterval.start = start;
                    result.add(newInterval);
                    result.add(inte);
                    done = true;
                    inprev = false;
                } else if (newInterval.end < inte.end) {
                    newInterval.start = start;
                    newInterval.end = inte.end;
                    result.add(newInterval);
                    done = true;
                    inprev = false;
                }
            } else if (done)
                result.add(inte);
        }

        if (inprev && !done) {
            newInterval.start = start;
            result.add(newInterval);
        } else if (!done) {
            result.add(newInterval);
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // [[2,4],[6,8],[18,18]], [6,11]
        Interval i = new Interval(2, 4);
        Interval i1 = new Interval(6, 8);
        Interval i2 = new Interval(18, 18);
        // Interval i3 = new Interval(11,13);
        Interval newi = new Interval(6, 11);
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i);
        intervals.add(i1);
        intervals.add(i2);
        // intervals.add(i3);
        insert(intervals, newi);

    }

}
