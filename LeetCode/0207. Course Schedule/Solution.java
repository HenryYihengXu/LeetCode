import java.util.LinkedList;
import java.util.Queue;

class Solution {
    LinkedList<Integer>[] adjacencyList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjacencyList = new LinkedList[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (adjacencyList[prerequisite[0]] == null) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(prerequisite[1]);
                adjacencyList[prerequisite[0]] = list;
            } else {
                adjacencyList[prerequisite[0]].add(prerequisite[1]);
            }
        }

        boolean[] globalVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (globalVisited[i]) {
                continue;
            }
            boolean[] localVisited = new boolean[numCourses];
            localVisited[i] = true;
            if (foundCycle(i, localVisited, globalVisited)) {
                return false;
            }
        }
        return true;
    }

    boolean foundCycle(int root, boolean[] localVisited, boolean[] globalVisited) {
        LinkedList<Integer> children = adjacencyList[root];
        if (children == null) {
            return false;
        }
        for (int child : children) {
            if (localVisited[child]) {
                return true;
            }
            if (!globalVisited[child]) {
                globalVisited[child] = true;
                localVisited[child] = true;
                if (foundCycle(child, localVisited, globalVisited)) {
                    return true;
                }
                localVisited[child] = false;
            }
        }
        return false;
    }
}
