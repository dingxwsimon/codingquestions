package number;

public class FactorialZero {

    // find how many tailing zeros will a factorial have
    public static int zero(int n) {
        int z = 0;
        while (n > 0) {
            z += n / 5;
            n /= 5;
        }
        return z;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(zero(11));
    }

}
