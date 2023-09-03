import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class KruskalsAlgorithm {

    public static List<Edge> kruskalsMST(List<Edge> edges, int V) {
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>();
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (Edge edge : edges) {
            int srcParent = find(parent, edge.src);
            int destParent = find(parent, edge.dest);

            if (srcParent != destParent) {
                mst.add(edge);
                union(parent, srcParent, destParent);
            }
        }

        return mst;
    }

    public static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    public static void union(int[] parent, int src, int dest) {
        int srcParent = find(parent, src);
        int destParent = find(parent, dest);
        parent[srcParent] = destParent;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> mst = kruskalsMST(edges, V);

        System.out.println("Minimum Spanning Tree Edges:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}
