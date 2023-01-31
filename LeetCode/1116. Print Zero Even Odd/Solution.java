import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore semZero;
    private Semaphore semEven;
    private Semaphore semOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        semZero = new Semaphore(1);
        semEven = new Semaphore(0);
        semOdd = new Semaphore(2);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semZero.acquire();
            printNumber.accept(0);
            semEven.release();
            semOdd.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                semEven.acquire(3);
                printNumber.accept(i);
                semZero.release();
                semOdd.release();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                semOdd.acquire(3);
                printNumber.accept(i);
                semZero.release();
                semEven.release();
            }
        }

    }
}
