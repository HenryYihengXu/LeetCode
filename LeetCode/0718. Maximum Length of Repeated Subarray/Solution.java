class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[] memo = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                memo[i] = 1;
                ans = 1;
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = nums2.length - 1; j >= 1; j--) {
                if (nums1[i] == nums2[j]) {
                    memo[j] = memo[j - 1] + 1;
                    ans = Math.max(ans, memo[j]);
                } else {
                    memo[j] = 0;
                }
            }
            if (nums1[i] == nums2[0]) {
                memo[0] = 1;
                ans = Math.max(ans, 1);
            } else {
                memo[0] = 0;
            }
        }

        return ans;
    }
}
