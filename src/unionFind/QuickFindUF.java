package unionFind;

public class QuickFindUF {
    /**
     * Note --
     * Union is too expensive. It takes count 2 array accesses to process a sequence
     * of
     * count union commands on count objects.
     * find is O-1
     * union : O-count
     * initialize: O- count
     */
    private int count;
    private int[] id;

    QuickFindUF(int n) {
        this.count = n;
        this.id = new int[n];
        for (int i = 0; i < n; i++) { // id ==i
            this.id[i] = i;
        }

    }

    void union(int p, int q) {
        validate(p);
        validate(q);
        int pid = this.id[p];
        int qid = this.id[q];

        // // p and q are already in the same component

        if (pid == qid)
            return;

        /**
         * change all entries with id[p] to id[q]
         * (at most 2N + 2 array accesses)
         */

        for (int i = 0; i < id.length; i++) {
            if (this.id[i] == pid) {
                this.id[i] = qid;
            }
        }

    }

    private void validate(int p) {
        int n = id.length;
        validate(p);
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return this.id[p] == this.id[q];

    }

    int find(int p) {
        validate(p);
        return id[p];
    }

    int count() {
        return count;
    }

}