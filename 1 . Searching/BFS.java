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

    // BFS traversal starting from vertex v
    public void BFS(int v) {
        // Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current vertex as visited and enqueue it
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            v = queue.poll();
            System.out.print(v + " ");

            // Get all adjacent vertices of the dequeued vertex v
            // If an adjacent vertex has not been visited, mark it visited and enqueue it
            for (Integer neighbor : adj[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println("Breadth-First Traversal (starting from vertex 0): ");
        g.BFS(0);
    }
}
