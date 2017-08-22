package chapterone;

/**
 * Created by liyanzhen on 17/7/3.
 */
public class 在沉睡中停止 {
    public static void main(String[] args) {
        StopWhenSleeping thread = new StopWhenSleeping();
        thread.start();
        try {
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}

class StopWhenSleeping extends Thread {
    @Override
    public void run() {
        System.out.println("run begin");
        try {
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止，进入catch --" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}