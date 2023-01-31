import java.util.Arrays;

class Solution {
    public int[] memo;
    public int racecar(int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        return dp(target);
    }

    public int dp(int target) {
        if (memo[target] >= 0) {
            return memo[target];
        }
        int min = Integer.MAX_VALUE;
        int i;
        for (i = 1; i < 32 - Integer.numberOfLeadingZeros(target); i++) {
            for (int j = 0; j < i; j++) {
                min = Math.min(min, i + 1 + j + 1 + dp(target - ((1 << i) - 1) + ((1 << j) - 1)));
            }
        }
        if (target == ((1 << i) - 1)) {
            memo[target] = i;
            return i;
        }
        min = Math.min(min, i + 1 + dp((1 << i) - 1 - target));
        memo[target] = min;
        return min;
    }
}



//class Solution {
//    public int[] memo;
//    public int racecar(int target) {
//        int ans = 0;
//        int lowerLog = Solution.log(target - 1, 2);
//        memo = new int[(int)Math.pow(2, lowerLog + 1)];
//        ans = dp(target);
//        return ans;
//    }
//
//    public int dp(int target) {
//        if (target == 0) {
//            return 0;
//        }
//        int lowerLog = Solution.log(target, 2);
//        int upperLog = lowerLog + 1;
//        int lowerBound = (int)Math.pow(2, lowerLog) - 1;
//        int upperBound = (lowerBound + 1) * 2 - 1;
//        if (target == lowerBound) {
//            return lowerLog;
//        }
//        if (target == upperBound) {
//            return upperLog;
//        }
//        int lowerDifference = target - lowerBound;
//        int upperDifference = upperBound - target;
//        int stepNeededFromLower = memo[lowerDifference];
//        int stepNeededFromUpper = memo[upperDifference];
//        if (stepNeededFromLower == 0) {
//            stepNeededFromLower = dp(lowerDifference);
//            memo[lowerDifference] = stepNeededFromLower;
//        }
//        if (stepNeededFromUpper == 0) {
//            stepNeededFromUpper = dp(upperDifference);
//            memo[upperDifference] = stepNeededFromUpper;
//        }
//        return lowerLog + 2 + Math.min(stepNeededFromLower, stepNeededFromUpper);
//    }
//
//    public static int log(int x, int base)
//    {
//        return (int)(Math.log(x) / Math.log(base));
//    }
//
//    public static void main(String args[]) {
//        System.out.println(Solution.log(3, 2));
//        System.out.println(Solution.log(7, 2));
//        System.out.println(Solution.log(8, 2));
//        System.out.println(Solution.log(9, 2));
//        System.out.println(Solution.log(15, 2));
//        System.out.println(Solution.log(16, 2));
//        System.out.println(Solution.log(17, 2));
//    }
//}
