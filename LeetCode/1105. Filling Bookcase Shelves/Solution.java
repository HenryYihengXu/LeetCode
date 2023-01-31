class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];
        dp[n - 1] = books[n - 1][1];
        for (int i = books.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int heightThisLevel = books[i][1];
            int j = i + 1;
            int widthThisLevel = books[i][0];

            do {
                int totalHeight = heightThisLevel + dp[j]; // put j to the next level
                if (totalHeight < min) {
                    min = totalHeight;
                }
                heightThisLevel = Math.max(heightThisLevel, books[j][1]); // put j on this level
                widthThisLevel += books[j][0];
                j += 1;
            } while (j < n && widthThisLevel <= shelfWidth);

            if (j == n && widthThisLevel <= shelfWidth) {
                if (heightThisLevel < min) {
                    min = heightThisLevel;
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }
}
