package reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liyanzhen on 17/5/5.
 */
public class ReentrantLockExample01 {
    int a = 0;
    ReentrantLock lock = new ReentrantLock(true);

    public void writer() {
        lock.lock();
        try {
            a++;
            System.out.println(a);
        } finally {
            lock.unlock();
        }
    }

    public void reader() {
        lock.lock();
        try {
            int i = a;
            System.out.println(i);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample01 demo = new ReentrantLockExample01();
        new Thread(() -> {
            demo.writer();
            System.out.println("thread1");
        }).start();

        new Thread(() -> {
            demo.reader();
            System.out.println("thread2");
        }).start();
    }
}
