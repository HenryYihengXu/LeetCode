class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k += 1;
                nums[k] = nums[i];
            } else {
                continue;
            }
        }
        return k + 1;
    }
}
