import java.util.*;

public class BellmanFordAlgorithm {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void bellmanFord(List<Edge> edges, int V, int start) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int w = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains a negative-weight cycle.");
                return;
            }
        }

        System.out.println("Shortest Distances from Node " + start + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 3));
        edges.add(new Edge(1, 2, -2));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(1, 4, 3));
        edges.add(new Edge(3, 2, 5));
        edges.add(new Edge(3, 1, 1));
        edges.add(new Edge(4, 3, -4));

        int startNode = 0;

        bellmanFord(edges, V, startNode);
    }
}
