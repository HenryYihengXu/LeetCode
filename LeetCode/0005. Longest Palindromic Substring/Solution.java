import java.util.*;

class Solution {
    public boolean dp[][];
    int len;

    public String longestPalindrome(String s) {

        len = s.length();
        dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i + 1][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                int i0 = j;
                int j0 = i + j + 1;

                boolean isPalindrome = dp[i0 + 1][j0 - 1];
                if (isPalindrome && s.charAt(i0) == s.charAt(j0)) {
                    dp[i0][j0] = true;
                } else {
                    dp[i0][j0] = false;
                }
            }
        }

//        printDp();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i + 1; j++) {
                int i0 = j;
                int j0 = len - i - 1 + j;
                if (dp[i0][j0]) {
                    return s.substring(i0, j0 + 1);
                }
            }
        }
        return "";
    }

    public void printDp() {
        for (int j = len - 1; j >= 0; j--) {
            for (int i = 0; i < j + 2 && i < len; i++) {
                if (dp[i][j]) {
                    System.out.print(dp[i][j] + "  ");
                } else {
                    System.out.print(dp[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

//    public int dp[][][];
//    int len;
//    public String longestPalindrome(String s) {
//        if (s.isEmpty()) {
//            return "";
//        }
//        len = s.length();
//        dp = new int[len][len][2];
//        for (int i = 0; i < len; i++) {
//            dp[i][i][0] = i;
//            dp[i][i][1] = i;
//        }
//        for (int i = 0; i < len - 1; i++) {
//            dp[i + 1][i][0] = i + 1;
//            dp[i + 1][i][1] = i;
//        }
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = 0; j < len - i - 1; j++) {
//                int i0 = j;
//                int j0 = i + j + 1;
//                int i1 = dp[i0][j0 - 1][0];
//                int j1 = dp[i0][j0 - 1][1];
//                int i2 = dp[i0 + 1][j0][0];
//                int j2 = dp[i0 + 1][j0][1];
//                int i3 = dp[i0 + 1][j0 - 1][0];
//                int j3 = dp[i0 + 1][j0 - 1][1];
//
//                int len1 = j1 - i1 + 1;
//                int len2 = j2 - i2 + 1;
//                int len3 = j3 - i3 + 1;
//                if (i3 == i0 + 1 && j3 == j0 - 1 && s.charAt(i0) == s.charAt(j0)) {
//                    len3 += 2;
//                    i3 = i0;
//                    j3 = j0;
//                }
//                if (len1 >= len2 && len1 >= len3) {
//                    dp[i0][j0][0] = i1;
//                    dp[i0][j0][1] = j1;
//                } else if (len2 >= len1 && len2 >= len3) {
//                    dp[i0][j0][0] = i2;
//                    dp[i0][j0][1] = j2;
//                } else {
//                    dp[i0][j0][0] = i3;
//                    dp[i0][j0][1] = j3;
//                }
//            }
//        }
//        int i = dp[0][len - 1][0];
//        int j = dp[0][len - 1][1];
//
//        printDp();
//
//        return s.substring(i, j + 1);
//    }
//
//    public void printDp() {
//        for (int j = len - 1; j >= 0; j--) {
//            for (int i = 0; i < j + 2 && i < len; i++) {
//                System.out.print("(" + dp[i][j][0] + ", " + dp[i][j][1] + ") ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
        System.out.println("aaa");
    }
}