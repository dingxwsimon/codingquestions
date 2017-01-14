package dynamic;

public class NumOfPath {

    public static int numPath(int x, int y) {
        if (x == 0 || y == 0)
            return 1;

        return numPath(x - 1, y) + numPath(x, y - 1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(numPath(2, 3));
    }

}
