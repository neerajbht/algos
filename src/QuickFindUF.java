
public class QuickFindUF {
    /**
     * Note --
     * Union is too expensive. It takes N 2 array accesses to process a sequence of
     * N union commands on N objects.
     * find is O-1
     * union : O-N
     * initialize: O- N
     */
    private int N;
    private int[] id;

    QuickFindUF(int N) {
        this.N = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) { // id ==i
            this.id[i] = i;
        }

    }

    void union(int p, int q) {

        int pid = this.id[p];
        int qid = this.id[q];
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

    boolean connected(int p, int q) {
        return this.id[p] == this.id[q];

    }

    int find(int p) {
        return 0;// todo
    }

    int count() {
        return this.id.length;
    }

}