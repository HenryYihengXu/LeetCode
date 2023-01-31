class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0;
        int r = mat.length - 1;
        while (true) {
            int mid = (l + r) / 2;
            System.out.println(l + ", " + r + ", " + mid);

            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for (int i = 0; i < mat[mid].length; i++) {
                if (mat[mid][i] > max) {
                    max = mat[mid][i];
                    maxIdx = i;
                }
            }

            if (l == r) {
                return new int[]{mid, maxIdx};
            } else if (mid == l) {
                if (mat[mid + 1][maxIdx] > mat[mid][maxIdx]) {
                    l = mid + 1;
                } else {
                    return new int[]{mid, maxIdx};
                }
            } else if (mat[mid][maxIdx] > mat[mid + 1][maxIdx] && mat[mid][maxIdx] > mat[mid - 1][maxIdx]) {
                return new int[]{mid, maxIdx};
            } else if (mat[mid + 1][maxIdx] > mat[mid][maxIdx]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }
}
