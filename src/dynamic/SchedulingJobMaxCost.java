package dynamic;

public class SchedulingJobMaxCost {

    public static class Job {
        public int cost;
        public int start;
        public int finish;
    }

    /*
     * include current element or, not include current element
     */
    private int dpSolution(Job[] jobs, int size) {
        int[] dp = new int[size];
        dp[size - 1] = jobs[size - 1].cost;
        // cost of last job equals to just itself
        for (int k = size - 2; k >= 0; k--) {
            int next = findNextJob(jobs, k);
            int includeK = jobs[k].cost;
            if (next < size) {
                includeK += dp[next];
            }
            int excludeK = dp[k + 1];
            dp[k] = Math.max(includeK, excludeK);
        }
        return dp[0];
    }

    private int findNextJob(Job[] jobs, int k) {
        int finishTime = jobs[k].finish;
        int next = k + 1;
        while (next < jobs.length) {
            if (jobs[next].start < finishTime) {
                next++;
            } else {
                break;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
