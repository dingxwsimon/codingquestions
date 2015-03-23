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
    public void reservoirSampling(int k) throws FileNotFoundException,
	    IOException {
	File f = new File("data.txt");
	// creating buffered reader object to read the file contains our data
	BufferedReader br = new BufferedReader(new FileReader(f));
	String currentLine;
	int reservoirSize = 10;
	// reservoirList is where our selected lines stored
	List<String> reservoirList = new ArrayList<String>(reservoirSize);
	// we will use this counter to count the current line numebr while
	// iterating
	int count = 0;
	Random ra = new Random();

	int randomNumber;
	// here we will iterate through the file till it ends
	while ((currentLine = br.readLine()) != null) {
	    // increase the line number
	    count++;
	    if (count <= k) {
		reservoirList.add(currentLine);
	    } else {
		randomNumber = (int) ra.nextInt(count);
		if (randomNumber < reservoirSize) {
		    reservoirList.set(randomNumber, currentLine);
		}
	    }
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
