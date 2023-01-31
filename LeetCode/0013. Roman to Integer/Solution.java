import java.util.HashMap;

class Solution {
    public HashMap<Character, Integer> r2i;
    public int romanToInt(String s) {
        r2i = new HashMap<>();
        r2i.put('I', 1);
        r2i.put('V', 5);
        r2i.put('X', 10);
        r2i.put('L', 50);
        r2i.put('C', 100);
        r2i.put('D', 500);
        r2i.put('M', 1000);

        int result = 0;
        int previous = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = r2i.get(c);
            if (value < previous) {
                result -= value;
            } else {
                result += value;
            }
            previous = value;
        }
        return result;
    }
}