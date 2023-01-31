class Solution {
//    public long goodTriplets(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int[] index1 = new int[n];
//        int[] index2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            index1[nums1[i]] = i;
//            index2[nums2[i]] = i;
//        }
//        int count = 0;
//        for (int pos1x = 0; pos1x < n - 2; pos1x++) {
//            int x = nums1[pos1x];
//            int pos2x = index2[x];
//            for (int pos2y = pos2x + 1; pos2y < n - 1; pos2y++) {
//                int y = nums2[pos2y];
//                int pos1y = index1[y];
//                if (pos1y <= pos1x) {
//                    continue;
//                }
//                for (int pos1z = pos1y + 1; pos1z < n; pos1z++) {
//                    int z = nums1[pos1z];
//                    int pos2z = index2[z];
//                    if (pos2z > pos2y) {
//                        count += 1;
//                    }
//                }
//            }
//        }
//        return count;
//    }

    public long goodTriplets(int[] nums1, int[] nums2) {

    }
}

//class FenwickTree():
//        def __init__(self, N):
//        self.N = N
//        self.bit = [0 for i in range(N+1)]
//
//        def add(self, index, value):
//        index += 1
//        while index <= self.N:
//        self.bit[index] += value
//        index += (index & -index)
//
//        def prefixSum(self, index):
//        index += 1
//        ans = 0
//        while index != 0:
//        ans += self.bit[index]
//        index -= (index & -index)
//        return ans
//
//class Solution:
//        def goodTriplets(self, nums1: List[int], nums2: List[int]) -> int:
//        N = len(nums1)
//        fenwick1 = FenwickTree(N)
//        fenwick2 = FenwickTree(N)
//
//        # re-index
//        indexes = {n: i for i, n in enumerate(nums1)}
//        nums2 = [indexes[n] for n in nums2]
//
//        # count increasing triplets
//        ans = 0
//        for n in nums2:
//        if n > 0:
//        # count of increasing pairs with second number smaller then n
//        cnt = fenwick2.prefixSum(n-1)
//        ans += cnt
//        # fenwick1.prefixSum(n-1) give us count of numbers smaller than n before
//        fenwick2.add(n, fenwick1.prefixSum(n-1))
//        # add 1 to number n
//        fenwick1.add(n, 1)
//        return ans
