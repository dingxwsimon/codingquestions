package CrackingCoding;

import java.util.LinkedList;

public class c4_2 {
    public static enum State {
	Unvisited, Visited, Visiting;
    }

    public static class Node {
	private Node adjacent[];
	public int adjacentCount;
	private String vertex;
	public State state;

	public Node(String vertex, int adjacentLength) {
	    this.vertex = vertex;
	    adjacentCount = 0;
	    adjacent = new Node[adjacentLength];
	}

	public void addAdjacent(Node x) {
	    if (adjacentCount < 30) {
		this.adjacent[adjacentCount] = x;
		adjacentCount++;
	    } else {
		System.out.print("No more adjacent can be added");
	    }
	}

	public Node[] getAdjacent() {
	    return adjacent;
	}

	public String getVertex() {
	    return vertex;
	}
    }

    public static class Graph {
	private Node vertices[];
	public int count;

	public Graph() {
	    vertices = new Node[6];
	    count = 0;
	}

	public void addNode(Node x) {
	    if (count < 30) {
		vertices[count] = x;
		count++;
	    } else {
		System.out.print("Graph full");
	    }
	}

	public Node[] getNodes() {
	    return vertices;
	}
    }

    public static void main(String a[]) {
	Graph g = createNewGraph();
	Node[] n = g.getNodes();
	Node start = n[3];
	Node end = n[5];
	System.out.println(search(g, start, end));
    }

    public static Graph createNewGraph() {
	Graph g = new Graph();
	Node[] temp = new Node[6];

	temp[0] = new Node("a", 3);
	temp[1] = new Node("b", 0);
	temp[2] = new Node("c", 0);
	temp[3] = new Node("d", 1);
	temp[4] = new Node("e", 1);
	temp[5] = new Node("f", 0);

	temp[0].addAdjacent(temp[1]);
	temp[0].addAdjacent(temp[2]);
	temp[0].addAdjacent(temp[3]);
	temp[3].addAdjacent(temp[4]);
	temp[4].addAdjacent(temp[5]);
	for (int i = 0; i < 6; i++) {
	    g.addNode(temp[i]);
	}
	return g;
    }

    public static boolean search(Graph g, Node start, Node end) {
	LinkedList<Node> q = new LinkedList<Node>();
	for (Node u : g.getNodes()) {
	    u.state = State.Unvisited;
	}
	start.state = State.Visiting;
	q.add(start);
	Node u;
	while (!q.isEmpty()) {
	    u = q.removeFirst();
	    if (u != null) {
		for (Node v : u.getAdjacent()) {
		    if (v.state == State.Unvisited) {
			if (v == end) {
			    return true;
			} else {
			    v.state = State.Visiting;
			    q.add(v);
			}
		    }
		}
		u.state = State.Visited;
	    }
	}
	return false;
    }

}
