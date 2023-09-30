import java.util.*;

class Graph {
    private int V; // Number of vertices
    private List<Integer>[] adj; // Adjacency list

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList<>();
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
        Queue<Integer> queue = new LinkedList<>();

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
/*
The provided Java program implements the Breadth-First Search (BFS) algorithm for traversing a graph starting from a specified vertex. Here's a description of the program:

Graph Class:

This class represents a graph using an adjacency list data structure.
It has private instance variables:
V: The number of vertices in the graph.
adj: An array of lists, where each list represents the adjacency list of a vertex.
The constructor Graph(int v) initializes the graph with a specified number of vertices v. It creates an array of ArrayList objects to store adjacency lists for each vertex.
addEdge Method:

This method allows you to add an edge between two vertices in the graph.
It takes two parameters: v and w, which represent the vertices to be connected by an edge.
It adds w to the adjacency list of vertex v, effectively creating an edge between v and w.
BFS Method:

The BFS method performs a Breadth-First Search traversal starting from a given vertex v.
It uses a boolean array visited to keep track of visited vertices.
It utilizes a Queue (implemented as a LinkedList) to maintain the order of traversal.
It starts by marking the initial vertex v as visited and enqueues it.
Then, it enters a loop that continues as long as the queue is not empty.
Inside the loop, it dequeues a vertex, prints it, and explores its adjacent vertices.
For each adjacent vertex that has not been visited, it marks it as visited and enqueues it.
The loop continues until all reachable vertices have been visited.
main Method:

The main method is the entry point of the program.
It creates an instance of the Graph class with 7 vertices.
It adds edges to the graph to create a sample graph structure.
It then calls the BFS method to perform a BFS traversal starting from vertex 0.
The BFS traversal result is printed to the console.
Overall, this program demonstrates how to use the BFS algorithm to traverse a graph. In the provided example, it creates a graph with 7 vertices and performs a BFS traversal starting from vertex 0, printing the traversal order to the console.
    */

