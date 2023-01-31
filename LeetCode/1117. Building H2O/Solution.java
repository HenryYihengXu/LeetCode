import java.util.concurrent.Semaphore;

class H2O {
    private Semaphore semH;
    private Semaphore semO;

    public H2O() {
        semH = new Semaphore(2);
        semO = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semO.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semH.release(2);
    }
}
