import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class Solution {
    Random rand;
    ArrayList<Integer> prefixSum;
    int sum;
    public Solution(int[] w) {
        rand = new Random();
        prefixSum = new ArrayList<>(w.length + 1);
        sum = 0;
        for (int weight : w) {
            prefixSum.add(sum);
            sum += weight;
        }
        prefixSum.add(sum);
    }

    public int pickIndex() {
        int x = rand.nextInt(sum);
        int l = 0, r = prefixSum.size();
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (x == prefixSum.get(mid)) {
                return mid;
            } else if (x < prefixSum.get(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */


//class Solution {
//
//    Random rand;
//    ArrayList<Integer> list;
//    public Solution(int[] w) {
//        rand = new Random();
//        list = new ArrayList<>();
//        for (int i = 0; i < w.length; i++) {
//            for (int j = 0; j < w[i]; j++) {
//                list.add(i);
//            }
//        }
//    }
//
//    public int pickIndex() {
//        int index = rand.nextInt(list.size());
//        return list.get(index);
//    }
//}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
