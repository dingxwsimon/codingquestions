package number;

import java.util.PriorityQueue;

// this have duplicate numbers
public class PerfectPower implements Comparable<PerfectPower> {
    private final long value;
    private final int a;
    private final int b;

    public PerfectPower(int a, int b) {
        this.value = power(a, b);
        this.a = a;
        this.b = b;
    }

    // brute force exponentation suffices
    public static long power(int a, int b) {
        long pow = 1;
        for (int i = 0; i < b; i++) {
            pow *= a;
        }
        return pow;
    }

    public int compareTo(PerfectPower that) {
        if (this.value < that.value)
            return -1;
        else if (this.value > that.value)
            return +1;
        else
            return 0;
    }

    public String toString() {
        return value + " = " + a + "^" + b;
    }

    public static boolean isPP(long n) {
        int b = (int) Math.log(n) + 1;
        for (int i = 2; i <= n; i++) {
            int l = 1, r = (int) Math.log(n);
            while (l <= r) {
                int m = (l + r) / 2;
                int x = (int) Math.pow(m, b);
                if (n == x)
                    return true;
                else if (x < n) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int x = 2;
        if (args.length == 1)
            x = Integer.parseInt(args[0]);

        // initialize priority queue
        PriorityQueue<PerfectPower> pq = new PriorityQueue<PerfectPower>();

        // maximum power representable as a long is 2^62
        for (int b = x; b <= 62; b++) {
            pq.offer(new PerfectPower(2, b));
        }

        // find smallest power, print out, and update
        while (!pq.isEmpty()) {
            PerfectPower p = pq.poll();
            System.out.println(p);

            // add next perfect power if it doesn't overflow a long
            if (Math.pow(p.a + 1, p.b) < Long.MAX_VALUE)
                pq.offer(new PerfectPower(p.a + 1, p.b));
        }
    }

}
