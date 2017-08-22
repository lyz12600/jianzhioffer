package process;

/**
 * Created by liyanzhen on 17/3/18.
 */
public class SynchronizedDemo3 {
    public void m4t1() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void m4t2() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ed) {
                    ed.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        SynchronizedDemo3 s = new SynchronizedDemo3();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                s.m4t1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s.m4t2();
            }
        });
        t1.start();
        t2.start();
    }
}
