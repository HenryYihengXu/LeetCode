import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class CustomStack {
    private int maxSize;
    private int[] inc;
    private Stack<Integer> stack;
    public CustomStack(int maxSize) {
        stack = new Stack<>();
        inc = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.push(x);
        }
    }

    public int pop() {
        int i = stack.size() - 1;
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            inc[i - 1] += inc[i];
        }
        int result = stack.pop() + inc[i];
        inc[i] = 0;
        return result;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0) {
            inc[i] += val;
        }
    }
}

//class CustomStack {
//    private int maxSize;
//    private LinkedList<Integer> storage;
//    public CustomStack(int maxSize) {
//        storage = new LinkedList<>();
//        this.maxSize = maxSize;
//    }
//
//    public void push(int x) {
//        if (storage.size() < maxSize) {
//            storage.addLast(x);
//        }
//    }
//
//    public int pop() {
//        if (!storage.isEmpty()) {
//            return storage.removeLast();
//        } else {
//            return -1;
//        }
//    }
//
//    public void increment(int k, int val) {
//        for (int i = 0; i < Math.min(k, storage.size()); i++) {
//            storage.set(i, storage.get(i) + val);
//        }
//    }
//}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
