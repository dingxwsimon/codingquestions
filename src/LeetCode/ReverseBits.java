package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1; // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    public int reverseBits1(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) // convert int into 4 bytes
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]); // reverse per byte
            if (i < 3)
                result <<= 8;
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b); // first look up from cache
        if (value != null)
            return value;
        value = 0;
        // reverse by bit
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseBits r = new ReverseBits();
        int a = 43261596;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(r.reverseBits(43261596)));
    }
}
