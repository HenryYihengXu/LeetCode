class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            memo[i][i + 1] = 0;
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2 - i; j++) {
                int ii = j;
                int jj = i + 2 + j;
                int min = Integer.MAX_VALUE;
                for (int k = ii + 1; k <= jj - 1; k++) {
                    min = Math.min(min, memo[ii][k] + memo[k][jj] + values[ii] * values[jj] * values[k]);
                }
                memo[ii][jj] = min;
            }
        }
        return memo[0][n - 1];
    }
}

//class Solution {
//    public HashMap<String, Integer> memo;
//    public int n;
//    public int minScoreTriangulation(int[] values) {
//        n = values.length;
//        memo = new HashMap<>();
//        int[] vertices = new int[n];
//        for (int i = 0; i < n; i++) {
//            vertices[i] = i;
//        }
//        return dp(vertices, values);
//    }
//
////    public int dp(int[] vertices, int[] values) {
////        if (vertices.length == 3) {
////            return values[vertices[0]] * values[vertices[1]] * values[vertices[2]];
////        }
////
////        String s = verticesToString(vertices);
////        if (memo.containsKey(s)) {
////            return memo.get(s);
////        }
////        int min = Integer.MAX_VALUE;
////
////        for (int i = 0; i < vertices.length - 2; i++) {
////            int[] vertices1 = Arrays.copyOfRange(vertices, i, i + 3);
////            int[] vertices2 = new int[vertices.length - 1];
////            for (int k = 0; k <= i; k++) {
////                vertices2[k] = vertices[k];
////            }
////            for (int k = i + 2; k < vertices.length; k++) {
////                vertices2[k - 1] = vertices[k];
////            }
////            min = Math.min(min, dp(vertices1, values) + dp(vertices2, values));
////        }
////        if (vertices.length > 4) {
////            min = Math.min(min, dp(new int[]{vertices[0], vertices[vertices.length - 2], vertices[vertices.length - 1]}, values) + dp(Arrays.copyOfRange(vertices, 0, vertices.length - 1), values));
////            min = Math.min(min, dp(new int[]{vertices[0], vertices[1], vertices[vertices.length - 1]}, values) + dp(Arrays.copyOfRange(vertices, 1, vertices.length), values));
////        }
////        memo.put(s, min);
////        return min;
////    }
//
//    public int dp(int[] vertices, int[] values) {
//        if (vertices.length == 3) {
//            return values[vertices[0]] * values[vertices[1]] * values[vertices[2]];
//        }
//
//        String s = verticesToString(vertices);
//        if (memo.containsKey(s)) {
//            return memo.get(s);
//        }
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < vertices.length - 2; i++) {
//            for (int j = i + 2; j < vertices.length - (i == 0 ? 1 : 0); j++) {
//                int[] vertices1 = Arrays.copyOfRange(vertices, i, j + 1);
//                int[] vertices2 = new int[vertices.length - vertices1.length + 2];
//                for (int k = 0; k <= i; k++) {
//                    vertices2[k] = vertices[k];
//                }
//                for (int k = j; k < vertices.length; k++) {
//                    vertices2[i + k - j + 1] = vertices[k];
//                }
//                min = Math.min(min, dp(vertices1, values) + dp(vertices2, values));
//            }
//        }
//        memo.put(s, min);
//        return min;
//    }
//
//    private String verticesToString(int[] vertices) {
//        StringBuilder s = new StringBuilder();
//        int i = 0;
//        for (int j = 0; j < n; j++) {
//            if (i < vertices.length && vertices[i] == j) {
//                s.append('1');
//                i += 1;
//            } else {
//                s.append('0');
//            }
//        }
//        return s.toString();
//    }
//}
