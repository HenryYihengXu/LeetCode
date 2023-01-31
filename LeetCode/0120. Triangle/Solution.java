import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int j = 0; j < n; j++) {
            memo[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                memo[i][j] = triangle.get(i).get(j) + Math.min(memo[i + 1][j], memo[i + 1][j + 1]);
            }
        }
        return memo[0][0];
    }
}
