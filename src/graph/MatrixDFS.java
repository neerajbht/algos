package graph;

public class MatrixDFS {
    int dfs(int[][] grid, int r, int c, int[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;
        /**
         * if r ,c are less than leftmost border
         * if r,c are greater than right border
         * if cell is marked visited or gird is marked blocked
         */
        if (Math.min(r, c) < 0 || r == ROWS || c == COLS ||
                visit[r][c] == 1 || grid[r][c] == 1) {
            return 0;
        }
        /** if last r,c return reached /visited */
        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        visit[r][c] = 1;

        int count = 0;
        /**
         * explore recursively from the cell postion to all position direction
         * 
         * 
         * r + 1, c -----> down
         * r - 1, c,------>up
         * r, c + 1,------->right
         * r, c - 1,------left
         * 
         * 
         */
        count += dfs(grid, r + 1, c, visit);
        count += dfs(grid, r - 1, c, visit);
        count += dfs(grid, r, c + 1, visit);
        count += dfs(grid, r, c - 1, visit);

        visit[r][c] = 0;
        return count;
    }

}
