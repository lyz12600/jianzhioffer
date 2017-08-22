package process;

/**
 * Created by liyanzhen on 17/1/12.
 */
public class InvokeRun extends Thread {
    private int i;

    public void run() {
        for (; i < 100; i++) {
            //System.out.println(this.getName() + "--------A" + i);
            System.out.println(Thread.currentThread().getName() + "--------B" + i);
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "*********" + i);
            if (i == 20) {
                new InvokeRun().run();
                new InvokeRun().start();
            }
        }
    }
}
