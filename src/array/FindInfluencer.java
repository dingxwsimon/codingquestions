package array;

public class FindInfluencer {
    /**
     * Given a matrix of following between N LinkedIn users (with ids from 0 to
     * N-1): followingMatrix[i][j] == true iff user i is following user j thus
     * followingMatrix[i][j] doesn't imply followingMatrix[j][i]. Let's also
     * agree that followingMatrix[i][i] == false
     * <p>
     * Influencer is a user who is: - followed by everyone else and - not
     * following anyone himself
     * <p>
     * This method should find an Influencer by a given matrix of following, or
     * return -1 if there is no Influencer in this group.
     */

    // a[i][j] =1 denotes person i follow person j
    int Celebrity(int[][] a) {
        int n = a.length;
        int candidate = 0;
        int i = 1;
        while (i < n) {
            if (a[i][candidate] == 0 || a[candidate][i] == 1)
                candidate = i;
            i++;
        }
        // check
        for (int j = 0; j < n; j++) {
            if (j != candidate
                    && (a[j][candidate] == 0 || a[candidate][j] == 1))
                return -1;// no celebrity exist
        }
        return candidate;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
