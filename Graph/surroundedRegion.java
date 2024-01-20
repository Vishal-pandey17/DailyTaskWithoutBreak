class Solution {
    public void dfs(int row, int col, int vis[][], char grid[][], int delrow[], int delcol[]) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, grid, delrow, delcol);
            }
        }
    }

    public void solve(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, 1, 0, -1 };

        // To triverse in first row and last row;

        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && grid[0][j] == 'O') {
                dfs(0, j, vis, grid, delrow, delcol);
            }

            if (vis[n - 1][j] == 0 && grid[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, grid, delrow, delcol);
            }
        }

        // To triverse in first coloum and last coloum;

        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && grid[i][0] == 'O') {
                dfs(i, 0, vis, grid, delrow, delcol);
            }

            if (vis[i][m - 1] == 0 && grid[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, grid, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 'O')
                    grid[i][j] = 'X';
            }
        }

    }
}