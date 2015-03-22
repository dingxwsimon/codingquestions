package LeetCode;

public class MajorElement {
    public int majorityElement(int[] num) {
	int cand = num[0];
	int time = 0;
	for (int i = 0; i < num.length; i++) {
	    if (time == 0) {
		cand = num[i];
		time++;
	    } else {
		if (cand == num[i])
		    time++;
		else
		    time--;
	    }
	}
	return cand;
    }
}
