package process;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liyanzhen on 17/3/18.
 */
public class LockDemo {

    public static void main(String[] args) {
        MyRunnable myRunnable = new LockDemo().new MyRunnable();

        Thread t1 = new Thread(myRunnable, "thread1");
        Thread t2 = new Thread(myRunnable, "thread2");
        t1.start();
        t2.start();
        t2.interrupt();
    }


    public class MyRunnable implements Runnable {
        private Lock lock = new ReentrantLock();

        @Override
        public synchronized void run() {
            try {
                lock.lockInterruptibly();
                System.out.println("获取了锁");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "响应中断");
            }
            finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }
        }
    }

}
