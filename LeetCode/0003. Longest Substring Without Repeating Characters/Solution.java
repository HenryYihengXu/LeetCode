class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        int beginning = 0;
        HashMap<Character, Integer> memo = new HashMap();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (memo.containsKey(c)) {
                int index = memo.get(c);
                if (index >= beginning) {
                    if (count > max) {
                        max = count;
                    }
                    count = count + beginning - index;
                    beginning = index + 1;
                } else {
                    count++;
                }
                memo.put(c, i);
            } else {
                count++;
                memo.put(c, i);
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }
}
//Your runtime beats 98.38 % of java submissions.
//Varies greatly because randomness of HashMap.

