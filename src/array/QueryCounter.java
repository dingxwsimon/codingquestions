package array;

import java.util.Arrays;

public class QueryCounter {
    final int SIZE = 60 * 60; // seconds in one hour
    int[] arr = new int[SIZE];
    int hour = 0;
    int minute = 0;
    long last = 0;

    long currSecond() {
        return System.currentTimeMillis() / 1000;
    }

    long clear() {
        long curr = currSecond();
        if (curr > last) {
            if (curr - last >= SIZE) {
                hour = 0;
                minute = 0;
                Arrays.fill(arr, 0);
            } else {
                if (curr - last >= 60) {
                    minute = 0;
                } else {
                    for (long i = last - 60 + 1; i <= curr - 60; i++) {
                        minute -= arr[(int) (i % SIZE)];
                    }
                }

                for (long i = last + 1; i <= curr; i++) {
                    int p = (int) (i % SIZE);
                    hour -= arr[p];
                    arr[p] = 0;
                }
            }
            last = curr;
        }

        return curr;
    }

    void request() {
        long curr = clear();
        arr[(int) (curr % SIZE)]++;
        hour++;
        minute++;
    }

    int lastSecond() {
        long curr = clear();
        return arr[(int) (curr % SIZE)];
    }

    int lastMinute() {
        clear();
        return minute;
    }

    int lastHour() {
        clear();
        return hour;
    }
}
