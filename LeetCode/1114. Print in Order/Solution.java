import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore[] semaphores;
    public Foo() {
        int numThreads = 3;
        semaphores = new Semaphore[numThreads];
        for (int i = 0; i < numThreads; i++) {
            semaphores[i] = new Semaphore(0);
        }
        semaphores[0].release();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphores[0].acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphores[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphores[1].acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphores[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphores[2].acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphores[0].release();
    }
}


//class Foo {
//    class Status {
//        private boolean isDone;
//
//        public boolean isDone() {
//            return isDone;
//        }
//
//        public void done() {
//            isDone = true;
//        }
//    }
//
//    public Status status1;
//    public Status status2;
//
//    public Foo() {
//        status1 = new Status();
//        status2 = new Status();
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        status1.done();
//        synchronized (status1) {
//            status1.notifyAll();
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        if (!status1.isDone()) {
//            synchronized (status1) {
//                status1.wait();
//            }
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        status2.done();
//        synchronized (status2) {
//            status2.notifyAll();
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        if (!status2.isDone()) {
//            synchronized (status2) {
//                status2.wait();
//            }
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}


//class Foo {
//    volatile boolean firstDone;
//    volatile boolean secondDone;
//    public Foo() {
//
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        firstDone = true;
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (!firstDone){}
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        secondDone = true;
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (!secondDone){}
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}
