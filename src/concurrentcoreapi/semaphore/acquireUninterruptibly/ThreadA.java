package concurrentcoreapi.semaphore.acquireUninterruptibly;

import concurrentcoreapi.semaphore.acquireUninterruptibly.ServiceCanInterrupt;

/**
 * Created by liyanzhen on 17/6/7.
 */
public class ThreadA extends Thread {
    private ServiceCanInterrupt mService = new ServiceCanInterrupt();

    public ThreadA(ServiceCanInterrupt service) {
        super();
        this.mService = service;
    }

    @Override
    public void run() {
        mService.tesetMethod();
    }
}
