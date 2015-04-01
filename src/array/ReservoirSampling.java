package array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import LeetCode.AddLinkList.ListNode;

public class ReservoirSampling {
    public ListNode sampling(ListNode head) {
	ListNode s = head;
	Random rand = new Random();
	int count = 1;
	while (head != null) {
	    int position = (int) (rand.nextInt(count) + 1);
	    count++;
	    if (position == 1)
		s = head;
	}
	return s;
    }

    // remember it
    public List<Integer> sample(List<Integer> list, int k) {
        final List<Integer> samples = new ArrayList<Integer>(k);
        int count = 0;
        final Random random = new Random();
        for (int item : list) {
            if (count < k) {
                samples.add(item);
            } else {
                // http://en.wikipedia.org/wiki/Reservoir_sampling
                // In effect, for all i, the ith element of S is chosen to be included in the reservoir with probability
                // k/i.
                int randomPos = random.nextInt(count + 1);
                if (randomPos < k) {
                    samples.set(randomPos, item);
                }
            }
            count++;
        }
        return samples;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
