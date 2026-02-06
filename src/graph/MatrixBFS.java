package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class MatrixBFS {

    public int bfs(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[2]); // Add {0, 0}
        visit[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int pair[] = queue.poll();
                int r = pair[0], c = pair[1];
                // if at last return length
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }
                // We can directly build the four neighbors
                /**
                 * 
                 * r, c + 1,------->right
                 * r, c - 1,------left
                 * r + 1, c -----> down
                 * r - 1, c,------>up
                 * neighbors = { right, left, down,up}
                 */
                int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c } };

                for (int j = 0; j < 4; j++) { // 4 is neighbors.length

                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    // if leftmost boundary , rightmost bounday, if marked visited , if blocked
                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS
                            || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(neighbors[j]);
                    // mark visited
                    visit[newR][newC] = 1;
                }
            }
            length++;
        }
        return length; // This should never be called
    }

}
