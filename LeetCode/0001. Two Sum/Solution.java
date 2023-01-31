import java.util.HashMap;
import static java.lang.System.out;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < size; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < size; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null && j != i) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        out.println("sdfsadf");
    }
}
//81.26
