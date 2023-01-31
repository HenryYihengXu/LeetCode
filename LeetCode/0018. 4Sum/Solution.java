import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int n1 = nums[i];

            for (int j = i + 1; j <nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int n2 = nums[j];

                int l = j + 1;
                int r = nums.length - 1;

                while (l < r) {
                    int n3 = nums[l];
                    int n4 = nums[r];
                    long sum = (long)n1 + (long)n2 + (long)n3 + (long)n4;
                    if (sum > Integer.MAX_VALUE) {
                        r -= 1;
                    } else if (sum < Integer.MIN_VALUE) {
                        l += 1;
                    } else if (sum == target) {
                        ans.add(Arrays.asList(n1, n2, n3, n4));
                        l += 1;
                        r -= 1;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l += 1;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r -= 1;
                        }
                    } else if (sum < target) {
                        l += 1;
                    } else {
                        r -= 1;
                    }
                }
            }
        }
        return ans;
    }
}
