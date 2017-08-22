package synchronize;

/**
 * Created by liyanzhen on 17/5/5.
 */
public class MonitorExample {
    int a = 0;

    public synchronized void writer() {
        for (int i = 0; i < 1000; i++) {
            ++a;
        }
    }

    public synchronized void read() {
        int i = a;
        System.out.println(i);
    }

    public static void main(String args[]) {
        MonitorExample a = new MonitorExample();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
                a.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
                a.read();
            }
        }).start();
    }
}
