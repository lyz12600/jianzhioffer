package runnable;

/**
 * 可以共享线程类的实例变量
 * Created by liyanzhen on 17/6/20.
 */
public class RunnableDemo01 implements Runnable {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "=====>" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RunnableDemo01 r = new RunnableDemo01();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "=====>" + i);
            if (i == 20) {
                new Thread(r, "新线程1").start();
                new Thread(r, "新线程2").start();
            }
        }
    }
}
