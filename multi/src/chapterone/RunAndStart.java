package chapterone;

/**
 * Created by liyanzhen on 17/6/26.
 */
public class RunAndStart {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        System.out.println("main - begin--" + System.currentTimeMillis());
        mt.run();
        System.out.println("main - end--" + System.currentTimeMillis());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread - start---" + currentThread().getName() + "---" + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread - end---" + currentThread().getName() + "---" + System.currentTimeMillis());
    }
}