import java.util.LinkedList;
import java.util.List;

class Solution {
    public int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        List<String> ans = new LinkedList<>();
        dfs(ans, new StringBuilder(), 0, 0);
        return ans;
    }

    public void dfs(List<String> ans, StringBuilder path, int l, int r) {
        if (r == n) {
            ans.add(path.toString());
            return;
        }
        if (l < n) {
            path.append('(');
            dfs(ans, path, l + 1, r);
            path.deleteCharAt(path.length() - 1);
        }
        if (l > r) {
            path.append(')');
            dfs(ans, path, l, r + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
