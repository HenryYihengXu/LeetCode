class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int l, int r, int target) {
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (l == r) {
            return -1;
        }

        if (nums[mid] >= nums[l]) {
            if (nums[mid] > target && target >= nums[l]) {
                return binarySearch(nums, l, mid - 1, target);
            } else {
                return search(nums, mid + 1, r, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[r]) {
                return binarySearch(nums, mid + 1, r, target);
            } else {
                return search(nums, l, mid - 1, target);
            }
        }
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
