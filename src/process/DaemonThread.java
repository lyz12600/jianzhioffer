package process;

/**
 * Created by liyanzhen on 17/3/18.
 */
public class DaemonThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String args[]){
        DaemonThread t = new DaemonThread();
        t.setDaemon(true);
        t.start();
        new DaemonThread().start();
        System.out.println("main thread exit");
        return;
    }
}