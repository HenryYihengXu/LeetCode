import java.util.*;

class RandomizedCollection {

    private HashMap<Integer, HashSet<Integer>> map;
    private ArrayList<Integer> list;
    private Random rand;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        list.add(list.size(), val);

        if (map.containsKey(val)) {
            map.get(val).add(list.size() - 1);
            if (map.get(val).size() == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(list.size() - 1);
            map.put(val, set);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val) && map.get(val).size() != 0) {
            int removeIndex = map.get(val).iterator().next();
            map.get(val).remove(removeIndex);
            if (removeIndex != list.size() - 1) {
                int lastVal = list.get(list.size() - 1);
                list.set(removeIndex, lastVal);
                map.get(lastVal).remove(list.size() - 1);
                map.get(lastVal).add(removeIndex);
            }
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
