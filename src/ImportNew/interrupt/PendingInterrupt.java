package ImportNew.interrupt;

import sun.awt.windows.ThemeReader;

/**
 * Created by liyanzhen on 17/6/20.
 */
public class PendingInterrupt extends Object {
    public static void main(String[] args) {
        if (args.length > 0)
            Thread.currentThread().interrupt();

        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " was NOT interrupted");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }

        System.out.println(Thread.currentThread().getName() + " elapsedTime = " + (System.currentTimeMillis() - start));
    }
}
