package chapterone;

/**
 * Created by liyanzhen on 17/6/26.
 */
public class InterruptedDemo01 {
    public static void main(String[] args) {
        InterruptThread it = new InterruptThread();
        it.start();
        try {
            Thread.sleep(20);
            it.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}

class InterruptThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("已经停止了");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            System.out.println("我在for下面");
        } catch (InterruptedException e) {
            System.out.println("进Thread类run方法中的catch了");
            e.printStackTrace();
        }
    }
}