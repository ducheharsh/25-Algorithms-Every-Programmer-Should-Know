public class UnionFind {

    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        int size = 6;
        UnionFind uf = new UnionFind(size);

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);

        System.out.println("Are 0 and 3 connected? " + (uf.find(0) == uf.find(3)));
        System.out.println("Are 2 and 4 connected? " + (uf.find(2) == uf.find(4)));
    }
}
