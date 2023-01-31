class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = 0, j = -1, k = -1;
        for (int index = 1; index < nums.length; index++) {
            if (j == -1) {
                if (nums[index] > nums[i]) {
                    j = index;
                } else {
                    i = index;
                }
            } else {
                if (nums[index] > nums[j]) {
                    return true;
                } else if (nums[index] > nums[i]) {
                    j = index;
                    if (k != -1) {
                        i = k;
                        k = -1;
                    }
                } else {
                    if (k != -1 && nums[index] > nums[k]) {
                        i = k;
                        j = index;
                        k = -1;
                    } else {
                        k = index;
                    }
                }
            }
        }
        return false;
    }
}
