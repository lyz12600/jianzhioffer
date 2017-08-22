package concurrentcoreapi.semaphore.acquireUninterruptibly;

import java.util.concurrent.Semaphore;

/**
 * Created by liyanzhen on 17/6/7.
 */
public class ServiceCanInterrupt {
    private Semaphore semaphore = new Semaphore(1);

    public void tesetMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "begin timer = " + System.currentTimeMillis());
            semaphore.acquire();
            for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
                String s = new String();
                Math.random();
            }
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + "end timer =" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "进入了catch");
            e.printStackTrace();
        }
    }
}
