package chapterone;

/**
 * Created by liyanzhen on 17/7/3.
 */
public class 先停止再沉睡 {
    public static void main(String[] args) {
        Mythread mt = new Mythread();
        mt.start();
        mt.interrupt();
        System.out.println("end");
    }
}

class Mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("i = " + (i + 1));
        }
        System.out.println("run begin");
        try {
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，再sleep，进入run catch");
            e.printStackTrace();
        }
    }
}
