class Solution {
    public final int MODULO = 1000000000 + 7;

    public int[][] numApples;
    public int[][][] memo;
    int numRow;
    int numCol;

    public int ways(String[] pizza, int k) {
        numRow = pizza.length;
        numCol = pizza[0].length();
        numApples = new int[numRow][numCol];
        memo = new int[numRow][numCol][k];

        numApples[numRow - 1][numCol - 1] = pizza[numRow - 1].charAt(numCol - 1) == 'A' ? 1 : 0;
        for (int j = numCol - 2; j >= 0; j--) {
            numApples[numRow - 1][j] = numApples[numRow - 1][j + 1] + (pizza[numRow - 1].charAt(j) == 'A' ? 1 : 0);
        }

        for (int i = numRow - 2; i >= 0; i--) {
            numApples[i][numCol - 1] = numApples[i + 1][numCol - 1] + (pizza[i].charAt(numCol - 1) == 'A' ? 1 : 0);
            for (int j = numCol - 2; j >= 0; j--) {
                numApples[i][j] = numApples[i + 1][j] + numApples[i][j + 1] - numApples[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }

        // for (int i = 0; i < numRow; i++) {
        //     for (int j = 0; j < numCol; j++) {
        //         System.out.print(numApples[i][j] + ", ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();


        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                memo[i][j][0] = numApples[i][j] > 0 ? 1 : 0;
            }
        }

        for (int kk = 1; kk < k; kk++) {
            for (int i = numRow - 1; i >= 0; i--) {
                for (int j = numCol - 1; j >=0; j--) {
                    if (numApples[i][j] < kk + 1) {
                        memo[i][j][kk] = 0;
                        continue;
                    }
                    int num = 0;
                    for (int ii = numRow - 1; ii > i; ii--) {
                        if (numApples[i][j] == numApples[ii][j]) {
                            continue;
                        }
                        num = (num + memo[ii][j][kk - 1]) % MODULO;
                    }
                    for (int jj = numCol - 1; jj > j; jj--) {
                        if (numApples[i][j] == numApples[i][jj]) {
                            continue;
                        }
                        num = (num + memo[i][jj][kk - 1]) % MODULO;
                    }
                    memo[i][j][kk] = num;
                }
            }
        }

//        for (int kk = 0; kk < k; kk++) {
//            System.out.println("kk = " + kk);
//            for (int i = 0; i < numRow; i++) {
//                for (int j = 0; j < numCol; j++) {
//                    System.out.print(memo[i][j][kk] + ", ");
//                }
//                System.out.println();
//            }
//        }

        return memo[0][0][k - 1];
    }

    public static void main(String[] args) {
        String[] pizza = {"A..","AAA","..."};
        int k = 3;
        Solution solution = new Solution();
        solution.ways(pizza, k);

    }
}
