package concurrentcoreapi.semaphore.acquireUninterruptibly;

/**
 * Created by liyanzhen on 17/6/7.
 */
public class Run {
    public static void main(String args[]) {
        ServiceCanInterrupt service = new ServiceCanInterrupt();
        ThreadA a = new ThreadA(service);
        a.setName("Thread-A");

        ThreadB b = new ThreadB(service);
        b.setName("Thread-B");

        a.start();
        b.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        b.interrupt();
        System.out.println("main中断了b");
    }
}
