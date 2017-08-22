package 并发练习;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestConcurrent {
    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadA()).start();
    }
}

//class MyLock {
//    private boolean locked = false;
//
//    public boolean lock() {
//        while (!locked) {
//            locked = true;
//            System.out.println(Thread.currentThread().getName() + "-------if------" + locked);
//            return true;
//        }
//        System.out.println(Thread.currentThread().getName() + "------" + locked);
//        return false;
//    }
//}

class MyLock {
    private AtomicBoolean locked = new AtomicBoolean(false);

    public boolean lock() {
        System.out.println(locked.compareAndSet(false, true));
        return locked.compareAndSet(false, true);
    }
}

class ThreadA implements Runnable {
    MyLock myLock = new MyLock();

    @Override
    public void run() {

        myLock.lock();
    }
}