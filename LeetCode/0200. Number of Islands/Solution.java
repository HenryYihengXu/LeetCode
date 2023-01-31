class Solution {
    public char[][] grid;
    public boolean[][] visited;
    public int m;
    public int n;
    public int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j) {
        visited[i][j] = true;
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            dfs(i - 1, j);
        }
        if (i + 1 < m && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            dfs(i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            dfs(i, j - 1);
        }
        if (j + 1 < n && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            dfs(i, j + 1);
        }
    }
}
