import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        int k = words[0].length();
        int n = words.length;
        HashMap<String, Integer> kmers = new HashMap<>();
        for (String kmer : words) {
            kmers.put(kmer, kmers.getOrDefault(kmer, 0) + 1);
        }

        for (int i = 0; i <= s.length() - k * n; i++) {
            HashMap<String, Integer> visited = new HashMap<>();
            int j;
            for (j = 0; j < n; j++) {
                String kmer = s.substring(i + j * k, i + j * k + k);
                if (!kmers.containsKey(kmer)) {
                    break;
                }
                visited.put(kmer, visited.getOrDefault(kmer, 0) + 1);
                if (visited.get(kmer) > kmers.get(kmer)) {
                    break;
                }
            }
            if (j == words.length) {
                ans.add(i);
            }
        }
        return ans;
    }

//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> ans = new LinkedList<>();
//        int k = words[0].length();
//        HashMap<String, Integer> kmers = new HashMap<>(words.length);
//        for (String kmer : words) {
//            if (kmers.containsKey(kmer)) {
//                int occurrence = kmers.get(kmer);
//                kmers.put(kmer, occurrence + 1);
//            } else {
//                kmers.put(kmer, 1);
//            }
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            HashMap<String, Integer> visited = new HashMap<>(words.length);
//            int j;
//            for (j = 0; j < words.length; j++) {
//                if (i + j * k + k > s.length()) {
//                    break;
//                }
//                String kmer = s.substring(i + j * k, i + j * k + k);
//                if (!kmers.containsKey(kmer)) {
//                    break;
//                }
//                int occurrence = kmers.get(kmer);
//                if (visited.containsKey(kmer)) {
//                    int visitedOccurrence = visited.get(kmer);
//                    if (visitedOccurrence >= occurrence) {
//                        break;
//                    }
//                    visited.put(kmer, visitedOccurrence + 1);
//                } else {
//                    visited.put(kmer, 1);
//                }
//            }
//            if (j == words.length) {
//                ans.add(i);
//            }
//        }
//        return ans;
//    }
}
