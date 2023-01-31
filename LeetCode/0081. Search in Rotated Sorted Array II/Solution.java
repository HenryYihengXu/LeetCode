class Solution {
    public boolean search(int[] nums, int target) {
        if (nums[0] == target) {
            return true;
        }
        int r = nums.length - 1;
        while (r >= 0 && nums[0] == nums[r]) {
            r -= 1;
        }
        if (r < 0) {
            return false;
        }
        return search(nums, 0, r, target);
    }

    public boolean search(int[] nums, int l, int r, int target) {
//        System.out.println(l +", " + r);
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (l == r) {
            return false;
        }

        if (nums[mid] >= nums[l]) {
//            System.out.println(2);
            if (nums[mid] > target && target >= nums[l]) {
                return binarySearch(nums, l, mid - 1, target);
            } else {
                return search(nums, mid + 1, r, target);
            }
        } else {
//            System.out.println(3);
            if (nums[mid] < target && target <= nums[r]) {
                return binarySearch(nums, mid + 1, r, target);
            } else {
                return search(nums, l, mid - 1, target);
            }
        }
    }

    public boolean binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
