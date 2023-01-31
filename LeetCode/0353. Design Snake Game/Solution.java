import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

class SnakeGame {
    private int[][] food;
    private int score;
    private Deque<Integer> snake;
    private HashSet<Integer> body;
    private int width;
    private int height;

    public SnakeGame(int width, int height, int[][] food) {
        snake = new ArrayDeque<>();
        snake.add(0);
        body = new HashSet<>();
        body.add(0);
        this.food = food;
        score = 0;
        this.width = width;
        this.height = height;
    }

    public int move(String direction) {
        int head = snake.peekFirst();
        int headX = head / width;
        int headY = head % width;

        switch (direction) {
            case "L":
                if (headY == 0) {
                    return -1;
                }
                return moveToNext(head - 1);
            case "R":
                if (headY == width - 1) {
                    return -1;
                }
                return moveToNext(head + 1);
            case "U":
                if (headX == 0) {
                    return -1;
                }
                return moveToNext(head - width);
            case "D":
                if (headX == height - 1) {
                    return -1;
                }
                return moveToNext(head + width);
            default:
                return -1;
        }
    }

    public int moveToNext(int next) {
        if (score < food.length && to1D(food[score][0], food[score][1]) == next && !body.contains(next)) {
            score += 1;
            snake.addFirst(next);
            body.add(next);
            return score;
        }
        int end = snake.removeLast();
        body.remove(end);
        if (body.contains(next)) {
            return -1;
        }
        snake.addFirst(next);
        body.add(next);
        return score;
    }

    public int to1D(int x, int y) {
        return x * width + y;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
