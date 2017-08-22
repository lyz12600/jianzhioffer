package concurrentcoreapi.semaphore.acquireUninterruptibly;

import java.util.concurrent.Semaphore;

/**
 * Created by liyanzhen on 17/6/7.
 */
public class ServiceCannotInterrupt {
    private Semaphore semaphore = new Semaphore(1);

    public void tesetMethod() {
        System.out.println(Thread.currentThread().getName() + "begin timer = " + System.currentTimeMillis());
        semaphore.acquireUninterruptibly();
        for (int i = 0; i < Integer.MAX_VALUE / 50; i++) {
            String s = new String();
            Math.random();
        }
        semaphore.release();
        System.out.println(Thread.currentThread().getName() + "end timer =" + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + "进入了catch");
    }
}
