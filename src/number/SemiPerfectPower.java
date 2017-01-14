package number;

import java.util.ArrayList;
import java.util.HashMap;

public class SemiPerfectPower {
    // too long
    public static long getSemiPerfectPower(long n, long m) {

        long count = 0;
        for (long i = n; i <= m; i++) {
            long key = 1;
            long num = i;
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            ArrayList<Long> list = new ArrayList<Long>();
            while (num > 1) {
                for (long j = 2; j <= num; j++) { // use to check prime
                    if (num % j == 0) { // find a prime factor
                        key = j;
                        list.add(key);
                        if (map.containsKey(key))
                            map.put(key, map.get(key) + 1); // keep this prime
                            // factor
                        else {
                            map.put(key, 1); // keep this prime factor
                        }
                        break;
                    }
                }
                num = num / key; // keep factorize
            }
            System.out.println(i);
            System.out.println(list);
            int odd = 0;
            for (long fact : map.keySet()) {
                if (map.get(fact) % 2 == 1) {
                    odd++;
                }
            }
            if (odd < 2) {
                count++;
            }

        }
        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(getSemiPerfectPower(319268319114310L,
                35860463407469139L));
    }

}
