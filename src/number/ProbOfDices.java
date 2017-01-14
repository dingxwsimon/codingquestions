package number;

public class ProbOfDices {

    public static int maxV = 6;

    public static void probOfDices(int num) {

        double p[][] = new double[2][maxV * num + 1];
        for (int i = 0; i < maxV * num + 1; i++) {
            p[0][i] = 0;
            p[1][i] = 0;

        }

        int flag = 0;
        for (int i = 1; i <= maxV; i++)
            p[flag][i] = 1;

        for (int k = 2; k <= num; ++k) {
            for (int i = k; i <= maxV * k; ++i) {
                p[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxV; ++j) {
                    p[1 - flag][i] += p[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow((double) maxV, num);
        for (int i = num; i <= maxV * num; i++) {
            double ratio = p[flag][i] / total;
            System.out.println(i + " : " + ratio);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        probOfDices(3);
    }

}
