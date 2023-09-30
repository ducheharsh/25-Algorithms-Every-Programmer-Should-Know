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
/*Graph Class:

The Graph class represents an undirected graph using an adjacency list representation.
It has two instance variables:
V: An integer representing the number of vertices in the graph.
adj: An array of linked lists (LinkedList) where each element of the array represents a vertex, and the linked list at each element stores its adjacent vertices.
The constructor Graph(int v) initializes the graph with the specified number of vertices (v) and initializes an empty adjacency list for each vertex.
The addEdge(int v, int w) method allows adding an edge between vertices v and w by adding w to the adjacency list of v and vice versa (assuming an undirected graph).
BFS(int v) Method:

This method performs a Breadth-First Search traversal starting from the vertex v.
It uses a boolean array visited to keep track of visited vertices to avoid revisiting them.
It uses a LinkedList named queue to implement the BFS queue.
It starts by marking the initial vertex v as visited and enqueuing it into the queue.
It then enters a loop that continues until the queue is empty.
Inside the loop, it dequeues a vertex, prints it, and explores its adjacent vertices:
For each adjacent vertex (neighbor) that hasn't been visited yet, it marks it as visited and enqueues it into the queue.
The BFS traversal prints the vertices in the order they are visited, which follows the breadth-first exploration of the graph.
main Method:

In the main method, an instance of the Graph class g is created with 7 vertices.
Edges are added to the graph using the addEdge method to create a simple graph structure with 7 vertices and connections between them.
Finally, a BFS traversal is initiated from vertex 0, and the result is printed to the console.
The code demonstrates how to create a graph, add edges to it, and perform a BFS traversal starting from a specified vertex. In the provided example, the BFS traversal starts from vertex 0 and prints the visited vertices in BFS order.
*/







/*This Java program represents a graph data structure and performs a Breadth-First Search (BFS) traversal on the graph, starting from a specified vertex. Here's a short description of the key components and functionality:

1. `Graph` class:
   - The `Graph` class represents a graph with a specified number of vertices (`V`).
   - It uses an adjacency list to store the edges between vertices.
   - The constructor initializes the graph by creating an adjacency list for each vertex.
   - The `addEdge` method adds an edge between two vertices by updating the adjacency list.

2. `BFS` method:
   - This method performs a Breadth-First Search traversal starting from a given vertex.
   - It uses a boolean array `visited` to keep track of visited vertices.
   - It utilizes a queue (`LinkedList`) to implement the BFS algorithm.
   - The algorithm starts with the specified vertex, marks it as visited, and enqueues it.
   - It then iterates through the queue, dequeuing vertices, printing them, and enqueuing their unvisited neighbors until the queue is empty.
   - This ensures that vertices are visited in breadth-first order, i.e., all vertices at the current level are visited before moving to the next level.

3. `main` method:
   - In the `main` method, an instance of the `Graph` class is created with 7 vertices.
   - Edges are added to the graph to form a specific structure.
   - The BFS traversal is initiated from vertex 0, and the result is printed to the console.

In this example, the BFS traversal starting from vertex 0 would print the vertices in the following order: 0, 1, 2, 3, 4, 5, 6. This program demonstrates the fundamental BFS algorithm for exploring and traversing graphs in a breadth-first manner.*/
