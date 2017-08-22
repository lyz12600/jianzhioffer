package synchronize;

/**
 * Created by liyanzhen on 17/6/20.
 */
public class SynchTest {
    public static void main(String[] args) {
        SynchRun synchRun = new SynchRun(System.currentTimeMillis());
        new Thread(synchRun).start();
        new Thread(synchRun).start();
        new Thread(synchRun).start();
    }
}

class SynchRun implements Runnable {
    private final Object synch = new Object();
    private long mStart;

    public SynchRun(long start) {
        mStart = start;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
    }
}