package concurrentcoreapi.semaphore.SemaphoreTest1;

/**
 * Created by liyanzhen on 17/6/6.
 */
public class ThreadA extends Thread {
    private Service mService;

    public ThreadA(Service service) {
        super();
        this.mService = service;
    }

    @Override
    public void run() {
        mService.testMethod();
    }
}
