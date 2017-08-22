package process;


/**
 * Created by liyanzhen on 17/3/18.
 */
public class SynchronizedDemo {
    private final Object object = new Object();
    private boolean flage = false;

    public static void main(String[] args) {
        SynchronizedDemo a = new SynchronizedDemo();
        MyRunnable1 runnable1 = a.new MyRunnable1();
        MyRunnable2 runnable2 = a.new MyRunnable2();
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
    }

    public class MyRunnable1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (flage) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    flage = true;
                    object.notify();
                }
            }
        }
    }

    public class MyRunnable2 implements Runnable {
        @Override
        public void run() {
            while(true){
                synchronized (object){
                    if (!flage){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    flage = false;
                    object.notify();
                }
            }
        }
    }
}

