import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        LinkedList<Integer>[] adjacencyList = new LinkedList[numCourses];
        int[] inDegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int dest = prerequisite[0];
            if (adjacencyList[source] == null) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(dest);
                adjacencyList[source] = list;
            } else {
                adjacencyList[source].add(dest);
            }
            inDegrees[dest] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[i] = course;
            i += 1;
            if (adjacencyList[course] != null) {
                for (int dest : adjacencyList[course]) {
                    inDegrees[dest] -= 1;
                    if (inDegrees[dest] == 0) {
                        queue.add(dest);
                    }
                }
            }
        }

        if (i != numCourses) {
            return new int[0];
        }
        return order;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prerequisites1 = {{1,0}};
        int[][] prerequisites2 = {{1,0}, {2,0},{3,1},{3,2}};
        System.out.println(solution.findOrder(prerequisites2.length, prerequisites2));
    }
}


//class Solution {
//    LinkedList<Integer>[] adjacencyList;
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        LinkedList<Integer> order = new LinkedList<>();
//        adjacencyList = new LinkedList[numCourses];
//        for (int[] prerequisite : prerequisites) {
//            if (adjacencyList[prerequisite[0]] == null) {
//                LinkedList<Integer> list = new LinkedList<>();
//                list.add(prerequisite[1]);
//                adjacencyList[prerequisite[0]] = list;
//            } else {
//                adjacencyList[prerequisite[0]].add(prerequisite[1]);
//            }
//        }
//
//        boolean[] globalVisited = new boolean[numCourses];
//        boolean[] localVisited = new boolean[numCourses];
//
//        for (int i = 0; i < numCourses; i++) {
//            if (globalVisited[i]) {
//                continue;
//            }
//            if (dfs(i, order, localVisited, globalVisited)) {
//                return new int[]{};
//            }
//        }
//
//        int[] ans = new int[numCourses];
//        int i = 0;
//        for (int node : order) {
//            ans[i] = node;
//            i++;
//        }
//        return ans;
//    }
//
//    boolean dfs(int root, LinkedList<Integer> order, boolean[] localVisited, boolean[] globalVisited) {
//        localVisited[root] = true;
//        globalVisited[root] = true;
//        LinkedList<Integer> children = adjacencyList[root];
//        if (children != null) {
//            for (int child : children) {
//                if (localVisited[child]) {
//                    return true;
//                }
//                if (!globalVisited[child]) {
//                    if (dfs(child, order, localVisited, globalVisited)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        localVisited[root] = false;
//        order.add(root);
//        return false;
//    }
//}
