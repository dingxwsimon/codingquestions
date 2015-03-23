package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vert implements Comparable<Vert> {
    public final String name;

    public Edge[] adjacencies;

    public double minDistance = Double.POSITIVE_INFINITY;

    public Vert previous;

    public Vert(String argName) {
	name = argName;
    }

    public String toString() {
	return name;
    }

    public int compareTo(Vert other) {
	return Double.compare(minDistance, other.minDistance);
    }

}

class Edge {
    public final Vert target;

    public final double weight;

    public Edge(Vert argTarget, double argWeight) {
	target = argTarget;
	weight = argWeight;
    }
}

public class Dijkstra {
    public static void computePaths(Vert source) {
	source.minDistance = 0.;
	// vertex sort by mindistance in the queue
	PriorityQueue<Vert> vertexQueue = new PriorityQueue<Vert>();
	vertexQueue.add(source);

	while (!vertexQueue.isEmpty()) {
	    Vert u = vertexQueue.poll();

	    // Visit each edge exiting u
	    for (Edge e : u.adjacencies) {
		Vert v = e.target;
		double weight = e.weight;
		double distanceThroughU = u.minDistance + weight;
		if (distanceThroughU < v.minDistance) {
		    vertexQueue.remove(v);

		    v.minDistance = distanceThroughU;
		    v.previous = u;
		    vertexQueue.add(v);
		}
	    }
	}
    }

    public static List<Vert> getShortestPathTo(Vert target) {
	List<Vert> path = new ArrayList<Vert>();
	for (Vert vertex = target; vertex != null; vertex = vertex.previous)
	    path.add(vertex);

	Collections.reverse(path);
	return path;
    }

    public static void main(String[] args) {
	Vert v0 = new Vert("Harrisburg");
	Vert v1 = new Vert("Baltimore");
	Vert v2 = new Vert("Washington");
	Vert v3 = new Vert("Philadelphia");
	Vert v4 = new Vert("Binghamton");
	Vert v5 = new Vert("Allentown");
	Vert v6 = new Vert("New York");
	v0.adjacencies = new Edge[] { new Edge(v1, 79.83), new Edge(v5, 81.15) };
	v1.adjacencies = new Edge[] { new Edge(v0, 79.75), new Edge(v2, 39.42),
		new Edge(v3, 103.00) };
	v2.adjacencies = new Edge[] { new Edge(v1, 38.65) };
	v3.adjacencies = new Edge[] { new Edge(v1, 102.53),
		new Edge(v5, 61.44), new Edge(v6, 96.79) };
	v4.adjacencies = new Edge[] { new Edge(v5, 133.04) };
	v5.adjacencies = new Edge[] { new Edge(v0, 81.77), new Edge(v3, 62.05),
		new Edge(v4, 134.47), new Edge(v6, 91.63) };
	v6.adjacencies = new Edge[] { new Edge(v3, 97.24), new Edge(v5, 87.94) };
	Vert[] vertices = { v0, v1, v2, v3, v4, v5, v6 };

	computePaths(v0);
	for (Vert v : vertices) {
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    List<Vert> path = getShortestPathTo(v);
	    System.out.println("Path: " + path);
	}
    }
}
