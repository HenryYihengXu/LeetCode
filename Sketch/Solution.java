import java.util.*;

public class Solution {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rand;

    Solution() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    boolean add(int value) {
        if (map.containsKey(value)) {
            return false;
        } else {
            map.put(value, list.size());
            list.add(value);
            return true;
        }
    }

    boolean remove(int value) {
        if (map.containsKey(value)) {
            int index = map.get(value);
            if (index != list.size() - 1) {
                int lastValue = list.get(list.size() - 1);
                list.set(index, lastValue);
                map.put(lastValue, index);
            }
            list.remove(list.size() - 1);
            map.remove(value);
            return true;
        } else {
            return false;
        }
    }

    int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
