package LeetCode;

import java.util.HashMap;

public class MaxPointOnaLine {

    public static class Point {
	int x;
	int y;

	Point() {
	    x = 0;
	    y = 0;
	}

	Point(int a, int b) {
	    x = a;
	    y = b;
	}
    }

    public static int GCD(int a, int b) {
	return a != 0 ? a / Math.abs(a) * Math.abs(GCD(b % a, a)) : b;
    }

    public static int maxPoints(Point[] points) {
	int result = 0;
	for (int i = 0; i < points.length; i++) {
	    HashMap<String, Integer> count = new HashMap<String, Integer>();
	    int same = 1, mx = 0;
	    for (int j = i + 1; j < points.length; j++) {
		int x = points[i].x - points[j].x;
		int y = points[i].y - points[j].y;
		int g = GCD(x, y);
		if (g == 0) {
		    same++;
		    continue;
		}
		x /= g;
		y /= g;
		String tmp = x + " " + y;
		if (!count.containsKey(tmp)) {
		    count.put(tmp, 1);
		} else {
		    count.put(tmp, count.get(tmp) + 1);
		}
		mx = Math.max(mx, count.get(tmp));
	    }
	    result = Math.max(result, mx + same);
	}
	return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Point p1 = new Point(0, 0);
	Point p2 = new Point(1, 0);
	Point[] points = new Point[] { p1, p2 };
	System.out.println(maxPoints(points));
    }

}
