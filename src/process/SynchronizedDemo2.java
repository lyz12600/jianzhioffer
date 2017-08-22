package process;

/**
 * Created by liyanzhen on 17/3/18.
 */
public class SynchronizedDemo2 implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "synchronized loop" + i);
            }
        }
    }

    public static void main(String args[]) {
        SynchronizedDemo2 s = new SynchronizedDemo2();
        Thread t1 = new Thread(s, "A");
        Thread t2 = new Thread(s, "B");
        t1.start();
        t2.start();
    }
}
