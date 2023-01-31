class Solution {
    public int minSteps(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        int ans = 0;
        for (char c : t.toCharArray()) {
            countT[c - 'a'] += 1;
        }
        for (char c : s.toCharArray()) {
            if (countS[c - 'a'] == countT[c - 'a']) {
                ans += 1;
            } else {
                countS[c - 'a'] += 1;
            }
        }
        return ans;
    }
}
