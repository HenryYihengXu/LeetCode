import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<String, Integer> table = new HashMap<>();
        for (int i = 0; i < n; i++) {
            table.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < n; i++) {
            String s = words[i];
            if (table.containsKey("") && table.get("") != i && isPalindrome(s)) {
                ans.add(Arrays.asList(i, table.get("")));
            }

            for (int j = 1; j <= s.length(); j++) {
                String l = s.substring(0, j);
                String r = s.substring(j);
                if (table.containsKey(r) && table.get(r) != i && isPalindrome(l)) {
                    ans.add(Arrays.asList(table.get(r), i));
                }
                if (table.containsKey(l) && table.get(l) != i && isPalindrome(r)) {
                    ans.add(Arrays.asList(i, table.get(l)));
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }

//    public List<List<Integer>> palindromePairs(String[] words) {
//        int n = words.length;
//        List<List<Integer>> ans = new ArrayList<>();
//        HashMap<String, Integer> table = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            table.put(words[i], i);
//        }
//
//        for (int i = 0; i < n; i++) {
//            String s = words[i];
//            String reverse = "";
//            for (int j = s.length(); j > 0; j--) {
//                reverse += s.charAt(j - 1);
//            }
//            if (table.containsKey(reverse)) {
//                int index = table.get(reverse);
//                if (index != i) {
//                    ans.add(new ArrayList<>(List.of(i, index)));
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            String s = words[i];
//            for (int j = 1; j <= s.length(); j++) {
//                if (isPalindromePrefix(s, j)) {
//                    String reverseSuffix = "";
//                    for (int k = s.length(); k > j; k--) {
//                        reverseSuffix += s.charAt(k - 1);
//                    }
//                    if (table.containsKey(reverseSuffix)) {
//                        int index = table.get(reverseSuffix);
//                        if (index != i) {
//                            ans.add(new ArrayList<>(List.of(index, i)));
//                        }
//                    }
//                }
//            }
//
//            for (int j = s.length() - 1; j >= 0; j--) {
//                if (isPalindromeSuffix(s, j)) {
//                    String reversePrefix = "";
//                    for (int k = j; k > 0; k--) {
//                        reversePrefix += s.charAt(k - 1);
//                    }
//                    if (table.containsKey(reversePrefix)) {
//                        ans.add(new ArrayList<>(List.of(i, table.get(reversePrefix))));
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//
//    public boolean isPalindromePrefix(String s, int end) {
//        if (end == 0) {
//            return true;
//        }
//        for (int i = 0; i < end / 2; i++) {
//            if (s.charAt(i) != s.charAt(end - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean isPalindromeSuffix(String s, int start) {
//        if (start == s.length()) {
//            return true;
//        }
//        for (int i = 0; i < (s.length() - start) / 2; i++) {
//            if (s.charAt(start + i) != s.charAt(s.length() - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
