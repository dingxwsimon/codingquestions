package graph;

import java.util.LinkedList;

public class Bipartite {
    public static boolean isBipartite(int G[][], int src) {
        // Create a color array to store colors assigned to all veritces. Vertex
        // number is used as index in this array. The value '-1' of colorArr[i]
        // is used to indicate that no color is assigned to vertex 'i'. The
        // value
        // 1 is used to indicate first color is assigned and value 0 indicates
        // second color is assigned.
        int V = G.length;
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        // Assign first color to source
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers and enqueue source vertex
        // for BFS traversal
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.push(src);

        // Run while there are vertices in queue (Similar to BFS)
        while (!q.isEmpty()) {
            // Dequeue a vertex from queue ( Refer http://goo.gl/35oz8 )
            int u = q.pop();

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v) {
                // An edge from u to v exists and destination v is not colored
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }

                // An edge from u to v exists and destination v is colored with
                // same color as u
                else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
                    return false;
            }
        }

        // If we reach here, then all adjacent vertices can be colored with
        // alternate color
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int G[][] = new int[][]{{0, 1, 0, 1}, {1, 0, 1, 0},
                {0, 1, 0, 1}, {1, 0, 1, 0}};
        System.out.println(isBipartite(G, 0));
    }

}
