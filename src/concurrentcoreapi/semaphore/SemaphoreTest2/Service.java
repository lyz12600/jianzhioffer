package concurrentcoreapi.semaphore.SemaphoreTest2;

import java.util.concurrent.Semaphore;

/**
 * Created by liyanzhen on 17/6/6.
 */
public class Service {
    private Semaphore semaphore = new Semaphore(10);

    public void testMethod() {
        try {
            semaphore.acquire(2);
            System.out.println(Thread.currentThread().getName() + "  begin timer = " + System.currentTimeMillis());
            int sleepValue = ((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "  停止了" + sleepValue + " 毫秒");
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + "  end timer = " + System.currentTimeMillis());
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
