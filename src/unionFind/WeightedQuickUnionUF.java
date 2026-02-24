package unionFind;

public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] rank; // rannk[i] = number of elements in subtree rooted at i
    private int count;

    public WeightedQuickUnionUF(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.count = n;
    }

    private void validate(int p) {
        int n = parent.length;
        validate(p);
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public int size() {
        return this.count;
    }

    public boolean connected(int p, int q) {

        return find(p) == find(q);
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
            rank[rootQ] += rank[rootP];
        } else {
            parent[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
        }
        count--;

    }

}
