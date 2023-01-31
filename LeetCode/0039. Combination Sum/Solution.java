import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] candidates;
    public int target;
    public List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        ans = new LinkedList<>();
        int sum = 0;
        dfs(0, 0, path);
        return ans;
    }

    public void dfs(int i, int sum, LinkedList<Integer> path) {
        if (sum == target) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            int newSum = sum + candidates[j];
            if (newSum > target) {
                break;
            }
            path.addLast(candidates[j]);
            dfs(j, newSum, path);
            path.removeLast();
        }
    }
}
