import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        ArrayList<HashSet<Integer>> adjList = new ArrayList<>(n);
        ArrayList<HashSet<Integer>> ancestors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
            ancestors.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
        }
        System.out.println(adjList);

        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, n, adjList, ancestors, visited);
            }
        }

        ArrayList<List<Integer>> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }

    private void dfs(int node, int n, ArrayList<HashSet<Integer>> adjList, ArrayList<HashSet<Integer>> ancestors, HashSet<Integer> visited) {
        visited.add(node);
        for (int ancestor : adjList.get(node)) {
            if (!visited.contains(ancestor)) {
                dfs(ancestor, n, adjList, ancestors, visited);
            }
            ancestors.get(node).add(ancestor);
            ancestors.get(node).addAll(ancestors.get(ancestor));
        }
    }
}
