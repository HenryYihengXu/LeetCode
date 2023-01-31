import java.util.concurrent.Semaphore;

class FooBar {

    private int n;
    private Semaphore semaphoreFoo;
    private Semaphore semaphoreBar;

    public FooBar(int n) {
        this.n = n;
        semaphoreFoo = new Semaphore(1);
        semaphoreBar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();
        }
    }
}



//class FooBar {
//    class Status {
//        private int next;
//        public int getNext() {
//            return next;
//        }
//        public void setNext(int next) {
//            this.next = next;
//        }
//        public Status() {
//            next = 1;
//        }
//    }
//
//    private int n;
//    private Status status;
//
//    public FooBar(int n) {
//        this.n = n;
//        status = new Status();
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            synchronized (status) {
//                if (status.getNext() != 1) {
//                    status.wait();
//                }
//
//                // printFoo.run() outputs "foo". Do not change or remove this line.
//                printFoo.run();
//
//                status.setNext(2);
//                status.notifyAll();
//            }
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//            synchronized (status) {
//                if (status.getNext() != 2) {
//                    status.wait();
//                }
//
//                // printBar.run() outputs "bar". Do not change or remove this line.
//                printBar.run();
//
//                status.setNext(1);
//                status.notifyAll();
//            }
//        }
//    }
//}
