package concurrentcoreapi.semaphore.permits;

import java.util.concurrent.Semaphore;

/**
 * Created by liyanzhen on 17/6/7.
 */
public class ServiceDrainPermits {
    private Semaphore semaphore = new Semaphore(10);

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + "  " + semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + "  " + semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + "  " + semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
