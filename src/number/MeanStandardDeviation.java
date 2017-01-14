package number;

public class MeanStandardDeviation {

    public static class RunningStats {
        int n = 0;
        double oldMean;
        double newMean;
        double oldSD;
        double newSD;

        public void push(double x) {
            n++;
            if (n == 1) {
                oldMean = newMean = x;
                oldSD = 0.0;
            } else {
                newMean = oldMean + (x - oldMean) / n;
                newSD = oldSD + (x - oldMean) * (x - newMean);
                oldMean = newMean;
                oldSD = newSD;
            }
        }

        public double mean() {
            return n > 0 ? newMean : 0.0;
        }

        public double sd() {
            return Math.sqrt(n > 1 ? newSD / n - 1 : 0.0);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
