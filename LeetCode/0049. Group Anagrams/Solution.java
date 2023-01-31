import java.util.*;

class Anagram {
    int[] occurrences;
    public Anagram() {
        occurrences = new int[26];
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int occurrence : occurrences) {
            result = result * 31 + occurrence;
        }
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Anagram)) {
            return false;
        }

        for (int i = 0; i < 26; i++) {
            if (this.occurrences[i] != ((Anagram) other).occurrences[i]) {
                return false;
            }
        }
        return true;
    }

    public Anagram(String str) {
        occurrences = new int[26];
        for (char c : str.toCharArray()) {
            occurrences[c - 'a'] += 1;
        }
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Anagram, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Anagram anagram = new Anagram(str);
            if (!map.containsKey(anagram)) {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(anagram, list);
            } else {
                map.get(anagram).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
