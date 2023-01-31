class Solution {
    public int findPeakElementWithDuplicates(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int mid = (l + r) / 2;
            int leftDifferent = mid - 1;
            int rightDifferent = mid + 1;
            while (leftDifferent >= l && nums[leftDifferent] == nums[mid]) {
                leftDifferent -= 1;
            }
            while (rightDifferent <= r && nums[rightDifferent] == nums[mid]) {
                rightDifferent += 1;
            }

            if (leftDifferent == l - 1 && rightDifferent == r + 1) {
                return mid;
            }
            if (leftDifferent == l - 1) {
                if (nums[mid] > nums[rightDifferent]) {
                    return mid;
                } else {
                    l = rightDifferent;
                    continue;
                }
            }
            if (rightDifferent == r + 1) {
                if (nums[mid] > nums[leftDifferent]) {
                    return mid;
                } else {
                    r = leftDifferent;
                    continue;
                }
            }

            if (nums[mid] > nums[leftDifferent] && nums[mid] > nums[rightDifferent]) {
                return mid;
            }

            if (nums[leftDifferent] > nums[mid]) {
                r = leftDifferent;
            } else if (nums[rightDifferent] > nums[mid]) {
                l = rightDifferent;
            }
        }
    }

    // no duplicates
    public int findGlobalPeakElement(int[] nums) {
        int peak = Integer.MIN_VALUE;
        int peakIndex = -1;
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            peak = nums[0];
            peakIndex = 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            if (nums[nums.length - 1] > peak) {
                peak = nums[nums.length - 1];
                peakIndex = nums.length - 1;
            }
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                if (nums[i] > peak) {
                    peak = nums[i];
                    peakIndex = i;
                }
            }
        }
        return peakIndex;
    }

    public int findGlobalPeakElementWithDuplicates(int[] nums) {
        int peak = Integer.MIN_VALUE;
        int peakIndex = -1;
        int i = 0;
        while (i < nums.length) {
            int left = (i == 0) ? Integer.MIN_VALUE : nums[i - 1];
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i += 1;
            }
            int right = (i == nums.length - 1) ? Integer.MIN_VALUE : nums[i + 1];
            if (nums[i] > left && nums[i] > right) {
                if (nums[i] > peak) {
                    peak = nums[i];
                    peakIndex = i;
                }
            }
            i += 1;
        }
        return peakIndex;
    }

    // no duplicates
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int l = 1;
        int r = nums.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 2, 2, 2, 1};
        int[] nums2 = {1, 2, 2, 2, 2, 1};
        int[] nums3 = {2, 2, 2, 2, 2, 2};
        System.out.println(solution.findPeakElementWithDuplicates(nums1));
        System.out.println(solution.findPeakElementWithDuplicates(nums2));
        System.out.println(solution.findPeakElementWithDuplicates(nums3));

        int[] nums4 = {1, 2, 1, 2, 3, 2};
        int[] nums5 = {1, 2, 0, 5, 2, 7};
        System.out.println(solution.findGlobalPeakElement(nums4));
        System.out.println(solution.findGlobalPeakElement(nums5));

        int[] nums6 = {1, 2, 2, 2, 1, 3, 3, 4, 4, 1};
        int[] nums7 = {1, 2, 2, 2, 1, 3, 3, 1, 5, 5};
        int[] nums8 = {9, 2, 2, 2, 1, 3, 3, 1, 5, 5};
        System.out.println(solution.findGlobalPeakElementWithDuplicates(nums6));
        System.out.println(solution.findGlobalPeakElementWithDuplicates(nums7));
        System.out.println(solution.findGlobalPeakElementWithDuplicates(nums8));
    }
}
