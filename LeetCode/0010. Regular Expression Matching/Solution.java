class Solution {
    public boolean dp[][][];
    public int lenS;
    public int lenP;
    public String s;
    public String p;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        lenS = s.length();
        lenP = p.length();
        dp = new boolean[lenP + 1][lenS + 1][2];

        return isMatchRecursive(0, 0);
    }

    public boolean isMatchRecursive(int i, int j) {
        boolean result = false;
        if (i == lenP && j == lenS) {
            result = true;
        } else if (i == lenP){
            result = false;
        } else if (j == lenS) {
            if (i + 1 < lenP && p.charAt(i + 1) == '*') {
                if (i + 2 == lenP) {
                    result = true;
                } else {
                    if (dp[i + 2][j][0]) {
                        result = dp[i + 2][j][1];
                    } else {
                        result = isMatchRecursive(i + 2, j);
                    }
                }
            } else {
                result = false;
            }
        } else if (i + 1 < lenP && p.charAt(i + 1) == '*') {
            boolean result1 = false;
            boolean result2 = false;
            boolean result3 = false;

            if (dp[i + 2][j][0]) {
                result1 = dp[i + 2][j][1];
            } else {
                result1 = isMatchRecursive(i + 2, j);
            }

            if (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) {
                if (dp[i + 2][j + 1][0]) {
                    result2 = dp[i + 2][j + 1][1];
                } else {
                    result2 = isMatchRecursive(i + 2, j + 1);
                }

                if (dp[i][j + 1][0]) {
                    result3 = dp[i][j + 1][1];
                } else {
                    result3 = isMatchRecursive(i, j + 1);
                }
            } else {
                result2 = false;
                result3 = false;
            }

            result = result1 || result2 || result3;
        } else {
            if (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) {
                if (dp[i + 1][j + 1][0]) {
                    result = dp[i + 1][j + 1][1];
                } else {
                    result = isMatchRecursive(i + 1, j + 1);
                }
            } else {
                result = false;
            }
        }
        dp[i][j][0] = true;
        dp[i][j][1] = result;
        if (j == lenS) {
            System.out.println("\'\'");
        } else {
            System.out.println(s.substring(j));
        }

        if (i == lenP) {
            System.out.println("\'\'");
        } else {
            System.out.println(p.substring(i));
        }
        System.out.println(result);
        System.out.println();
        return result;
    }

}