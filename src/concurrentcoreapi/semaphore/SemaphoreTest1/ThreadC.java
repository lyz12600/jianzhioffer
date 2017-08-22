package concurrentcoreapi.semaphore.SemaphoreTest1;

/**
 * Created by liyanzhen on 17/6/6.
 */
public class ThreadC extends Thread {
    private Service mService;

    public ThreadC(Service service) {
        super();
        this.mService = service;
    }

    @Override
    public void run() {
        mService.testMethod();
    }
}
