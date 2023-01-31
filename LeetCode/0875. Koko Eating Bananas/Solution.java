import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            if (pile > r) {
                r = pile;
            }
        }

        while (l < r) {
            int mid = (l + r) / 2;
            int hoursNeeded = computeH(mid, piles);
            if (hoursNeeded > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int computeH(int k, int[] piles) {
        int h = 0;
        for (int pile : piles) {
            h += pile / k + (pile % k == 0 ? 0 : 1);
        }
        return h;
    }
}
