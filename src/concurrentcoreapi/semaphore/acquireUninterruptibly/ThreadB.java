package concurrentcoreapi.semaphore.acquireUninterruptibly;

import concurrentcoreapi.semaphore.acquireUninterruptibly.ServiceCanInterrupt;

/**
 * Created by liyanzhen on 17/6/7.
 */
public class ThreadB extends Thread {
    private ServiceCanInterrupt mService = new ServiceCanInterrupt();

    public ThreadB(ServiceCanInterrupt service) {
        super();
        this.mService = service;
    }

    @Override
    public void run() {
        mService.tesetMethod();
    }
}
