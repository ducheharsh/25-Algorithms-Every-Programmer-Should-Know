import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Recursive DFS function starting from vertex v
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current vertex as visited
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the adjacent vertices
        for (Integer neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // DFS traversal starting from vertex v
    public void DFS(int v) {
        // Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to perform DFS
        DFSUtil(v, visited);
    }
}

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println("Depth-First Traversal (starting from vertex 0): ");
        g.DFS(0);
    }
}
