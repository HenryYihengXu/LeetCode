class Solution {
    public int countPrimes(int n) {
        boolean[] composite = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (composite[i]) {
                continue;
            }
            for (int j = i; i * j < n; j++) {
                composite[i * j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            count += composite[i] ? 0 : 1;
        }
        return count;
    }
}
