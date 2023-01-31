import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// approach 2: make people pick left and right alternatively as their neighbors by letting odd person
// first pick left, even person first pick right
class DiningPhilosophers {

    static final int NUM_PHILOSOPHER = 5;

    private Lock[] locks;

    public DiningPhilosophers() {
        locks = new Lock[NUM_PHILOSOPHER];
        for (int i = 0; i < NUM_PHILOSOPHER; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % NUM_PHILOSOPHER;
//        int left = (philosopher == 0) ? 4 : philosopher - 1;
//        int right = philosopher;

        if (philosopher % 2 == 0) {
            locks[left].lock();
            locks[right].lock();
        } else {
            locks[right].lock();
            locks[left].lock();
        }

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        locks[right].unlock();
        locks[left].unlock();
    }
}

//// approach 2: make sure each person pick up both forks at the same time by a global lock
//class DiningPhilosophers {
//
//    static final int NUM_PHILOSOPHER = 5;
//
//    private Lock[] locks;
//    private Lock lock;
//
//    public DiningPhilosophers() {
//        locks = new Lock[NUM_PHILOSOPHER];
//        lock = new ReentrantLock();
//        for (int i = 0; i < NUM_PHILOSOPHER; i++) {
//            locks[i] = new ReentrantLock();
//        }
//    }
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//        int left = philosopher;
//        int right = (philosopher + 1) % NUM_PHILOSOPHER;
////        int left = (philosopher == 0) ? 4 : philosopher - 1;
////        int right = philosopher;
//        lock.lock();
//        locks[left].lock();
//        locks[right].lock();
//        lock.unlock();
//        pickLeftFork.run();
//        pickRightFork.run();
//        eat.run();
//        putLeftFork.run();
//        putRightFork.run();
//        locks[right].unlock();
//        locks[left].unlock();
//    }
//}

//// approach 1: make sure at most 4 people can hold the right fork by a global semaphore
//class DiningPhilosophers {
//
//    static final int NUM_PHILOSOPHER = 5;
//
//    private Lock[] locks;
//    private Semaphore semTotal;
//
//    public DiningPhilosophers() {
//        locks = new Lock[NUM_PHILOSOPHER];
//        semTotal = new Semaphore(NUM_PHILOSOPHER - 1);
//        for (int i = 0; i < NUM_PHILOSOPHER; i++) {
//            locks[i] = new ReentrantLock();
//        }
//    }
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//        int left = philosopher;
//        int right = (philosopher + 1) % NUM_PHILOSOPHER;
////        int left = (philosopher == 0) ? 4 : philosopher - 1;
////        int right = philosopher;
//        locks[left].lock();
//        semTotal.acquire();
//        locks[right].lock();
//        pickLeftFork.run();
//        pickRightFork.run();
//        eat.run();
//        putLeftFork.run();
//        putRightFork.run();
//        locks[right].unlock();
//        semTotal.release();
//        locks[left].unlock();
//    }
//}
