package 交替打印.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liyanzhen on 17/6/22.
 */
public class ConditionExample {
    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    private char currentThreadName = 'A';

    public static void main(String args[]) {
        ConditionExample ce = new ConditionExample();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(ce.new ThreadA());
        service.execute(ce.new ThreadB());
        service.execute(ce.new ThreadC());

        service.shutdown();
    }

    private class ThreadA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    /**
                     * 如果当前线程名字不是A，那么ThreadA就处理等待状态
                     */
                    while (currentThreadName != 'A') {
                        try {
                            conditionA.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    /**
                     * 将当前线程名置为B， 然后通知ThreadB执行
                     */
                    currentThreadName = 'B';
                    conditionB.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class ThreadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (currentThreadName != 'B') {
                        try {
                            conditionB.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    currentThreadName = 'C';
                    conditionC.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class ThreadC implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (currentThreadName != 'C') {
                        try {
                            conditionC.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    currentThreadName = 'A';
                    conditionA.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
