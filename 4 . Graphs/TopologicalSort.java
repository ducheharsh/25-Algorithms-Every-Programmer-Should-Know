import java.util.*;

public class TopologicalSort {

    static class Graph {
        private int V;
        private List<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
            visited[v] = true;

            for (Integer i : adj[v]) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            stack.push(v);
        }

        void topologicalSort() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            System.out.println("Topological Sorting:");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }
}/*This Java program performs a topological sort on a directed acyclic graph (DAG) using depth-first search (DFS) and prints the topological ordering. Here's a concise description of its key components and functionality:

Graph class:

Represents a directed graph with a specified number of vertices (V).
Utilizes an adjacency list to store the graph's edges.
The addEdge method adds a directed edge from vertex v to vertex w.
topologicalSortUtil method:

A recursive utility function for performing topological sort.
Marks the current vertex as visited and explores its adjacent vertices.
Pushes vertices onto a stack in a specific order based on the topological sorting.
topologicalSort method:

Initiates the topological sort process for the entire graph.
Utilizes a stack to store the topological ordering.
Iterates through each vertex and calls topologicalSortUtil for unvisited vertices to perform the DFS-based topological sort.
Prints the topological ordering after completing the traversal.
main method:

Creates an instance of the Graph class with 6 vertices.
Adds directed edges to create a directed acyclic graph (DAG).
Calls the topologicalSort method to find and print the topological sorting order of the vertices.
This program is designed to find a valid topological ordering for a directed acyclic graph, which is a useful operation in various applications, such as scheduling and dependency resolution, where tasks or elements must be processed in a specific order without cycles.*/






