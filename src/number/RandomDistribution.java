package number;

import java.util.HashMap;

public class RandomDistribution {
    /*
     * Design and implement a class to generate random numbers in an arbitrary
     * probability distribution given by an array of integer weights, i.e. for
     * int[] w return a number, n, from 0 to w.length - 1 with probability w[n]
     * / sum(w). Using an existing random number generator with a uniform
     * distribution is permitted. Example distribution: w = 1, 2, 3, 2, 1
     * Example probabilities: w / sum = 1/9, 2/9, 1/3, 2/9, 1/9 Example results:
     * n = 0, 1, 2, 3, 4
     */
    HashMap<Integer, Integer> alias = new HashMap<Integer, Integer>();
    int sum = 0;

    public RandomDistribution(int[] weights) {
        for (int w : weights) {
            sum += w;
        }
        int slot = 0;
        int partial = weights[slot];
        for (int i = 0; i < sum; i++) {
            if (i >= partial) {
                slot += 1;
                partial += weights[slot];
            }
            alias.put(i, slot);
        }
    }

    public int next() {
        return alias.get((int) (Math.random() * (sum - 1)));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] dis = new int[]{1, 2, 3, 2, 1};
        RandomDistribution rd = new RandomDistribution(dis);
        System.out.println(rd.next());
    }

}
