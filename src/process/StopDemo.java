package process;

/**
 * Created by liyanzhen on 17/5/5.
 */
public class StopDemo {
    public static void main(String[] args) {
        MyThread my = new MyThread();
        new Thread(my, "hellokitty").start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        my.stop();
    }
}

class MyThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (this.flag) {
            System.out.println(Thread.currentThread().getName() + "run" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }
}
