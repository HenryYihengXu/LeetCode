import java.util.*;

class Solution {
    class State {
        public int x;
        public int y;
        public int key;

        public State(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
    public int shortestPathAllKeys(String[] grid) {

        State startState = null;
        int numKeys = 0;
        for (int i = 0; i < grid.length; i++) {
             for (int j = 0; j < grid[0].length(); j++) {
                 char c = grid[i].charAt(j);
                 if (c == '@') {
                     startState = new State(i, j, 0);
                 } else if (c >= 'a' && c <= 'z') {
                     numKeys += 1;
                 }
             }
        }

        int allKeys = 1;
        for (int i = 1; i < numKeys; i++) {
            allKeys <<= 1;
            allKeys |= 1;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        HashSet<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();

        int dist = 0;
        queue.offer(startState);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                State state = queue.poll();

                if (state.key == allKeys) {
                    return dist;
                }

                for (int[] direction : directions) {
                    int x = state.x + direction[0];
                    int y = state.y + direction[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length()) {
                        char c = grid[x].charAt(y);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'A' && c <= 'Z' && (state.key & (1 << (c - 'A'))) == 0) {
                            continue;
                        }
                        int key = 0;
                        if (c >= 'a' && c <= 'z') {
                            key = state.key | (1 << (c - 'a'));
                        } else {
                            key = state.key;
                        }

                        String s = x + " " + y + " " + key;
                        if (visited.contains(s)) {
                            continue;
                        }

                        visited.add(s);
                        State nextState = new State(x, y, key);
                        queue.offer(nextState);
                    }
                }

                size -= 1;
            }
            dist += 1;
        }
        return -1;
    }
}

// class Solution {
//     int minLength = -1;

//     public int shortestPathAllKeys(String[] grid) {
//         char[][] board = new char[grid.length][grid[0].length()];
//         int x = 0;
//         int y = 0;
//         int numKeys = 0;
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 char c = grid[i].charAt(j);
//                 if (c == '@') {
//                     x = i;
//                     y = j;
//                 } else if (c >= 'a' && c <= 'z') {
//                     numKeys += 1;
//                 }
//                 board[i][j] = c;
//             }
//         }

//         HashSet<Character> keys = new HashSet<>();
//         Stack<char[][]> boards = new Stack<>();
//         dfs(x, y, board, keys, numKeys, 0, boards);

//         return minLength;
//     }

//     private void dfs(int x, int y, char[][] board, HashSet<Character> keys, int numKeys, int length, Stack<char[][]> boards) {
//         if (minLength != -1 && length >= minLength) {
//             return;
//         }
//         if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
//             return;
//         }

//         char c = board[x][y];
//         if (c == '#' || c == '0') {
//             return;
//         }
//         if (c >= 'A' && c <= 'Z' && !keys.contains((char)(c - 'A' + 'a'))) {
//             return;
//         }

//         if (c >= 'a' && c <= 'z') {
//             if (keys.size() == numKeys - 1) {
//                 if (minLength == -1) {
//                     minLength = length;
//                 } else {
//                     minLength = Math.min(minLength, length);
//                 }
//                 // System.out.println("success");
//                 // System.out.println();
//                 // System.out.println();
//                 return;
//             }

//             char[][] currBoard = new char[board.length][board[0].length];
//             for (int i = 0; i < board.length; i++) {
//                 for (int j = 0; j < board[0].length; j++) {
//                     currBoard[i][j] = board[i][j];
//                     if (board[i][j] == '0') {
//                         board[i][j] = '.';
//                     }
//                 }
//             }
//             boards.push(currBoard);
//             keys.add(c);
//         }

//         board[x][y] = '0';

//         dfs(x - 1, y, board, keys, numKeys, length + 1, boards);
//         dfs(x + 1, y, board, keys, numKeys, length + 1, boards);
//         dfs(x, y - 1, board, keys, numKeys, length + 1, boards);
//         dfs(x, y + 1, board, keys, numKeys, length + 1, boards);

//         if (c >= 'a' && c <= 'z') {
//             char[][] prevBoard = boards.pop();
//             for (int i = 0; i < board.length; i++) {
//                 for (int j = 0; j < board[0].length; j++) {
//                     board[i][j] = prevBoard[i][j];
//                 }
//             }
//         } else {
//             board[x][y] = c;
//         }
//         keys.remove(c);
//         // printBoard(board);
//         // System.out.println();

//     }

//     private void printBoard(char[][] board) {
//     for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 System.out.print(board[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }
