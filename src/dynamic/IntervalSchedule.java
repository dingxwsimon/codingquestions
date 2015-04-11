package dynamic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class IntervalSchedule {
    public static class Interval {
	public int start;
	public int end;
	public int weight;

	public Interval() {
	    start = 0;
	    end = 0;
	    weight = 0;
	}

	public Interval(int s, int e, int w) {
	    start = s;
	    end = e;
	    weight = w;
	}

	public String toString() {
	    return "[" + start + "," + end + "," + weight +"]";
	}
    }
    
    
    public int schedule(ArrayList<Interval> input) {
	Comparator<Interval> myC = new Comparator<Interval>() {
	    public int compare(Interval a, Interval b) {
		    return a.end - b.end;
		}
	};
	
	Collections.sort(input, myC);
	int[] start = new int[input.size()];
	int[] end = new int[input.size()];
	for(int i = 0; i < input.size(); i++){
	    start[i]=input.get(i).start;
	    end[i]=input.get(i).end;
	}
	
	int[] dp = new int[input.size()+1];
	dp[0]=0;
	dp[1]=input.get(0).weight;
	for(int i = 2;i <= input.size(); i++){
	    int left = bsless(end, start[i-1]);
	    if(left != -1)
		dp[i] = Math.max(dp[i-1], input.get(i-1).weight + dp[left]);
	    else{
		dp[i] = Math.max(dp[i-1], input.get(i-1).weight);
	    }
	}
	return dp[input.size()];
    }
    
    //may vary, depend on whether the start and end can be one point?
    public int bsless(int[] a, int x){
	int l = 0;
	int r = a.length - 1;
	while(l < r){
	    int m = (l + r) /2 ;
	    if(a[m] < x) l = m+1;
	    else r = m;
	}
	return l-1;
    }
}
