package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CloneGraph {

    public static class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
	    label = x;
	    neighbors = new ArrayList<UndirectedGraphNode>();
	}
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	if (node == null)
	    return null;
	LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	queue.add(node);
	UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
	HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, CloneGraph.UndirectedGraphNode>();
	map.put(copy.label, copy);
	while (!queue.isEmpty()) {
	    UndirectedGraphNode cur = queue.poll();
	    UndirectedGraphNode copycur = new UndirectedGraphNode(cur.label);
	    for (UndirectedGraphNode n : cur.neighbors) {
		int l = n.label;
		if (!map.containsKey(l)) {
		    UndirectedGraphNode copyn = new UndirectedGraphNode(l);
		    copycur.neighbors.add(copyn);
		    map.put(l, copyn);
		    queue.add(n);
		} else {
		    copycur.neighbors.add(map.get(l));
		}
	    }
	}
	return copy;
    }

    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
	if (node == null)
	    return null;
	LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
	q.add(node);
	UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
	HashMap<Integer, UndirectedGraphNode> labels = new HashMap<Integer, UndirectedGraphNode>();
	labels.put(copy.label, copy);
	while (!q.isEmpty()) {
	    UndirectedGraphNode cur = q.poll();
	    UndirectedGraphNode copycur = labels.get(cur.label);
	    Iterator<UndirectedGraphNode> iter = cur.neighbors.iterator();
	    while (iter.hasNext()) {
		UndirectedGraphNode tmp = iter.next();
		if (!labels.containsKey(tmp.label)) {
		    UndirectedGraphNode newNode = new UndirectedGraphNode(
			    tmp.label);
		    copycur.neighbors.add(newNode);
		    labels.put(tmp.label, newNode);
		    q.add(tmp);
		} else {
		    copycur.neighbors.add(labels.get(tmp.label));
		}
	    }

	}
	return copy;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
