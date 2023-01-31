import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            if (index != list.size() - 1) {
                list.set(index, list.get(list.size() - 1));
                map.put(list.get(list.size() - 1), index);
            }
            map.remove(val);
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
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
