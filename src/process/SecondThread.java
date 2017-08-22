package process;

/**
 * Created by liyanzhen on 17/1/11.
 */
public class SecondThread implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-----" + i);
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "*******" + i);
            if (i == 20){
                SecondThread r = new SecondThread();
                new Thread(r,"aaaaaa").start();
                new Thread(r,"bbbbbb").start();
            }
        }
    }
}
