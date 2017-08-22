package process;

/**
 * Created by liyanzhen on 17/1/11.
 */
public class FirstThread extends Thread {
    private int i;

    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "------" + i);
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "*******" + i);
            if (i == 20){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new FirstThread().start();
                new FirstThread().run();
            }
        }
    }
}
