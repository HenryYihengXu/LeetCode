import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }

        ArrayList<Integer> noLose = new ArrayList<>();
        ArrayList<Integer> oneLose = new ArrayList<>();
        for (int player : map.keySet()) {
            if (map.get(player) == 0) {
                noLose.add(player);
            } else if (map.get(player) == 1) {
                oneLose.add(player);
            }
        }
        Collections.sort(noLose);
        Collections.sort(oneLose);

        ArrayList<List<Integer>> ans = new ArrayList<>();
        ans.add(noLose);
        ans.add(oneLose);
        return ans;
    }
}
