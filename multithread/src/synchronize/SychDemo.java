package synchronize;

/**
 * Created by liyanzhen on 17/6/20.
 */
public class SychDemo {
    public static void main(String[] args) {
        Synch01 synch01 = new Synch01();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synch01.fun01();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synch01.fun02();
            }
        });
        t1.start();
        t2.start();
    }
}

class Synch01 {
    public synchronized void fun01() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void fun02() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

