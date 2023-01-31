import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int n1 = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int n2 = nums[l];
                int n3 = nums[r];
                int sum = n1 + n2 + n3;
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }

        }
        return ans;

    }
//    public int threeSumClosest(int[] nums, int target) {
//        int difference = Integer.MAX_VALUE;
//        int result = 0;
//
//        Arrays.sort(nums);
//        int i;
//        for (i = 0; i < nums.length - 2; i++) {
//            if (i != 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            int n1 = nums[i];
//            int j;
//            for (j = i + 1; j < nums.length - 1; j++) {
//                if (j != i + 1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
//
//                int n2 = nums[j];
//                int bestN3 = target - n1 - n2;
//                int closestN3 = 0;
//
//                int l = j + 1;
//                int r = nums.length - 1;
//
//                if (l == r) {
//                    closestN3 = nums[r];
//                } else {
//                    while (true) {
////                        System.out.println("(" + l + ", " + r + ")");
//                        if (l + 1 == r) {
//                            if (bestN3 - nums[l] < nums[r] - bestN3) {
//                                closestN3 = nums[l];
//                            } else {
//                                closestN3 = nums[r];
//                            }
//                            break;
//                        }
//                        int mid = (l + r) / 2;
//                        if (bestN3 == nums[mid]) {
//                            return target;
//                        }
//                        if (bestN3 > nums[mid]) {
//                            l = mid;
//                        } else {
//                            r = mid;
//                        }
//                    }
//                }
//                if (Math.abs(closestN3 - bestN3) < difference) {
//                    result = n1 + n2 + closestN3;
//                    difference = Math.abs(closestN3 - bestN3);
//                }
//            }
//        }
//
//        return result;
//    }
}
