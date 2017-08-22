package chapterone;

/**
 * Created by liyanzhen on 17/7/3.
 */
public class SuspendDemo {
    public static void main(String[] args) {
        try {
            TestThread tt = new TestThread();
            tt.start();
            Thread.sleep(5000);

            //A
            tt.suspend();
            System.out.println("A = " + System.currentTimeMillis() + "----" + tt.getI());

            Thread.sleep(5000);
            System.out.println("A = " + System.currentTimeMillis() + "----" + tt.getI());

            //B
            tt.resume();
            Thread.sleep(5000);

            //C
            tt.suspend();
            System.out.println("C = " + System.currentTimeMillis() + "----" + tt.getI());

            Thread.sleep(5000);
            System.out.println("C = " + System.currentTimeMillis() + "----" + tt.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestThread extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }
}