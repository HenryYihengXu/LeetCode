import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] coordinate = q.poll();
            int i = coordinate[0];
            int j = coordinate[1];

            if (i > 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
                rooms[i - 1][j] = rooms[i][j] + 1;
                q.add(new int[]{i - 1, j});
            }
            if (i < m - 1 && rooms[i + 1][j] == Integer.MAX_VALUE) {
                rooms[i + 1][j] = rooms[i][j] + 1;
                q.add(new int[]{i + 1, j});
            }
            if (j > 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
                rooms[i][j - 1] = rooms[i][j] + 1;
                q.add(new int[]{i, j - 1});
            }
            if (j < n - 1 && rooms[i][j + 1] == Integer.MAX_VALUE) {
                rooms[i][j + 1] = rooms[i][j] + 1;
                q.add(new int[]{i, j + 1});
            }
        }
    }

//    public void wallsAndGates(int[][] rooms) {
//        int m = rooms.length;
//        int n = rooms[0].length;
//        List<Stack<int[]>> gates = new LinkedList<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (rooms[i][j] == 0) {
//                    Stack<int[]> stack = new Stack<>();
//                    stack.push(new int[]{i, j});
//                    gates.add(stack);
//                }
//            }
//        }
//        while (!gates.isEmpty()) {
//            List<Stack<int[]>> newGates = new LinkedList<>();
//            for (Stack<int[]> stack : gates) {
//                Stack<int[]> newStack = new Stack<>();
//                while (!stack.isEmpty()) {
//                    int[] coordinate = stack.pop();
//                    int i = coordinate[0];
//                    int j = coordinate[1];
//                    if (i > 0 && rooms[i - 1][j] == Integer.MAX_VALUE) {
//                        rooms[i - 1][j] = rooms[i][j] + 1;
//                        newStack.add(new int[]{i - 1, j});
//                    }
//                    if (i < m - 1 && rooms[i + 1][j] == Integer.MAX_VALUE) {
//                        rooms[i + 1][j] = rooms[i][j] + 1;
//                        newStack.add(new int[]{i + 1, j});
//                    }
//                    if (j > 0 && rooms[i][j - 1] == Integer.MAX_VALUE) {
//                        rooms[i][j - 1] = rooms[i][j] + 1;
//                        newStack.add(new int[]{i, j - 1});
//                    }
//                    if (j < n - 1 && rooms[i][j + 1] == Integer.MAX_VALUE) {
//                        rooms[i][j + 1] = rooms[i][j] + 1;
//                        newStack.add(new int[]{i, j + 1});
//                    }
//                }
//                if (!newStack.isEmpty()) {
//                    newGates.add(newStack);
//                }
//            }
//            gates = newGates;
//        }
//    }
}
