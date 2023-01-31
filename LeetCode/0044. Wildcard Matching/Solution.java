class Solution {
    private boolean[][][] memo;

    public boolean isMatch(String s, String p) {
        memo = new boolean[s.length()][p.length()][2];
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int i, int j) {
        if (j == p.length() && i < s.length()) {
            return false;
        }
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (i == s.length() && j < p.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (memo[i][j][0]) {
            return memo[i][j][1];
        }
        boolean result = false;
        if (p.charAt(j) == '?') {
            result = dp(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '*') {
            if (j == p.length() - 1) {
                result = true;
            } else {
//                for (int k = i; k < s.length(); k++) {
//                    result = result || dp(s, p, k, j + 1);
//                }
                result = dp(s, p, i + 1, j) || dp(s, p, i, j + 1);
            }
        } else {
            if (s.charAt(i) != p.charAt(j)) {
                result = false;
            } else {
                result = dp(s, p, i + 1, j + 1);
            }
        }
        memo[i][j][0] = true;
        memo[i][j][1] = result;
        return result;
    }
}
