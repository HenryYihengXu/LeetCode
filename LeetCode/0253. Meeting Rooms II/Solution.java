import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int ans = 1;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            while (!pq.isEmpty() && intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
            if (pq.size() > ans) {
                ans = pq.size();
            }
        }
        return ans;
    }
}
