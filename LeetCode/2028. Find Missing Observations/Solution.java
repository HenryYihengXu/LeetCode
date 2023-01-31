class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sumM = 0;
        for (int i : rolls) {
            sumM += i;
        }
        int sumN = mean * (m + n) - sumM;
        if (sumN < n) {
            return new int[0];
        }
        sumN -= n;
        for (int i = 2; i <= 6; i++) {
            if (sumN <= n) {
                int[] result = new int[n];
                int j = 0;
                for (; j < sumN; j++) {
                    result[j] = i;
                }
                for (; j < n; j++) {
                    result[j] = i - 1;
                }
                return result;
            }
            sumN -= n;
        }
        return new int[0];
    }
}
