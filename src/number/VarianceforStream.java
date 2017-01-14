package number;

public class VarianceforStream {
    public static double variance(double[] data) {
        double sum = 0.0;
        double sumsquare = 0.0;
        double variance = 0.0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            sumsquare += data[i] * data[i];
            int size = i + 1;
            variance = sumsquare / size - sum * sum / size;
        }
        return variance;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
