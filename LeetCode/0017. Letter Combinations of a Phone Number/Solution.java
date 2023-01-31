import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<char[]> map;

    public List<String> letterCombinations(String digits) {
        map = new ArrayList<>(8);
        map.add(new char[]{'a', 'b', 'c'});
        map.add(new char[]{'d', 'e', 'f'});
        map.add(new char[]{'g', 'h', 'i'});
        map.add(new char[]{'j', 'k', 'l'});
        map.add(new char[]{'m', 'n', 'o'});
        map.add(new char[]{'p', 'q', 'r', 's'});
        map.add(new char[]{'t', 'u', 'v'});
        map.add(new char[]{'w', 'x', 'y', 'z'});
        if (digits.length() == 0) {
            return new ArrayList<>(0);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> tmp = new ArrayList<>();
            char digit = digits.charAt(i);
            if (ans.isEmpty()) {
                for (char c : map.get(digit - 48 - 2)) {
                    tmp.add("" + c);
                }
            } else {
                for (String s : ans) {
                    for (char c : map.get(digit - 48 - 2)) {
                        tmp.add(s + c);
                    }
                }
            }
            ans = tmp;
        }
        return ans;
    }
}
