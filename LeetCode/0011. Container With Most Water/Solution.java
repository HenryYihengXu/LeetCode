import java.lang.Math;

class Solution {
    public int maxArea(int[] height) {
        int most = 0;
        int l = 0;
        int r = height.length - 1;

        while (true) {
            int hl = height[l];
            int hr = height[r];
            int volume = Math.min(hl, hr) * (r - l);
            if (volume > most) {
                most = volume;
            }
            if (hl < hr) {
                int i;
                for (i = l + 1; i < r; i++) {
                    if (height[i] > hl) {
                        l = i;
                        break;
                    }
                }
                if (i == r) {
                    break;
                }
            } else {
                int i;
                for (i = r - 1; i > l; i--) {
                    if (height[i] > hr) {
                        r = i;
                        break;
                    }
                }
                if (i == l) {
                    break;
                }
            }
        }
        return most;
    }
}
