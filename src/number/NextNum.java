package number;

public class NextNum {
    // has same number of "1" in binary format
    // next larger number
    public static int nextNumSameOne(int a) {
        int c = (a & -a);
        int r = a + c;
        return (((r ^ a) >> 2) / c) | r;
    }

    // next smaller number
    public static int getNextSmaller(int num) {
        return ~nextNumSameOne(~num);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(nextNumSameOne(124));
    }

}
