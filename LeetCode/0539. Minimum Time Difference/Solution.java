import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int i = 0;
        for (String time : timePoints) {
            times[i] = getMinutes(time);
            i += 1;
        }
        Arrays.sort(times);
        int ans = 24 * 60 - times[timePoints.size() - 1] + times[0];
        i = 1;
        for (; i < times.length; i++) {
            ans = Math.min(ans, times[i] - times[i - 1]);
        }
        return ans;
    }

    public int getMinutes(String time) {
        int ans = Integer.parseInt(time.substring(0, 2)) * 60;
        ans += Integer.parseInt(time.substring(3));
        return ans;
    }
}
