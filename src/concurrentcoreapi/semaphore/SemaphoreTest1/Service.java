package concurrentcoreapi.semaphore.SemaphoreTest1;

import java.util.concurrent.Semaphore;

/**
 * Created by liyanzhen on 17/6/6.
 */
public class Service {
    private Semaphore semaphore = new Semaphore(3);

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "  begin timer = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "  end timer = " + System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
