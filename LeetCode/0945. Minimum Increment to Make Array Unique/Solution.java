import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {

    public int minIncrementForUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            int count = map.get(value);
            if (count == 1) {
                continue;
            }

            if (i == list.size() - 1) {
                ans += count * (count - 1) / 2;
                break;
            }

            int nextValue = list.get(i + 1);
            int diff = nextValue - value;
            if (diff < count) {
                ans += (count - 1 + count - diff) * diff / 2;
                map.put(nextValue, map.get(nextValue) + count - diff);
            } else {
                ans += count * (count - 1) / 2;
            }
        }
        return ans;
    }

//    public int minIncrementForUnique(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        ArrayList<Integer> list = new ArrayList<>(map.keySet());
//        Collections.sort(list);
//
//        int ans = 0;
//        for (int i : list) {
//            while (map.get(i) > 1) {
////                System.out.println(map);
//                int count = map.get(i) - 1;
//                map.put(i, 1);
//                ans += count;
//                i += 1;
//                map.put(i, map.getOrDefault(i, 0) + count);
//            }
//        }
//        return ans;
//    }
}
