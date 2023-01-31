import java.util.PriorityQueue;
import java.util.TreeMap;

class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> (b - a));
        right = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
            return;
        }

        if (right.isEmpty()) {
            if (num < left.peek()) {
                right.add(left.poll());
                left.add(num);
            } else {
                right.add(num);
            }
            return;
        }

        if (num < left.peek()) {
            if (left.size() <= right.size()) {
                left.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        } else if (num > right.peek()) {
            if (right.size() <= left.size()) {
                right.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            if (left.size() <= right.size()) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
    }

    public double findMedian() {
        if (left.size() < right.size()) {
            return right.peek();
        } else if (right.size() < left.size()) {
            return left.peek();
        } else {
            return (double)(left.peek() + right.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
