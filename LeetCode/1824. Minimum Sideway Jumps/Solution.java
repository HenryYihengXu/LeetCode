class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[][] memo = new int[n + 1][3];
        memo[n][0] = 0;
        memo[n][1] = 0;
        memo[n][2] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (obstacles[i + 1] == 0) {
                memo[i][0] = obstacles[i] == 1 ? Integer.MAX_VALUE : memo[i + 1][0];
                memo[i][1] = obstacles[i] == 2 ? Integer.MAX_VALUE : memo[i + 1][1];
                memo[i][2] = obstacles[i] == 3 ? Integer.MAX_VALUE : memo[i + 1][2];
            } else if (obstacles[i + 1] == 1) {
                memo[i][1] = obstacles[i] == 2 ? Integer.MAX_VALUE : memo[i + 1][1];
                memo[i][2] = obstacles[i] == 3 ? Integer.MAX_VALUE : memo[i + 1][2];
                memo[i][0] = obstacles[i] == 1 ? Integer.MAX_VALUE : Math.min(memo[i][1], memo[i][2]) + 1;
            } else if (obstacles[i + 1] == 2) {
                memo[i][0] = obstacles[i] == 1 ? Integer.MAX_VALUE : memo[i + 1][0];
                memo[i][2] = obstacles[i] == 3 ? Integer.MAX_VALUE : memo[i + 1][2];
                memo[i][1] = obstacles[i] == 2 ? Integer.MAX_VALUE : Math.min(memo[i][0], memo[i][2]) + 1;
            } else {
                memo[i][0] = obstacles[i] == 1 ? Integer.MAX_VALUE : memo[i + 1][0];
                memo[i][1] = obstacles[i] == 2 ? Integer.MAX_VALUE : memo[i + 1][1];
                memo[i][2] = memo[i][2] = obstacles[i] == 3 ? Integer.MAX_VALUE : Math.min(memo[i][0], memo[i][1]) + 1;
            }
        }
        return memo[0][1];
    }
}
