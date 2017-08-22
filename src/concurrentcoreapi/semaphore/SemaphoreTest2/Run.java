package concurrentcoreapi.semaphore.SemaphoreTest2;

import java.util.concurrent.Semaphore;

/**
 * Created by liyanzhen on 17/6/6.
 * 动态增加permits的个数
 */
public class Run {
    public static void main(String[] args) {
//        ServiceCanInterrupt service = new ServiceCanInterrupt();
//        ThreadA[] a = new ThreadA[10];
//        for (int i = 0; i < 10; i++) {
//            a[i] = new ThreadA(service);
//            a[i].start();
//        }

        try {
            Semaphore semaphore = new Semaphore(5);
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits()); //0
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();//5
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            semaphore.release(4);
            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
