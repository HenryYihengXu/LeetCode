import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(0);
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int n1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int n2 = nums[j];
                int n3 = 0 - n1 - n2;
                if (map.containsKey(n3)) {
                    int k = map.get(n3);
                    if (k > j) {
                        ArrayList<Integer> list = new ArrayList<>(3);
                        list.add(n1);
                        list.add(n2);
                        list.add(n3);
                        result.add(list);
                    }
                }

            }
        }
        return result;
    }
}
