package process;

/**
 * Created by liyanzhen on 17/3/18.
 */
public class YieldTest extends Thread {
    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + " " + i);
            if (i == 20){
                Thread.yield();
            }
        }
    }

    public static void main(String args[]){
        YieldTest t1 = new YieldTest("高级");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        YieldTest t2 = new YieldTest("低级");
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
    }
}
