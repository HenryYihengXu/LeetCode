import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BoundedBlockingQueue {
    private ReentrantReadWriteLock lock;
    private Lock readLock;
    private Lock writeLock;
    private Condition conditionFull;
    private Condition conditionEmpty;
    private Queue<Integer> queue;
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
        conditionFull = writeLock.newCondition();
        conditionEmpty = writeLock.newCondition();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        writeLock.lock();
        try {
            while (queue.size() == capacity) {
                conditionFull.await();
            }
            queue.offer(element);
            conditionEmpty.signal();
        } finally {
            writeLock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        writeLock.lock();
        try {
            while (queue.size() == 0) {
                conditionEmpty.await();
            }
            int element = queue.poll();
            conditionFull.signal();
            return element;
        } finally {
            writeLock.unlock();
        }
    }

    public int size() {
        readLock.lock();
        try {
            return queue.size();
        } finally {
            readLock.unlock();
        }
    }
}


//class BoundedBlockingQueue {
//    private Semaphore lock;
//    private Semaphore semFull;
//    private Semaphore semEmpty;
//    private Queue<Integer> queue;
//
//    public BoundedBlockingQueue(int capacity) {
//        lock = new Semaphore(1);
//        semFull = new Semaphore(capacity);
//        semEmpty = new Semaphore(0);
//        queue = new LinkedList<>();
//    }
//
//    public void enqueue(int element) throws InterruptedException {
//        semFull.acquire();
//        lock.acquire();
//        queue.add(element);
//        lock.release();
//        semEmpty.release();
//    }
//
//    public int dequeue() throws InterruptedException {
//        semEmpty.acquire();
//        lock.acquire();
//        int element = queue.remove();
//        lock.release();
//        semFull.release();
//        return element;
//    }
//
//    public int size() {
//        return semEmpty.availablePermits();
//    }
//}
