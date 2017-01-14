package number;

import java.util.Arrays;
import java.util.LinkedList;

public class findMaxMultupleOf3 {

    public static void findMaxMultupleOf3(int[] arr) {
        // Step 1: sort the array in non-decreasing order
        int size = arr.length;
        Arrays.sort(arr);

        // Create 3 queues to store numbers with remainder 0, 1
        // and 2 respectively
        LinkedList q0 = new LinkedList<Integer>();
        LinkedList q1 = new LinkedList<Integer>();
        LinkedList q2 = new LinkedList<Integer>();
        int i = 0;
        int sum = 0;

        // Step 2 and 3 get the sum of numbers and place them in
        // corresponding queues
        for (i = 0, sum = 0; i < size; i++) {
            sum += arr[i];
            if ((arr[i] % 3) == 0)
                q0.add(arr[i]);
            else if ((arr[i] % 3) == 1)
                q1.add(arr[i]);
            else
                q2.add(arr[i]);
        }
        // Step 4.2: The sum produces remainder 1
        if (sum % 3 == 1) {
            // either remove one item from queue1
            if (!q1.isEmpty()) {
                q1.removeFirst();
            }
            // or remove two items from queue2
            else {
                if (!q2.isEmpty())
                    q2.removeFirst();
                else
                    return;

                if (!q2.isEmpty())
                    q2.removeFirst();
                else
                    return;
            }
        }

        // Step 4.3: The sum produces remainder 2
        else if ((sum % 3) == 2) {
            // either remove one item from queue2
            if (!q2.isEmpty()) {
                q2.removeFirst();
            }

            // or remove two items from queue1
            else {
                if (!q1.isEmpty())
                    q1.removeFirst();
                else
                    return;

                if (!q1.isEmpty())
                    q1.removeFirst();
                else
                    return;
            }
        }

        // Empty all the queues into an auxiliary array.

        // sort the array in non-increasing order

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
