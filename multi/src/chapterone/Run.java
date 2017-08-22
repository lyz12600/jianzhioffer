package chapterone;

/**
 * Created by liyanzhen on 17/6/26.
 */
public class Run {
    public static void main(String[] args) {
        CountOperate co = new CountOperate();
        Thread t = new Thread(co);
        System.out.println("main begin t is Alive---" + t.isAlive());
        t.setName("A");
        t.start();
        System.out.println("main end t is Alive---" + t.isAlive());
    }
}

class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName()---" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()---" + Thread.currentThread().isAlive());
        System.out.println("this.getName()---" + this.getName());
        System.out.println("this.isAlive()---" + this.isAlive());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName()---" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()---" + Thread.currentThread().isAlive());
        System.out.println("this.getName()---" + this.getName());
        System.out.println("this.isAlive()---" + this.isAlive());
        System.out.println("run---end");
    }
}
